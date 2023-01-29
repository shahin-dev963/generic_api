package com.shahin.genericrestapi.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(updatable = false)
    private String createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date createdAt;
    private String updatedBy;
    @Temporal(TemporalType.TIME)
    private Date updatedAt;
    private Boolean isActive;

    @PrePersist
    public void setInsertData(){
        this.createdAt = new Date();
        this.createdBy = "shahin";
        this.isActive = true;
    }

    @PreUpdate
    public void setPreUdateData(){
        this.updatedAt = new Date();
    }
}
