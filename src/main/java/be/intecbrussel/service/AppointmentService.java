package be.intecbrussel.service;

import be.intecbrussel.connection.EntityManagerProvider;
import be.intecbrussel.model.Appointment;
import be.intecbrussel.repository.AppointmentRepository;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class AppointmentService {

    private AppointmentRepository appointmentRepository = new AppointmentRepository();

    public void createAppointment(Appointment appointment) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        String newId = String.valueOf(appointment.getDay()) + "_" + String.valueOf(appointment.getMonth());
        appointment.setId(newId);
        appointmentRepository.createAppointment(em, appointment);
        em.close();

    }

    public Optional<Appointment> readAppointment(String id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Appointment> optionalCountry = appointmentRepository.readAppointment(em, id);
        em.close();
        return optionalCountry;
    }

    public void deleteCountry(String id) {
        EntityManager em = EntityManagerProvider.getEntityManager();
        Optional<Appointment> appointment = appointmentRepository.readAppointment(em, id);

        if (appointment.isPresent()) {
            appointmentRepository.deleteCountry(em, appointment.get());
        }
        em.close();

    }

}
