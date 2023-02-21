package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Fattura {


    private String idLocale;

    private String pIVA;
    private double costo;

    public Fattura(String idLocale, String pIVA)
    {
        this.idLocale=idLocale;
        this.pIVA=pIVA;
        this.costo=50.0;
    }


    public void setCosto(int numProgr){
        this.costo=costo*(double) numProgr;
    }
}
