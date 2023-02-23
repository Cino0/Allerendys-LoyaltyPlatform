package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Policy;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class CashBackPolicy implements Policy{




    @Override
    public void applica(Iscrizioni iscrizioni, double spesa) {
        double c = iscrizioni.getCashback();
        double per = (c*10)/100;
        c+= per;
        iscrizioni.setCashback(c);
    }
}
