/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.gen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "GEN_TIPO_SOLICITUD", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenTipoSolicitud.findAll", query = "SELECT g FROM GenTipoSolicitud g"),
    @NamedQuery(name = "GenTipoSolicitud.findByIdTipoSolicitud", query = "SELECT g FROM GenTipoSolicitud g WHERE g.idTipoSolicitud = :idTipoSolicitud"),
    @NamedQuery(name = "GenTipoSolicitud.findByNombre", query = "SELECT g FROM GenTipoSolicitud g WHERE g.nombre = :nombre"),
    @NamedQuery(name = "GenTipoSolicitud.findByRestrictiva", query = "SELECT g FROM GenTipoSolicitud g WHERE g.restrictiva = :restrictiva")})
public class GenTipoSolicitud implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_tipo_solicitud")
    private BigDecimal idTipoSolicitud;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @OneToMany(mappedBy = "idTipoSolicitud", fetch = FetchType.EAGER)
    private List<GenSolicitudFinaciera> genSolicitudFinacieraList;

    public GenTipoSolicitud() {
    }

    public GenTipoSolicitud(BigDecimal idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public BigDecimal getIdTipoSolicitud() {
        return idTipoSolicitud;
    }

    public void setIdTipoSolicitud(BigDecimal idTipoSolicitud) {
        this.idTipoSolicitud = idTipoSolicitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<GenSolicitudFinaciera> getGenSolicitudFinacieraList() {
        return genSolicitudFinacieraList;
    }

    public void setGenSolicitudFinacieraList(List<GenSolicitudFinaciera> genSolicitudFinacieraList) {
        this.genSolicitudFinacieraList = genSolicitudFinacieraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoSolicitud != null ? idTipoSolicitud.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenTipoSolicitud)) {
            return false;
        }
        GenTipoSolicitud other = (GenTipoSolicitud) object;
        if ((this.idTipoSolicitud == null && other.idTipoSolicitud != null) || (this.idTipoSolicitud != null && !this.idTipoSolicitud.equals(other.idTipoSolicitud))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.GenTipoSolicitud[ idTipoSolicitud=" + idTipoSolicitud + " ]";
    }
    
}
