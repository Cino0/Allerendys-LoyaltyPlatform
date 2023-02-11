package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Sconti
{
    @Id
    private String idSconto;
    private String nome;
    private double sconto;


    public Sconti(String idSconto)
    {
        this.idSconto=idSconto;
    }
}
