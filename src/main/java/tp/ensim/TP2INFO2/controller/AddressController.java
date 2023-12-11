package tp.ensim.TP2INFO2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tp.ensim.TP2INFO2.model.AdresseRepository;

@Controller
public class AddressController {
    @Autowired
    AdresseRepository addressRepository;
    @GetMapping("/adresses")
    public String showAddresses(Model model) {
        model.addAttribute("allAddresses", addressRepository.findAll());
        return "addresses";
    }

    @GetMapping("/adresse")
    public String showAddressForm(Model model) {
        return "adresse";
    }



}
