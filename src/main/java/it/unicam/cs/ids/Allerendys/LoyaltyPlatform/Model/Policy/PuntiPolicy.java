package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Policy;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class PuntiPolicy implements Policy{


    @Override
    public void applica(Iscrizioni iscrizioni, double spesa) {
        int p = iscrizioni.getPunti();
        int np = (int)spesa *100;
        p+=np;
        iscrizioni.setPunti(p);
    }
}
