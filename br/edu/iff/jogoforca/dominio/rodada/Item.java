package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.dominio.ObjetoDominioImpl;

public class Item extends ObjetoDominioImpl{
    //Define todos os atributos da classe Item
    private Palavra palavra;
    private List<Boolean> posicoesDescobertas;
    private String palavraArriscada;

    // Construtor privado para criação de nova Palavra com palavra e id como parâmetro
    private Item(int id, Palavra palavra) {
		super(id);
        this.palavra = palavra;
    }

	// Construtor privado para reconstituir um Item com todos os atributos como parâmetros
	private Item(int id, Palavra palavra, List<Boolean> posicoesDescobertas, String palavraArriscada) {
        super(id);
        this.palavra = palavra;
        this.posicoesDescobertas = posicoesDescobertas;
        this.palavraArriscada = palavraArriscada;
    }

    // Método estático para criar um novo objeto Item com apenas a palavra como parâmetro
	static Item criar(int id, Palavra palavra){
        List<Boolean> posicoesDescobertas = new ArrayList<Boolean>();
        for(int i=0; i<palavra.getTamanho();i++){
            posicoesDescobertas.add(i, false);
        }
        Item item = new Item(id, palavra, posicoesDescobertas, null);
        return item;
	}

    // Método estático para reconstituir um objeto Item a partir dos seus atributos
    public static Item reconstituir(int id, Palavra palavra, List<Boolean> posicoesDescobertas, String palavraArriscada){
        Item item = new Item(id, palavra, posicoesDescobertas, palavraArriscada);
        return item;
    }

    // Método para arriscar uma palavra
    void arriscar(String palavraArriscada) {
        this.palavraArriscada = palavraArriscada;
    }

    // Método para verificar se o jogador acertou a palavra
    public boolean acertou() {
        return arriscou() ? palavra.comparar(palavraArriscada) : false;
    }

    // Método para verificar se o jogador descobriu a palavra
    public boolean descobriu(){
        if (acertou() || qtdeLetrasEncobertas() == 0){
            return true;
        }
        return false;
    }

    // Método para exibir a palavra de acordo com as letras já descobertas
    public void exibir(Object contexto){
        palavra.exibir(contexto, posicoesDescobertas);
    }

    // Método para verificar se o jogador já arriscou uma palavra
    public boolean arriscou() {
        return palavraArriscada != null;
    }

    // Método para retornar a palavra arriscada pelo jogador
    public String getPalavraArriscada() {
        return palavraArriscada;
    }

    // Tenta descobrir as posições das letras da palavra com o código fornecido
    boolean tentar(char codigo) {
        List<Integer> posicoes = palavra.tentar(codigo);

        if(posicoes.size() == 0) {
            return false;
        }
        for(Integer posicaoTemp: posicoes) {
            posicoesDescobertas.set(posicaoTemp, true);
        }

        return true;
    }

    // Calcula os pontos obtidos por cada letra ainda não descoberta
    public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
        int pontos = 0;
        for (boolean b : posicoesDescobertas) {
            if (b) {
                pontos += valorPorLetraEncoberta;
            }
        }
        return pontos;
    }
    
    // Retorna a quantidade de letras ainda não descobertas
    public int qtdeLetrasEncobertas() {
        return this.getLetrasEncobertas().size();
    }

    // Retorna uma lista com as letras ainda não descobertas da palavra
    public List<Letra> getLetrasEncobertas() {
        List<Letra> encobertas = new ArrayList<>();
        for (int i = 0; i < posicoesDescobertas.size(); i++) {
            if (!posicoesDescobertas.get(i)) {
                encobertas.add(palavra.getLetra(i));
            }
        }
        return encobertas;
    }

    // Retorna uma lista com as letras já descobertas da palavra
    public List<Letra> getLetrasDescobertas() {
        List<Letra> descobertas = new ArrayList<>();
        for (int i = 0; i < posicoesDescobertas.size(); i++) {
            if (posicoesDescobertas.get(i)) {
                descobertas.add(palavra.getLetra(i));
            }
        }
        return descobertas;
    }

    // Retorna a palavra deste Item
    public Palavra getPalavra() {
        return palavra;
    }
}
