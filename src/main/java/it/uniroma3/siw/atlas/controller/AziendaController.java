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
                                        @RequestParam(required = false) String amministrazione,
                                        @RequestParam(required = false) String nome,
                                        @RequestParam(required = false)String pIva,
                                        @RequestParam(required = false)String settore)
    {return this.aziendaService.addAzienda(id,amministrazione, nome,pIva, settore); }

    @GetMapping(value = "/deleteAzienda")
    public List<AziendaDTO> deleteAzienda(@RequestParam String id){
        return this.aziendaService.deleteAzienda(id);
    }

    @GetMapping(value = "/modifyAzienda")
    public List<AziendaDTO> modifyAzienda(@RequestParam String id,
                                          @RequestParam String amministrazione,
                                          @RequestParam String nome,
                                          @RequestParam String pIva,
                                          @RequestParam String settore){
        return this.aziendaService.modifyAzienda(id,amministrazione, nome, pIva, settore);
    }
}
