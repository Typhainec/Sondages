package fr.simplon.sondagesc.controller;

import fr.simplon.sondagesc.dao.SondageRepository;
import fr.simplon.sondagesc.entity.Sondage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Configuration

@RestController
public class SondageController {

    private final SondageRepository repo;

    public SondageController(SondageRepository fr) {this.repo = fr;}

    @GetMapping("/rest/sondage") //Permet d'afficher les sondages existants en base de données.
    public List<Sondage> getSondage(){return repo.findAll();}

    @GetMapping("/rest/sondage/{id}") //Permet d'afficher un sondage en particulier.
    public Sondage getSondageById(@PathVariable Long id){return repo.findById(id).orElse(null);}

    @PostMapping("/rest/sondage") //Permet d'enregistrer un nouveau sondage
    public List<Sondage> saveSondage(@RequestBody Sondage sondage) {
        repo.save(sondage);
        return repo.findAll();
    }

    @PutMapping("/rest/sondage/{id}") //Permet de mettre à jour un sondage
    public Sondage updateSondage(@PathVariable Long id, @NonNull @RequestBody Sondage updateSondage){
        Sondage sondage = repo.findById(id).orElse(null);
        if (sondage != null){
            sondage.setDescription(updateSondage.getDescription());
            sondage.setQuestion(updateSondage.getQuestion());
            sondage.setCreation(updateSondage.getCreation());
            sondage.setCloture(updateSondage.getCloture());
            sondage.setPersonne(updateSondage.getPersonne());
        }
        assert sondage != null;
        return repo.save(sondage);
    }

    @DeleteMapping("/rest/sondage/{id}") // Permet de supprimer un sondage
    public ResponseEntity<String> deleeteSondage(@PathVariable Long id){
        repo.deleteById(id);
        return ResponseEntity.ok("Le sondage " + id + " a bien été supprimé");
    }

}
