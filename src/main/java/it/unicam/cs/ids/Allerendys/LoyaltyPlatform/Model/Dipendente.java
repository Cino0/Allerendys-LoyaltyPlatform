package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Dipendeti")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Dipendente {
    private String idDipendente;

    private String nome;

    private String cognome;

    private String localeImpiego;
}
