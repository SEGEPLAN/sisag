/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.seg;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "SEG_BITACORA", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SegBitacora.findAll", query = "SELECT s FROM SegBitacora s"),
    @NamedQuery(name = "SegBitacora.findByIdBitacora", query = "SELECT s FROM SegBitacora s WHERE s.idBitacora = :idBitacora"),
    @NamedQuery(name = "SegBitacora.findByFechaCrea", query = "SELECT s FROM SegBitacora s WHERE s.fechaCrea = :fechaCrea"),
    @NamedQuery(name = "SegBitacora.findByFechaMod", query = "SELECT s FROM SegBitacora s WHERE s.fechaMod = :fechaMod"),
    @NamedQuery(name = "SegBitacora.findByOperacion", query = "SELECT s FROM SegBitacora s WHERE s.operacion = :operacion"),
    @NamedQuery(name = "SegBitacora.findByTablas", query = "SELECT s FROM SegBitacora s WHERE s.tablas = :tablas"),
    @NamedQuery(name = "SegBitacora.findByRestrictiva", query = "SELECT s FROM SegBitacora s WHERE s.restrictiva = :restrictiva")})
public class SegBitacora implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_bitacora")
    private BigDecimal idBitacora;
    @Column(name = "fecha_crea")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCrea;
    @Column(name = "fecha_mod")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaMod;
    @Column(name = "operacion")
    private String operacion;
    @Column(name = "tablas")
    private String tablas;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @JoinColumn(name = "id_sesion", referencedColumnName = "id_sesion")
    @ManyToOne(fetch = FetchType.EAGER)
    private SegSesion idSesion;
    @JoinColumn(name = "id_pagina", referencedColumnName = "id_pagina")
    @ManyToOne(fetch = FetchType.EAGER)
    private SegPagina idPagina;

    public SegBitacora() {
    }

    public SegBitacora(BigDecimal idBitacora) {
        this.idBitacora = idBitacora;
    }

    public BigDecimal getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(BigDecimal idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Date getFechaCrea() {
        return fechaCrea;
    }

    public void setFechaCrea(Date fechaCrea) {
        this.fechaCrea = fechaCrea;
    }

    public Date getFechaMod() {
        return fechaMod;
    }

    public void setFechaMod(Date fechaMod) {
        this.fechaMod = fechaMod;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public String getTablas() {
        return tablas;
    }

    public void setTablas(String tablas) {
        this.tablas = tablas;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    public SegSesion getIdSesion() {
        return idSesion;
    }

    public void setIdSesion(SegSesion idSesion) {
        this.idSesion = idSesion;
    }

    public SegPagina getIdPagina() {
        return idPagina;
    }

    public void setIdPagina(SegPagina idPagina) {
        this.idPagina = idPagina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBitacora != null ? idBitacora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SegBitacora)) {
            return false;
        }
        SegBitacora other = (SegBitacora) object;
        if ((this.idBitacora == null && other.idBitacora != null) || (this.idBitacora != null && !this.idBitacora.equals(other.idBitacora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.SegBitacora[ idBitacora=" + idBitacora + " ]";
    }
    
}
