package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.dominio.ObjetoDominioImpl;

public class Jogador extends ObjetoDominioImpl{

    // Declaração das variáveis privadas
    private int pontuacao = 0;
    private String nome;

    // Construtor privado que recebe "id", "nome" e "pontuacao" como parâmetros
    private Jogador(long id, String nome, int pontuacao) {
        super(id);
        this.nome = nome;
        this.pontuacao = pontuacao;
    }

    // Construtor privado que recebe "id" e "nome" como parâmetros
    private Jogador(long id, String nome) {
        super(id);
        this.nome = nome;;
    }

    // Método estático que retorna uma instância de Jogador com "id", "nome" e "pontuacao"
    public static Jogador reconstituir(long id, String nome, int pontuacao) {
        return new Jogador(id, nome, pontuacao);
    }

    // Método estático que retorna uma instância de Jogador com "id" e "nome"
    public static Jogador criar(long id, String nome) {
        return new Jogador(id, nome);
    }

    // Getters e Setters dos atributos privados
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
