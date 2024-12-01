/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.persistence.*;

/**
 *
 * @author Steve
 */
@Entity
@Table(name = "newtb")
public class patients {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "p_name")
    private String p_name;
    
    @Column(name = "complaints")
    private String complaints;
    
        
    @Column(name = "p_type")
    private String p_type;
    
    @Column(name = "narration")
    private String narration;
    
    @Column(name = "nurse")
    private String nurse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getComplaints() {
        return complaints;
    }

    public void setComplaints(String complaints) {
        this.complaints = complaints;
    }

    public String getP_type() {
        return p_type;
    }

    public void setP_type(String p_type) {
        this.p_type = p_type;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getNurse() {
        return nurse;
    }

    public void setNurse(String nurse) {
        this.nurse = nurse;
    }
    
    
}
