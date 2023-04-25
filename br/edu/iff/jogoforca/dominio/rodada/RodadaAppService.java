package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.JogadorNaoEncontradoException;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class RodadaAppService {

    private static RodadaAppService soleInstance; // Instância única da classe (padrão Singleton)
    private RodadaFactory rodadaFactory; // Fábrica de objetos Rodada
    private RodadaRepository rodadaRepository; // Repositório de objetos Rodada
    private JogadorRepository jogadorRepository; // Repositório de objetos Jogador

    // Construtor privado da classe que recebe as dependências necessárias
    private RodadaAppService(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository, JogadorRepository jogadorRepository) {
        this.rodadaFactory = rodadaFactory;
        this.rodadaRepository = rodadaRepository;
        this.jogadorRepository = jogadorRepository;
    }

    // Método estático que retorna a instância única da classe (padrão Singleton)
    public static RodadaAppService getSoleInstance() {
        return soleInstance;
    }

    // Método estático que cria a instância única da classe (padrão Singleton)
    public static void createSoleInstance(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository, JogadorRepository jogadorRepository) {
        if (soleInstance == null) {
            soleInstance = new RodadaAppService(rodadaFactory, rodadaRepository, jogadorRepository);
        }
    }

    // Método que salva uma rodada no repositório de rodadas
    public boolean salvarRodada(Rodada rodada) throws RepositoryException{
        try {
            rodadaRepository.inserir(rodada);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    // Método que cria uma nova rodada para um jogador existente
    public Rodada novaRodada(Jogador jogador) {
        try {
			jogadorRepository.inserir(jogador);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
        return rodadaFactory.getRodada(jogador);
    }

    // Método que cria uma nova rodada para um jogador com um determinado nome
    public Rodada novaRodada(String nomeJogador) throws JogadorNaoEncontradoException {
        Jogador jogador = jogadorRepository.getPorNome(nomeJogador);
        if (jogador == null) {
            throw new JogadorNaoEncontradoException(nomeJogador);
        }
        return rodadaFactory.getRodada(jogador);
    }

    // Método que cria uma nova rodada para um jogador com um determinado ID
    public Rodada novaRodada(long idJogador) {
        Jogador jogador = jogadorRepository.getPorId(idJogador);
        return rodadaFactory.getRodada(jogador);
    }
}