package br.edu.iff.bancodepalavras.dominio.letra.texto;

public class LetraTexto extends br.edu.iff.bancodepalavras.dominio.letra.Letra{

	public LetraTexto(char codigo) {
		super(codigo);
	}

	@Override
	public void exibir(Object contexto){
		System.out.println(contexto);
	}
}
