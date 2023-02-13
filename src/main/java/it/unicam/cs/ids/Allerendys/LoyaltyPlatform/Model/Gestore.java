package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Gestori")
@Getter
@Setter
public class Gestore {

    @Id
    private String codiceFiscale;

    private String nome;

    private String cognome;
}
