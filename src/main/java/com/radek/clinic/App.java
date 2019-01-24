package com.radek.clinic;

import com.radek.clinic.hibernate.Appointment;
import com.radek.clinic.hibernate.Patient;

public class App {

    public static void main(String[] args) {

        var database = Database.getInstance();

        var patient = database.get(Patient.class, 1);
        System.out.println(patient.getSurname());

        var appointment = database.get(Appointment.class, 1);
        System.out.println(appointment.getRecord().getContent());
    }
}
