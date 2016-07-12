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
import javax.swing.JOptionPane;
import modelo.web.Provincia;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Noemi
 */
public class ProvinciaDao implements Serializable{
   // obteniendo la sesion 
    public Session getSession() {
        return HibernateUtil.getSession();
    }

//     metodo guardar provincia
    public void guardarProv(Object o) {
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

    //metodo para obtener un objeto a partir de su id
    public Provincia getId(String nombre) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String consulta = "from Provincia where nombre =:nombre";
        Query query = session.createQuery(consulta);
        query.setString("nombre", nombre);
        Provincia provincia = (Provincia) query.uniqueResult();
        return provincia;
    }

    //obtener lista provincias
    public List<Provincia> ObtListaProv() { // buscar todas las provincias

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Criteria cri = session.createCriteria(Provincia.class);//obtener la lista
        ArrayList<Provincia> lis = (ArrayList<Provincia>) cri.list();

        session.close();
        return lis;
 
}
}
