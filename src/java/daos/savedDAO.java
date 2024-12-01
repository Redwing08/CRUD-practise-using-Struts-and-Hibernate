/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import models.patients;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.internal.util.xml.ErrorLogger;
import utils.HibernateUtil;

/**
 *
 * @author Steve
 */
public class savedDAO {
    public String saveUser(patients p){
        Session s = null;
        Transaction tr = null;
        s = HibernateUtil.getSessionFactory().openSession();
        
        tr = s.beginTransaction();
        s.saveOrUpdate(p);
        
        tr.commit();
        s.close();
        return "SUCCESS";
    }
    
    
    
    public List<patients> getAllPatients(){
    Session session = HibernateUtil.getSessionFactory().openSession();
    List<patients> patients = null;
    try {
        String hql = "FROM patients"; // HQL query
        org.hibernate.Query query = (org.hibernate.Query) session.createQuery(hql); // Create query
          patients = query.list();// Cast the result to a list of users
    } finally {
        session.close();
    }
    return patients;
}
    
    
  
    
    
    
    
  public Boolean deletePatientbyId(int id) {
        Boolean retValue = true;
        patients c = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            c = (patients) session.get(patients.class, id);
            session.delete(c);
            if (!session.getTransaction().wasCommitted()) session.getTransaction().commit();
        } catch (HibernateException e) {
            if (session.getTransaction() != null && session.getTransaction().isActive()) {
                session.getTransaction().rollback();
            }

            retValue = false;
        } finally {
            session.close();
        }
        return retValue;
    }  
      public patients getID(int id){
      patients retValue = null;
    Session s  = HibernateUtil.getSessionFactory().openSession();
    
    try{
        s.beginTransaction();
        retValue = (patients) s.get(patients.class, id);
        if(s.getTransaction().wasCommitted()) s.getTransaction().commit();
    }catch(HibernateException e){
        if(s.getTransaction() != null && s.getTransaction().isActive()){
            s.getTransaction().rollback();
        }
     
    }finally{
        s.close();
        
        
    }
    return retValue;
    }
      
      
      
      
  public List<patients> getAllTypes(String type) {
    List<patients> patients = new ArrayList<>();
    Session session = HibernateUtil.getSessionFactory().openSession();

    try {
        // HQL query - ensure 'patients' matches your entity class name
        String hql = "FROM patients WHERE p_type = :type";
        Query query = session.createQuery(hql);
        query.setParameter("type", type);
        patients = query.list();
    } catch (Exception e) {
        // Use a logging framework for better logging in production
        e.printStackTrace();
    } finally {
        // Always close the session
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    return patients;
}




  

}
