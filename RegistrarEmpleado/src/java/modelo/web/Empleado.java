/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.web;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Noemi
 */
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_em;
    @Column(length = 50, nullable = false)
    String nombres;
    @Column(length = 50, nullable = false)
    String apellidos;
    @Temporal(TemporalType.DATE)
    Date fechaNacimiento;
    @Column(length = 10, nullable = false)
    String numTelf;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_prov")
    private Provincia provincia;

    
    public Empleado() {
    }

    public String getNombres() {
        return nombres;
    }

 

    public Long getId_em() {
        return id_em;
    }

    public void setId_em(Long id_em) {
        this.id_em = id_em;
    }
       public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumTelf() {
        return numTelf;
    }

    public void setNumTelf(String numTelf) {
        this.numTelf = numTelf;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

}
