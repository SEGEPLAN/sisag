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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "DTI_SISTEMA_OPERATIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtiSistemaOperativo.findAll", query = "SELECT d FROM DtiSistemaOperativo d"),
    @NamedQuery(name = "DtiSistemaOperativo.findById", query = "SELECT d FROM DtiSistemaOperativo d WHERE d.id = :id"),
    @NamedQuery(name = "DtiSistemaOperativo.findByDescripcion", query = "SELECT d FROM DtiSistemaOperativo d WHERE d.descripcion = :descripcion")})
public class DtiSistemaOperativo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "DTI_SISTEMA_OPERATIVO_GEN")
    @TableGenerator(name = "DTI_SISTEMA_OPERATIVO_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "DTI_SISTEMA_OPERATIVO", allocationSize = 1)
    
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idSistemaOperativo", fetch = FetchType.LAZY)
    private List<DtiServidor> dtiServidorList;

    public DtiSistemaOperativo() {
    }

    public DtiSistemaOperativo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @XmlTransient
    public List<DtiServidor> getDtiServidorList() {
        return dtiServidorList;
    }

    public void setDtiServidorList(List<DtiServidor> dtiServidorList) {
        this.dtiServidorList = dtiServidorList;
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
        if (!(object instanceof DtiSistemaOperativo)) {
            return false;
        }
        DtiSistemaOperativo other = (DtiSistemaOperativo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.DtiSistemaOperativo[ id=" + id + " ]";
    }
    
}
