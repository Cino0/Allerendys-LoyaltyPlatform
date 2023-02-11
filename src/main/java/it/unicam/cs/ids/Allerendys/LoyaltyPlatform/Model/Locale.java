package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Locali")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Locale {
    @Id
    private String idLocale;

    private String nome;

    private String proprietario;

    private String citta;

    private String indirizzo;

    private List<Programma> programmiFedelta;

    private List<Recensione> recensioni;

    public String addRecensione(Recensione recensione)
    {
        this.recensioni.add(recensione);
    }

}
