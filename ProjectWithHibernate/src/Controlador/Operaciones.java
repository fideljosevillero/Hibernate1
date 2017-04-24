/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.InfPersonal;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.*;

/**
 *
 * @author fidel.villero
 */
public class Operaciones {
    
    public void guardarData(InfPersonal personal){
        try{
            SessionFactory sesionFactory = NewHibernateUtil.getSessionFactory();
            Session sesion;
            sesion = sesionFactory.openSession();
            
            Transaction tx = sesion.beginTransaction();
            sesion.save(personal);
            tx.commit();
            sesion.close();
        }catch(Exception er){
            System.out.println("Error guardando {0}" + er.toString());
        }
        
    }
    
    public InfPersonal getData(String correo){
        SessionFactory sesionFactory = NewHibernateUtil.getSessionFactory();
        Session sesion = sesionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        try{
            Query query = sesion.createQuery("from InfPersonal where correo = '"+correo+"'");
            tx.commit();                   
            return (InfPersonal)query.list().get(0);
        }catch(Exception er){
            System.out.println("error "+er.toString());
            return new InfPersonal();
        }finally{
            sesion.close(); 
        }
    }
    
    public boolean updateData(InfPersonal obj){
        SessionFactory sesionFactory = NewHibernateUtil.getSessionFactory();
        Session sesion = sesionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        try{
            InfPersonal p = getData(obj.getCorreo());
            p.setNombres("ACTUALIZADO");
            sesion.update(p);
            tx.commit();
        }catch(Exception er){
            System.out.println("Error "+er.toString());
        }finally{
            sesion.close();
        }
        return false;
    }
    
    public boolean deleteData(String correo){
        SessionFactory sesionFactory = NewHibernateUtil.getSessionFactory();
        Session sesion = sesionFactory.openSession();
        Transaction tx = sesion.beginTransaction();
        try{
            InfPersonal p = getData(correo);
            sesion.delete(p);
            tx.commit();
        }catch(Exception er){
            System.out.println("Error "+er.toString());
        }finally{
            sesion.close();
        }
        return false;
    }
    
}
