package com.radek.clinic.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "appointments")
@Data
@NoArgsConstructor
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_APPOINTMENT")
    private Integer id;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ID_APPOINTMENT", referencedColumnName = "ID_APPOINTMENT")
    private Record record;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PATIENT", referencedColumnName = "ID_USER")
    private User patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCTOR", referencedColumnName = "ID_USER")
    private User doctor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_EMPLOYEE", referencedColumnName = "ID_USER")
    private User employee;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_OFFICE", referencedColumnName = "ID_OFFICE")
    private Office office;

    @Column(name = "DATETIME")
    private LocalDateTime dateTime;

    @Column(name = "APPOINTMENT_DATE")
    private LocalDateTime appointmentDate;

    @Column(name = "STATUS")
    private String status;


    public Appointment(Record record, User patient, User doctor, User employee, Office office, LocalDateTime dateTime,
                       LocalDateTime appointmentDate, String status) {
        this.record = record;
        this.patient = patient;
        this.doctor = doctor;
        this.employee = employee;
        this.office = office;
        this.dateTime = dateTime;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }
}
