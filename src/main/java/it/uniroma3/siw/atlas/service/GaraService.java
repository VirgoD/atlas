package it.uniroma3.siw.atlas.service;

import it.uniroma3.siw.atlas.dto.GaraDTO;
import it.uniroma3.siw.atlas.repository.GaraRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GaraService {
    private GaraRepository garaRepository;

    public GaraService(GaraRepository garaRepository) {
        this.garaRepository = garaRepository;
    }

    /*Query opere*/
    public List<GaraDTO> getGare() {
        return this.garaRepository.getGare()
                .stream()
                .map(entry -> new GaraDTO(
                        entry.getId(),
                        entry.getAnno(),
                        entry.getNome(),
                        entry.getData(),
                        entry.getBaseAsta(),
                        entry.getBanditore()
                )).collect(Collectors.toList());
    }

    public List<GaraDTO> getGaraSpecifica(String titolo) {
        return this.garaRepository.getGaraSpecifica(titolo)
                .stream()
                .map(entry -> new GaraDTO(
                        entry.getId(),
                        entry.getAnno(),
                        entry.getNome(),
                        entry.getData(),
                        entry.getBaseAsta(),
                        entry.getBanditore()
                )).collect(Collectors.toList());
    }

    public List<GaraDTO> addGara(String id,Long anno, String banditore,String  baseAsta, Long data, String nome) {
        return this.garaRepository.addGara(id, anno, banditore, baseAsta,data,nome)
                .stream()
                .map(entry -> new GaraDTO(
                        entry.getId(),
                        entry.getAnno(),
                        entry.getNome(),
                        entry.getData(),
                        entry.getBaseAsta(),
                        entry.getBanditore()
                )).collect(Collectors.toList());
    }

    public List<GaraDTO> modifyGara(String id,Long anno, String banditore,String  baseAsta, Long data, String nome) {
        return this.garaRepository.modifyGara(id,anno,banditore,baseAsta,data,nome)
                .stream()
                .map(entry -> new GaraDTO(
                        entry.getId(),
                        entry.getAnno(),
                        entry.getNome(),
                        entry.getData(),
                        entry.getBaseAsta(),
                        entry.getBanditore()
                )).collect(Collectors.toList());
    }

    public List<GaraDTO> cancellaGara(String id) {
        return this.garaRepository.cancellaGara(id)
                .stream()
                .map(entry -> new GaraDTO(
                        entry.getId(),
                        entry.getAnno(),
                        entry.getNome(),
                        entry.getData(),
                        entry.getBaseAsta(),
                        entry.getBanditore()
                )).collect(Collectors.toList());
    }
}
