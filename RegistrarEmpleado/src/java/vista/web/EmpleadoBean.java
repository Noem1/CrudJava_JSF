/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.web;

import dao.EmpleadoDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.web.Empleado;
import modelo.web.Provincia;


/**
 *
 * @author Noemi
 */
@ManagedBean
@SessionScoped
public class EmpleadoBean implements Serializable{

    private Empleado empleadoEdicion;
    private Provincia provincia;
    private List<Empleado> lista;
    private List<Provincia> selectItemOneProvincia;

    //constructor 
    public EmpleadoBean() {
        empleadoEdicion = new Empleado();
        provincia = new Provincia();

    }
    // metodos 

    public String accionNuevo() {
        empleadoEdicion = new Empleado();
     
        return "ingresarDatos?faces-redirect=true";
    }

    public void accionEliminar() {
        EmpleadoDao eliC = new EmpleadoDao();

        eliC.eliminar(empleadoEdicion);
        empleadoEdicion = new Empleado();
    }

    public String accionEditar() {
        EmpleadoDao edC = new EmpleadoDao();

        edC.actualiza(empleadoEdicion);
        return "ingresarDatos?faces-redirect=true";
    }

    public String accionCancelar() {
        empleadoEdicion = null;
        return "lista?faces-redirect=true";
    }

    public String accionGuardar() {
        empleadoEdicion.setProvincia(provincia);
        new EmpleadoDao().guardarEmpleado(empleadoEdicion);
        return "lista?faces-redirect=true";
    }

    public List<Empleado> listaEmpleados() {
        EmpleadoDao cd = new EmpleadoDao();
        lista = cd.getAll(cd.getSession());
        return lista;
    }
 
    public Empleado getEmpleadoEdicion() {
        return empleadoEdicion;
    }

    public void setEmpleadoEdicion(Empleado empleadoEdicion) {
        this.empleadoEdicion = empleadoEdicion;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public List<Empleado> getLista() {
        return lista;
    }

    public void setLista(List<Empleado> lista) {
        this.lista = lista;
    }

    public List<Provincia> getSelectItemOneProvincia() {
        return selectItemOneProvincia;
    }

    public void setSelectItemOneProvincia(List<Provincia> selectItemOneProvincia) {
        this.selectItemOneProvincia = selectItemOneProvincia;
    }

}
