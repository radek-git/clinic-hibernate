package com.radek.clinic.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "offices")
@Data
@NoArgsConstructor
public class Office implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OFFICE")
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FLOOR")
    private int floor;


    public Office(String name, int floor) {
        this.name = name;
        this.floor = floor;
    }
}
