package fr.simplon.sondagesc;

import fr.simplon.sondagesc.entity.Sondage;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@SpringBootTest
public class TestTousLesSondages {

    private RestTemplate restTemplate;

    @Test
    void test() {
        this.restTemplate = new RestTemplate();
        String url = "http://localhost:8080/rest/sondage";
        ResponseEntity<List<Sondage>> response =
                restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Sondage>>() {
                });
        List<Sondage> sondages = response.getBody();
        assert (!sondages.isEmpty());
    }
}
