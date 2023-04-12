package br.edu.iff.bancodepalavras.dominio.tema;

public class Tema {
    private String nome;
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return this.nome;
    }
    
    public Tema reconstituir(long id, String nome) {
        Tema tema = new Tema();
        tema.setId(id);
        tema.setNome(nome);
        return tema;
    }
    
    public Tema criar(long id, String nome) {
        Tema tema = new Tema();
        tema.setId(id);
        tema.setNome(nome);
        return tema;
    }
    
    private long id;
    
    public long getId() {
        return this.id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
}
