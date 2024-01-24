package it.epicode.dao;

import it.epicode.entities.Persona;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonaDAO {
    private final EntityManager entityManager;
    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Persona persona) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(persona);
        transaction.commit();

        System.out.println(persona.getNome() + " " + persona.getCognome() + " aggiunto correttamente!");
    }
    public Persona getById(long id) {
        return entityManager.find(Persona.class, id);
    }
    public void deleteById(long id) {
        Persona found = this.getById(id);

        if (found != null) {
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(found);
            transaction.commit();

            System.out.println(found.getNome() + " " + found.getCognome() + " rimosso correttamente!");

        } else {
            System.out.println("La persona con id [" + id + "] non è stato trovata");
        }
    }
}
