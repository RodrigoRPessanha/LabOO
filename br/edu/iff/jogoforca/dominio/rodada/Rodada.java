package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public class Rodada extends ObjetoDominioImpl {
    private static int maxPalavras = 1; // O máximo de palavras a serem descobertas em uma rodada
    private static int maxErros = 10; // O máximo de erros permitidos em uma rodada
    private static int pontosQuandoDescobreTodasAsPalavras = 100; // Pontuação atribuída quando todas as palavras são descobertas
    private static int pontosPorLetraEncoberta = 15; // Pontuação atribuída por cada letra ainda não descoberta
    private static BonecoFactory bonecoFactory; // Factory responsável por criar instâncias de Boneco
    private List<Item> itens; // Itens da rodada (Palavra ou Letra)
    private Set<Letra> certas; // Conjunto de Letras corretamente descobertas
    private Set<Letra> erradas; // Conjunto de Letras incorretamente descobertas
    private List<Palavra> palavras; // Palavras a serem descobertas na rodada
    private Jogador jogador; // Jogador que está jogando a rodada
    private Tema tema; // Tema da rodada
    private Boneco boneco; // Instância de Boneco que representa a forca

    // Obtém o máximo de palavras que podem ser descobertas em uma rodada
    public static int getMaxPalavras() {
        return maxPalavras;
    }

    // Define o máximo de palavras que podem ser descobertas em uma rodada
    public static void setMaxPalavras(int maxPalavras) {
        Rodada.maxPalavras = maxPalavras;
    }

    // Obtém o máximo de erros permitidos em uma rodada
    public static int getMaxErros() {
        return maxErros;
    }

    // Define o máximo de erros permitidos em uma rodada
    public static void setMaxErros(int maxErros) {
        Rodada.maxErros = maxErros;
    }

    // Obtém a pontuação atribuída quando todas as palavras são descobertas
    public static int getPontosQuandoDescobreTodasAsPalavras() {
        return pontosQuandoDescobreTodasAsPalavras;
    }

    // Define a pontuação atribuída quando todas as palavras são descobertas
    public static void setPontosQuandoDescobreTodasAsPalavras(int pontosQuandoDescobreTodasAsPalavras) {
        Rodada.pontosQuandoDescobreTodasAsPalavras = pontosQuandoDescobreTodasAsPalavras;
    }

    // Obtém a pontuação atribuída por cada letra ainda não descoberta
    public static int getPontosPorLetraEncoberta() {
        return pontosPorLetraEncoberta;
    }

    // Define a pontuação atribuída por cada letra ainda não descoberta
    public static void setPontosPorLetraEncoberta(int pontosPorLetraEncoberta) {
        Rodada.pontosPorLetraEncoberta = pontosPorLetraEncoberta;
    }

    // Define o valor da pontuação por letra encoberta
    public static void setBonecoFactory(BonecoFactory bonecoFactory) {
        Rodada.bonecoFactory = bonecoFactory;
    }

    // Define a fábrica de objetos Boneco
    public static BonecoFactory getBonecoFactory() {
        return bonecoFactory;
    }

    // Cria uma nova instância de Rodada com o id, lista de palavras e jogador
    // especificados
    public static Rodada criar(long id, List<Palavra> palavras, Jogador jogador) {
        Rodada rodada = new Rodada(id, palavras, jogador);
        return rodada;
    }

    // Reconstitui uma instância de Rodada a partir do id, lista de itens, lista de
    // letras erradas e jogador especificados
    public static Rodada reconstituir(long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
        Rodada rodada = new Rodada(id, itens, erradas, jogador);
        return rodada;
    }

    // Construtor da classe Rodada
    public Rodada(long id, List<Palavra> palavras, Jogador jogador) {
        super(id);
        this.jogador = jogador;
        this.certas = new HashSet<Letra>();
        this.erradas = new HashSet<Letra>();
        this.itens = new ArrayList<Item>();
        this.palavras = palavras;
        // Para cada palavra na lista de palavras, cria um novo Item e adiciona à lista
        // de itens
        for (int i = 0; i < palavras.size(); i++) {
            this.itens.add(Item.criar(i, palavras.get(i)));
        }
        this.boneco = getBonecoFactory().getBoneco();
        // Se a fábrica de bonecos não foi iniciada, lança uma exceção
        if (getBonecoFactory() == null) {
            throw new RuntimeException("Boneco não iniciado");
        }
    }

    // Construtor da classe Rodada
    private Rodada(long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
        super(id);
        // Inicializa a lista de itens vazia.
        this.itens = new ArrayList<Item>();
        // Popula a lista de itens com base nas palavras da rodada.
        for (int i = 0; i < palavras.size(); i++) {
            this.itens.add(Item.criar(i, palavras.get(i)));
        }
        // Inicializa as listas de letras corretas e erradas vazias.
        this.erradas = new HashSet<Letra>();
        this.jogador = jogador;
        this.certas = new HashSet<Letra>();
        // Obtém o boneco da fábrica de bonecos.
        this.boneco = getBonecoFactory().getBoneco();
        // Verifica se a fábrica de bonecos foi iniciada corretamente.
        if (getBonecoFactory() == null) {
            throw new RuntimeException("Boneco não iniciado");
        }
        // Adiciona os itens e as letras corretas de cada item à lista de itens e à
        // lista de letras corretas da rodada.
        for (int contador = 0; contador < itens.size(); contador++) {
            Item itemTemp = itens.get(contador);
            this.itens.add(itemTemp);
            for (Letra corretaTemp : itemTemp.getLetrasDescobertas()) {
                this.certas.add(corretaTemp);
            }
        }
        // Adiciona as letras erradas à lista de letras erradas da rodada.
        for (Letra erradaTemp : erradas) {
            this.erradas.add(erradaTemp);
        }
    }

    // Retorna o jogador responsável pela rodada
    public Jogador getJogador() {
        return this.jogador;
    }

    // Retorna o tema da primeira palavra contida nos itens da rodada
    public Tema getTema() {
        if (itens.size() == 0) {
            throw new IllegalStateException("itens tem que conter ao menos um item");
        }
        return itens.get(0).getPalavra().getTema();
    }

    // Retorna a lista de palavras da rodada
    public List<Palavra> getPalavras() {
        return palavras;
    }

    // Retorna o número de palavras da rodada
    public int getNumPalavras() {
        return palavras.size();
    }

    // Tenta descobrir uma letra nas palavras da rodada
    public void tentar(char codigo) {
        // Se a rodada já encerrou, retorna sem fazer nada
        if (encerrou()) {
            return;
        }
        Map<Item, Boolean> itensCertos = new HashMap<Item, Boolean>();
        LetraFactory letraFactory = Palavra.getLetraFactory();

        // Percorre todos os itens da rodada
        for (Item itemTemp : itens) {
            // Tenta descobrir a letra no item atual
            if (itemTemp.tentar(codigo)) {
                // Adiciona a letra correta ao conjunto de letras 
                certas.add(letraFactory.getLetra(codigo));
                // Marca o item atual como tendo sido corretamente preenchido
                itensCertos.put(itemTemp, true);
            } else {
                // Marca o item atual como tendo sido preenchido de forma incorreta
                itensCertos.put(itemTemp, false);
            }
        }
        // Se nenhum item foi preenchido corretamente, adiciona a letra errada ao conjunto de letras erradas
        if (!itensCertos.containsValue(true)) {
            erradas.add(letraFactory.getLetra(codigo));
        }
        // Se a rodada encerrou após a tentativa, calcula a pontuação do jogador
        if (encerrou()) {
            this.jogador.setPontuacao(this.calcularPontos());
        }
    }

    // Método para arriscar uma lista de palavras
    public void arriscar(List<String> palavras) {
        if (this.encerrou()) {
            return;
        }
        itens.get(0).arriscar(palavras.get(0));
        if (this.encerrou()) {
            this.jogador.setPontuacao(this.calcularPontos());
        }
    }

    // Método para exibir os itens da rodada
    public void exibirItens(Object contexto) {
        for (int i = 0; i < this.itens.size() / 2; i++) {
            itens.get(i).exibir(itens.get(i));
            System.out.print(" ");
        }
    }

    // Método para exibir o boneco da forca
    public void exibirBoneco(Object object) {
        boneco.exibir(object, getQtdeErros());

    }

    // Método para exibir as palavras da rodada
    public void exibirPalavras(Object object) {
        for (Palavra palavraTemp : getPalavras()) {
            palavraTemp.exibir(palavraTemp);
            System.out.print(" ");
        }
    }

    // Método para exibir as letras erradas já tentadas pelo jogador
    public void exibirLetrasErradas(Object contexto) {
        for (Letra letra : erradas) {
            letra.exibir(letra);
            System.out.print(" ");
        }
    }

    // Retorna um conjunto de todas as letras tentadas pelo jogador
    public Set<Letra> getTentativas() {
        Set<Letra> tentativasTemp = new HashSet<Letra>();
        tentativasTemp.addAll(certas);
        tentativasTemp.addAll(erradas);
        return tentativasTemp;
    }

    // Retorna um conjunto de todas as letras corretas tentadas pelo jogador
    public Set<Letra> getCertas() {
        Set<Letra> certasTemp = new HashSet<Letra>();
        certasTemp.addAll(certas);
        return certasTemp;
    }

    // Retorna um conjunto de todas as letras erradas tentadas pelo jogador
    public Set<Letra> getErradas() {
        Set<Letra> erradasTemp = new HashSet<Letra>();
        erradasTemp.addAll(erradas);
        return erradasTemp;
    }

    // Calcula a pontuação do jogador ao final da partida
    public int calcularPontos() {
        if (!descobriu()) {
            return 0;
        }

        int pontosTemp = getPontosQuandoDescobreTodasAsPalavras();
        for (Item itemTemp : itens) {
            pontosTemp = pontosTemp + itemTemp.calcularPontosLetrasEncobertas(getPontosPorLetraEncoberta());
        }
        return pontosTemp;

    }

    // Método para verificar se o jogo encerrou
    public boolean encerrou() {
        // Se arriscou, descobriu todas as palavras ou atingiu o número máximo de erros, o jogo encerrou
        if (arriscou() || descobriu() || getQtdeErros() == maxErros) {
            return true;
        }
        return false;
    }

    // Método para verificar se todas as palavras foram descobertas
    public boolean descobriu() {
        // Percorre todos os itens
        for (Item i : this.itens) {
             // Se o item foi descoberto, retorna true
            if (i.descobriu()) {
                return true;
            }
        }
        // Caso contrário, retorna false
        return false;
    }

    // Método para verificar se o jogador já arriscou alguma palavra
    public boolean arriscou() {
         // Percorre todos os itens
        for (Item i : itens) {
            // Se o item foi arriscado, retorna true
            if (i.arriscou()) {
                return true;
            }
        }
        // Caso contrário, retorna false
        return false;
    }

    // Método para obter a quantidade de tentativas restantes
    public int getQtdeTentativaRestantes() {
        return maxErros - getQtdeErros();
    }

    // Método para obter a quantidade de erros cometidos
    public int getQtdeErros() {
        return erradas.size();
    }

    // Método para obter a quantidade de acertos
    public int getQtdeAcertos() {
        return certas.size();
    }

    // Método para obter a quantidade de tentativas (certas e erradas)
    public int getQtdeTentativas() {
        return getQtdeErros() + getQtdeAcertos();
    }
}