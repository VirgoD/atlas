package it.uniroma3.siw.atlas.controller;

import it.uniroma3.siw.atlas.dto.BanditoreDTO;
import it.uniroma3.siw.atlas.service.BanditoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1")
public class BanditoreController {

    @Autowired
    BanditoreService banditoreService;

    @GetMapping(path ="/banditori")
    public List<BanditoreDTO> getBanditori(){ return this.banditoreService.getBanditori(); }

    @GetMapping(path ="/banditoreSpecifico")
    public List<BanditoreDTO> getSpecificaBanditore(@RequestParam String titolo){ return this.banditoreService
            .getBanditoreSpecifica(titolo); }

    @GetMapping(path ="/addBanditore")
    public  List<BanditoreDTO> addCollection(@RequestParam String titolo,
                                                @RequestParam Long anno,
                                                @RequestParam String descrizione,
                                                @RequestParam String curatoreId)
    {return this.banditoreService.addCollection(titolo,anno,descrizione,curatoreId); }
}
