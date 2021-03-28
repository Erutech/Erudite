package com.example.erudite;

public class StudentModel {
    private int id;
    private String name;
    private String abc123;
    private String courses;
    private String eruID;

    // constructors
    public StudentModel(int id, String name, String abc123, String courses, String eruID) {
        this.id = id;
        this.name = name;
        this.abc123 = abc123;
        this.courses = courses;
        this.eruID = eruID;
    }
    public StudentModel() {}

    // toString is necessary for printing the contents of a class object
    @Override
    public String toString() {
        return "StudentModel{" +
                "name='" + name + '\'' +
                ", abc123='" + abc123 + '\'' +
                ", courses='" + courses + '\'' +
                ", eruID='" + eruID + '\'' +
                '}';
    }

    // getters
    public String getName() {
        return name;
    }
    public String getAbc123() {
        return abc123;
    }
    public String getCourses() {
        return courses;
    }
    public String getEruID() {
        return eruID;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setAbc123(String abc123) {
        this.abc123 = abc123;
    }
    public void setCourses(String courses) {
        this.courses = courses;
    }
    public void setEruID(String eruID) {
        this.eruID = eruID;
    }
}
