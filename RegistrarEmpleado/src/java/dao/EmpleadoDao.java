/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import hibernateUtil.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.swing.JOptionPane;
import org.hibernate.Criteria;
import org.hibernate.Session;
import modelo.web.Empleado;
import modelo.web.Provincia;
import org.hibernate.Query;
/**
 *
 * @author Noemi
 */
public class EmpleadoDao  implements Serializable{
public Session getSession() {
        return HibernateUtil.getSession();
    }
     
//     metodo guardar
    public void guardarEmpleado(Object o) {
        Session se = HibernateUtil.getSession();
        try {
            se.beginTransaction();
            se.saveOrUpdate(o);
            se.getTransaction().commit();
        } catch (Exception e) {
            se.getTransaction().rollback();
            JOptionPane.showMessageDialog(null, "Error");
        }        
    }
    
    // obtener todo
    public List<Empleado> getAll(Session s){
         try {
            Criteria cri = s.createCriteria(Empleado.class);
            List lista = cri.list();
            return lista;
        } catch (Exception e) {
            System.out.println("No  hay datos");
            return new ArrayList();// devolver lista vacia
        }
    
    }
//metodo eliminar
    public void eliminar(Object o) {
        Session s = getSession();
        try {
            s.beginTransaction();
            s.delete(o);
            s.getTransaction().commit();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "éxito","Cliente Eliminado"));
        }
        s.close();
    }
    
//    
    public void actualiza(Object ob)  { 
        Session  se=getSession();
    try 
    { 
        se.beginTransaction();
        se.update(ob); 
        se.getTransaction().commit(); 
    }catch (Exception e){
        se.beginTransaction().rollback();
        se.close();
    }
    }
  
}
