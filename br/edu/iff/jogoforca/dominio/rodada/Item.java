package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;

public class Item extends br.edu.iff.dominio.ObjetoDominioImpl{
    private Palavra palavra;
    private List<Boolean> posicoesDescobertas;
    private String palavraArriscada;

    private Item(int id, Palavra palavra) {
		super(id);
        this.palavra = palavra;
    }
	
	static Item criar(int id, Palavra palavra){
        Item item = new Item(id, palavra);
        return item;
	}

    public static Item reconstituir(int id, Palavra palavra, List<Boolean> posicoesDescobertas, String palavraArriscada){
        Item item = new Item(id, palavra, posicoesDescobertas, palavraArriscada);
        return item;
    }

	private Item(int id, Palavra palavra, List<Boolean> posicoesDescobertas, String palavraArriscada) {
        super(id);
        this.palavra = palavra;
        this.posicoesDescobertas = posicoesDescobertas;
        this.palavraArriscada = palavraArriscada;
    }

    void arriscar(String palavraArriscada) {
        this.palavraArriscada = palavraArriscada;
    }

    public boolean acertou() {
        return arriscou() ? palavra.comparar(palavraArriscada) : false;
    }

    public boolean descobriu(){
        if (acertou() || qtdeLetrasEncobertas() == 0){
            return true;
        }
        return false;
    }

    public void exibir(Object contexto){
        palavra.exibir(contexto, posicoesDescobertas);
    }

    public boolean arriscou() {
        return palavraArriscada != null;
    }

    public String getPalavraArriscada() {
        return palavraArriscada;
    }

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

    public int calcularPontosLetrasEncobertas(int valorPorLetraEncoberta) {
        int pontos = 0;
        for (boolean b : posicoesDescobertas) {
            if (b) {
                pontos += valorPorLetraEncoberta;
            }
        }
        return pontos;
    }

    public int qtdeLetrasEncobertas() {
        int qtde = 0;
        for (boolean b : posicoesDescobertas) {
            if (b) {
                qtde++;
            }
        }
        return qtde;
    }

    public List<Letra> getLetrasEncobertas() {
        List<Letra> encobertas = new ArrayList<>();
        for (int i = 0; i < posicoesDescobertas.size(); i++) {
            if (!posicoesDescobertas.get(i)) {
                encobertas.add(palavra.getLetra(i));
            }
        }
        return encobertas;
    }

    public List<Letra> getLetrasDescobertas() {
        List<Letra> descobertas = new ArrayList<>();
        for (int i = 0; i < posicoesDescobertas.size(); i++) {
            if (posicoesDescobertas.get(i)) {
                descobertas.add(palavra.getLetra(i));
            }
        }
        return descobertas;
    }

    public Palavra getPalavra() {
        return palavra;
    }
}
