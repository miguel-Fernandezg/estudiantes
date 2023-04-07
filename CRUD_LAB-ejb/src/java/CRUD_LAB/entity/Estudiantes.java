/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "ESTUDIANTES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estudiantes.findAll", query = "SELECT e FROM Estudiantes e"),
    @NamedQuery(name = "Estudiantes.findByCodEstudiantes", query = "SELECT e FROM Estudiantes e WHERE e.codEstudiantes = :codEstudiantes"),
    @NamedQuery(name = "Estudiantes.findByNombreEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.nombreEstudiante = :nombreEstudiante"),
    @NamedQuery(name = "Estudiantes.findByApellidoEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.apellidoEstudiante = :apellidoEstudiante"),
    @NamedQuery(name = "Estudiantes.findBySemestreEstudiante", query = "SELECT e FROM Estudiantes e WHERE e.semestreEstudiante = :semestreEstudiante")})
public class Estudiantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COD_ESTUDIANTES")
    private String codEstudiantes;
    @Size(max = 20)
    @Column(name = "NOMBRE_ESTUDIANTE")
    private String nombreEstudiante;
    @Size(max = 20)
    @Column(name = "APELLIDO_ESTUDIANTE")
    private String apellidoEstudiante;
    @Column(name = "SEMESTRE_ESTUDIANTE")
    private Integer semestreEstudiante;

    public Estudiantes() {
    }

    public Estudiantes(String codEstudiantes) {
        this.codEstudiantes = codEstudiantes;
    }

    public Estudiantes(String codEstudiantes, String nombreEstudiante, String apellidoEstudiante, Integer semestreEstudiante) {
        this.codEstudiantes = codEstudiantes;
        this.nombreEstudiante = nombreEstudiante;
        this.apellidoEstudiante = apellidoEstudiante;
        this.semestreEstudiante = semestreEstudiante;
    }

    
    
    public String getCodEstudiantes() {
        return codEstudiantes;
    }

    public void setCodEstudiantes(String codEstudiantes) {
        this.codEstudiantes = codEstudiantes;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getApellidoEstudiante() {
        return apellidoEstudiante;
    }

    public void setApellidoEstudiante(String apellidoEstudiante) {
        this.apellidoEstudiante = apellidoEstudiante;
    }

    public Integer getSemestreEstudiante() {
        return semestreEstudiante;
    }

    public void setSemestreEstudiante(Integer semestreEstudiante) {
        this.semestreEstudiante = semestreEstudiante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEstudiantes != null ? codEstudiantes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estudiantes)) {
            return false;
        }
        Estudiantes other = (Estudiantes) object;
        if ((this.codEstudiantes == null && other.codEstudiantes != null) || (this.codEstudiantes != null && !this.codEstudiantes.equals(other.codEstudiantes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CRUD_LAB.entity.Estudiantes[ codEstudiantes=" + codEstudiantes + " ]";
    }
    
}
