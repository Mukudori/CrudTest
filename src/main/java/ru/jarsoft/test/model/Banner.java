package ru.jarsoft.test.model;

import java.math.BigDecimal;
import javax.persistence.*;

@Entity
@Table(name="t_banner")
public class Banner {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name="category_id", referencedColumnName = "id")
    private Category category;
    @Column(name="content")
    private String content;
    @Column(name="deleted")
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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString(){
        return "id " + id + " , Name = " + name + " Content = " + content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


}
