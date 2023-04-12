package br.edu.iff.bancodepalavras.dominio.letra.imagem;

public class LetraImagem extends br.edu.iff.bancodepalavras.dominio.letra.Letra{

	public LetraImagem(char codigo) {
		super(codigo);
	}

	@Override
	public void exibir(Object contexto){
		System.out.println(contexto);
	}
}
