package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter

public class Recensione {
    private String titolo;
    private int stelle;
    private long idCliente;


    public Recensione(String titolo, int stelle) {
        this.titolo = titolo;
        this.stelle = stelle;
    }
}
