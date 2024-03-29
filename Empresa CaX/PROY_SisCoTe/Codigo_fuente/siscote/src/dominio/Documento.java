package dominio;
// Generated 5/11/2014 06:32:33 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Documento generated by hbm2java
 */
@Entity
@Table(name="documento"
    ,catalog="siscote"
    , uniqueConstraints = {@UniqueConstraint(columnNames="Titulo"), @UniqueConstraint(columnNames="Codigo")} 
)
public class Documento  implements java.io.Serializable {


     private Integer idDocumento;
     private Especialidad especialidad;
     private Categoria categoria;
     private String codigo;
     private String titulo;
     private boolean estado;
     private Date fechaPublicacion;
     private Set<Tema> temas = new HashSet(0);
     private Set<Autor> autors = new HashSet(0);

    public Documento() {
    }

	
    public Documento(Especialidad especialidad, Categoria categoria, String codigo, String titulo, boolean estado, Date fechaPublicacion) {
        this.especialidad = especialidad;
        this.categoria = categoria;
        this.codigo = codigo;
        this.titulo = titulo;
        this.estado = estado;
        this.fechaPublicacion = fechaPublicacion;
    }
    public Documento(Especialidad especialidad, Categoria categoria, String codigo, String titulo, boolean estado, Date fechaPublicacion, Set<Tema> temas, Set autors) {
       this.especialidad = especialidad;
       this.categoria = categoria;
       this.codigo = codigo;
       this.titulo = titulo;
       this.estado = estado;
       this.fechaPublicacion = fechaPublicacion;
       this.temas = temas;
       this.autors = autors;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)
    
    @Column(name="idDocumento", unique=true, nullable=false)
    public Integer getIdDocumento() {
        return this.idDocumento;
    }
    
    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Especialidad_idEspecialidad", nullable=false)
    public Especialidad getEspecialidad() {
        return this.especialidad;
    }
    
    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }
@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Categoria_idCategoria", nullable=false)
    public Categoria getCategoria() {
        return this.categoria;
    }
    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    @Column(name="Codigo", unique=true, nullable=false, length=45)
    public String getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    @Column(name="Titulo", unique=true, nullable=false, length=45)
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    @Column(name="Estado", nullable=false)
    public boolean isEstado() {
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FechaPublicacion", nullable=false, length=19)
    public Date getFechaPublicacion() {
        return this.fechaPublicacion;
    }
    
    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="documento_has_tema", catalog="siscote", joinColumns = { 
        @JoinColumn(name="Documento_idDocumento", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Tema_idTema", nullable=false, updatable=false) })
    public Set<Tema> getTemas() {
        return this.temas;
    }
    
    public void setTemas(Set<Tema> temas) {
        this.temas = temas;
    }
@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinTable(name="documento_has_autor", catalog="siscote", joinColumns = { 
        @JoinColumn(name="Documento_idDocumento", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="Autor_idAutor", nullable=false, updatable=false) })
    public Set<Autor> getAutors() {
        return this.autors;
    }
    
    public void setAutors(Set<Autor> autors) {
        this.autors = autors;
    }




}


