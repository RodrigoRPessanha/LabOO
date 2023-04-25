package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public interface RodadaFactory {
    // Método que recebe um jogador e retorna uma nova rodada
    public Rodada getRodada(Jogador jogador);
}
