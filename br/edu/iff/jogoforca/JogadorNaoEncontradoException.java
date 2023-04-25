package br.edu.iff.jogoforca;

public class JogadorNaoEncontradoException extends Exception {

    // Atributo que armazena o nome do jogador que não foi encontrado
    private String jogador;

    // Construtor da classe JogadorNaoEncontradoException que recebe o nome do jogador como parâmetro
    public JogadorNaoEncontradoException(String jogador) {
        super("Jogador " + jogador + " não encontrado"); // Chama o construtor da classe pai (Exception) e passa uma mensagem de erro com o nome do jogador
        this.jogador = jogador; // Atribui o nome do jogador ao atributo jogador
    }

    // Método para obter o nome do jogador que não foi encontrado
    public String getJogador() {
        return jogador;
    }
} 