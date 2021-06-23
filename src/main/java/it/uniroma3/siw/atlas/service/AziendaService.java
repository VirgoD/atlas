package it.uniroma3.siw.atlas.service;

import it.uniroma3.siw.atlas.dto.AziendaDTO;
import it.uniroma3.siw.atlas.repository.AziendaRepository;
import org.springframework.data.repository.query.Param;
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

    public List<AziendaDTO> addAzienda(String id, String amministrazione,String nome, String pIva,String settore) {
        return this.aziendaRepository.addAzienda(id,amministrazione, nome, pIva, settore)
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

    public List<AziendaDTO> modifyAzienda(String id, String amministratore,
                                          String nome,String pIva,String settore) {
        return this.aziendaRepository.modifyAzienda(id, amministratore, nome, pIva,settore)
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
