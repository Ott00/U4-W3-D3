package it.epicode.dao;

import it.epicode.entities.Partecipazione;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PartecipazioneDAO {
    private final EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void save(Partecipazione partecipazione) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(partecipazione);
        transaction.commit();

        System.out.println("La partecipazione di " + partecipazione.getPerson() + " è stata aggiunto correttamente!");
    }

    public Partecipazione getById(long id) {
        return entityManager.find(Partecipazione.class, id);
    }

    public void deleteById(long id) {
        Partecipazione found = this.getById(id);

        if (found != null) {
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(found);
            transaction.commit();

            System.out.println("La partecipazione di " + found.getPerson() + " rimosso correttamente!");

        } else {
            System.out.println("La partecipazione con id [" + id + "] non è stato trovata");
        }
    }
}
