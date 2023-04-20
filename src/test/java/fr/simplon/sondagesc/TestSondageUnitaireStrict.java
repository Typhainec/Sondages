package fr.simplon.sondagesc;

import fr.simplon.sondagesc.controller.SondageController;
import fr.simplon.sondagesc.dao.SondageRepository;
import fr.simplon.sondagesc.entity.Sondage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TestSondageUnitaireStrict {

    /*
    Ce test est un test unitaire valide cependant il ne teste pas côté client en utilisant l'url et RestTemplates.
     */

    @MockBean
    private SondageRepository sondageRepository;

    @Test
    void testGetSondage() {

        // Mock de la liste de sondages retournée par le repository
        List<Sondage> sondages = new ArrayList<>();
        sondages.add(new Sondage("Description 1", "Question 1", LocalDate.of(2023, 4, 20), LocalDate.of(2023, 5, 1), "Personne 1"));
        sondages.add(new Sondage("Description 2", "Question 2", LocalDate.of(2023, 4, 22), LocalDate.of(2023, 5, 3), "Personne 2"));
        Mockito.when(sondageRepository.findAll()).thenReturn(sondages);

        // Appel de la méthode getSondage() du controller
        SondageController controller = new SondageController(sondageRepository);
        List<Sondage> result = controller.getSondage();

        // Vérification du résultat
        Assertions.assertFalse(result.isEmpty());

    }
}