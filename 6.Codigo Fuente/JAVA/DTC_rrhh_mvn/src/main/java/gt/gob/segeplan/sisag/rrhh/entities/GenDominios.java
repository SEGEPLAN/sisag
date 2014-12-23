/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "GEN_DOMINIOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GenDominios.findAll", query = "SELECT g FROM GenDominios g"),
    @NamedQuery(name = "GenDominios.findById", query = "SELECT g FROM GenDominios g WHERE g.id = :id"),
    @NamedQuery(name = "GenDominios.findByNombre", query = "SELECT g FROM GenDominios g WHERE g.nombre = :nombre")})
public class GenDominios implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private BigDecimal id;
    @Size(max = 50)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(mappedBy = "idEstado", fetch = FetchType.EAGER)
    private List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;
    @OneToMany(mappedBy = "idDominio", fetch = FetchType.EAGER)
    private List<GenDominios> genDominiosList;
    @JoinColumn(name = "ID_DOMINIO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenDominios idDominio;
    @OneToMany(mappedBy = "idPrioridad", fetch = FetchType.EAGER)
    private List<RrhhNecesidad> rrhhNecesidadList;
    @OneToMany(mappedBy = "idCaracter", fetch = FetchType.EAGER)
    private List<RrhhNecesidad> rrhhNecesidadList1;
    @OneToMany(mappedBy = "idEstado", fetch = FetchType.EAGER)
    private List<RrhhNecesidad> rrhhNecesidadList2;
    @OneToMany(mappedBy = "idDisponibilidad", fetch = FetchType.EAGER)
    private List<RrhhNecesidad> rrhhNecesidadList3;
    @OneToMany(mappedBy = "idNivelConocimiento", fetch = FetchType.EAGER)
    private List<RrhhNecesidad> rrhhNecesidadList4;

    public GenDominios() {
    }

    public GenDominios(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<RrhhSolicitudCapacitacion> getRrhhSolicitudCapacitacionList() {
        return rrhhSolicitudCapacitacionList;
    }

    public void setRrhhSolicitudCapacitacionList(List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList) {
        this.rrhhSolicitudCapacitacionList = rrhhSolicitudCapacitacionList;
    }

    @XmlTransient
    public List<GenDominios> getGenDominiosList() {
        return genDominiosList;
    }

    public void setGenDominiosList(List<GenDominios> genDominiosList) {
        this.genDominiosList = genDominiosList;
    }

    public GenDominios getIdDominio() {
        return idDominio;
    }

    public void setIdDominio(GenDominios idDominio) {
        this.idDominio = idDominio;
    }

    @XmlTransient
    public List<RrhhNecesidad> getRrhhNecesidadList() {
        return rrhhNecesidadList;
    }

    public void setRrhhNecesidadList(List<RrhhNecesidad> rrhhNecesidadList) {
        this.rrhhNecesidadList = rrhhNecesidadList;
    }

    @XmlTransient
    public List<RrhhNecesidad> getRrhhNecesidadList1() {
        return rrhhNecesidadList1;
    }

    public void setRrhhNecesidadList1(List<RrhhNecesidad> rrhhNecesidadList1) {
        this.rrhhNecesidadList1 = rrhhNecesidadList1;
    }

    @XmlTransient
    public List<RrhhNecesidad> getRrhhNecesidadList2() {
        return rrhhNecesidadList2;
    }

    public void setRrhhNecesidadList2(List<RrhhNecesidad> rrhhNecesidadList2) {
        this.rrhhNecesidadList2 = rrhhNecesidadList2;
    }

    @XmlTransient
    public List<RrhhNecesidad> getRrhhNecesidadList3() {
        return rrhhNecesidadList3;
    }

    public void setRrhhNecesidadList3(List<RrhhNecesidad> rrhhNecesidadList3) {
        this.rrhhNecesidadList3 = rrhhNecesidadList3;
    }

    @XmlTransient
    public List<RrhhNecesidad> getRrhhNecesidadList4() {
        return rrhhNecesidadList4;
    }

    public void setRrhhNecesidadList4(List<RrhhNecesidad> rrhhNecesidadList4) {
        this.rrhhNecesidadList4 = rrhhNecesidadList4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GenDominios)) {
            return false;
        }
        GenDominios other = (GenDominios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.GenDominios[ id=" + id + " ]";
    }
    
}
