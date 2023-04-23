package br.edu.iff.bancodepalavras.dominio.tema;

import br.edu.iff.repository.RepositoryException;

public class TemaFactoryImpl extends br.edu.iff.factory.EntityFactory implements br.edu.iff.bancodepalavras.dominio.tema.TemaFactory{
    private static TemaFactory soleInstance = null;
	
	private TemaFactoryImpl(TemaRepository temaRepository) {
		super(temaRepository);
	}
	
	private TemaRepository getTemaRepository() {
		
		return (TemaRepository) getRepository();
	}
	
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
	
	public static void createSoleInstance(TemaRepository temaRepository) {
		soleInstance = new TemaFactoryImpl(temaRepository);
	}

	public static TemaFactory getSoleInstance() {
		if(soleInstance == null) {
			throw new RuntimeException("A fabrica de temas não foi iniciada");
		}
		else {
			return soleInstance;
		}
		
	}
}
