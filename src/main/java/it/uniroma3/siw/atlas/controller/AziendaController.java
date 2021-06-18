package it.uniroma3.siw.atlas.controller;

import it.uniroma3.siw.atlas.dto.AziendaDTO;
import it.uniroma3.siw.atlas.service.AziendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class AziendaController {

    @Autowired
    AziendaService aziendaService;

    @GetMapping(path = "/aziende")
    public List<AziendaDTO> aziende(){ return this.aziendaService.getAziende(); }

    @GetMapping(path ="/aziendaSpecifico")
    public List<AziendaDTO> getSpecificoAzienda(@RequestParam String nome){ return this.aziendaService.getSpecificoAzienda(nome); }

    @GetMapping(path = "/addAzienda")
    public  List<AziendaDTO> addAzienda(@RequestParam String id,
                                        @RequestParam String nome,
                                        @RequestParam String luogoNascita,
                                        @RequestParam Long dataNascita,
                                        @RequestParam(required = false) String luogoMorte,
                                        @RequestParam(required = false) Long dataMorte,
                                        @RequestParam String nazionalita)
    {return this.aziendaService.addAzienda(id,nome,luogoNascita, dataNascita, luogoMorte, dataMorte, nazionalita); }

    @DeleteMapping(value = "/deleteArtist")
    public List<AziendaDTO> deleteArtist(@RequestParam String id){
        return this.aziendaService.deleteAzienda(id);
    }

}
