package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;

public class LetraTexto extends Letra{

	// Construtor da classe LetraImagem que recebe o código da letra como parâmetro
	public LetraTexto(char codigo) {
		super(codigo); // Chama o construtor da classe pai (Letra)
	}

	// Implementa o método exibir da classe Letra
	@Override
	public void exibir(Object contexto){
		System.out.println(contexto);
	}
}
