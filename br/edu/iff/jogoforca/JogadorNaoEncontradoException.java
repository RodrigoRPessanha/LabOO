package br.edu.iff.jogoforca;

public class JogadorNaoEncontradoException extends Exception {

    private String jogador;

    public JogadorNaoEncontradoException(String jogador) {
        super("Jogador " + jogador + " não encontrado");
        this.jogador = jogador;
    }

    public String getJogador() {
        return jogador;
    }
} 