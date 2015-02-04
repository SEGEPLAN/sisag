/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "DTI_DISPOSITIVO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtiDispositivo.findAll", query = "SELECT d FROM DtiDispositivo d"),
    @NamedQuery(name = "DtiDispositivo.findById", query = "SELECT d FROM DtiDispositivo d WHERE d.id = :id"),
    @NamedQuery(name = "DtiDispositivo.findByPosicionGabinete", query = "SELECT d FROM DtiDispositivo d WHERE d.posicionGabinete = :posicionGabinete"),
    @NamedQuery(name = "DtiDispositivo.findByMarca", query = "SELECT d FROM DtiDispositivo d WHERE d.marca = :marca"),
    @NamedQuery(name = "DtiDispositivo.findByModelo", query = "SELECT d FROM DtiDispositivo d WHERE d.modelo = :modelo"),
    @NamedQuery(name = "DtiDispositivo.findBySerie", query = "SELECT d FROM DtiDispositivo d WHERE d.serie = :serie"),
    @NamedQuery(name = "DtiDispositivo.findBySerieTag", query = "SELECT d FROM DtiDispositivo d WHERE d.serieTag = :serieTag"),
    @NamedQuery(name = "DtiDispositivo.findByNoInventario", query = "SELECT d FROM DtiDispositivo d WHERE d.noInventario = :noInventario"),
    @NamedQuery(name = "DtiDispositivo.findByUs", query = "SELECT d FROM DtiDispositivo d WHERE d.us = :us")})
public class DtiDispositivo implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "DTI_DISPOSITIVO_GEN")
    @TableGenerator(name = "DTI_DISPOSITIVO_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "DTI_DISPOSITIVO", allocationSize = 1)
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "POSICION_GABINETE")
    private String posicionGabinete;
    @Size(max = 200)
    @Column(name = "MARCA")
    private String marca;
    @Size(max = 200)
    @Column(name = "MODELO")
    private String modelo;
    @Size(max = 200)
    @Column(name = "SERIE")
    private String serie;
    @Size(max = 20)
    @Column(name = "SERIE_TAG")
    private String serieTag;
    @Size(max = 200)
    @Column(name = "NO_INVENTARIO")
    private String noInventario;
    @Column(name = "US")
    private BigInteger us;
    @Lob
    @Column(name = "IMAGEN")
    private Serializable imagen;
    @OneToMany(mappedBy = "idDispositivo", fetch = FetchType.LAZY)
    private List<DtiServidor> dtiServidorList;
    @JoinColumn(name = "ID_GABINETE", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DtiGabinete idGabinete;
    @JoinColumn(name = "ID_TIPO_DISPOSITIVO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DtiTipoDispositivo idTipoDispositivo;

    public DtiDispositivo() {
    }

    public DtiDispositivo(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getPosicionGabinete() {
        return posicionGabinete;
    }

    public void setPosicionGabinete(String posicionGabinete) {
        this.posicionGabinete = posicionGabinete;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSerieTag() {
        return serieTag;
    }

    public void setSerieTag(String serieTag) {
        this.serieTag = serieTag;
    }

    public String getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(String noInventario) {
        this.noInventario = noInventario;
    }

    public BigInteger getUs() {
        return us;
    }

    public void setUs(BigInteger us) {
        this.us = us;
    }

    public Serializable getImagen() {
        return imagen;
    }

    public void setImagen(Serializable imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public List<DtiServidor> getDtiServidorList() {
        return dtiServidorList;
    }

    public void setDtiServidorList(List<DtiServidor> dtiServidorList) {
        this.dtiServidorList = dtiServidorList;
    }

    public DtiGabinete getIdGabinete() {
        return idGabinete;
    }

    public void setIdGabinete(DtiGabinete idGabinete) {
        this.idGabinete = idGabinete;
    }

    public DtiTipoDispositivo getIdTipoDispositivo() {
        return idTipoDispositivo;
    }

    public void setIdTipoDispositivo(DtiTipoDispositivo idTipoDispositivo) {
        this.idTipoDispositivo = idTipoDispositivo;
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
        if (!(object instanceof DtiDispositivo)) {
            return false;
        }
        DtiDispositivo other = (DtiDispositivo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.DtiDispositivo[ id=" + id + " ]";
    }
    
}
