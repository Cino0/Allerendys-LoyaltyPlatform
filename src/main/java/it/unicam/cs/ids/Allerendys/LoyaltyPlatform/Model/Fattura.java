package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Fattura {


    private long idLocale;

    private String pIVA;
    private double costo;

    public Fattura(long idLocale)
    {
        this.idLocale=idLocale;
        this.costo=50.0;
    }


    public void setCosto(int numProgr){
        this.costo=costo*(double) numProgr;
    }
}
