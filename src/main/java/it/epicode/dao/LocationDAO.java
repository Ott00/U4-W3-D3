package it.epicode.dao;

import it.epicode.entities.Location;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class LocationDAO {
    private final EntityManager entityManager;
    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public void save(Location location) {
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        entityManager.persist(location);
        transaction.commit();

        System.out.println(location.getNome() + " aggiunto correttamente!");
    }
    public Location getById(long id) {
        return entityManager.find(Location.class, id);
    }
    public void deleteById(long id) {
        Location found = this.getById(id);

        if (found != null) {
            EntityTransaction transaction = entityManager.getTransaction();

            transaction.begin();
            entityManager.remove(found);
            transaction.commit();

            System.out.println("Location [" + found.getNome() + "] rimossa correttamente!");

        } else {
            System.out.println("La location con id [" + id + "] non è stato trovata");
        }
    }
}
