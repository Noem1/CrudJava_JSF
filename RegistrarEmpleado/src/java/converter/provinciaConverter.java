/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package converter;

import dao.ProvinciaDao;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import modelo.web.Provincia;

/**
 *
 * @author Noemi
 */
@FacesConverter(value = "convertidorProvincia")
public class provinciaConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        ProvinciaDao cp = new ProvinciaDao();
        //consulta
        Provincia p = cp.getId(value); // enviando el id q esta como string y lo transformo a long

        return p;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value != null) {
            System.out.println("............."+value.toString());
            if (value instanceof Provincia) {
                Provincia p1 = (Provincia) value;
                String retornarid = p1.getNombre();
                return retornarid;
            }
            System.out.println("No es una instancia de provincia");
            return "";
        }
        System.out.println("el valor es nulo");
        return "";

    }
    // CUANDO VOY A RETORNAR Y SOLO ME MUESTRA UN NOMBRE EN STRING PERO NECESITO UNA LISTA DE OBJETOS 
    
    /*
    recuperar un objeto de una clase a partir de un string por ejemplo.... cuando listas elementos ciudades por eejmplo... en el select te aparece tan solo un string y necesitas devolver todo el objeto... entonces creas el converter...
    */

}
