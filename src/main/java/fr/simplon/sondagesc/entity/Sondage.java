package fr.simplon.sondagesc.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "sondage")
public class Sondage {

    /*
une description (chaîne vide/blanche interdite, min 3 caractères et max 120 caractères)
une question (max 120 car.)
une date de création (automatiquement remplie au jour actuel),
une date de cloture (doit être après la date de création)
le nom de la personne qui l'a proposé (chaine vide/blanche interdite, max 64 car.)
     */

    public Sondage(String description, String question, LocalDate cloture, LocalDate creation, String personne) {
        this.Description = description;
        this.Question = question;
        this.Creation = creation;
        this.Cloture = cloture;
        this.Personne = personne;
    }

    public Sondage() {}

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(length = 120, nullable = false) // Determine la longueur et qu'il n'accepte pas que le champ soit vide.
    private String Description;
    @Column(length = 120) // Determine la longueur.
    private String Question;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Sinon problème formulaire Thymeleaf th:field avec les <input type="date">
    private LocalDate Creation;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Sinon problème formulaire Thymeleaf th:field avec les <input type="date">
    private LocalDate Cloture;

    @Column(length = 64, nullable = false)
    private String Personne;


    // ----------- Getters and setters ------------- //

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }

    public LocalDate getCreation() {
        return Creation;
    }

    public void setCreation(LocalDate creation) {
        Creation = creation;
    }

    public LocalDate getCloture() {
        return Cloture;
    }

    public void setCloture(LocalDate cloture) {
        Cloture = cloture;
    }

    public String getPersonne() {
        return Personne;
    }

    public void setPersonne(String personne) {
        Personne = personne;
    }
}
