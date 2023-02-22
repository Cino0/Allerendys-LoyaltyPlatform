package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Policy.CashBackPolicy;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Policy.LivelloPolicy;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Policy.Policy;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Policy.PuntiPolicy;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "Programmi")
@Builder
@AllArgsConstructor
@Getter
@Setter
public class Programma {



    @Transient
    public static final String SEQUENCE_NAME = "programma_sequence";

    @Id
    private String idProgramma;

    private String titolo;

    private String locale;

    private String dettaglio;

    private List<Sconti> sconti;

    private Policy policy;
    public void addSconti(Sconti sconto){
        this.sconti.add(sconto);
    }


    public void impostaPolicy(int tipologia){
        switch (tipologia){
            case 1 :
                policy= new PuntiPolicy();
                break;
            case 2 :
                policy = new LivelloPolicy();
                break;
            case 3 :
                policy = new CashBackPolicy();
                break;
            default:
                break;
        }
    }


    public void applicaPolicy(Iscrizioni iscrizioni ,double spesa){
        policy.applica(iscrizioni,spesa);
    }
}
