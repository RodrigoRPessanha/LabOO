package br.edu.iff.jogoforca.embdr;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.palavra.embdr.BDRPalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.bancodepalavras.dominio.tema.embdr.BDRTemaRepository;
import br.edu.iff.jogoforca.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.jogador.embdr.BDRJogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.jogoforca.dominio.rodada.embdr.BDRRodadaRepository;

public class BDRRepositoryFactory implements RepositoryFactory {

    public BDRRepositoryFactory() {
    }

    public BDRRepositoryFactory getSoleInstance() {
        return null;
    }

    @Override
    public PalavraRepository getPalavraRepository() {
        return null;
    }

    @Override
    public TemaRepository getTemaRepository() {
        return null;
    }

    @Override
    public RodadaRepository getRodadaRepository() {
        return null;
    }

    @Override
    public JogadorRepository getJogadorRepository() {
        return null;
    }

}
