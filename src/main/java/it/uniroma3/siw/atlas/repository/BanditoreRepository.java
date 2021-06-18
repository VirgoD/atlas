package it.uniroma3.siw.atlas.repository;

import it.uniroma3.siw.atlas.entity.BanditoreInterface;
import it.uniroma3.siw.atlas.model.Banditore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BanditoreRepository extends JpaRepository<Banditore,String>, JpaSpecificationExecutor<Banditore> {

    @Query(value = "SELECT * FROM collezioni.banditore", nativeQuery = true)
    public List<BanditoreInterface> getBanditori();

    @Query(value = "SELECT * FROM collezioni.banditore WHERE banditore.titolo like :titolo%", nativeQuery = true)
    public List<BanditoreInterface> getSpecificaBanditore(@Param("titolo") String titolo);

    @Query(value = "insert into collezioni.banditore(titolo, anno, descrizione, curatore_id) " +
            "VALUES(:titolo,:anno, :descrizione, :curatore_id) ", nativeQuery = true)
    public List<BanditoreInterface> addCollection(@Param("titolo") String titolo,
                                                     @Param("anno") Long anno,
                                                     @Param("descrizione") String descrizione,
                                                     @Param("curatore_id")String curatoreId);
}
