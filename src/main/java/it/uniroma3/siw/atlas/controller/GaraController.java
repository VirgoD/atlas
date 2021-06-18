package it.uniroma3.siw.atlas.controller;

import it.uniroma3.siw.atlas.dto.GaraDTO;
import it.uniroma3.siw.atlas.service.GaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class GaraController {

    @Autowired
    GaraService garaService;


    @GetMapping(path ="/gare")
    public List<GaraDTO> getGare(){ return this.garaService.getGare(); }

    @GetMapping(path ="/garaSpeficifa")
    public List<GaraDTO> getSpecificaGara(@RequestParam String titolo){ return this.garaService.getGaraSpecifica(titolo); }

    @GetMapping(path ="/addGara")
    public  List<GaraDTO> addGara(@RequestParam String titolo,
                                    @RequestParam Long anno,
                                    @RequestParam String descrizione,
                                    @RequestParam String azienda)
    {return this.garaService.addGara(titolo,anno,descrizione,azienda); }
}
