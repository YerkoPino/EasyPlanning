package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author jano
 */
@Entity
@NamedQueries({
    @NamedQuery(name="Asignatura.findByCodigoAndPlan", 
            query="SELECT a FROM Asignatura a WHERE a.codigo = :codigo AND a.planEstudio = :plan")
})
public class Asignatura implements Serializable {
    @OneToMany(mappedBy = "asignatura")
    private List<Coordinacion> coordinaciones;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String codigo;
    private String nombre;
    private int nivel;
    private int teoria;
    private int ejercicios;
    private int laboratorio;
    private String planEstudio;
    
    public Asignatura(){        
    }
    
    @OneToMany
    private List<Asignatura> prerequisitos;
    
    @ManyToMany
    private List<Profesor> profesores;

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public int getTeoria() {
        return teoria;
    }

    public void setTeoria(int teoria) {
        this.teoria = teoria;
    }

    public int getEjercicios() {
        return ejercicios;
    }

    public void setEjercicios(int ejercicios) {
        this.ejercicios = ejercicios;
    }

    public int getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(int laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<Coordinacion> getCoordinaciones() {
        return coordinaciones;
    }

    public void setCoordinaciones(List<Coordinacion> coordinaciones) {
        this.coordinaciones = coordinaciones;
    }
    public List<Asignatura> getPrerequisitos() {
        return prerequisitos;
    }

    public void setPrerequisitos(List<Asignatura> prerequisitos) {
        this.prerequisitos = prerequisitos;
    }
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getPlanEstudio() {
        return planEstudio;
    }

    public void setPlanEstudio(String planEstudio) {
        this.planEstudio = planEstudio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Asignatura)) {
            return false;
        }
        Asignatura other = (Asignatura) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Asignatura[ id=" + id + ", codigo= "+codigo+", nombre= "+nombre+", nivel= "+nivel+",T= "+teoria+", E= "+ejercicios+", L= "+laboratorio+"  ]";
    }

}
