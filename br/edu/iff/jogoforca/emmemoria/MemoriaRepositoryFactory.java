package br.edu.iff.jogoforca.emmemoria;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.palavra.emmemoria.MemoriaPalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.bancodepalavras.dominio.tema.emmemoria.MemoriaTemaRepository;
import br.edu.iff.jogoforca.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.jogador.emmemoria.MemoriaJogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.jogoforca.dominio.rodada.emmemoria.MemoriaRodadaRepository;

public class MemoriaRepositoryFactory implements RepositoryFactory {

    // Instância única da fábrica, seguindo o padrão Singleton
    private static MemoriaRepositoryFactory soleInstance = null;

    // Construtor privado para garantir que a classe só pode ser instanciada internamente
    private MemoriaRepositoryFactory() {
    }

    // Retorna a instância única da fábrica, criando uma se não existir, seguindo o padrão Singleton
    public static MemoriaRepositoryFactory getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaRepositoryFactory();
        }
        return soleInstance;
    }

    // Retorna uma instância do repositório de palavras em memória
    @Override
    public PalavraRepository getPalavraRepository() {
        return MemoriaPalavraRepository.getSoleInstance();
    }

    // Retorna uma instância do repositório de temas em memória
    @Override
    public TemaRepository getTemaRepository() {
        return MemoriaTemaRepository.getSoleInstance();
    }

    // Retorna uma instância do repositório de rodadas em memória
    @Override
    public RodadaRepository getRodadaRepository() {
        return MemoriaRodadaRepository.getSoleInstance();
    }

    // Retorna uma instância do repositório de jogadores em memória
    @Override
    public JogadorRepository getJogadorRepository() {
        return MemoriaJogadorRepository.getSoleInstance();
    }

}
