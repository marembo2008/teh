/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.request.auth;

import com.anosym.vjax.VXMLBindingException;
import com.anosym.vjax.v3.VObjectMarshaller;
import com.anosym.vjax.xml.VDocument;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marembo
 */
public class Credential {

    private String userId = "";
    private String password = "";
    private String ip = "";

    public static Credential loadCredential() {
        File f = new File(System.getProperty("user.home"), "teh-credential.xml");
        return loadCredential(f.getAbsolutePath());
    }

    public static Credential loadCredential(String credentialFile) {
        try {
            VObjectMarshaller<Credential> vom = new VObjectMarshaller<Credential>(Credential.class);
            File path = new File(credentialFile);
            if (path.exists()) {
                VDocument doc = VDocument.parseDocument(path);
                return vom.unmarshall(doc);
            } else {
                VDocument doc = vom.marshall(new Credential());
                doc.setDocumentName(path);
                doc.writeDocument();
            }
        } catch (VXMLBindingException ex) {
            Logger.getLogger(Credential.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

}
