package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;

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

    public boolean salvarRodada(Rodada rodada) {
        return rodadaRepository.salvar(rodada);
    }

    public Rodada novaRodada(Jogador jogador) {
        return rodadaFactory.criar(jogador);
    }

    public Rodada novaRodada(String nomeJogador) throws JogadorNaoEncontradoException {
        Jogador jogador = jogadorRepository.buscarPorNome(nomeJogador);
        if (jogador == null) {
            throw new JogadorNaoEncontradoException(nomeJogador);
        }
        return rodadaFactory.criar(jogador);
    }

    public Rodada novaRodada(long idJogador) {
        Jogador jogador = jogadorRepository.buscarPorId(idJogador);
        return rodadaFactory.criar(jogador);
    }
}