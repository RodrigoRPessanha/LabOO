package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;

public class Rodada {
    private long id;
    private int pontos;
    private int qtdeTentativas;
    private int qtdeAcertos;
    private int qtdeErros;
    private int qtdeTentativasRestantes;
    private Letra[] tentativas;
    private Letra[] certas;
    private Letra[] erradas;
    private Palavra[] palavras;
    private Tema tema;
    private Jogador jogador;
    private BonecoFactory bonecoFactory;
    private int pontosPorLetraEncoberta = 15;
    private int pontosQuandoDescobreTodasAsPalavras = 100;
    private int maxErros = 10;
    private int maxPalavras = 3;

    public Rodada(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
        this.id = id;
        this.tentativas = new Letra[itens.length];
        this.certas = new Letra[itens.length];
        this.qtdeTentativas = 0;
        this.qtdeAcertos = 0;
        this.qtdeErros = 0;
        this.qtdeTentativasRestantes = maxErros;
        this.jogador = jogador;
        this.erradas = erradas;
        for (int i = 0; i < itens.length; i++) {
            Letra letra = new Letra('_', false);
            tentativas[i] = letra;
            for (Letra certa : itens[i].getLetras()) {
                certa.setEncoberta(true);
                certas[i] = certa;
            }
        }
    }

    public Rodada(long id, Palavra[] palavras, Jogador jogador) {
        this.id = id;
        this.palavras = palavras;
        this.tentativas = new Letra[palavras.length];
        this.certas = new Letra[palavras.length];
        this.qtdeTentativas = 0;
        this.qtdeAcertos = 0;
        this.qtdeErros = 0;
        this.qtdeTentativasRestantes = maxErros;
        this.jogador = jogador;
        for (int i = 0; i < palavras.length; i++) {
            Letra letra = new Letra('_', false);
            tentativas[i] = letra;
            for (Letra certa : palavras[i].getLetras()) {
                certa.setEncoberta(true);
                certas[i] = certa;
            }
        }
    }

    public void reconstituir(long id, Item[] itens, Letra[] erradas, Jogador jogador) {
        this.id = id;
        this.tentativas = new Letra[itens.length];
        this.certas = new Letra[itens.length];
        this.qtdeTentativas = 0;
        this.qtdeAcertos = 0;
        this.qtdeErros = 0;
        this.qtdeTentativasRestantes = maxErros;
        this.jogador = jogador;
        this.erradas = erradas;
        for (int i = 0; i < itens.length; i++) {
            Letra letra = new Letra('_', false);
            tentativas[i] = letra;
            for (Letra certa : itens[i].getLetras()) {
                certa.setEncoberta(true);
                certas[i] = certa;
            }
        }
    }
    
    public void criar(long id, Palavra[] palavras, Jogador jogador) {
        this.id = id;
        this.palavras = palavras;
        this.jogador = jogador;
        this.itens = new Item[palavras.length];
        this.erradas = new Letra[maxErros];
        this.tentativas = new Letra[maxErros];
        this.qtdeTentativas = 0;
        this.qtdeAcertos = 0;
        this.qtdeErros = 0;
        this.qtdeTentativasRestantes = maxErros;
        this.encerrou = false;
        this.descobriu = false;
        this.arriscou = false;
        this.bonecoFactory = new BonecoFactory();
        for (int i = 0; i < palavras.length; i++) {
            this.itens[i] = new Item(palavras[i]);
        }
    }
    
    public void exibirItens(Object contexto) {
        System.out.println("ITENS DA RODADA:");
        System.out.println("-----------------");

        // exibe o tema da rodada
        System.out.println("TEMA: " + tema.getNome());

        // exibe o jogador atual
        System.out.println("JOGADOR: " + jogador.getNome());

        // exibe as palavras da rodada
        System.out.println("PALAVRAS:");
        for (Palavra palavra : palavras) {
            System.out.println("- " + palavra.getPalavraEncoberta());
        }

        // exibe as letras erradas
        System.out.println("LETRAS ERRADAS:");
        for (Letra letra : erradas) {
            System.out.print(letra.getCodigo() + " ");
        }
        System.out.println();

        // exibe as letras certas
        System.out.println("LETRAS CERTAS:");
        for (Letra letra : certas) {
            System.out.print(letra.getCodigo() + " ");
        }
        System.out.println();

        // exibe as letras tentadas
        System.out.println("LETRAS TENTADAS:");
        for (Letra letra : tentativas) {
            System.out.print(letra.getCodigo() + " ");
        }
        System.out.println();

        // exibe a quantidade de tentativas restantes
        System.out.println("TENTATIVAS RESTANTES: " + getQtdeTentativasRestantes());

        // exibe o boneco da forca
        BonecoFactory bonecoFactory = getBonecoFactory();
        if (bonecoFactory != null) {
            Boneco boneco = bonecoFactory.criarBoneco(getQtdeErros());
            System.out.println("BONECO:");
            System.out.println(boneco.desenhar());
        }
    }
    
    