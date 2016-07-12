/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hibernateUtil;

import dao.EmpleadoDao;
import dao.ProvinciaDao;
import modelo.web.Empleado;
import modelo.web.Provincia;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Noemi
 */
public class HibernateUtil {

    private static Session sesion;
    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    //metodo
    public static Session getSession() {
        return getSessionFactory().openSession();
    }

    public static void main(String[] args) {

        hibernateUtil.HibernateUtil h = new HibernateUtil();
        EmpleadoDao emp = new EmpleadoDao();
        Empleado e = new Empleado();
        //Provincia prov = new Provincia();
//        ProvinciaDao pd = new ProvinciaDao();
//
//        Provincia p1 = new Provincia();
//        p1.setNombre("AZUAY");
//        pd.guardarProv(p1);
//        Provincia p2 = new Provincia();
//        p2.setNombre(" BOLIVAR");
//        pd.guardarProv(p2);
//        Provincia p3 = new Provincia();
//        p3.setNombre("CAÑAR");
//        pd.guardarProv(p3);
//        Provincia p4 = new Provincia();
//        p4.setNombre("CARCHI");
//        pd.guardarProv(p4);
//        Provincia p5 = new Provincia();
//        p5.setNombre("COTOPAXI");
//        pd.guardarProv(p5);
//        Provincia p6 = new Provincia();
//        p6.setNombre("CHIMBORAZO");
//        pd.guardarProv(p6);
//        Provincia p7 = new Provincia();
//        p7.setNombre("EL ORO");
//        pd.guardarProv(p7);
//        Provincia p8 = new Provincia();
//        p8.setNombre("ESMERALDAS");
//        pd.guardarProv(p8);
//        Provincia p9 = new Provincia();
//        p9.setNombre("GUAYAS");
//        pd.guardarProv(p9);
//        Provincia p10 = new Provincia();
//        p10.setNombre("GALAPAGOS");
//        pd.guardarProv(p10);
//        Provincia p11 = new Provincia();
//        p11.setNombre("IMBABURA");
//        pd.guardarProv(p11);
//        Provincia p12 = new Provincia();
//        p12.setNombre("LOJA");
//        pd.guardarProv(p12);
//        Provincia p13 = new Provincia();
//        p13.setNombre("LOS RIOS");
//        pd.guardarProv(p13);
//        Provincia p14 = new Provincia();
//        p14.setNombre("MANABI");
//        pd.guardarProv(p14);
//        Provincia p15 = new Provincia();
//        p15.setNombre("MORONA SANTIAGO");
//        pd.guardarProv(p15);
//        Provincia p16 = new Provincia();
//        p16.setNombre("NAPO");
//        pd.guardarProv(p16);
//        Provincia p17 = new Provincia();
//        p17.setNombre("PASTAZA");
//        pd.guardarProv(p17);
//        Provincia p18 = new Provincia();
//        p18.setNombre("PICHINCHA");
//        pd.guardarProv(p18);
//        Provincia p19 = new Provincia();
//        p19.setNombre("TUNGURAHUA");
//        pd.guardarProv(p19);
//        Provincia p20 = new Provincia();
//        p20.setNombre("SUCUMBIOS");
//        pd.guardarProv(p20);
//        Provincia p21 = new Provincia();
//        p21.setNombre("ORELLANA");
//        pd.guardarProv(p21);
//        Provincia p22 = new Provincia();
//        p22.setNombre("SANTO DOMINGO DE LOS TSACHILAS");
//        pd.guardarProv(p22);
//        Provincia p23 = new Provincia();
//        p23.setNombre("SANTA ELENA");
//        pd.guardarProv(p23);
//        Provincia p24 = new Provincia();
//        p24.setNombre("ZAMORA CHINCHIPE");
//        pd.guardarProv(p24);

    }

}
