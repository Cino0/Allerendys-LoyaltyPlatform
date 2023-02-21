package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Fattura {


    private String idFattura;
    private String pIVA;
    private double costo;

    public Fattura(String idFattura, String pIVA, double costo)
    {
        this.idFattura=idFattura;
        this.pIVA=pIVA;
        this.costo=costo;
    }
}
