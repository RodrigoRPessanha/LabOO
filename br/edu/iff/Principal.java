package br.edu.iff;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraAppService;
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

        // Obtém a instância única da classe Aplicacao
        Aplicacao aplicacao = Aplicacao.getSoleInstance();

        // Configura a aplicação
        aplicacao.configurar();

        // Insere temas e palavras no jogo
        inserirTemasEPalavras();

        // Cria um scanner para ler entrada do usuário
        Scanner tecladoInput = new Scanner(System.in);

        // Pede ao usuário que informe seu nome
        System.out.println("Informe seu nome: ");
        String nomeJogador = tecladoInput.nextLine();
        System.out.println();

        // Obtém um jogador com o nome informado ou cria um novo jogador
        Jogador jogador = Aplicacao.getSoleInstance().getJogadorFactory().getJogador(nomeJogador);

        // Cria um repositório de memória do jogador e depois remove a duplicidade do jogador
        MemoriaJogadorRepository memoriaJogadorRepository = MemoriaJogadorRepository.getSoleInstance();
        memoriaJogadorRepository.remover(jogador);

        // Cria uma nova rodada com o jogador
        Rodada rodada = RodadaAppService.getSoleInstance().novaRodada(jogador);

         // Loop para executar a rodada enquanto ela não tiver terminado
        do {
            // Exibe o tema da rodada
            System.out.println("Tema: " + rodada.getTema().getNome());
            System.out.println();

            // Exibe as palavras da rodada
            System.out.println("Palavras:");
            rodada.exibirItens(null);
            System.out.println();

            // Exibe as letras erradas da rodada
            System.out.println("Letras Erradas:");
            rodada.exibirLetrasErradas(null);
            System.out.println();

            // Exibe o boneco da forca da rodada
            System.out.println("Boneco:");
            rodada.exibirBoneco(null);
            System.out.println();

            // Exibe as opções para o usuário escolher
            System.out.println("[1] Tentar");
            System.out.println("[2] Arriscar");

            // Lê a opção escolhida pelo usuário
            int option = tecladoInput.nextInt();

            // Executa a ação correspondente à opção escolhida
            switch (option) {
                case 1:
                    // Pede ao usuário que informe uma letra
                    System.out.println("Informe uma letra: ");
                    char codigo = tecladoInput.next().charAt(0);
                    System.out.println();

                    // Executa uma tentativa com a letra informada
                    rodada.tentar(codigo);
                    break;
                case 2:
                    // Pede ao usuário que informe uma palavra
                    Scanner input = new Scanner(System.in);
                    List<String> palavras = new ArrayList<>(rodada.getNumPalavras());
                    System.out.println("Informe a Palavra: ");
                    palavras.add(input.nextLine());
                    System.out.println();

                    // Executa um palpite com a palavra informada
                    rodada.arriscar(palavras);
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        } while (!rodada.encerrou());

        // Exibindo o resultado final do jogo
        System.out.println("Resultado Final: " + (rodada.descobriu() ? "venceu" : "perdeu"));

        // Exibindo o total de tentativas feitas pelo jogador
        System.out.println("Total Tentativas: " + rodada.getQtdeTentativas());

        // Exibindo o número de tentativas erradas feitas pelo jogador
        System.out.println("Tentativas Erradas: " + rodada.getQtdeErros());

        // Exibindo o número de tentativas certas feitas pelo jogador
        System.out.println("Tentativas Certas: " + rodada.getQtdeAcertos());

        // Exibindo se o jogador arriscou alguma palavra durante a rodada
        System.out.println("Arriscou: " + (rodada.arriscou() ? "sim" : "não"));

        // Exibindo a pontuação final do jogador na rodada
        System.out.println("Pontos: " + rodada.calcularPontos());
    }

    // Definindo método para inserir temas e palavras no jogo
    private static void inserirTemasEPalavras() {

        // Obtendo a única instância da aplicação e criando os temas
        Aplicacao.getSoleInstance().getTemaFactory().getTema("bebidas");
        Aplicacao.getSoleInstance().getTemaFactory().getTema("alimentos");
        Aplicacao.getSoleInstance().getTemaFactory().getTema("pais");
        Aplicacao.getSoleInstance().getTemaFactory().getTema("criptomoeda");

        // Criando as palavras relacionadas aos temas
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

        palavraService.novaPalavra("dogecoin", 4L);
        palavraService.novaPalavra("bitcoin", 4L);
        palavraService.novaPalavra("ethereum", 4L);

    }
}