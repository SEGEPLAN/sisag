/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.core.poa;

import gt.gob.segeplan.sisag.core.gen.GenSolicitudFinaciera;
import gt.gob.segeplan.sisag.core.gen.GenUnidadMedida;
import gt.gob.segeplan.sisag.core.katun.KatunMeta;
import gt.gob.segeplan.sisag.core.rrhh.RrhhSolicitudCapacitacion;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "POA_META", catalog = "", schema = "SCHE$SISAG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PoaMeta.findAll", query = "SELECT p FROM PoaMeta p"),
    @NamedQuery(name = "PoaMeta.findByIdMeta", query = "SELECT p FROM PoaMeta p WHERE p.idMeta = :idMeta"),
    @NamedQuery(name = "PoaMeta.findByDescripcion", query = "SELECT p FROM PoaMeta p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "PoaMeta.findByResultadoEsperado", query = "SELECT p FROM PoaMeta p WHERE p.resultadoEsperado = :resultadoEsperado"),
    @NamedQuery(name = "PoaMeta.findByRestrictiva", query = "SELECT p FROM PoaMeta p WHERE p.restrictiva = :restrictiva")})
public class PoaMeta implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "id_meta")
    private BigDecimal idMeta;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "resultado_esperado")
    private BigInteger resultadoEsperado;
    @Column(name = "restrictiva")
    private Character restrictiva;
    @OneToMany(mappedBy = "idMeta", fetch = FetchType.EAGER)
    private List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poaMeta", fetch = FetchType.EAGER)
    private List<PoaMetaPeriodo> poaMetaPeriodoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "poaMeta", fetch = FetchType.EAGER)
    private List<PoaMetaDireccion> poaMetaDireccionList;
    @JoinColumn(name = "id_sub_producto", referencedColumnName = "id_sub_producto")
    @ManyToOne(fetch = FetchType.EAGER)
    private PoaSubProducto idSubProducto;
    @JoinColumn(name = "id_katun_meta", referencedColumnName = "id_katun_meta")
    @ManyToOne(fetch = FetchType.EAGER)
    private KatunMeta idKatunMeta;
    @JoinColumn(name = "id_unidad_medida", referencedColumnName = "id_unidad_medida")
    @ManyToOne(fetch = FetchType.EAGER)
    private GenUnidadMedida idUnidadMedida;
    @OneToMany(mappedBy = "idMeta", fetch = FetchType.EAGER)
    private List<GenSolicitudFinaciera> genSolicitudFinacieraList;

    public PoaMeta() {
    }

    public PoaMeta(BigDecimal idMeta) {
        this.idMeta = idMeta;
    }

    public BigDecimal getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(BigDecimal idMeta) {
        this.idMeta = idMeta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigInteger getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setResultadoEsperado(BigInteger resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    public Character getRestrictiva() {
        return restrictiva;
    }

    public void setRestrictiva(Character restrictiva) {
        this.restrictiva = restrictiva;
    }

    @XmlTransient
    public List<RrhhSolicitudCapacitacion> getRrhhSolicitudCapacitacionList() {
        return rrhhSolicitudCapacitacionList;
    }

    public void setRrhhSolicitudCapacitacionList(List<RrhhSolicitudCapacitacion> rrhhSolicitudCapacitacionList) {
        this.rrhhSolicitudCapacitacionList = rrhhSolicitudCapacitacionList;
    }

    @XmlTransient
    public List<PoaMetaPeriodo> getPoaMetaPeriodoList() {
        return poaMetaPeriodoList;
    }

    public void setPoaMetaPeriodoList(List<PoaMetaPeriodo> poaMetaPeriodoList) {
        this.poaMetaPeriodoList = poaMetaPeriodoList;
    }

    @XmlTransient
    public List<PoaMetaDireccion> getPoaMetaDireccionList() {
        return poaMetaDireccionList;
    }

    public void setPoaMetaDireccionList(List<PoaMetaDireccion> poaMetaDireccionList) {
        this.poaMetaDireccionList = poaMetaDireccionList;
    }

    public PoaSubProducto getIdSubProducto() {
        return idSubProducto;
    }

    public void setIdSubProducto(PoaSubProducto idSubProducto) {
        this.idSubProducto = idSubProducto;
    }

    public KatunMeta getIdKatunMeta() {
        return idKatunMeta;
    }

    public void setIdKatunMeta(KatunMeta idKatunMeta) {
        this.idKatunMeta = idKatunMeta;
    }

    public GenUnidadMedida getIdUnidadMedida() {
        return idUnidadMedida;
    }

    public void setIdUnidadMedida(GenUnidadMedida idUnidadMedida) {
        this.idUnidadMedida = idUnidadMedida;
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
        hash += (idMeta != null ? idMeta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PoaMeta)) {
            return false;
        }
        PoaMeta other = (PoaMeta) object;
        if ((this.idMeta == null && other.idMeta != null) || (this.idMeta != null && !this.idMeta.equals(other.idMeta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.core.entities.PoaMeta[ idMeta=" + idMeta + " ]";
    }
    
}