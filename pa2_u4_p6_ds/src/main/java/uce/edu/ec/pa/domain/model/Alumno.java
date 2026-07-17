package uce.edu.ec.pa.domain.model;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="alumno")
public class Alumno extends PanacheEntityBase {

    @Id
    @Column(name="alum_id")
    @SequenceGenerator(name="seq_alumno_generator", sequenceName="seq_alumno", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seq_alumno_generator")
    private Integer id;

    @Column(name="alum_apellido")
    private String apellido;

    @Column(name="alum_nombre")
    private String nombre;

    @Column(name="alum_cedula")
    private String cedula;

    @Column(name="alum_facultad")
    private String facultad;

    @Column(name="alum_semestre")
    private String semestre;

    public Alumno(Integer id, String apellido, String nombre, String cedula, String faculdad, String semestre) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.cedula = cedula;
        this.facultad = faculdad;
        this.semestre = semestre;
    }

    public Alumno() {

    }

    public Integer getId() {
        return id;

    }

    public void setId(Integer id) {
        this.id = id;

    }

    public String getApellido() {
        return apellido;

    }

    public void setApellido(String apellido) {
        this.apellido = apellido;

    }

    public String getNombre() {
        return nombre;

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;

    }

    public String getCedula() {
        return cedula;

    }

    public void setCedula(String cedula) {
        this.cedula = cedula;

    }

    public String getFacultad() {
        return facultad;

    }

    public void setFacultad(String faculdad) {
        this.facultad = faculdad;

    }

    public String getSemestre() {
        return semestre;

    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;

    }

    @Override
    public String toString() {
        return "Alumno [id=" + id + ", apellido=" + apellido + ", nombre=" + nombre + ", cedula=" + cedula
                + ", faculdad=" + facultad + ", semestre=" + semestre + "]";
                
    }

}
