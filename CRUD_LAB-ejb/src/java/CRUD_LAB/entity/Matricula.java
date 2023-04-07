/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CRUD_LAB.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Miguel
 */
@Entity
@Table(name = "MATRICULA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m"),
    @NamedQuery(name = "Matricula.findByCodigoCurso", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "Matricula.findByCodigoEstudiantes", query = "SELECT m FROM Matricula m WHERE m.matriculaPK.codigoEstudiantes = :codigoEstudiantes"),
    @NamedQuery(name = "Matricula.findByMatFecha", query = "SELECT m FROM Matricula m WHERE m.matFecha = :matFecha"),
    @NamedQuery(name = "Matricula.findByMatPrecio", query = "SELECT m FROM Matricula m WHERE m.matPrecio = :matPrecio")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MatriculaPK matriculaPK;
    @Column(name = "MAT_FECHA")
    @Temporal(TemporalType.DATE)
    private Date matFecha;
    @Column(name = "MAT_PRECIO")
    private Integer matPrecio;
    @JoinColumn(name = "CODIGO_CURSO", referencedColumnName = "COD_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;

    public Matricula() {
    }

    public Matricula(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Matricula(String codigoCurso, String codigoEstudiantes) {
        this.matriculaPK = new MatriculaPK(codigoCurso, codigoEstudiantes);
    }

    public MatriculaPK getMatriculaPK() {
        return matriculaPK;
    }

    public void setMatriculaPK(MatriculaPK matriculaPK) {
        this.matriculaPK = matriculaPK;
    }

    public Date getMatFecha() {
        return matFecha;
    }

    public void setMatFecha(Date matFecha) {
        this.matFecha = matFecha;
    }

    public Integer getMatPrecio() {
        return matPrecio;
    }

    public void setMatPrecio(Integer matPrecio) {
        this.matPrecio = matPrecio;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaPK != null ? matriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.matriculaPK == null && other.matriculaPK != null) || (this.matriculaPK != null && !this.matriculaPK.equals(other.matriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CRUD_LAB.entity.Matricula[ matriculaPK=" + matriculaPK + " ]";
    }
    
}
