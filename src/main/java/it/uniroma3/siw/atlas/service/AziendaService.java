package it.uniroma3.siw.atlas.service;

import it.uniroma3.siw.atlas.dto.AziendaDTO;
import it.uniroma3.siw.atlas.repository.AziendaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AziendaService {

    private AziendaRepository aziendaRepository;

    public AziendaService(AziendaRepository aziendaRepository) {
        this.aziendaRepository = aziendaRepository;
    }

    /*Query azienda*/
    public List<AziendaDTO> getAziende() {
        return this.aziendaRepository.getAzienda()
                .stream()
                .map(entry -> new AziendaDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getP_Iva(),
                        entry.getAmministratore(),
                        entry.getSettore())
                ).collect(Collectors.toList());

    }

    public List<AziendaDTO> getSpecificoAzienda(String nome) {
        return this.aziendaRepository.getSpecificoAzienda(nome)
                .stream()
                .map(entry -> new AziendaDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getP_Iva(),
                        entry.getAmministratore(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }

    public List<AziendaDTO> addAzienda(String id, String nome, String luogoNascita,
                                       Long dataNascita, String luogoMorte,
                                       Long dataMorte, String nazionalita) {
        return this.aziendaRepository.addAzienda(id,nome, luogoNascita, dataNascita, luogoMorte, dataMorte, nazionalita)
                .stream()
                .map(entry -> new AziendaDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getP_Iva(),
                        entry.getAmministratore(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }

    public List<AziendaDTO> deleteAzienda(String id) {
        return this.aziendaRepository.deleteAzienda(id)
                .stream()
                .map(entry -> new AziendaDTO(
                        entry.getId(),
                        entry.getNome(),
                        entry.getP_Iva(),
                        entry.getAmministratore(),
                        entry.getSettore()
                )).collect(Collectors.toList());
    }
}
