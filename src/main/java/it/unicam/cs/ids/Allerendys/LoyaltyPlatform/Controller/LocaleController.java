package it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Controller;

import it.unicam.cs.ids.Allerendys.LoyaltyPlatform.Service.LocaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/locale")
public class LocaleController {
    @Autowired
    public LocaleService localeService;



}
