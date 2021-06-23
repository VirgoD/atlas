package it.uniroma3.siw.atlas.repository;

import it.uniroma3.siw.atlas.entity.AziendaInterface;
import it.uniroma3.siw.atlas.model.Azienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AziendaRepository extends JpaRepository<Azienda,String>, JpaSpecificationExecutor<Azienda> {

    @Query(value = "SELECT * FROM azienda", nativeQuery = true)
    public List<AziendaInterface> getAzienda();

    @Query(value = "SELECT * FROM azienda WHERE azienda.nome like :nome%", nativeQuery = true)
    public List<AziendaInterface> getSpecificoAzienda(@Param("nome") String nome);

    @Query(value = "INSERT INTO  azienda (id, amministratore, nome, p_iva, settore) " +
            "VALUES (:id,:amministratore,:nome,:p_iva,:settore)", nativeQuery = true)
    public List<AziendaInterface> addAzienda(@Param("id") String id,
                                             @Param("amministratore") String amministratore,
                                             @Param("nome") String nome,
                                             @Param("p_iva") String pIva,
                                             @Param("settore") String settore);

    @Query(value = "DELETE FROM azienda WHERE azienda.id = :id ", nativeQuery = true)
    public List<AziendaInterface> deleteAzienda(@Param("id") String id);


    @Query(value = "UPDATE azienda SET nome= :nome, amministratore = :amministratore,\n" +
            "                   p_iva = :pIva, settore = :settore\n" +
            "       WHERE azienda.id =:id", nativeQuery = true)
    public List<AziendaInterface> modifyAzienda(@Param("id") String id,
                                                @Param("amministratore") String amministratore,
                                                @Param("nome") String nome,
                                                @Param("pIva") String pIva,
                                                @Param("settore") String settore);

}
