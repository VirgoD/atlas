package it.uniroma3.siw.atlas.dto;

public class GaraDTO {
    String id;
    Long anno;
    String nome;
    Long data;
    String baseAsta;
    String banditore;
    public GaraDTO(String id, Long anno, String nome, Long data, String baseAsta, String banditore) {
    }

    public String getId() {
        return id;
    }

    public Long getAnno() {
        return anno;
    }

    public String getNome() {
        return nome;
    }

    public Long getData() {
        return data;
    }

    public String getBaseAsta() {
        return baseAsta;
    }

    public String getBanditore() {
        return banditore;
    }
}
