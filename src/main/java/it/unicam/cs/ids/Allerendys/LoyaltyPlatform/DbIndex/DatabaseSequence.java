package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.DbIndex;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "db_sequence")
@Getter
@Setter
public class DatabaseSequence {


    @Id
    private String id;



    private long seq;


    public DatabaseSequence() {
    }
}
