package it.uniroma3.siw.atlas.repository;

import it.uniroma3.siw.atlas.model.Gara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GaraRepository extends JpaRepository<Gara,String>, JpaSpecificationExecutor<Gara> {

    @Query(value = "SELECT * FROM opere.gara", nativeQuery = true)
    List<Gara> getGare();

    @Query(value = "SELECT * FROM opere.gara WHERE gara.titolo like :titolo%", nativeQuery = true)
    List<Gara> getGaraSpecifica(String titolo);

    @Query(value = "insert into opere.gara(titolo, anno, descrizione, azienda) " +
            "VALUES(:titolo,:anno, :descrizione, :azienda) ", nativeQuery = true)
    public List<Gara> addGara(@Param("titolo") String titolo,
                               @Param("anno") Long anno,
                               @Param("descrizione") String descrizione,
                               @Param("azienda")String azienda);
}
