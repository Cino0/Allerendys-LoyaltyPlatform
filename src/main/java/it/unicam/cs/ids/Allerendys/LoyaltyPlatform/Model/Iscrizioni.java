package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;


import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

@Data
@Getter
public class Iscrizioni {



    @Transient
    public static final String SEQUENCE_NAME = "iscrizioni_sequence";


    @Id
    private long id;
    private long programma;
    private  int punti;
    private String livello;
    private double cashback;


    public Iscrizioni(long idProgramma,int cashback, int punti, String livello) {
        this.programma = idProgramma;
        this.cashback=cashback;
        this.punti = punti;
        this.livello = livello;
    }



    public String visualizzaStatus(){
        String status = ""+this.programma+
                ""+this.punti+
                ""+this.livello+
                ""+this.cashback;
        return status;
    }
}
