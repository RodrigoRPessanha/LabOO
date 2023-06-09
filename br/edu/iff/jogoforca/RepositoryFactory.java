package br.edu.iff.jogoforca;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

public interface RepositoryFactory {
    // Método para criar um repositório de palavras.
    public PalavraRepository getPalavraRepository();

    // Método para criar um repositório de temas.
    public TemaRepository getTemaRepository();

    // Método para criar um repositório de rodadas.
    public RodadaRepository getRodadaRepository();

    // Método para criar um repositório de jogadores.
    public JogadorRepository getJogadorRepository();
}
