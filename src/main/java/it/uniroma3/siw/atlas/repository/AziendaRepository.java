package it.uniroma3.siw.atlas.repository;

import it.uniroma3.siw.atlas.entity.AziendaInterface;
import it.uniroma3.siw.atlas.model.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AziendaRepository extends JpaRepository<Azienda,String>, JpaSpecificationExecutor<Azienda> {

    @Query(value = "SELECT * FROM artisti.azienda", nativeQuery = true)
    public List<AziendaInterface> getAzienda();

    @Query(value = "SELECT * FROM artisti.azienda WHERE azienda.nome like :nome%", nativeQuery = true)
    public List<AziendaInterface> getSpecificoAzienda(@Param("nome") String nome);

    @Query(value = "INSERT INTO artisti.azienda (id, nome, luogo_nascita, data_nascita, luogo_morte, data_morte, natzionalita) \n" +
            "VALUES (:id, :nome, :luogo_nascita, :data_nascita, :luogo_morte, :data_morte, :natzionalita)", nativeQuery = true)
    public List<AziendaInterface> addAzienda(@Param("id") String id,
                                             @Param("nome") String nome,
                                             @Param("luogo_nascita") String luogoNascita,
                                             @Param("data_nascita") Long dataNascita,
                                             @Param("luogo_morte") String luogoMorte,
                                             @Param("data_morte") Long dataMorte,
                                             @Param("natzionalita") String nazionalita);

    @Query(value = "DELETE FROM artisti.azienda WHERE azienda.id = :id ", nativeQuery = true)
    public List<AziendaInterface> deleteAzienda(@Param("id") String id);

    @Query(value = ")", nativeQuery = true)
    public List<AziendaInterface> modifyAzienda(@Param("id") String id,
                                             @Param("nome") String nome,
                                             @Param("luogo_nascita") String luogoNascita,
                                             @Param("data_nascita") Long dataNascita,
                                             @Param("luogo_morte") String luogoMorte,
                                             @Param("data_morte") Long dataMorte,
                                             @Param("natzionalita") String nazionalita);

}
