package br.edu.iff.jogoforca.dominio.jogador;

public class Jogador {
    private long id;
    private int pontuacao = 0;
    private String nome;

    private Jogador(long id, String nome, int pontuacao) {
        this.id = id;
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    private Jogador(long id, String nome) {
        this(id, nome, 0);
    }

    public static Jogador reconstituir(long id, String nome, int pontuacao) {
        return new Jogador(id, nome, pontuacao);
    }

    public static Jogador criar(long id, String nome) {
        return new Jogador(id, nome);
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
