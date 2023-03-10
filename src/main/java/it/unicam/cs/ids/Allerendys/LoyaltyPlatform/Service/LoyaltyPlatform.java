package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service;


import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.DbIndex.SequenceGeneratorService;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LoyaltyPlatform {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

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
            Tessera t = new Tessera();
            t.setIdTessera(sequenceGeneratorService.generateSequence(Tessera.SEQUENCE_NAME));
            cliente.setIdTessera(t.getIdTessera());
            clienteService.salvaCliente(cliente);
            tesseraService.salvaTessera(t);
        }
        return cliente.getCodiceFiscale();
    }

    public long registraCliente(Cliente cliente ,long idProgramma){
        Optional<Cliente> c = clienteService.controllaDati(cliente);
        if(c.isPresent()){
            return 0;
        }else {
            Tessera t = new Tessera();
            t.setIdTessera(sequenceGeneratorService.generateSequence(Tessera.SEQUENCE_NAME));
            cliente.setIdTessera(t.getIdTessera());
            clienteService.salvaCliente(cliente);
            t.addIscricione(idProgramma);
            System.out.println(t.toString());
            return tesseraService.salvaTessera(t);
        }
    }
    public  void scriviRecensioni(long idLocale, long idCliente,Recensione recensione)
    {
        recensione.setIdCliente(idCliente);
        localiService.aggiungiRecensione(idLocale,idCliente,recensione);
    }


    public long creaSconto(int finalita, Sconti sconto, long idProgramma){
        sconto.setFinalita(finalita);
        sconto.setIdSconto(sequenceGeneratorService.generateSequence(Sconti.SEQUENCE_NAME));
        scontiService.salvaSconto(sconto);
        if(finalita==1){
            programmaService.aggiungiScontoaProgramma(sconto,idProgramma);
        }
        return sconto.getIdSconto();
    }


    public void creaCampagnaSms(Sms sms,long idLocale,int finalita){
            smsService.salvaMessaggio(sms,finalita);
            if(finalita==1){
                localiService.aggiungiSms(idLocale,sms);
            }
    }


    public String creaLocale(Locale locale,String idProprietario){
        locale.setIdLocale(sequenceGeneratorService.generateSequence(Locale.SEQUENCE_NAME));
        locale.setProprietario(idProprietario);
        Optional<Locale> l =localiService.controllaDati(locale);
        if(l.isEmpty()){
            return String.valueOf(localiService.salva(locale));
        }
        return "Locale esistente";
    }



    public List<Programma> controlloTessera(long idTessera,long idLocale){
       Optional<Tessera> t =tesseraService.controlloTessera(idTessera);
       List<Programma> programmi = new ArrayList<>();
       if(t.isPresent()){
           List<Iscrizioni> iscr = t.get().getIscrizioni();
           for(Iscrizioni i:iscr){
               long prog =i.getProgramma();
               Optional<Programma> p = programmaService.getPrograma(prog);
               if (idLocale==p.get().getLocale()){
                   programmi.add(p.get());
               }
           }
       }else {
           return null;
       }
       for(Programma p1: programmi){
           System.out.println(p1.toString());
       }
       return  programmi;
    }



    public String visualizzaStatus(long idTessera,long idLocale,long idProgramma){
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


    public String convalidaAcquisto(long idTessera,long idLocale,long idProgramma, double spesa){

        List<Programma> p=this.controlloTessera(idTessera,idLocale);
        if(!p.isEmpty()){
            for(Programma prog : p){
                if (prog.getIdProgramma()==idProgramma){
                    Iscrizioni i =tesseraService.getIscrizione(idProgramma,idTessera);
                    Iscrizioni newIscr = prog.applicaPolicy(i,spesa);
                    tesseraService.aggiornaIscrizione(newIscr,idTessera);
                    return "Acquiasto convalidato";
                }
            }
        }
        return "Acquisto non convalidato";
    }


    public String creaDipendente(long idLocale,Dipendente dipendente){
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



    public String creaCoalizione(String nome,long idLocale, Programma programma,int tipologia)
    {
        long p = this.creaProgrammaFedelta(programma, tipologia, idLocale);
        Optional<Programma> prog = programmaService.getPrograma(p);
        Coalizione coal= new Coalizione(nome,prog.get());
        coal.addLocale(idLocale);
        coal.setId(sequenceGeneratorService.generateSequence(Coalizione.SEQUENCE_NAME));
        Optional<Coalizione> c = coalizioneService.getCoalizione(coal.getId());
        if(c.isPresent())
        {
            return "Coalizone gia presente";
        }
        else
        {
            return String.valueOf(coalizioneService.salvaCoalizione(coal));

        }

    }
    public String uniscitiACoalizione(long idCoalizione,long idLocale)
    {
        Optional<Coalizione> c=coalizioneService.getCoalizione(idCoalizione);
        if(c.isPresent())
        {

            localiService.addProgramma( c.get().getProgramma(),idLocale);
            coalizioneService.aggiungiLocale(c.get(),idLocale);
            return "Locale aggiunto alla coalizione";
        }
        else
        {
            return "Coalizone non esistente";
        }
    }
    public String creaFattura(long idLocale)
    {
        Optional<Locale> l=localiService.getLocale(idLocale);
        System.out.println("here");
        if(l.isPresent())
        {
            int n= l.get().getNumProgrammi();
            System.out.println(n);
            Optional<Proprietario> p= proprietarioService.getProprietario(l.get().getProprietario());
            System.out.println("sotto");
            Fattura f=new Fattura(idLocale);
            if (p.isPresent()){
                f.setPIVA(p.get().getPIVA());
            }
            f.setCosto(n);
            return f.toString();
        }
        return "Locale inesistente";
    }


    public long creaProgrammaFedelta(Programma programma,int tipologia, long idLocale){
        programma.setLocale(idLocale);
        programma.setIdProgramma(sequenceGeneratorService.generateSequence(Programma.SEQUENCE_NAME));
        programma.impostaPolicy(tipologia);
        long esito =programmaService.salva(programma);
        localiService.addProgramma(programma,idLocale);
        return esito;
    }

    public String visualizzaStatistiche(long idLocale)
    {
        Optional<Locale> l= localiService.getLocale(idLocale);
        List<Programma> programmi = l.get().getProgrammiFedelta();
        String statistiche = null;
        for(int i=0;i<programmi.size();i++)
        {
            statistiche=programmi.get(i).getTitolo()+" "+iscrizioniService.getNumIscritti(programmi.get(i).getIdProgramma());

        }
        return statistiche;
    }

}
