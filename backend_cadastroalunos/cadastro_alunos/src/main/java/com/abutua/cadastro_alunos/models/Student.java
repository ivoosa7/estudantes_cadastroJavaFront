package com.abutua.cadastro_alunos.models;

public class Student {
    //Atributos
    private int id;
    private String name;
    private String email;
    private String phone;
    private boolean newStudent;
    private Course course;
    private int period;
    
    //Construtor
    public Student() {
    }

    public Student(int id, String name, String email, String phone, boolean newStudent, Course course, int period) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.newStudent = newStudent;
        this.course = course;
        this.period = period;
    }

    //Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isNewStudent() {
        return newStudent;
    }

    public void setNewStudent(boolean newStudent) {
        this.newStudent = newStudent;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }
    
}
