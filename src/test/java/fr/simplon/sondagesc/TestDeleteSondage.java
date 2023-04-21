package fr.simplon.sondagesc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@SpringBootTest
public class TestDeleteSondage {
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    void TestDeleteSondage() {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/sondage/{id}";
        Long id = 1L;
        restTemplate.delete(url, id);
    }
}
