package br.edu.iff.jogoforca.dominio.jogador;

import br.edu.iff.repository.RepositoryException;

public class JogadorFactoryImpl extends br.edu.iff.factory.EntityFactory implements br.edu.iff.jogoforca.dominio.jogador.JogadorFactory{
    private static JogadorFactoryImpl soleInstance = null;

	public static void createSoleInstance(JogadorRepository jogadorRepository) {
		soleInstance = new JogadorFactoryImpl(jogadorRepository);
	}

	public static JogadorFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException(" jogador não inicializado");
		}
		return soleInstance;
	}

	private JogadorFactoryImpl(JogadorRepository jogadorRepository) {
		super(jogadorRepository);
	}

	private JogadorRepository getJogadorRepository() {
		return (JogadorRepository) getRepository();
	}

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