package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.aggregation.ConvertOperators;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoyaltyPlatform {

    @Autowired
    private ClienteService clienteService;
    @Autowired
    private TesseraService tesseraService;
    @Autowired
    private LocaleService localiService;
    @Autowired
    private ScontiService scontiService;
    @Autowired
    private ProgrammaService programmaService;
    @Autowired
    private SmsService smsService;
    @Autowired
    private DipendeteService dipendeteService;
    @Autowired
    private GestoreService gestoreService;
    @Autowired
    private ProprietarioService proprietarioService;
    @Autowired
    private CoalizioneService coalizioneService;
    @Autowired
    private IscrizioniService iscrizioniService;

    public String registrazione(Cliente cliente){
        Optional<Cliente> c = clienteService.controllaDati(cliente);
        if(c.isPresent()){
            return "Dati gia presenti,per favore reinserire";
        }else {
            Tessera t = new Tessera("Id");
            cliente.setIdTessera(t.getIdTessera());
            clienteService.salvaCliente(cliente);
            tesseraService.salvaTessera(t);
        }
        return cliente.getCodiceFiscale();
    }

    public String registraCliente(Cliente cliente ,String idProgramma){
        Optional<Cliente> c = clienteService.controllaDati(cliente);
        if(c.isPresent()){
            return "Dati gia presenti,per favore reinserire";
        }else {
            Tessera t = new Tessera("idTessera");
            cliente.setIdTessera(t.getIdTessera());
            clienteService.salvaCliente(cliente);
            t.addIscricione(idProgramma);
            System.out.println(t.toString());
            return tesseraService.salvaTessera(t);
        }
    }
    public  String scriviRecensioni(String idLocale, String idCliente,Recensione recensione)
    {
        localiService.aggiungiRecensione(idLocale,idCliente,recensione);
        return null;
    }


    public void creaSconto(int finalita, Sconti sconto, String idProgramma){
        sconto.setFinalita(finalita);
        scontiService.salvaSconto(sconto);
        if(finalita==1){
            programmaService.aggiungiScontoaProgramma(sconto,idProgramma);
        }
    }


    public void creaCampagnaSms(Sms sms,String idLocale,int finalita){
            smsService.salvaMessaggio(sms,finalita);
            if(finalita==1){
                localiService.aggiungiSms(idLocale,sms);
            }
    }



    public List<Programma> controlloTessera(String idTessera,String idLocale){
       Optional<Tessera> t =tesseraService.controlloTessera(idTessera);
       List<Programma> programmi = new ArrayList<>();
       if(t.isPresent()){
           List<Iscrizioni> iscr = t.get().getIscrizioni();
           for(Iscrizioni i:iscr){
               String prog =i.getProgramma();
               Optional<Programma> p = programmaService.getPrograma(prog);
               if (idLocale==p.get().getLocale()){
                   programmi.add(p.get());
               }
           }
       }else {
           return null;
       }
       return  programmi;
    }



    public String visualizzaStatus(String idTessera,String idLocale,String idProgramma){
        List<Programma> p=this.controlloTessera(idTessera,idLocale);

        if(!p.isEmpty()){
            for(Programma prog : p){
                if (prog.getIdProgramma()==idProgramma){
                    Iscrizioni i =tesseraService.getIscrizione(idProgramma,idTessera);
                    return i.visualizzaStatus();
                }
            }
        }
        return "Tessera non valida";
    }


    public String convalidaAcquisto(String idTessera,String idLocale,String idProgramma, double spesa){
        List<Programma> p=this.controlloTessera(idTessera,idLocale);
        if(!p.isEmpty()){
            for(Programma prog : p){
                if (prog.getIdProgramma()==idProgramma){
                    Iscrizioni i =tesseraService.getIscrizione(idProgramma,idTessera);
                    prog.applicaPolicy(i,spesa);
                }
            }
        }
        return null;
    }


    public String creaDipendente(String idLocale,Dipendente dipendente){
        Optional<Dipendente> d = dipendeteService.controllaDati(dipendente);
        if (d.isPresent()){
            dipendente.setLocaleImpiego(idLocale);
            return dipendeteService.salvaDipendete(dipendente);
        }
        return null;
    }


    public String creaUtentiSpecialiGestore(Gestore gestore){
        Optional<Gestore> g = gestoreService.controllaDati(gestore);
        if(g.isEmpty()){
            return gestoreService.salvaGestore(gestore);
        }
        return "Dati gia presenti";
    }


    public String creaUtentiSpecialiProprietatio(Proprietario proprietario){
        Optional<Proprietario> p = proprietarioService.controllaDati(proprietario);
        if(p.isEmpty()){
            return proprietarioService.salvaProprietario(proprietario);
        }
        return "Dati gia presenti";
    }

    public String login(String codicefiscale)
    {
        Optional<Cliente> c=clienteService.autenticazione(codicefiscale);
        if(c.isPresent())
        {
            return "Bentornato";
        }
        else
        {
            return "Dati non corretti";
        }

    }



    public String creaCoalizione(Coalizione coalizione,String idLocale)
    {
        Optional<Coalizione> c=coalizioneService.getCoalizione(coalizione.getId());
        if(c.isPresent())
        {
            return "Coalizone gia presente";
        }
        else
        {
            return coalizioneService.salvaCoalizione(coalizione);

        }

    }
    public String uniscitiACoalizione(String idCoalizione,String idLocale)
    {
        Optional<Coalizione> c=coalizioneService.getCoalizione(idLocale);
        if(c.isPresent())
        {

            localiService.addProgramma( c.get().getProgramma(),idLocale);
            c.get().addLocale(idLocale);
            return "Locale aggiunto alla coalizione";
        }
        else
        {
            return "Coalizone non esistente";
        }
    }
    public String creaFattura(String idLocale)
    {
        Optional<Locale> l=localiService.getLocale(idLocale);
        if(l.isPresent())
        {
            int n= l.get().getNumProgrammi();
            Optional<Proprietario> p= proprietarioService.getProprietario(l.get().getProprietario());
            Fattura f=new Fattura(idLocale,p.get().getPIVA());
            f.setCosto(n);
            return f.toString();
        }
        return "Locale inesistente";
    }


    public String creaProgrammaFedelta(Programma programma,int tipologia, String idLocale){
        programma.setLocale(idLocale);
        programma.impostaPolicy(tipologia);
        String esito =programmaService.salva(programma);
        localiService.addProgramma(programma,idLocale);
        return esito;
    }

    public String visualizzaStatistiche(String idLocale)
    {
        Optional<Locale> l= localiService.getLocale(idLocale);
        List<Programma> programmi = l.get().getProgrammiFedelta();
        String statistiche = null;
        for(int i=0;i<programmi.size();i++)
        {
            statistiche=programmi.get(i).getTitolo()+iscrizioniService.getNumIscritti(programmi.get(i).getIdProgramma());;

        }
        return statistiche;
    }

}
