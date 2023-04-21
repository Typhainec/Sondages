package fr.simplon.sondagesc;

import fr.simplon.sondagesc.entity.Sondage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
public class TestPutSondage {
    private RestTemplate restTemplate = new RestTemplate();
    private Long id = 10L;
    private Sondage sondage = new Sondage();

    @Test
    void testPutSondage() {
        String url = "http://localhost:8080/rest/sondage/update/{id}";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Sondage> request = new HttpEntity<>(sondage, headers);
        ResponseEntity<Sondage> response = restTemplate.exchange(url, HttpMethod.PUT, request, Sondage.class, id);

    }
}
