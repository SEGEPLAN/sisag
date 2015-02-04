/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "DTI_IP_SERVER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtiIpServer.findAll", query = "SELECT d FROM DtiIpServer d"),
    @NamedQuery(name = "DtiIpServer.findById", query = "SELECT d FROM DtiIpServer d WHERE d.id = :id"),
    @NamedQuery(name = "DtiIpServer.findByIp", query = "SELECT d FROM DtiIpServer d WHERE d.ip = :ip")})
public class DtiIpServer implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "DTI_IP_SERVER_GEN")
    @TableGenerator(name = "DTI_IP_SERVER_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "DTI_IP_SERVER", allocationSize = 1)
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "IP")
    private String ip;
    @JoinColumn(name = "ID_SERVER", referencedColumnName = "ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private DtiServidor idServer;

    public DtiIpServer() {
    }

    public DtiIpServer(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public DtiServidor getIdServer() {
        return idServer;
    }

    public void setIdServer(DtiServidor idServer) {
        this.idServer = idServer;
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
        if (!(object instanceof DtiIpServer)) {
            return false;
        }
        DtiIpServer other = (DtiIpServer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.DtiIpServer[ id=" + id + " ]";
    }
    
}
