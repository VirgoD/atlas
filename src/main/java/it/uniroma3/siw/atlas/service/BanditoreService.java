package it.uniroma3.siw.atlas.service;

import it.uniroma3.siw.atlas.dto.BanditoreDTO;
import it.uniroma3.siw.atlas.repository.BanditoreRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BanditoreService {

    private BanditoreRepository banditoreRepository;

    public BanditoreService(BanditoreRepository banditoreRepository) {
        this.banditoreRepository = banditoreRepository;
    }

    /*QUery banditore*/
    public List<BanditoreDTO> getBanditori() {
        return this.banditoreRepository.getBanditori()
                .stream()
                .map(entry -> new BanditoreDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }

    public List<BanditoreDTO> getBanditoreSpecifica(String titolo) {
        return this.banditoreRepository.getSpecificaBanditore(titolo)
                .stream()
                .map(entry -> new BanditoreDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }

    public List<BanditoreDTO> addCollection(String titolo, Long anno, String descrizione, String curatoreId) {
        return this.banditoreRepository.addCollection(titolo,anno,descrizione,curatoreId)
                .stream()
                .map(entry -> new BanditoreDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }
}
