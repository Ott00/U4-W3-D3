package it.epicode;

import it.epicode.dao.EventoDAO;
import it.epicode.dao.LocationDAO;
import it.epicode.dao.PartecipazioneDAO;
import it.epicode.dao.PersonaDAO;
import it.epicode.entities.Evento;
import it.epicode.entities.Location;
import it.epicode.entities.Partecipazione;
import it.epicode.entities.Persona;
import it.epicode.enumeration.EventType;
import it.epicode.enumeration.Genere;
import it.epicode.enumeration.Stato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class GestioneEventi {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static void main(String[] args) {
        EntityManager entityManager = emf.createEntityManager(); // Entity Manager è responsabile della gestione delle interazioni col DB
        EventoDAO eventoDAO = new EventoDAO(entityManager);
        LocationDAO locationDAO = new LocationDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);

        Location location1 = new Location("Villa Franca", "Roma");
        Location location2 = new Location("Castello Sforzesco", "Milano");
        Persona persona1 = new Persona("Chiara", "Marini", "chiaramarini@gmail.com", LocalDate.now(), Genere.F);
        Persona persona2 = new Persona("Stefano", "Miceli", "stefanomiceli@gmail.com", LocalDate.now(), Genere.M);
        Evento evento1 = new Evento("Live Green Day", LocalDate.now(), "Concerto Live dei Green Day a Roma", EventType.PUBBLICO, 10000, location1);
        Evento evento2 = new Evento("Live Green Day", LocalDate.now(), "Concerto Live dei Green Day a Milano", EventType.PUBBLICO, 10000, location2);
        Partecipazione partecipazione1 = new Partecipazione(persona1, evento1, Stato.DA_CONFERMARE);
        Partecipazione partecipazione2 = new Partecipazione(persona1, evento1, Stato.CONFERMATA);

        locationDAO.save(location1);
        locationDAO.save(location2);
        personaDAO.save(persona1);
        personaDAO.save(persona2);
        eventoDAO.save(evento1);
        eventoDAO.save(evento2);
        partecipazioneDAO.save(partecipazione1);
        partecipazioneDAO.save(partecipazione2);
        locationDAO.deleteById(29);

        entityManager.close();
    }
}
