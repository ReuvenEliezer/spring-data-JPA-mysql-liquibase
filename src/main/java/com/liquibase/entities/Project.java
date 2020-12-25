package com.liquibase.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project extends AbstractEntity {

    @Column(name = "title")
    private String title;


    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees = new HashSet<>();

    public Project() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }


    @Override
    public String toString() {
        return "Project{" +
                ", title='" + title + '\'' +
                ", employees=" + employees +
                '}';
    }
}