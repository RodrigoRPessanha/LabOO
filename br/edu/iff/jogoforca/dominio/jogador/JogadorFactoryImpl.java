package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class JogadorFactoryImpl extends EntityFactory implements JogadorFactory{
	// Cria uma única instância da classe JogadorFactoryImpl
    private static JogadorFactoryImpl soleInstance = null;

	// Método para criar a única instância da classe JogadorFactoryImpl
	public static void createSoleInstance(JogadorRepository jogadorRepository) {
		soleInstance = new JogadorFactoryImpl(jogadorRepository);
	}

	// Método para obter a única instância da classe JogadorFactoryImpl
	public static JogadorFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException(" jogador não inicializado");
		}
		return soleInstance;
	}

	// Construtor privado que recebe o repositório de jogadores
	private JogadorFactoryImpl(JogadorRepository jogadorRepository) {
		super(jogadorRepository);
	}

	// Método privado para obter o repositório de jogadores
	private JogadorRepository getJogadorRepository() {
		return (JogadorRepository) getRepository();
	}

	// Implementação do método getJogador da interface JogadorFactory
	@Override
	public Jogador getJogador(String nome) {
		Jogador jogador = Jogador.criar(getProximoId(), nome);
		try {
			getJogadorRepository().inserir(jogador);
		} catch ( RepositoryException repositoryException) {
			throw new RuntimeException ("Ocorreu um erro ao tentar armazenar o jogador");
		}
		return jogador;
	}
}