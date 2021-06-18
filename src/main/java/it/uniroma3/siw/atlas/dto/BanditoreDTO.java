package it.uniroma3.siw.atlas.dto;

public class BanditoreDTO {
    String id;
    String nome;
    String settore;

    public BanditoreDTO(String id, String nome, String settore) {
        this.id = id;
        this.nome = nome;
        this.settore = settore;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSettore() {
        return settore;
    }
}