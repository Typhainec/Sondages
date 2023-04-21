package fr.simplon.sondagesc;

import fr.simplon.sondagesc.entity.Sondage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestPutSondage {
    private RestTemplate restTemplate = new RestTemplate();
    private Long id = 10L;
    private Sondage sondage = new Sondage();

    @Test
    void testPutSondage() {

        String url = "http://localhost:8080/rest/sondage/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Sondage> request = new HttpEntity<>(sondage, headers);
        ResponseEntity<Sondage> putResponse = restTemplate.exchange(url, HttpMethod.PUT, request, Sondage.class, id);
        assertNotNull(putResponse.getBody());


        String getUrl = "http://localhost:8080/rest/sondage/{id}";
        ResponseEntity<Sondage> getResponse = restTemplate.getForEntity(getUrl, Sondage.class, id);
        assertNotNull(getResponse.getBody());


        Sondage updatedSondage = getResponse.getBody();
        assertEquals(sondage.getDescription(), updatedSondage.getDescription());
        assertEquals(sondage.getQuestion(), updatedSondage.getQuestion());
        assertEquals(sondage.getCreation(), updatedSondage.getCreation());
        assertEquals(sondage.getCloture(), updatedSondage.getCloture());
        assertEquals(sondage.getPersonne(), updatedSondage.getPersonne());
    }
}
