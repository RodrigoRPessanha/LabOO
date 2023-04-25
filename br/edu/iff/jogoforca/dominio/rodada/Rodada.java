package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public class Rodada extends ObjetoDominioImpl{
    private static int maxPalavras = 3;
    private static int maxErros = 10;
    private static int pontosQuandoDescobreTodasAsPalavras = 100;
    private static int pontosPorLetraEncoberta = 15;
    private static BonecoFactory bonecoFactory;
    private List<Item> itens;
    private Set<Letra> certas;
    private Set<Letra> erradas;
    private List<Palavra> palavras;
    private Jogador jogador;
    private Tema tema;
    private Boneco boneco;
    
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
		this.jogador = jogador;
		this.certas = new HashSet<Letra>();
		this.erradas = new HashSet<Letra>();
		this.itens = new ArrayList<Item>(palavras.size());
		this.boneco = getBonecoFactory().getBoneco();
		
		if(getBonecoFactory() == null) {
			throw new RuntimeException("Boneco não iniciado");

		}
		
		for(int contador = 0; contador < palavras.size(); contador++) {
			this.itens.add(Item.criar(contador, palavras.get(contador)));
		}
    }

    private Rodada(long id, List<Item> itens, List<Letra> erradas, Jogador jogador) { //Tem que terminar
        super(id);
        this.itens = new ArrayList<Item>(itens.size());
		this.erradas = new HashSet<Letra>();
        this.jogador = jogador;
		this.certas = new HashSet<Letra>();
		this.boneco = getBonecoFactory().getBoneco();
        
        if(getBonecoFactory() == null) {
			throw new RuntimeException("Boneco não iniciado");
		}

		for(int contador = 0; contador < itens.size(); contador++) {
			Item itemTemp = itens.get(contador);
			this.itens.add(itemTemp);

			for(Letra corretaTemp: itemTemp.getLetrasDescobertas()) {
				this.certas.add(corretaTemp);
			}
		}

		for(Letra erradaTemp: erradas ) {
			this.erradas.add(erradaTemp);
		}
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

    /*  + calcularPontos() : int
        + getErradas() : Letra[]
        + getCertas() : Letra[]
        + getTentativas() : Letra[]
        + exibirLetrasErradas(contexto : Object) : void
        + exibirPalavras(contexto : Object) : void
        + exibirBoneco(contexto : Object) : void
    */

    public boolean encerrou(){
        if (arriscou() || descobriu() || getQtdeErros() == maxErros) {
            return true;
        }
        return false;
    }

	public boolean descobriu() {
		for (Item i : this.itens) {
			if (!i.descobriu()) {
				return false;
			}
		}
		return true;
	}
	
    public boolean arriscou(){
        for(Item i: itens) {
			if(!i.arriscou()) {
				return false;
			}
		}
        return true;
    }

	public int getQtdeTentativaRestantes(){
		return getMaxErros() - erradas.size();
	}

	public int getQtdeErros() {
		return erradas.size();
	}

	public int getQtdeAcertos() {
		return certas.size();
	}

	public int getQtdeTentativas() {
		return getQtdeErros() + getQtdeAcertos();
	}
}