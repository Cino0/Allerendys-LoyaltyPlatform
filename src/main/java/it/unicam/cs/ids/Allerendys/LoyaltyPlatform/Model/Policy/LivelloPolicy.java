package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Policy;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
public class LivelloPolicy implements Policy{

    private static int base = 100;

    private static int medio = 5000;

    private static int avanzato = 10000;
    @Override
    public void applica(Iscrizioni iscrizioni, double spesa) {
        int p = iscrizioni.getPunti();
        p+=(int)spesa*100;
        iscrizioni.setPunti(p);
        if(p>=base && p < medio){
            iscrizioni.setLivello("BASE");
        } else if (p>=medio && p < avanzato) {
            iscrizioni.setLivello("MEDIO");
        }else if (p>= avanzato){
            iscrizioni.setLivello("AVANZATO");
        }
    }
}
