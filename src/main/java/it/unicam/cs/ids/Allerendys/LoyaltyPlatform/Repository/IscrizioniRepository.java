package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IscrizioniRepository extends MongoRepository<Iscrizioni,String> {
}
