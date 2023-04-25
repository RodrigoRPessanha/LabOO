package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.RepositoryException;

public class TemaFactoryImpl extends EntityFactory implements TemaFactory{
	// Uma instância única da fábrica de temas
    private static TemaFactory soleInstance = null;
	
	// Construtor privado que recebe uma instância do TemaRepository e passa para o construtor da classe pai
	private TemaFactoryImpl(TemaRepository temaRepository) {
		super(temaRepository);
	}
	
	// Este método retorna a instância do TemaRepository que foi passada no construtor
	private TemaRepository getTemaRepository() {
		return (TemaRepository) getRepository();
	}
	
	// Implementação do método getTema da interface TemaFactory
    // Este método cria um novo objeto Tema com o nome fornecido como parâmetro, insere no repositório e retorna o objeto criado
	@Override
	public Tema getTema(String nome) {
		Tema tema = Tema.criar(getProximoId(), nome);
		try {
			getTemaRepository().inserir(tema);
			
		}catch (RepositoryException e) {
			throw new RuntimeException("Erro ao tentar salvar o tema");
		}
		return tema;
	}
	
	// Este método é chamado para criar uma instância única da fábrica de temas usando a instância do TemaRepository fornecida como parâmetro
	public static void createSoleInstance(TemaRepository temaRepository) {
		soleInstance = new TemaFactoryImpl(temaRepository);
	}

	// Este método retorna a instância única da fábrica de temas, se ela já foi criada, ou lança uma exceção se ainda não foi criada
	public static TemaFactory getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("A fabrica de temas não foi iniciada");
		}
		else {
			return soleInstance;
		}
		
	}
}
