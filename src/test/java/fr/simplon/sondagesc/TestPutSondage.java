package fr.simplon.sondagesc;

import fr.simplon.sondagesc.entity.Sondage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestPutSondage {

    private RestTemplate restTemplate = new RestTemplate();
    private Long id = 5L;

    @Test
    void testPutSondage() {

        // Création d'un sondage avec les valeurs à mettre à jour
        Sondage sondage = new Sondage();
        sondage.setDescription("Nouvelle description");
        sondage.setQuestion("Nouvelle question");
        sondage.setCreation(LocalDate.parse("2023-01-12"));
        sondage.setCloture(LocalDate.parse("2023-05-12"));
        sondage.setPersonne("Nouvelle personne");

        // Envoi de la requête PUT pour mettre à jour le sondage avec l'ID 10
        String url = "http://localhost:8080/rest/sondage/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Sondage> request = new HttpEntity<>(sondage, headers);
        ResponseEntity<Sondage> putResponse = restTemplate.exchange(url, HttpMethod.PUT, request, Sondage.class, id);
        assertEquals(HttpStatus.OK, putResponse.getStatusCode());

        // Vérification que le sondage a bien été modifié en lisant les nouvelles valeurs
        ResponseEntity<Sondage> getResponse = restTemplate.getForEntity(url, Sondage.class, id);
        assertEquals(HttpStatus.OK, getResponse.getStatusCode());
        Sondage updatedSondage = getResponse.getBody();
        assertEquals(sondage.getDescription(), updatedSondage.getDescription());
        assertEquals(sondage.getQuestion(), updatedSondage.getQuestion());
        assertEquals(sondage.getCreation(), updatedSondage.getCreation());
        assertEquals(sondage.getCloture(), updatedSondage.getCloture());
        assertEquals(sondage.getPersonne(), updatedSondage.getPersonne());
    }
}
