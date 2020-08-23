package ru.jarsoft.test.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "t_request")
public class Request {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @JoinColumn(name="banner_id")
    private Banner banner;
    @Column(name="user_agent")
    private String user_agent;
    @Column(name="ip_address")
    private String ip_address;
    @Column(name = "date")
    private Date date;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Banner getBanner() {
        return banner;
    }

    public void setBanner(Banner banner) {
        this.banner = banner;
    }

    public String getUser_agent() {
        return user_agent;
    }

    public void setUser_agent(String user_agent) {
        this.user_agent = user_agent;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String toString(){
        return "[ " + ip_address + ", " + user_agent + ", " + banner.getName() +", " + date + " ]";
    }

}
