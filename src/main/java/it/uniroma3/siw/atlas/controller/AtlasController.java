package it.uniroma3.siw.atlas.controller;

import it.uniroma3.siw.atlas.model.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
class AtlasController {

    /*LogIn*/
    @RequestMapping(value = "/addAdmin", method = RequestMethod.GET)
    public String addAdmin(Model model) {
        model.addAttribute("admin", new User());
        return "signupAdmin.html";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginAdmin(Model model) {
        model.addAttribute("admin", new User());
        return "login.html";
    }

    @RequestMapping(value = {"/", "index"}, method = RequestMethod.GET)
    public String index(Model model) {
        return "index.html";
    }

}
