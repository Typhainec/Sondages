package fr.simplon.sondagesc;

import fr.simplon.sondagesc.dao.SondageRepository;
import fr.simplon.sondagesc.entity.Sondage;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestSondageById {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private SondageRepository sondageRepository;

    @Test
    public void testGetSondageById() throws Exception {
        // Créer un sondage pour les besoins du test
        Sondage sondage = new Sondage("Chocolat", "Aimez-vous le chocolat ?", LocalDate.parse("2023-09-01"), LocalDate.parse("2023-10-02"), "Charlie Choco");
        sondageRepository.save(sondage);

        // Appeler la méthode getSondageById du contrôleur
        ResponseEntity<Sondage> response = restTemplate.getForEntity("/rest/sondage/" + sondage.getId(), Sondage.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        Sondage responseSondage = response.getBody();
        assertNotNull(responseSondage);
        assertEquals(sondage.getId(), responseSondage.getId());
        assertEquals(sondage.getQuestion(), responseSondage.getQuestion());
        assertEquals(sondage.getDescription(), responseSondage.getDescription());
        assertEquals(sondage.getPersonne(), responseSondage.getPersonne());
        assertEquals(sondage.getCreation(), responseSondage.getCreation());
        assertEquals(sondage.getCloture(), responseSondage.getCloture());
    }

}
