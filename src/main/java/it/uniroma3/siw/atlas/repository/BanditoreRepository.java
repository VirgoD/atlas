package it.uniroma3.siw.atlas.repository;

import it.uniroma3.siw.atlas.entity.BanditoreInterface;
import it.uniroma3.siw.atlas.model.Banditore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Arrays;
import java.util.List;

public interface BanditoreRepository extends JpaRepository<Banditore,String>, JpaSpecificationExecutor<Banditore> {

    @Query(value = "SELECT * FROM banditore", nativeQuery = true)
    public List<BanditoreInterface> getBanditori();

    @Query(value = "SELECT * FROM banditore WHERE banditore.titolo like :titolo%", nativeQuery = true)
    public List<BanditoreInterface> getSpecificaBanditore(@Param("titolo") String titolo);

    @Query(value = " INSERT INTO banditore (id, nome, settore) VALUES (:id,:nome,:settore)", nativeQuery = true)
    public List<BanditoreInterface> addBanditore(@Param("id") String id,
                                                     @Param("nome") String nome,
                                                     @Param("settore") String settore);


    @Query(value = "UPDATE banditore set nome = :nome, settore = :settore\n" +
            "where banditore.id = :id", nativeQuery = true)
    public List<BanditoreInterface> modifyBanditore(@Param("id") String id,
                                                 @Param("nome") String nome,
                                                 @Param("settore") String settore);

    @Query(value = "DELETE FROM banditore WHERE banditore.id = :id ", nativeQuery = true)
    public List<BanditoreInterface> cancellaBanditore(@Param("id") String id);
}
