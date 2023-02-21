package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Clienti")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Proprietario {


    @Id
    private String codiceFiscale;

    private String nome;

    private String cognome;

    private String pec;

    private String pIVA;


}
