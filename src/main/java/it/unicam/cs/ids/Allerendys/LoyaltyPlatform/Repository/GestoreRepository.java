package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Gestore;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GestoreRepository extends MongoRepository<Gestore,String> {
}
