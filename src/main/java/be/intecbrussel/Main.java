package be.intecbrussel;

import be.intecbrussel.model.Appointment;
import be.intecbrussel.service.AppointmentService;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        int appointmentDay = 03;
        int appointmentMonth = 04;
        int appointmentYear = 2023;
        int appointmentHour = 15;
        int appointmentMinute = 15;

        Appointment appointment =
                new Appointment(
                        "rdv",
                        "dentist",
                        appointmentDay,
                        appointmentMonth,
                        appointmentYear,
                        appointmentHour,
                        appointmentMinute);
        //     this.id = day + "_" + month + "_"+ year +"_"  + hour + "_" + minute;
        AppointmentService appointmentService = new AppointmentService();
        appointmentService.createAppointment(appointment);
        System.out.println("appointment created: "+ appointment.getId());
        String appointmentId = appointmentDay + "_" + appointmentMonth +"_" + appointmentYear + "_" + appointmentHour + "_"
                + appointmentMinute;
        System.out.println("trying to get appointment: "+ appointmentId );
        Appointment createdAppointment = appointmentService.readAppointment(appointmentId).get();
        System.out.println(createdAppointment.getDescription());



    }
}