package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Policy;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Iscrizioni;

public interface Policy {


    public void applica(Iscrizioni iscrizioni,double spesa);
}
