package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.Repository;
import br.edu.iff.repository.RepositoryException;

public class PalavraFactoryImpl extends br.edu.iff.factory.EntityFactory implements br.edu.iff.bancodepalavras.dominio.palavra.PalavraFactory{
    private static PalavraFactoryImpl soleInstance = null;

	//Construtor
	private PalavraFactoryImpl(Repository repository) {
		super(repository);
	}

    //Singleton Parametrizado
    public static void createSoleInstance(PalavraRepository palavraRepository) {
        soleInstance = new PalavraFactoryImpl(palavraRepository);
    }

	public static PalavraFactoryImpl getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("Criação de palavras não iniciada!");
		}
		return soleInstance;
	}
	
	private PalavraRepository getPalavraRepository() {
		return (PalavraRepository) getRepository();
	}
	
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
