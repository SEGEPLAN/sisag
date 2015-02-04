/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.gob.segeplan.sisag.rrhh.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author ludwin.ayala
 */
@Entity
@Table(name = "DTI_GABINETE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DtiGabinete.findAll", query = "SELECT d FROM DtiGabinete d"),
    @NamedQuery(name = "DtiGabinete.findById", query = "SELECT d FROM DtiGabinete d WHERE d.id = :id"),
    @NamedQuery(name = "DtiGabinete.findByNombre", query = "SELECT d FROM DtiGabinete d WHERE d.nombre = :nombre"),
    @NamedQuery(name = "DtiGabinete.findByCapacidadUs", query = "SELECT d FROM DtiGabinete d WHERE d.capacidadUs = :capacidadUs"),
    @NamedQuery(name = "DtiGabinete.findByNoInventario", query = "SELECT d FROM DtiGabinete d WHERE d.noInventario = :noInventario")})
public class DtiGabinete implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID", nullable = false)
    @GeneratedValue(generator = "DTI_GABINETE_GEN")
    @TableGenerator(name = "DTI_GABINETE_GEN", table = "SECUENCIAS",
            pkColumnName = "ID", valueColumnName = "VALOR",
            pkColumnValue = "DTI_GABINETE", allocationSize = 1)
    private BigDecimal id;
    @Size(max = 200)
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CAPACIDAD_US")
    private BigInteger capacidadUs;
    @Size(max = 200)
    @Column(name = "NO_INVENTARIO")
    private String noInventario;
    @Lob
    @Column(name = "IMAGEN")
    private byte[]  imagen;
    @OneToMany(mappedBy = "idGabinete", fetch = FetchType.LAZY)
    private List<DtiDispositivo> dtiDispositivoList;

    
   @Transient 
   private StreamedContent grafico;
    
    
    public DtiGabinete() {
    }

    public DtiGabinete(BigDecimal id) {
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

    public BigInteger getCapacidadUs() {
        return capacidadUs;
    }

    public void setCapacidadUs(BigInteger capacidadUs) {
        this.capacidadUs = capacidadUs;
    }

    public String getNoInventario() {
        return noInventario;
    }

    public void setNoInventario(String noInventario) {
        this.noInventario = noInventario;
    }

    public byte[] getImagen() {
        
        return imagen;
    }

    public StreamedContent getGrafico() {
        
//        FacesContext context = FacesContext.getCurrentInstance();

//        if (context.getCurrentPhaseId() == PhaseId.RENDER_RESPONSE) {
//            // So, we're rendering the HTML. Return a stub StreamedContent so that it will generate right URL.
//            return new DefaultStreamedContent();
//        } else {
//             So, browser is requesting the image. Return a real StreamedContent with the image bytes.
         
           // grafico = new DefaultStreamedContent(new ByteArrayInputStream(getImagen()));
//        }
        
        return grafico;
    }

    public void setGrafico(StreamedContent grafico) {
        this.grafico = grafico;
    }
    
    
    

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @XmlTransient
    public List<DtiDispositivo> getDtiDispositivoList() {
        return dtiDispositivoList;
    }

    public void setDtiDispositivoList(List<DtiDispositivo> dtiDispositivoList) {
        this.dtiDispositivoList = dtiDispositivoList;
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
        if (!(object instanceof DtiGabinete)) {
            return false;
        }
        DtiGabinete other = (DtiGabinete) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gt.gob.segeplan.sisag.rrhh.entities.DtiGabinete[ id=" + id + " ]";
    }
    
}
