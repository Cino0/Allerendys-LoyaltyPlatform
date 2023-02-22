package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.DbIndex;

import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGeneratorService {


   private MongoOperations mongoOperations;

    public SequenceGeneratorService(MongoOperations mongoOperation) {
        this.mongoOperations = mongoOperation;
    }

    public long generateSequence(String seqNam){
      return 1;
    }
}
