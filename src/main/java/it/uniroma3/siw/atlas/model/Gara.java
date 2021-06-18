package it.uniroma3.siw.atlas.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gara")
public class Gara {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "anno")
    private Long anno;

    @Column(name = "nome")
    private String nome;


    @Column(name = "data")
    private Long data;

    @Column(name = "base_asta")
    private String baseAsta;

    @Column(name = "banditore")
    private String banditore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getAnno() {
        return anno;
    }

    public void setAnno(Long anno) {
        this.anno = anno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public String getBaseAsta() {
        return baseAsta;
    }

    public void setBaseAsta(String baseAsta) {
        this.baseAsta = baseAsta;
    }

    public String getBanditore() {
        return banditore;
    }

    public void setBanditore(String banditore) {
        this.banditore = banditore;
    }
}
