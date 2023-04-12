package br.edu.iff.jogoforca.dominio.rodada;

import java.util.Arrays;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;

public class Item {
    private int id;
    private Palavra palavra;
    private boolean[] posicoesDescobertas;
    private String palavraArriscada;

    public Item(int id, Palavra palavra) {
        this.id = id;
        this.palavra = palavra;
        this.posicoesDescobertas = new boolean[palavra.getTamanho()];
    }

    public Item(int id, Palavra palavra, boolean[] posicoesDescobertas, String palavraArriscada) {
        this.id = id;
        this.palavra = palavra;
        this.posicoesDescobertas = posicoesDescobertas;
        this.palavraArriscada = palavraArriscada;
    }

    public void arriscar(String palavraArriscada) {
        this.palavraArriscada = palavraArriscada;
    }

    public boolean acertou() {
        return palavraArriscada != null && palavraArriscada.equalsIgnoreCase(palavra.getPalavra());
    }

    public boolean arriscou() {
        return palavraArriscada != null;
    }

    public String getPalavraArriscada() {
        return palavraArriscada;
    }

    public boolean tentar(char codigo) {
        boolean acertou = false;
        for (int i = 0; i < palavra.getTamanho(); i++) {
            if (palavra.getLetra(i).getCodigo() == codigo) {
                posicoesDescobertas[i] = true;
                acertou = true;
            }
        }
        return acertou;
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

    public Letra[] getLetrasEncobertas() {
        Letra[] letrasEncobertas = new Letra[qtdeLetrasEncobertas()];
        int i = 0;
        for (int j = 0; j < posicoesDescobertas.length; j++) {
            if (!posicoesDescobertas[j]) {
                continue;
            }
            letrasEncobertas[i] = palavra.getLetra(j);
            i++;
        }
        return letrasEncobertas;
    }

    public Letra[] getLetrasDescobertas() {
        Letra[] letrasDescobertas = new Letra[palavra.getTamanho() - qtdeLetrasEncobertas()];
        int i = 0;
        for (int j = 0; j < posicoesDescobertas.length; j++) {
            if (posicoesDescobertas[j]) {
                continue;
            }
            letrasDescobertas[i] = palavra.getLetra(j);
            i++;
        }
        return letrasDescobertas;
    }

    public Palavra getPalavra() {
        return palavra;
    }
