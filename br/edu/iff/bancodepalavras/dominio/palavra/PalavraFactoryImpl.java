package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.factory.EntityFactory;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public class PalavraFactoryImpl extends EntityFactory implements PalavraFactory{
	
    // Instância única da classe PalavraFactoryImpl, seguindo o padrão Singleton
    private static PalavraFactoryImpl soleInstance = null;

    // Construtor da classe PalavraFactoryImpl que recebe um objeto Repository
	private PalavraFactoryImpl(Repository repository) {
		super(repository);
	}

    //Singleton Parametrizado
	// Cria uma instância única da classe PalavraFactoryImpl que usa o PalavraRepository como Repository, seguindo o padrão Singleton
    public static void createSoleInstance(PalavraRepository palavraRepository) {
        soleInstance = new PalavraFactoryImpl(palavraRepository);
    }

	// Retorna a instância única da classe PalavraFactoryImpl
	public static PalavraFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("Criação de palavras não iniciada!");
		}
		return soleInstance;
	}
	
	// Método que retorna o PalavraRepository a partir do Repository da classe
	private PalavraRepository getPalavraRepository() {
		return (PalavraRepository) getRepository();
	}
	
	// Implementação do método da interface PalavraFactory que cria uma nova instância de Palavra e a insere no PalavraRepository
	@Override
	public Palavra getPalavra(String palavraStr, Tema tema) {
		Palavra palavra = Palavra.criar(getProximoId(), palavraStr, tema);
		try {
			getPalavraRepository().inserir(palavra);
		} catch (RepositoryException repositoryException) {
			throw new RuntimeException("Erro ao armazenar palavra");
		}
		return palavra;
	}
}
