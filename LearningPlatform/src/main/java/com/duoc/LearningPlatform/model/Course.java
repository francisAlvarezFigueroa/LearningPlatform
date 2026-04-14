package com.duoc.LearningPlatform.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(name= "Nombre_Curso", length =200, nullable =false)
    private String name; 

    @Column(name= "Nombre_Instructor", length =200, nullable =false)
    private String instructor; 

    @Column(name="Curso_activo", nullable=false)
    private boolean active; 


    public Course(){}

    // para caso practico sin bd
    // con id autogenerado 
    public Course(Long id,String name, String instructor, boolean active) {
        this.id=id;
        this.name = name;
        this.instructor = instructor;
        this.active = active;
    }


    // con id autogenerado 
    public Course(String name, String instructor, boolean active) {
        this.name = name;
        this.instructor = instructor;
        this.active = active;
    }
    
     public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    //todo: ask about this
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    






}
