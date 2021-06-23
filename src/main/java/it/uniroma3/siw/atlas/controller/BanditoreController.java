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
    public  List<BanditoreDTO> addBanditore(@RequestParam String id,
                                            @RequestParam String nome,
                                            @RequestParam String settore)
    {return this.banditoreService.addBanditore(id, nome, settore); }

    @GetMapping(path ="/modifyBanditore")
    public  List<BanditoreDTO> modifyBanditore(@RequestParam String id,
                                            @RequestParam String nome,
                                            @RequestParam String settore)
    {return this.banditoreService.modifyBanditore(id, nome, settore); }

    @GetMapping(path = "/cancellaBanditore")
    public  List<BanditoreDTO> modifyBanditore(@RequestParam String id){
        return this.banditoreService.cancellaBanditore(id);
    }
}
