package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Programmi")
@Getter
@Setter
public class Sms {

    @Id
    private int id;

    private String messaggio;

    private int finalita;


    public Sms(String messaggio){
        this.messaggio=messaggio;
    }
}
