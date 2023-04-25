package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.JogadorNaoEncontradoException;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class RodadaAppService {

    private static RodadaAppService soleInstance;
    private RodadaFactory rodadaFactory;
    private RodadaRepository rodadaRepository;
    private JogadorRepository jogadorRepository;

    private RodadaAppService(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository, JogadorRepository jogadorRepository) {
        this.rodadaFactory = rodadaFactory;
        this.rodadaRepository = rodadaRepository;
        this.jogadorRepository = jogadorRepository;
    }

    public static RodadaAppService getSoleInstance() {
        return soleInstance;
    }

    public static void createSoleInstance(RodadaFactory rodadaFactory, RodadaRepository rodadaRepository, JogadorRepository jogadorRepository) {
        if (soleInstance == null) {
            soleInstance = new RodadaAppService(rodadaFactory, rodadaRepository, jogadorRepository);
        }
    }

    public boolean salvarRodada(Rodada rodada) throws RepositoryException{
        try {
            rodadaRepository.inserir(rodada);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public Rodada novaRodada(Jogador jogador) {
        try {
			jogadorRepository.inserir(jogador);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
        
        return rodadaFactory.getRodada(jogador);
    }

    public Rodada novaRodada(String nomeJogador) throws JogadorNaoEncontradoException {
        Jogador jogador = jogadorRepository.getPorNome(nomeJogador);
        if (jogador == null) {
            throw new JogadorNaoEncontradoException(nomeJogador);
        }
        return rodadaFactory.getRodada(jogador);
    }

    public Rodada novaRodada(long idJogador) {
        Jogador jogador = jogadorRepository.getPorId(idJogador);
        return rodadaFactory.getRodada(jogador);
    }
}