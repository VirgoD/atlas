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

    public List<BanditoreDTO> addBanditore(String id, String nome,String settore) {
        return this.banditoreRepository.addBanditore(id, nome,settore)
                .stream()
                .map(entry -> new BanditoreDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }

    public List<BanditoreDTO> modifyBanditore(String id, String nome,String settore) {
        return this.banditoreRepository.modifyBanditore(id, nome,settore)
                .stream()
                .map(entry -> new BanditoreDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }

    public List<BanditoreDTO> cancellaBanditore(String id) {
        return this.banditoreRepository.cancellaBanditore(id)
                .stream()
                .map(entry -> new BanditoreDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }
}
