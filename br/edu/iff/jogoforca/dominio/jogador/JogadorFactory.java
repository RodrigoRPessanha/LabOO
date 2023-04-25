package br.edu.iff.jogoforca.dominio.jogador;

public interface JogadorFactory {
    // Define o método que será implementado pelas classes que implementam a interface
    public Jogador getJogador(String nome);
}