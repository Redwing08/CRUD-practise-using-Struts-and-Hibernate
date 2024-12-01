/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import com.opensymphony.xwork2.ActionSupport;
import daos.savedDAO;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import models.patients;
import org.apache.struts2.ServletActionContext;

/**
 *
 * @author Steve
 */
public class PatientsAction extends ActionSupport {
    private String type;
    
    
    private boolean isEdit;
    
    private patients p = new patients();
    
    
    private List<patients> patients;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isIsEdit() {
        return isEdit;
    }

    public void setIsEdit(boolean isEdit) {
        this.isEdit = isEdit;
    }

  
    
    
    
    
    
    public List<patients> getPatients() {
        return patients;
    }

    public void setPatients(List<patients> patients) {
        this.patients = patients;
    }
    
    
    
    

    public patients getP() {
        return p;
    }

    public void setP(patients p) {
        this.p = p;
    }
    
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    
    
    
//    private String p_name;
//    private String p_type;
//    private String narration;
//    private String complaints;
//    private String nurse;
//
//    public String getP_name() {
//        return p_name;
//    }
//
//    public void setP_name(String p_name) {
//        this.p_name = p_name;
//    }
//
//    public String getP_type() {
//        return p_type;
//    }
//
//    public void setP_type(String p_type) {
//        this.p_type = p_type;
//    }
//
//    public String getNarration() {
//        return narration;
//    }
//
//    public void setNarration(String narration) {
//        this.narration = narration;
//    }
//
//    public String getComplaints() {
//        return complaints;
//    }
//
//    public void setComplaints(String complaints) {
//        this.complaints = complaints;
//    }
//
//    public String getNurse() {
//        return nurse;
//    }
//
//    public void setNurse(String nurse) {
//        this.nurse = nurse;
//    }
//    
//    
//    
//    public PatientsAction() {
//    }
    
    public String execute() throws Exception {
   
//           patients p = new patients();
//            p.setP_name(p_name);
//            p.setP_type(p_type);
//            p.setComplaints(complaints);
//            p.setNarration(narration);
//            p.setNurse(nurse);
//            
//            savedDAO dao = new savedDAO();
//             this.isEdit = true;
//            dao.saveUser(p);
//        savedDAO dao = new savedDAO();
//        List<patients> patients = dao.getAllPatients();
//        setPatients(patients);
//        return SUCCESS;
     
     
     return SUCCESS;
    }
    
    public String add(){
            isEdit = true;
            savedDAO dao = new savedDAO();
            dao.saveUser(p);
             return SUCCESS;

       
    }
    
//    public String getAllData(){
//        savedDAO dao = new savedDAO();
//        patients = dao.getAllPatients();
//        
//        return SUCCESS;
//    }
//    

    
    public String editData(){
        savedDAO dao = new savedDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = Integer.valueOf(request.getParameter("id"));
        this.p = dao.getID(id);
       
       
        System.out.println(p.getId());
        return SUCCESS;
    }

    public String deleteData(){
        savedDAO dao = new savedDAO();
        HttpServletRequest request = ServletActionContext.getRequest();
        int id = Integer.valueOf(request.getParameter("id"));
        
        dao.deletePatientbyId(id);
        getAllData();
   
        return SUCCESS;
        
    }
   
    public String getAllData() {
    savedDAO dao = new savedDAO();
    if ("All".equalsIgnoreCase(type) || type == null || type.isEmpty()) {
        // Get all patients if type is "All" or not provided
        patients = dao.getAllPatients();
    } else {
        // Get filtered patients by type
        patients = dao.getAllTypes(type);
    }
    return SUCCESS;
}

    
public List<patients> typeData() {
    savedDAO dao = new savedDAO();
    patients = dao.getAllTypes(type);  // Ensure this returns a non-null list
    if (patients == null) {
        patients = new ArrayList<>();  // Initialize to an empty list if null
    }
    return patients;
}

}
