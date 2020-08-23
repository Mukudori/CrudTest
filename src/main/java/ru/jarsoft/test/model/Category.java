package ru.jarsoft.test.model;

import javax.persistence.*;

@Entity
@Table(name="t_category")
public class Category {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "req_name")
    private String req_name;
    @Column(name = "deleted")
    private boolean deleted;

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

    public String getReq_name() {
        return req_name;
    }

    public void setReq_name(String req_name) {
        this.req_name = req_name;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String toString(){
        return name;
    }
}
