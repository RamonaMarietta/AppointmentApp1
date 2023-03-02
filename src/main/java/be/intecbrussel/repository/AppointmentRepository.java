package be.intecbrussel.repository;

import be.intecbrussel.model.Appointment;
import jakarta.persistence.EntityManager;

import java.util.Optional;

public class AppointmentRepository {

    public void createAppointment(EntityManager em, Appointment appointment){
        em.getTransaction().begin();

        em.persist(appointment);

        em.getTransaction().commit();
        //persistence context
    }
    public Optional<Appointment> readAppointment(EntityManager em, String id){
        Appointment appointment   = em.find(Appointment.class,id);
        return Optional.ofNullable(appointment);
        //if statement also possible
    }
    public void deleteCountry(EntityManager em,Appointment appointment){
        em.getTransaction().begin();
        em.remove(appointment);
        em.getTransaction().commit();
    }

}
