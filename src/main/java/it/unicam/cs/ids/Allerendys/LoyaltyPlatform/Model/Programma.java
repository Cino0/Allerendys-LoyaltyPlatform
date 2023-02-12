package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Programmi")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Programma {
    @Id
    private String idProgramma;

    private String titolo;

    private Locale locale;

    private String dettaglio;

    private List<Sconti> sconti;

    public void addSconti(Sconti sconto){
        this.sconti.add(sconto);
    }

}
