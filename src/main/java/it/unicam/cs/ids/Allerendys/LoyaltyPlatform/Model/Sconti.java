package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Sconti {
    private String idSconto;
    private String nome;
    private double sconto;

}
