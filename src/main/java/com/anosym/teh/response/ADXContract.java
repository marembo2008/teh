/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.anosym.teh.response;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author marembo
 */
@Entity
@Table(name = "ADXContracts")
@NamedQueries({
    @NamedQuery(name = "ADXContract.load_adxcontracs",
            query = "SELECT a FROM ADXContract a WHERE a.flag = :flag")
})
public class ADXContract implements Serializable {

    private static final long serialVersionUID = 3844893L;
    @Id
    @Column(name = "TokenID")
    private int tokenId;
    @Column(name = "Symbol")
    private String symbol;
    @Column(name = "Flag")
    private int flag;

    public ADXContract() {
    }

    public ADXContract(int tokenId, String symbol, int flag) {
        this.tokenId = tokenId;
        this.symbol = symbol;
        this.flag = flag;
    }

    public int getTokenId() {
        return tokenId;
    }

    public void setTokenId(int tokenId) {
        this.tokenId = tokenId;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.tokenId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ADXContract other = (ADXContract) obj;
        if (this.tokenId != other.tokenId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ADXContract{" + "tokenId=" + tokenId + ", symbol=" + symbol + ", flag=" + flag + '}';
    }

}
