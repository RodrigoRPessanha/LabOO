package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;

public class Palavra extends br.edu.iff.dominio.ObjetoDominioImpl{

	private static LetraFactory letraFactory;

	private List<Letra> palavra;

	private Tema tema;

	private Palavra(long id, String palavra, Tema tema) {
		super(id);
		LetraFactory letraFactory = getLetraFactory();
		if (letraFactory == null){
			throw new RuntimeException("Letra não iniciada");
		}

		this.tema = tema;
		this.palavra = new ArrayList<Letra>();
		for(int contador = 0; contador < palavra.length(); contador++ ) {
			this.palavra.add(letraFactory.getLetra(palavra.charAt(contador)));
		}
	}

	public static LetraFactory getLetraFactory() {
		return letraFactory;
	}

	public static void setLetraFactory(LetraFactory factory){
		letraFactory = factory;
	}

	public List<Letra> getPalavra() {
		return Collections.unmodifiableList(this.palavra);
	}

	public Tema getTema() {
		return this.tema;
	}

	public static Palavra criar(Long id, String palavra, Tema tema) {
		Palavra criarPalavra = new Palavra(id, palavra, tema);
		return criarPalavra;
	}

	public static Palavra reconstituir(Long id, String palavra, Tema tema) {
		Palavra criarPalavra = new Palavra(id, palavra, tema);
		return criarPalavra;
	}

	public List<Letra> getLetras(){
		return Collections.unmodifiableList(this.palavra);
	}

	public Letra getLetra(int posicao) {
		return this.palavra.get(posicao);

	}

	public void exibir(Object contexto) {
		for(Letra letraTemp: palavra) {
			letraTemp.exibir(null);
		}
	}

	public void exibir(Object contexto, List<Boolean> posicoes) {
		if(posicoes.size() != palavra.size()) {
			throw new RuntimeException("Ocorreu um erro na exibição da palavra");

		}
		LetraFactory letraFactory = getLetraFactory();
		Letra letraEncoberta = letraFactory.getLetraEncoberta();

		for(int contador = 0; contador < palavra.size(); contador++) {
			if(posicoes.get(contador)) {
				palavra.get(contador).exibir(null);
			}else {
				letraEncoberta.exibir(null);
			}
		}
	}

	public List<Integer> tentar(char codigo){
		List<Integer> posicoesEncotradas = new ArrayList<Integer>();
		for(int contador = 0; contador < palavra.size(); contador++) {
			if(palavra.get(contador).getCodigo() == codigo) {
				posicoesEncotradas.add(contador);
			}
		}
		return posicoesEncotradas;
	}

	public boolean comparar(String palavra) {
		for(int contador = 0; contador < this.palavra.size(); contador++) {
			if(this.palavra.get(contador).getCodigo() != palavra.charAt(contador)) {
				return false;
			}
		}

		return true;
	}

	public int getTamanho() {
		return this.palavra.size();
	}

	@Override
	public String toString() {
		return "Palavra [Palavras= " + palavra + ", Tema= " + tema + "]";
	}

}