package br.edu.iff.bancodepalavras.dominio.palavra;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;

public class Palavra {
	private long id;
    private String palavra;
    private Tema tema;
    private LetraFactory letraFactory;

    public Palavra(long id, String palavra, Tema tema) {
        this.id = id;
        this.palavra = palavra;
        this.tema = tema;
        this.letraFactory = getLetraFactory();
    }

    public int getTamanho() {
        return palavra.length();
    }

    public boolean comparar(String palavra) {
        return this.palavra.equals(palavra);
    }

    public Tema getTema() {
        return tema;
    }

    public int[] tentar(char codigo) {
        int[] posicoes = new int[palavra.length()];
		int j = 0;
        for (int i = 0; i < palavra.length(); i++) {
            Letra letra = letraFactory.criarLetra(palavra.charAt(i));
            if (letra.getCodigo() == codigo) {
                posicoes[j] = i+1;
				j++;
            }
        }
        return posicoes;
    }

    public void exibir(Object contexto, boolean[] posicoes) {
        for (int i = 0; i < palavra.length(); i++) {
            Letra letra = letraFactory.criarLetra(palavra.charAt(i));
            if (posicoes[i]) {
                letra.exibir(contexto);
            } else {
                letra.exibirOculta(contexto);
            }
        }
    }

    public void exibir(Object contexto) {
        for (int i = 0; i < palavra.length(); i++) {
            Letra letra = letraFactory.criarLetra(palavra.charAt(i));
            letra.exibir(contexto);
        }
    }

    public Letra getLetra(int posicao) {
        Letra letra = letraFactory.criarLetra(palavra.charAt(posicao));
        return letra;
    }

    public Letra[] getLetras() {
        Letra[] letras = new Letra[palavra.length()];
        for (int i = 0; i < palavra.length(); i++) {
            letras[i] = letraFactory.criarLetra(palavra.charAt(i));
        }
        return letras;
    }

    @Override
    public String toString() {
        return "Palavra [id=" + id + ", palavra=" + palavra + ", tema=" + tema + "]";
    }

    public static Palavra reconstituir(long id, String palavra, Tema tema) {
        return new Palavra(id, palavra, tema);
    }

    public static Palavra criar(long id, String palavra, Tema tema) {
        return new Palavra(id, palavra, tema);
    }

    public LetraFactory getLetraFactory() {
        return letraFactory;
    }

    public void setLetraFactory(LetraFactory letraFactory) {
        this.letraFactory = letraFactory;
    }
}
