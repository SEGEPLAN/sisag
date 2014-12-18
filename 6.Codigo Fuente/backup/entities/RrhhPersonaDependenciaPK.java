/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ludwin.ayala
 */
@Embeddable
public class RrhhPersonaDependenciaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADSCGED$ID_EMPLEADO")
    private BigInteger idPersona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADSCGDP$ID")
    private BigInteger idUnidad;

    public RrhhPersonaDependenciaPK() {
    }

    public RrhhPersonaDependenciaPK(BigInteger idPersona, BigInteger idUnidad) {
        this.idPersona = idPersona;
        this.idUnidad = idUnidad;
    }

    public BigInteger getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigInteger idPersona) {
        this.idPersona = idPersona;
    }

    public BigInteger getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(BigInteger idUnidad) {
        this.idUnidad = idUnidad;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + (this.idPersona != null ? this.idPersona.hashCode() : 0);
        hash = 23 * hash + (this.idUnidad != null ? this.idUnidad.hashCode() : 0);
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
        final RrhhPersonaDependenciaPK other = (RrhhPersonaDependenciaPK) obj;
        if (this.idPersona != other.idPersona && (this.idPersona == null || !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        if (this.idUnidad != other.idUnidad && (this.idUnidad == null || !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RrhhPersonaDependenciaPK{" + "idPersona=" + idPersona + ", idUnidad=" + idUnidad + '}';
    }

    

    
    
    

    
    
    
}
