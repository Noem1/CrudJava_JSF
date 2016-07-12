package vista.web;

import dao.ProvinciaDao;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import modelo.web.Provincia;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Noemi
 */
@ManagedBean
@SessionScoped
public class ProvinciaBean implements Serializable  {
   
    private List<Provincia> selectItemOneProvincia;
   
    Provincia provincia;

    public ProvinciaBean() {
    }
   


    //METODOS
    //obtener lista de provincias en la vista
    public List<Provincia> getSelectItemOneProvincia() {
        ProvinciaDao dp = new ProvinciaDao();
        this.selectItemOneProvincia = dp.ObtListaProv();
        return selectItemOneProvincia;
    }

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }
    
    
}
