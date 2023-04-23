package br.edu.iff.jogoforca.dominio.rodada.sorteio;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaFactoryImpl;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class RodadaSorteioFactory extends RodadaFactoryImpl{
    private static RodadaSorteioFactory soleInstance = null;
	
	public static RodadaSorteioFactory getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("Sorteio de rodada não iniciado");
		}
		
		return soleInstance;
	}

    private RodadaSorteioFactory(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(rodadaRepository, temaRepository, palavraRepository);
	}

    public static void createSoleInstance (RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		soleInstance = new RodadaSorteioFactory(rodadaRepository, temaRepository, palavraRepository);
	}
	@Override
	public Rodada getRodada(Jogador jogador) {
		Random numeroAleatorio = new Random();
		List<Tema> temasListTotal = getTemaRepository().getTodos();
		Tema temaEscolhido = temasListTotal.get(numeroAleatorio.nextInt(temasListTotal.size()));
		List<Palavra> palavrasPorTema = getPalavraRepository().getPorTema(temaEscolhido);
		int palavrasMaximo = Rodada.getMaxPalavras();
		int palavrasMinimo = 1;
		int totalPalavras = numeroAleatorio.nextInt((palavrasMaximo+1) - palavrasMinimo) + palavrasMinimo;
		List<Palavra> palavrasEscolhidas = new ArrayList<Palavra>();
		Palavra palavra = null;
		
		
		while(palavrasEscolhidas.size() != totalPalavras) {
			palavra = palavrasPorTema.get(numeroAleatorio.nextInt(palavrasPorTema.size()));
			if(!palavrasEscolhidas.contains(palavra) && palavrasEscolhidas.size() !=3) {
				palavrasEscolhidas.add(palavra);
			}
		}
		
		Rodada rodada = Rodada.criar(getProximoId(), palavrasEscolhidas, jogador);
		palavrasEscolhidas.clear();
		try {
			getRodadaRepository().inserir(rodada);
		} catch (RepositoryException e) {
			throw new RuntimeException("Erro ao tentar armazenar a rodada");
		}
		return rodada;
	}
}
