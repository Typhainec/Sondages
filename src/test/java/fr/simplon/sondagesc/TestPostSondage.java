package fr.simplon.sondagesc;

import fr.simplon.sondagesc.entity.Sondage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TestPostSondage {

        private RestTemplate restTemplate = new RestTemplate();

        @Test
        void test() {
                Sondage sondage = new Sondage();
                sondage.setQuestion("Test question");
                sondage.setDescription("Test description");

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                HttpEntity<Sondage> request = new HttpEntity<>(sondage, headers);
                String url = "http://localhost:8080/rest/sondage/save";
                ResponseEntity<Sondage> response = restTemplate.postForEntity(url, request, Sondage.class);

                assertEquals(HttpStatus.OK, response.getStatusCode());
        }
}
