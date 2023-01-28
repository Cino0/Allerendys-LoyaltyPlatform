package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Controller;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Model.Locale;
import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locale")
public class LocaleController {
    @Autowired
    public LocaleService localeService;


    @GetMapping("/all")
    public List<Locale> getLocali(){
        return localeService.getLocali();
    }


    public Optional<Locale> getLocale(String id){
        return localeService.getLocale(id);
    }

}
