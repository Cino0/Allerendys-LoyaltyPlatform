package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter

public class Recensione {
    private String titolo;
    private int stelle;
    private String idCliente;

}
