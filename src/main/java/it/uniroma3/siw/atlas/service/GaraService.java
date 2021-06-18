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

    public List<GaraDTO> addGara(String titolo, Long anno, String descrizione, String azienda) {
        return this.garaRepository.addGara(titolo, anno, descrizione,azienda)
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
