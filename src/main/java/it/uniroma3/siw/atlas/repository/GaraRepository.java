package it.uniroma3.siw.atlas.repository;

import it.uniroma3.siw.atlas.model.Gara;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface GaraRepository extends JpaRepository<Gara,String>, JpaSpecificationExecutor<Gara> {

    @Query(value = "SELECT * FROM gara", nativeQuery = true)
    List<Gara> getGare();

    @Query(value = "SELECT * FROM gara WHERE gara.titolo like :titolo%", nativeQuery = true)
    List<Gara> getGaraSpecifica(String titolo);

    @Query(value = "insert into gara (id, anno, banditore, base_asta, data,nome) " +
            "VALUES(:id,:anno, :banditore, :baseAsta, :data, :nome) ", nativeQuery = true)
    public List<Gara> addGara(@Param("id") String id,
                               @Param("anno") Long anno,
                               @Param("banditore") String banditore,
                               @Param("baseAsta")String baseAsta,
                              @Param("data") Long data,
                              @Param("nome") String nome);

    @Query(value = "UPDATE  gara set anno= :anno, banditore =:banditore, base_asta= :baseAsta, data = :data, nome = :nome\n" +
            "WHERE gara.id = :id", nativeQuery = true)
    public List<Gara> modifyGara(@Param("id") String id,
                                 @Param("anno") Long anno,
                                 @Param("banditore") String banditore,
                                 @Param("baseAsta")String baseAsta,
                                 @Param("data") Long data,
                                 @Param("nome") String nome);

    @Query(value = "DELETE FROM gara WHERE gara.id = :id", nativeQuery = true)
    List<Gara> cancellaGara(String id);
}
