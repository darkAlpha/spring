package org.mura.asyncservice.entity;


import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Entity
public class Model{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "create_time")
    private LocalDate createTime;

    public Model() {}

    public Model setId(Long id) {
        this.id = id;
        return this;
    }

    public Model setMessage(String message) {
        this.message = message;
        return this;
    }

    public Model setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
        return this;
    }
}
