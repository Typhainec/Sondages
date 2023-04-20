package fr.simplon.sondagesc.dao;

import fr.simplon.sondagesc.entity.Sondage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SondageRepository extends JpaRepository<Sondage, Long> {
    // < > entre crochets dit qu'on veut une collection, dedans, Fruit est le nom de la classe et Lon le type de l'ID
}
