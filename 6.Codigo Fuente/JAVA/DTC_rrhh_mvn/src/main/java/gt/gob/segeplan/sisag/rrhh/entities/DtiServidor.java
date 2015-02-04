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
@Table(name = "DTI_SERVIDOR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtiServidor.findAll", query = "SELECT d FROM DtiServidor d"),
    @NamedQuery(name = "DtiServidor.findById", query = "SELECT d FROM DtiServidor d WHERE d.id = :id"),
    @NamedQuery(name = "DtiServidor.findByNombre", query = "SELECT d FROM DtiServidor d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DtiServidor.findByIp", query = "SELECT d FROM DtiServidor d WHERE d.ip = :ip"),
    @NamedQuery(name = "DtiServidor.findByTarjetaRed", query = "SELECT d FROM DtiServidor d WHERE d.tarjetaRed = :tarjetaRed"),
    @NamedQuery(name = "DtiServidor.findByProcesador", query = "SELECT d FROM DtiServidor d WHERE d.procesador = :procesador"),
    @NamedQuery(name = "DtiServidor.findByRamMb", query = "SELECT d FROM DtiServidor d WHERE d.ramMb = :ramMb"),
    @NamedQuery(name = "DtiServidor.findByDiscoDuroGb", query = "SELECT d FROM DtiServidor d WHERE d.discoDuroGb = :discoDuroGb")})
public class DtiServidor implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "DTI_SERVIDOR_GEN")
    @TableGenerator(name = "DTI_SERVIDOR_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "DTI_SERVIDOR", allocationSize = 1)
    private BigDecimal id;
    @Size(max = 100)
    @Column(name = "NOMBRE")
    private String nombre;
    @Lob
    @Column(name = "IMAGEN")
    private Serializable imagen;
    @Size(max = 100)
    @Column(name = "IP")
    private String ip;
    @Size(max = 200)
    @Column(name = "TARJETA_RED")
    private String tarjetaRed;
    @Size(max = 200)
    @Column(name = "PROCESADOR")
    private String procesador;
    @Column(name = "RAM_MB")
    private BigInteger ramMb;
    @Column(name = "DISCO_DURO_GB")
    private BigInteger discoDuroGb;
    @OneToMany(mappedBy = "idServer", fetch = FetchType.LAZY)
    private List<DtiIpServer> dtiIpServerList;
    @JoinColumn(name = "ID_DISPOSITIVO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DtiDispositivo idDispositivo;
    @JoinColumn(name = "ID_SISTEMA_OPERATIVO", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DtiSistemaOperativo idSistemaOperativo;
    @JoinColumn(name = "ID_TIPO_SERVER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DtiTipoServer idTipoServer;

    public DtiServidor() {
    }

    public DtiServidor(BigDecimal id) {
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

    public Serializable getImagen() {
        return imagen;
    }

    public void setImagen(Serializable imagen) {
        this.imagen = imagen;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getTarjetaRed() {
        return tarjetaRed;
    }

    public void setTarjetaRed(String tarjetaRed) {
        this.tarjetaRed = tarjetaRed;
    }

    public String getProcesador() {
        return procesador;
    }

    public void setProcesador(String procesador) {
        this.procesador = procesador;
    }

    public BigInteger getRamMb() {
        return ramMb;
    }

    public void setRamMb(BigInteger ramMb) {
        this.ramMb = ramMb;
    }

    public BigInteger getDiscoDuroGb() {
        return discoDuroGb;
    }

    public void setDiscoDuroGb(BigInteger discoDuroGb) {
        this.discoDuroGb = discoDuroGb;
    }

    @XmlTransient
    public List<DtiIpServer> getDtiIpServerList() {
        return dtiIpServerList;
    }

    public void setDtiIpServerList(List<DtiIpServer> dtiIpServerList) {
        this.dtiIpServerList = dtiIpServerList;
    }

    public DtiDispositivo getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(DtiDispositivo idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public DtiSistemaOperativo getIdSistemaOperativo() {
        return idSistemaOperativo;
    }

    public void setIdSistemaOperativo(DtiSistemaOperativo idSistemaOperativo) {
        this.idSistemaOperativo = idSistemaOperativo;
    }

    public DtiTipoServer getIdTipoServer() {
        return idTipoServer;
    }

    public void setIdTipoServer(DtiTipoServer idTipoServer) {
        this.idTipoServer = idTipoServer;
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
        if (!(object instanceof DtiServidor)) {
            return false;
        }
        DtiServidor other = (DtiServidor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.DtiServidor[ id=" + id + " ]";
    }
    
}
