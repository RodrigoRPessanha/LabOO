package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Palavra extends ObjetoDominioImpl{
	//Define todos os atributos da classe Palavra
	private static LetraFactory letraFactory;

	private List<Letra> palavra;

	private Tema tema;

	// Construtor privado para criação de nova Palavra
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
	
	// Método para obter a fábrica de Letra
	public static LetraFactory getLetraFactory() {
		return letraFactory;
	}

	// Método para definir a fábrica de Letra
	public static void setLetraFactory(LetraFactory factory){
		letraFactory = factory;
	}

	// Método para obter a lista de Letras da Palavra
	public List<Letra> getPalavra() {
		return Collections.unmodifiableList(this.palavra);
	}

	// Método para obter o Tema da Palavra
	public Tema getTema() {
		return this.tema;
	}

	// Método estático para criar nova Palavra
	public static Palavra criar(Long id, String palavra, Tema tema) {
		Palavra criarPalavra = new Palavra(id, palavra, tema);
		return criarPalavra;
	}

	// Método estático para reconstituir Palavra existente
	public static Palavra reconstituir(Long id, String palavra, Tema tema) {
		Palavra criarPalavra = new Palavra(id, palavra, tema);
		return criarPalavra;
	}

	// Método que retorna a lista de letras da palavra, protegendo-a de modificações externas
	public List<Letra> getLetras(){
		return Collections.unmodifiableList(this.palavra);
	}

	// Método que retorna a letra da palavra na posição especificada
	public Letra getLetra(int posicao) {
		return this.palavra.get(posicao);

	}

	// Método que exibe a palavra, letra por letra, chamando o método exibir() de cada letra
	public void exibir(Object contexto) {
		for(Letra letraTemp: palavra) {
			letraTemp.exibir(null);
		}
	}

	// Método que exibe a palavra de acordo com as posições indicadas na lista de booleanos recebida
	public void exibir(Object contexto, List<Boolean> posicoes) {
		if(posicoes.size() != palavra.size()) {
			throw new RuntimeException("Ocorreu um erro na exibição da palavra");

		}
		LetraFactory letraFactory = getLetraFactory();
		Letra letraEncoberta = letraFactory.getLetraEncoberta();

		for(int contador = 0; contador < palavra.size(); contador++) {
			if(posicoes.get(contador)) {
				palavra.get(contador).exibir(palavra.get(contador));
			}else {
				letraEncoberta.exibir("_");
			}
		}
	}

	// Método que verifica se a letra passada como parâmetro está presente na palavra e retorna a posição em que ela se encontra
	public List<Integer> tentar(char codigo){
		List<Integer> posicoesEncotradas = new ArrayList<Integer>();
		for(int contador = 0; contador < palavra.size(); contador++) {
			if(palavra.get(contador).getCodigo() == codigo) {
				posicoesEncotradas.add(contador);
			}
		}
		return posicoesEncotradas;
	}

	//Método que verifica se a palavra passada como parâmetro é igual à palavra atual
	public boolean comparar(String palavra) {
		for(int contador = 0; contador < this.palavra.size(); contador++) {
			if(this.palavra.get(contador).getCodigo() != palavra.charAt(contador)) {
				return false;
			}
		}

		return true;
	}

	//Método que retorna o tamanho da palavra
	public int getTamanho() {
		return this.palavra.size();
	}

	//Método que retorna uma representação em string da palavra, mostrando as letras e o tema
	@Override
	public String toString() {
		return "Palavra [Palavras= " + palavra + ", Tema= " + tema + "]";
	}

}