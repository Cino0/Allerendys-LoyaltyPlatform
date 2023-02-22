package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Repository;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IscrizioniRepository extends MongoRepository<Iscrizioni,String> {


    @Query("{'programma':?0}")
    List<Iscrizioni> findByProgramma(String idProgramma);
}
