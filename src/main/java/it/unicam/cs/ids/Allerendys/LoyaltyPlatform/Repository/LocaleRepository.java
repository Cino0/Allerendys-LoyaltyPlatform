package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Locale;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocaleRepository extends MongoRepository<Locale,String> {
}
