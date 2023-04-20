package fr.simplon.sondagesc;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import fr.simplon.sondagesc.dao.SondageRepository;
import fr.simplon.sondagesc.entity.Sondage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner
{

    private final SondageRepository mSondageRepository;

    @Autowired
    public DataLoader(SondageRepository pSondageRepository)
    {
        this.mSondageRepository = pSondageRepository;
    }
    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        if (mSondageRepository.count() == 0)
        {
            ClassPathResource resource = new ClassPathResource("static/festivals.json");
            ObjectMapper objectMapper = new ObjectMapper();
            List<Sondage> sondages = objectMapper.readValue(
                    resource.getInputStream(), new TypeReference<List<Sondage>>(){});
            mSondageRepository.saveAll(sondages);
        }
    }
}