package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Clienti")
@Getter
@Setter
public class Cliente {

    @Id
    private String codiceFiscale;

    private String nome;

    private String cognome;

    private String idTessera;

    private String email;

    private String numeroTelefono;


    public Cliente(String codiceFiscale, String nome, String cognome, String email, String numeroTelefono) {
        this.codiceFiscale = codiceFiscale;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numeroTelefono = numeroTelefono;
    }
}
