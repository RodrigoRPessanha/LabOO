package br.edu.iff.jogoforca.dominio.rodada;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public class Rodada extends br.edu.iff.dominio.ObjetoDominioImpl{
    private static int maxPalavras = 3;
    private static int maxErros = 10;
    private static int pontosQuandoDescobreTodasAsPalavras = 100;
    private static int pontosPorLetraEncoberta = 15;
    private static BonecoFactory bonecoFactory;
    private List<Item> itens;
    private List<Letra> erradas;
    private List<Palavra> palavras;
    private Jogador jogador;
    private Boneco boneco;
    private Tema tema;
    
    public static int getMaxPalavras() {
        return maxPalavras;
    }
    
    public static void setMaxPalavras(int maxPalavras) {
        Rodada.maxPalavras = maxPalavras;
    }
    
    public static int getMaxErros() {
        return maxErros;
    }
    
    public static void setMaxErros(int maxErros) {
        Rodada.maxErros = maxErros;
    }
    
    public static int getPontosQuandoDescobreTodasAsPalavras() {
        return pontosQuandoDescobreTodasAsPalavras;
    }
    
    public static void setPontosQuandoDescobreTodasAsPalavras(int pontosQuandoDescobreTodasAsPalavras) {
        Rodada.pontosQuandoDescobreTodasAsPalavras = pontosQuandoDescobreTodasAsPalavras;
    }
    
    public static int getPontosPorLetraEncoberta() {
        return pontosPorLetraEncoberta;
    }
    
    public static void setPontosPorLetraEncoberta(int pontosPorLetraEncoberta) {
        Rodada.pontosPorLetraEncoberta = pontosPorLetraEncoberta;
    }
    
    public static void setBonecoFactory(BonecoFactory bonecoFactory) {
        Rodada.bonecoFactory = bonecoFactory;
    }

    public static BonecoFactory getBonecoFactory() {
        return bonecoFactory;
    }

    public static Rodada criar(long id, List<Palavra> palavras, Jogador jogador) {
        Rodada rodada = new Rodada(id, palavras, jogador);
        return rodada;
    }
    
    public static Rodada reconstituir(long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
        Rodada rodada = new Rodada(id, itens, erradas, jogador);
        return rodada;
    }
    
    public Rodada(long id, List<Palavra>palavras, Jogador jogador) { //Tem que terminar
        super(id);
        this.palavras = palavras;
        this.jogador = jogador;
    }

    private Rodada(long id, List<Item> itens, List<Letra> erradas, Jogador jogador) { //Tem que terminar
        super(id);
        this.itens = itens;
        this.erradas = erradas;
        this.jogador = jogador;
    }

    public Jogador getJogador() {
        return this.jogador;
    }

    public Tema getTema() {
        return tema;
    }

    public List<Palavra> getPalavras() {
        return palavras;
    }

    public int getNumPalavras() {
        return palavras.size();
    }

    public void tentar(char codigo) { //Tem que terminar
        if (encerrou()) {
            return;
        }
    }

    public void arriscar(List<String> codigo) {
        if (encerrou()) {
			return;
		}
		
    }
    
    public void exibirItens(Object contexto) {
        for(Item itemTemp : itens) {
            itemTemp.exibir(contexto);
            System.out.println();
        }
    }

    public boolean encerrou(){
        if (arriscou() || descobriu() || qtdeErros() == maxErros) {
            return true;
        }
        return false;
    }

	public boolean descobriu() {
		for (Palavra p : this.palavras) {
			if (!p.estaDescoberta()) {
				return false;
			}
		}
		return true;
	}
	
}