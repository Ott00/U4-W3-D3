package it.epicode.entities;

import it.epicode.enumeration.Stato;

import javax.persistence.*;

@Entity
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;
    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione(){}

    public Partecipazione(Persona person, Evento evento, Stato stato) {
        this.persona = person;
        this.evento = evento;
        this.stato = stato;
    }
    public Long getId() {
        return id;
    }
    public Evento getEvento() {
        return evento;
    }
    public void setEvento(Evento evento) {
        this.evento = evento;
    }
    public Persona getPerson() {
        return persona;
    }

    public void setPerson(Persona person) {
        this.persona = person;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "id=" + id +
                ", person=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
