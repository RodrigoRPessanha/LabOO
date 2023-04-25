package br.edu.iff;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraAppService;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.jogoforca.Aplicacao;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.emmemoria.MemoriaJogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaAppService;
import br.edu.iff.repository.RepositoryException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws RepositoryException {
        Aplicacao aplicacao = Aplicacao.getSoleInstance();
        aplicacao.configurar();

        inserirTemasEPalavras();

        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome: ");
        String nomeJogador = scanner.nextLine();
        System.out.println();

        Jogador jogador = Aplicacao.getSoleInstance().getJogadorFactory().getJogador(nomeJogador);
        MemoriaJogadorRepository a = MemoriaJogadorRepository.getSoleInstance();
        a.remover(jogador);
        Rodada rodada = RodadaAppService.getSoleInstance().novaRodada(jogador);

        do {
            System.out.println("Tema: " + rodada.getTema().getNome());
            System.out.println();

            System.out.println("Palavras:");
            rodada.exibirItens(null);
            System.out.println();

            System.out.println("Letras Erradas:");
            rodada.exibirLetrasErradas(null);
            System.out.println();

            System.out.println("Boneco:");
            rodada.exibirBoneco(null);
            System.out.println();

            System.out.println("[1] Tentar");
            System.out.println("[2] Arriscar");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.println("Informe uma letra: ");
                    char codigo = scanner.next().charAt(0);
                    System.out.println();

                    rodada.tentar(codigo);
                    break;
                case 2:
                    Scanner input = new Scanner(System.in);
                    List<String> palavras = new ArrayList<>(rodada.getNumPalavras());
                    System.out.println("Informe a Palavra: ");
                    palavras.add(input.nextLine());
                    System.out.println();
                    rodada.arriscar(palavras);
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (!rodada.encerrou());

        System.out.println("Resultado Final: " + (rodada.descobriu() ? "venceu" : "perdeu"));

        System.out.println("Total Tentativas: " + rodada.getQtdeTentativas());
        System.out.println("Tentativas Erradas: " + rodada.getQtdeErros());
        System.out.println("Tentativas Certas: " + rodada.getQtdeAcertos());
        System.out.println("Arriscou: " + (rodada.arriscou() ? "sim" : "não"));
        System.out.println("Pontos: " + rodada.calcularPontos());
    }

    private static void inserirTemasEPalavras() {
        Aplicacao.getSoleInstance().getTemaFactory().getTema("bebidas");
        Aplicacao.getSoleInstance().getTemaFactory().getTema("alimentos");
        Aplicacao.getSoleInstance().getTemaFactory().getTema("casa");

        PalavraAppService palavraService = PalavraAppService.getSoleInstance();

        palavraService.novaPalavra("guarana", 1L);
        palavraService.novaPalavra("guaraviton", 1L);
        palavraService.novaPalavra("agua", 1L);

        palavraService.novaPalavra("nhoque", 2L);
        palavraService.novaPalavra("ratatouille", 2L);
        palavraService.novaPalavra("lasanha", 2L);

        palavraService.novaPalavra("cazaquistao", 3L);
        palavraService.novaPalavra("andorra", 3L);
        palavraService.novaPalavra("suriname", 3L);

    }
}