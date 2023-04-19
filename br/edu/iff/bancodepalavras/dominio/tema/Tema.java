package br.edu.iff.bancodepalavras.dominio.tema;

public class Tema extends br.edu.iff.dominio.ObjetoDominioImpl {
    private String nome;

    private Tema(long id, String nome) {
        super(id);
        this.setNome(nome);
    }

    public static Tema reconstituir(long id, String nome) {
        Tema tema = new Tema(id, nome);
        return tema;
    }

    public static Tema criar(long id, String nome) {
        Tema tema = new Tema(id, nome);
        return tema;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
}
