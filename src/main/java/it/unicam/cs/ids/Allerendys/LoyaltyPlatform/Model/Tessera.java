package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection = "Tessere")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Tessera {

    @Id
    private String IdTessera;

    private List<Iscrizioni> iscrizioni;
}
