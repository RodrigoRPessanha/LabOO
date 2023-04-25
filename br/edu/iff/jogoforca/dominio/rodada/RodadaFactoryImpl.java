package br.edu.iff.jogoforca.dominio.rodada;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.factory.EntityFactory;

public abstract class RodadaFactoryImpl extends EntityFactory implements RodadaFactory {

    // Repositório para os temas das palavras
    private TemaRepository temaRepository;

    // Repositório para as palavras
    private PalavraRepository palavraRepository;

    // Construtor da fábrica de rodadas
    protected RodadaFactoryImpl(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(rodadaRepository);
		this.temaRepository = temaRepository;
		this.palavraRepository = palavraRepository;
	}

    // Retorna o repositório de temas
    protected TemaRepository getTemaRepository() {
        TemaRepository tema = this.temaRepository;
        return tema;
    }

    // Retorna o repositório de palavras
    protected PalavraRepository getPalavraRepository() {
        PalavraRepository palavra = this.palavraRepository;
        return palavra;
    }

    // Retorna o repositório de rodadas
    protected RodadaRepository getRodadaRepository() {
        return (RodadaRepository) getRepository();
    }

}
