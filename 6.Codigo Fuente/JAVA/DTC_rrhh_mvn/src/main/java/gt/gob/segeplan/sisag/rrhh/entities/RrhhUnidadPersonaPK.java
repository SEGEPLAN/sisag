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
public class RrhhUnidadPersonaPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADSCGED$ID_DEPENDENCIA")
    private BigInteger idDependencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ADSCGED$ID_EMPLEADO")
    private BigInteger idPersona;

    public RrhhUnidadPersonaPK() {
    }

    public RrhhUnidadPersonaPK(BigInteger idDependencia, BigInteger idPersona) {
        this.idDependencia = idDependencia;
        this.idPersona = idPersona;
    }

    public BigInteger getIdDependencia() {
        return idDependencia;
    }

    public void setIdDependencia(BigInteger idDependencia) {
        this.idDependencia = idDependencia;
    }

    public BigInteger getIdPersona() {
        return idPersona;
    }

    public void setIdPersona(BigInteger idPersona) {
        this.idPersona = idPersona;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (this.idDependencia != null ? this.idDependencia.hashCode() : 0);
        hash = 19 * hash + (this.idPersona != null ? this.idPersona.hashCode() : 0);
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
        final RrhhUnidadPersonaPK other = (RrhhUnidadPersonaPK) obj;
        if (this.idDependencia != other.idDependencia && (this.idDependencia == null || !this.idDependencia.equals(other.idDependencia))) {
            return false;
        }
        if (this.idPersona != other.idPersona && (this.idPersona == null || !this.idPersona.equals(other.idPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RrhhUnidadPersonaPK{" + "idDependencia=" + idDependencia + ", idPersona=" + idPersona + '}';
    }

   
}
