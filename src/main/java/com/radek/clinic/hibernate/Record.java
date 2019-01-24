package com.radek.clinic.hibernate;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "records")
@Getter
@NoArgsConstructor
public class Record implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECORD")
    private Integer id;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "ID_APPOINTMENT")
//    private Appointment appointment;

    @Column(name = "CONTENT")
    private String content;

    public Record(String content) {
        this.content = content;
    }
}
