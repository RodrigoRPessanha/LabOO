package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public abstract class RodadaFactoryImpl extends br.edu.iff.factory.EntityFactory implements br.edu.iff.jogoforca.dominio.rodada.RodadaFactory {

    private TemaRepository temaRepository;

    private PalavraRepository palavraRepository;

    protected RodadaFactoryImpl(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(rodadaRepository);
		this.temaRepository = temaRepository;
		this.palavraRepository = palavraRepository;
	}

    @Override
    public Rodada getRodada(Jogador jogador) {
        Rodada rodada = Rodada.criar(getProximoId(), jogador);

		try {
			getRodadaRepository().inserir(rodada);
		} catch ( RepositoryException repositoryException) {
			throw new RuntimeException ("Ocorreu um erro ao tentar armazenar a rodada");

		}

		return rodada;
    }

    protected TemaRepository getTemaRepository() {
        TemaRepository tema = this.temaRepository;
        return tema;
    }

    protected PalavraRepository getPalavraRepository() {
        PalavraRepository palavra = this.palavraRepository;
        return palavra;
    }

    protected RodadaRepository getRodadaRepository() {
        return (RodadaRepository) getRepository();
    }

}
