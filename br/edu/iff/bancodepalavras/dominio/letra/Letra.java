package br.edu.iff.bancodepalavras.dominio.letra;

public abstract class Letra {
	// Atributo protegido que armazena o código da letra

	private char codigo;

	// Construtor da classe Letra que recebe o código da letra como parâmetro
	protected Letra(char codigo) {
		this.codigo = codigo;
	}

	// Método público que retorna o código da letra
	public char getCodigo() {
		return this.codigo;
	}

	// Método abstrato que deve ser implementado pelas subclasses para exibir a letra em um contexto específico
	public abstract void exibir(Object contexto);

	// Sobrescreve o método equals da classe Object para comparar duas letras
	public boolean equals(Object o){
		if (!(o instanceof Letra)) return false;
		Letra outra = (Letra) o;
		return this.codigo == outra.codigo && this.getClass().equals(outra.getClass());
	}

	// Sobrescreve o método hashcode da classe Object para gerar um código hash para a letra
	public int hashcode() {
		return this.codigo + this.getClass().hashCode();
	}

	// Sobrescreve o método toString da classe Object para retornar uma representação em String da letra
	@Override
	public final String toString() {
		return String.valueOf(this.codigo);
	}
}
