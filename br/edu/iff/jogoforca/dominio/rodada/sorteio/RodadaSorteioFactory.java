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
	// declaração da única instância da classe
    private static RodadaSorteioFactory soleInstance = null;
	
	 // método para obter a instância única da classe
	public static RodadaSorteioFactory getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("Sorteio de rodada não iniciado");
		}
		
		return soleInstance;
	}

	// construtor privado da classe para garantir que não seja instanciada externamente
    private RodadaSorteioFactory(RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		super(rodadaRepository, temaRepository, palavraRepository);
	}

	// método estático para criar a instância única da classe
    public static void createSoleInstance (RodadaRepository rodadaRepository, TemaRepository temaRepository, PalavraRepository palavraRepository) {
		soleInstance = new RodadaSorteioFactory(rodadaRepository, temaRepository, palavraRepository);
	}

	@Override
	public Rodada getRodada(Jogador jogador) {
		Random numeroAleatorio = new Random();
		List<Tema> temasListTotal = getTemaRepository().getTodos();

		// Sorteia um tema da lista de temas disponíveis
		Tema temaEscolhido = temasListTotal.get(numeroAleatorio.nextInt(temasListTotal.size()));

		// Obtém a lista de palavras associadas ao tema escolhido
		List<Palavra> palavrasPorTema = getPalavraRepository().getPorTema(temaEscolhido);

		int palavrasMaximo = Rodada.getMaxPalavras();
		int palavrasMinimo = 1;

		// Sorteia um número aleatório de palavras entre o mínimo e o máximo permitido
		int totalPalavras = numeroAleatorio.nextInt((palavrasMaximo+1) - palavrasMinimo) + palavrasMinimo;

		// Cria uma lista para armazenar as palavras escolhidas
		List<Palavra> palavrasEscolhidas = new ArrayList<Palavra>();
		Palavra palavra = null;
		
		// Enquanto o número de palavras escolhidas for diferente do número total de palavras,
    	// seleciona aleatoriamente uma palavra da lista de palavras do tema e adiciona na lista
		while(palavrasEscolhidas.size() != totalPalavras) {
			palavra = palavrasPorTema.get(numeroAleatorio.nextInt(palavrasPorTema.size()));

			// Adiciona a palavra escolhida somente se ela ainda não foi escolhida antes
       	 	// e a lista de palavras escolhidas não atingiu o limite de 3 palavras
			if(!palavrasEscolhidas.contains(palavra) && palavrasEscolhidas.size() !=3) {
				palavrasEscolhidas.add(palavra);
			}
		}
		// Cria uma nova instância de Rodada com as palavras escolhidas e o jogador
		Rodada rodada = Rodada.criar(getProximoId(), palavrasEscolhidas, jogador);

		// Limpa a lista de palavras escolhidas para futuros sorteios de rodadas
		palavrasEscolhidas.clear();
		try {
			getRodadaRepository().inserir(rodada);
		} catch (RepositoryException e) {
			throw new RuntimeException("Erro ao tentar armazenar a rodada");
		}
		return rodada;
	}
}
