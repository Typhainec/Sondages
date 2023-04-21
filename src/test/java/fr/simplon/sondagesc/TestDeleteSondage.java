package fr.simplon.sondagesc;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
class TestDeleteSondage {
    private RestTemplate restTemplate = new RestTemplate();

    @Test
    void TestDeleteSondage() {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/sondage/{id}";
        Long id = 1L;
        restTemplate.delete(url, id);
        assertNull(restTemplate.getForObject(url, String.class, id));
    }
}
