package com.schoolofnet.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private String username;
    @Column
    private String name;
    @Column
    private String lastname;
    @Column(name = "created_date")
    private Date createdDate;
    @Column
    @OneToOne(mappedBy = "user")
    private Address address;
    @Column
    @OneToMany(mappedBy = "options")
    @ElementCollection
    private List<Options> options;
    @Column
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "computers")
    @ElementCollection
    private List<Computer> computers;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setComputers(List<Computer> computers) {
        this.computers = computers;
    }

    public List<Computer> getComputers() {
        return computers;
    }
}
