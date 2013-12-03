/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response.controller;

import com.anosym.teh.response.controller.exceptions.NonexistentEntityException;
import com.anosym.teh.response.controller.exceptions.PreexistingEntityException;
import com.anosym.utilities.ClassUtils;
import com.anosym.utilities.Utility;
import com.anosym.vjax.VXMLBindingException;
import com.anosym.vjax.VXMLMemberNotFoundException;
import com.anosym.vjax.v3.VObjectMarshaller;
import com.anosym.vjax.xml.VDocument;
import com.anosym.vjax.xml.persistence.PersistenceInfo;
import com.anosym.vjax.xml.persistence.PersistenceProperty;
import com.anosym.vjax.xml.persistence.PersistenceUnitInfo;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Persistence;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;

/**
 *
 * @author marembo
 */
public abstract class AbstractJpaController<T> {

    private EntityManagerFactory emf;
    private final Class<T> entityClass;
    private static PersistenceInfo PERSISTENCE_INFO;
    private static PersistenceUnitInfo persistenceUnitInfo;

    static {
        try {
            String url = "/META-INF/persistence.xml";
            //get the stream
            InputStream inn = AbstractJpaController.class.getResourceAsStream(url);
            VDocument doc = VDocument.parseDocument(inn);
            VObjectMarshaller<PersistenceInfo> m = new VObjectMarshaller<PersistenceInfo>(PersistenceInfo.class);
            PERSISTENCE_INFO = m.unmarshall(doc);
            persistenceUnitInfo = PERSISTENCE_INFO.getPersistenceUnitInfo("com.anosym.teh_teh_jar_1.0-SNAPSHOTPU");
            PersistenceProperty driverClass = persistenceUnitInfo.getPersistenceProperty("javax.persistence.jdbc.driver");
            if (driverClass != null) {
                Class.forName(driverClass.getValue());
            }
        } catch (VXMLMemberNotFoundException ex) {
            Logger.getLogger(AbstractJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (VXMLBindingException ex) {
            Logger.getLogger(AbstractJpaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AbstractJpaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Connection connection;
    private List<Field> fields;
    private Field idfield;
    private PreparedStatement insertStatement;
    private PreparedStatement updateStatement;
    private PreparedStatement findStatement;

    public final EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("com.anosym.teh_teh_jar_1.0-SNAPSHOTPU");
        }
        return emf.createEntityManager();
    }

    protected AbstractJpaController(Class<T> entityClass) {
        this.entityClass = entityClass;
        loadPersistentUnitInfo();
    }

    private void loadPersistentUnitInfo() {
        if (persistenceUnitInfo != null) {
            try {
                //url
                String url = persistenceUnitInfo.getPersistenceProperty("javax.persistence.jdbc.url").getValue();
                String userName = persistenceUnitInfo.getPersistenceProperty("javax.persistence.jdbc.user").getValue();
                String password = persistenceUnitInfo.getPersistenceProperty("javax.persistence.jdbc.password").getValue();
                connection = DriverManager.getConnection(url, userName, password);
                insertStatement = connection.prepareStatement(insert0());
                updateStatement = connection.prepareStatement(update0());
                findStatement = connection.prepareStatement(find0());
            } catch (SQLException ex) {
                Logger.getLogger(AbstractJpaController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AbstractJpaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private List<Field> getEntityFields() {
        if (fields == null) {
            fields = new ArrayList<Field>();
            getEntityFields(fields, entityClass);
            //we sort them in order to make sure that we have the exact
            Comparator<Field> cmp = new Comparator<Field>() {
                @Override
                public int compare(Field o1, Field o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            };
            Collections.sort(fields, cmp);
            for (Field f : fields) {
                if (f.getAnnotation(Id.class) != null) {
                    idfield = f;
                    break;
                }
            }
        }
        return fields;
    }

    private void getEntityFields(List<Field> ff, Class entityClass) {
        if (entityClass.getAnnotation(Entity.class) != null || entityClass.getAnnotation(MappedSuperclass.class) != null) {
            for (Field f : entityClass.getDeclaredFields()) {
                if (f.getAnnotation(Transient.class) == null) {
                    int mf = f.getModifiers();
                    if (Modifier.isFinal(mf) || Modifier.isStatic(mf)) {
                        continue;
                    }
                    ff.add(f);
                }
            }
            getEntityFields(ff, entityClass.getSuperclass());
        }
    }

    private String getColumnName(Field f) {
        Column c = f.getAnnotation(Column.class);
        String name = f.getName();
        if (c != null && !Utility.isNullOrEmpty(c.name())) {
            name = c.name();
        }
        return name;
    }

    private String insert0() throws Exception {
        List<Field> ff = getEntityFields();
        String columns = "";
        String values = "";
        for (Field f : ff) {
            String name = getColumnName(f);
            if (!columns.isEmpty()) {
                columns += ",";
            }
            columns += name;
            if (!values.isEmpty()) {
                values += ",";
            }
            values += "?";
        }
        String tableName = entityClass.getSimpleName();
        if (entityClass.getAnnotation(Table.class) != null) {
            Table t = entityClass.getAnnotation(Table.class);
            if (!Utility.isNullOrEmpty(t.name())) {
                tableName = t.name();
            }
        }
        return "INSERT INTO " + tableName + " (" + columns + ") VALUES(" + values + ")";
    }

    private String find0() {
        getEntityFields();
        return "SELECT " + getColumnName(idfield) + " FROM " + getTable() + " WHERE " + getColumnName(idfield) + "=?";
    }

    private String update0() throws Exception {
        List<Field> ff = getEntityFields();
        String values = "";
        for (Field f : ff) {
            if (f.getAnnotation(Id.class) != null) {
                continue;
            }
            String name = getColumnName(f);
            if (!values.isEmpty()) {
                values += ",";
            }
            values += (name + "=?");
        }
        return "UPDATE " + getTable() + " SET " + values + " WHERE " + getColumnName(idfield) + "=?";
    }

    private String getTable() {
        String tableName = entityClass.getSimpleName();
        if (entityClass.getAnnotation(Table.class) != null) {
            Table t = entityClass.getAnnotation(Table.class);
            if (!Utility.isNullOrEmpty(t.name())) {
                tableName = t.name();
            }
        }
        return tableName;
    }

    public T find(Object id) {
        synchronized (findStatement) {
            try {
                findStatement.clearParameters();
                setValue(findStatement, idfield, id, 1);
                ResultSet rs = findStatement.executeQuery();
                if (rs != null && rs.next()) {
                    return (T) rs.getObject(1);
                }
            } catch (Exception ex) {
                Logger.getLogger(AbstractJpaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void createOrUpdate(T entity) throws Exception {
        Object id = ClassUtils.getFieldValue(entity, Id.class);
        if (id == null || find(id) == null) {
            System.err.println("Creating......................");
            create(entity);
        } else {
            System.err.println("Updating......................");
            edit(entity);
        }
    }

    public void createOrUpdate(List<T> entities) throws Exception {
        try {
            for (T entity : entities) {
                Object id = ClassUtils.getFieldValue(entity, Id.class);
                if (id != null) {
                    if (find(id) == null) {
                        System.err.println("Creating......................");
                        create(entity);
                    } else {
                        System.err.println("Updating......................");
                        edit(entity);
                    }
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void create(T entity) throws PreexistingEntityException, Exception {
        synchronized (insertStatement) {
            try {
                insertStatement.clearParameters();
                for (int i = 0, j = 1; i < fields.size(); i++, j++) {
                    Field f = fields.get(i);
                    set(insertStatement, f, entity, j);
                }
                insertStatement.executeUpdate();
            } catch (Exception ex) {
                throw ex;
            }
        }
    }

    public void edit(T entity) throws NonexistentEntityException, Exception {
        synchronized (updateStatement) {
            try {
                updateStatement.clearParameters();
                int j = 1;
                for (int i = 0; i < fields.size(); i++, j++) {
                    Field f = fields.get(i);
                    if (f.getAnnotation(Id.class) != null) {
                        j--;
                        continue;
                    }
                    set(updateStatement, f, entity, j);
                }
                set(updateStatement, idfield, entity, j);
                updateStatement.executeUpdate();
            } catch (Exception ex) {
                throw ex;
            }
        }
    }

    private void set(PreparedStatement ps, Field f, Object entity, int j) throws Exception {
        f.setAccessible(true);
        if (f.getType() == String.class) {
            ps.setString(j, f.get(entity) + "");
        } else if (f.getType() == int.class) {
            ps.setInt(j, f.getInt(entity));
        } else if (f.getType() == long.class || f.getType() == Long.class) {
            ps.setLong(j, f.getLong(entity));
        } else if (f.getType() == BigDecimal.class) {
            ps.setBigDecimal(j, (BigDecimal) f.get(entity));
        } else if (f.getType().isAssignableFrom(Calendar.class)) {
            Calendar c = (Calendar) f.get(entity);
            Temporal t = f.getAnnotation(Temporal.class);
            if (t != null) {
                switch (t.value()) {
                    case DATE:
                        java.sql.Date d = new Date(c.getTimeInMillis());
                        ps.setDate(j, d, c);
                        break;
                    case TIME:
                        java.sql.Time tt = new Time(c.getTimeInMillis());
                        ps.setTime(j, tt, c);
                        break;
                    case TIMESTAMP:
                        java.sql.Timestamp ts = new Timestamp(c.getTimeInMillis());
                        ps.setTimestamp(j, ts, c);
                        break;
                }
            }
        } else {
            ps.setObject(j, f.get(entity));
        }
    }

    private void setValue(PreparedStatement ps, Field f, Object value, int j) throws Exception {
        f.setAccessible(true);
        if (f.getType() == String.class) {
            ps.setString(j, value + "");
        } else if (f.getType() == int.class) {
            ps.setInt(j, Integer.parseInt(value.toString()));
        } else if (f.getType() == long.class || f.getType() == Long.class) {
            ps.setLong(j, Long.parseLong(value.toString()));
        } else if (f.getType() == BigDecimal.class) {
            ps.setBigDecimal(j, (BigDecimal) value);
        } else {
            ps.setObject(j, value);
        }
    }

    protected void log(Throwable e) {
        Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, e);
    }

    @Override
    protected void finalize() throws Throwable {
        connection.close();
        super.finalize();
    }
}
