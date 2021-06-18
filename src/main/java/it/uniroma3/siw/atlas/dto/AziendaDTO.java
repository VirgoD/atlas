package it.uniroma3.siw.atlas.dto;

public class AziendaDTO {
    String id;
    String nome;
    String pIva;
    String amministratore;
    String settore;

    public AziendaDTO(String id, String nome, String pIva, String amministratore,String settore) {
        this.id = id;
        this.nome = nome;
        this.pIva = pIva;
        this.amministratore = amministratore;
        this.settore =settore;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getpIva() {
        return pIva;
    }

    public String getAmministratore() {
        return amministratore;
    }

    public String getSettore() {
        return settore;
    }
}