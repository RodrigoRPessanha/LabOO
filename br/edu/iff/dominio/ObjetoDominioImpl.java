package br.edu.iff.dominio;

public abstract class ObjetoDominioImpl implements ObjetoDominio{
	// Declarando o atributo privado id como long
    private long id;

    // Definindo o construtor da classe ObjetoDominioImpl
	public ObjetoDominioImpl(long id){
		this.id = id;
	}

	// Implementando o método getId() definido na interface ObjetoDominio
	public long getId(){
		return this.id;
	}
}
