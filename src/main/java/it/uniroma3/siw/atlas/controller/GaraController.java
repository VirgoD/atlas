package it.uniroma3.siw.atlas.controller;

import it.uniroma3.siw.atlas.dto.GaraDTO;
import it.uniroma3.siw.atlas.service.GaraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
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
    public  List<GaraDTO> addGara(@RequestParam String id,
                                  @RequestParam Long anno,
                                  @RequestParam String banditore,
                                  @RequestParam String baseAsta,
                                  @RequestParam Long data,
                                  @RequestParam String nome)
    {return this.garaService.addGara(id,anno,banditore,baseAsta,data,nome); }

    @GetMapping(path ="/modifyGara")
    public  List<GaraDTO> modifyGara(@RequestParam String id,
                                     @RequestParam Long anno,
                                     @RequestParam String banditore,
                                     @RequestParam String baseAsta,
                                     @RequestParam Long data,
                                     @RequestParam String nome)
    {return this.garaService.modifyGara(id,anno,banditore,baseAsta,data,nome); }

    @GetMapping(path ="/cancellaGara")
    public List<GaraDTO> cancellaGara(@RequestParam String id){ return this.garaService.cancellaGara(id); }

}
