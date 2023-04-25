package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.print.event.PrintEvent;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactory;
import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.dominio.ObjetoDominioImpl;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;
import br.edu.iff.jogoforca.dominio.jogador.Jogador;

public class Rodada extends ObjetoDominioImpl{
    private static int maxPalavras = 1;
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
    
    public Rodada(long id, List<Palavra>palavras, Jogador jogador) {
        super(id);
		this.jogador = jogador;
		this.certas = new HashSet<Letra>();
		this.erradas = new HashSet<Letra>();
		this.itens = new ArrayList<Item>();
		this.palavras = palavras;
        for (int i = 0; i < palavras.size(); i++) {
			this.itens.add(Item.criar(i, palavras.get(i)));
        }
		this.boneco = getBonecoFactory().getBoneco();
		
		if(getBonecoFactory() == null) {
			throw new RuntimeException("Boneco não iniciado");

		}
		
		for(int contador = 0; contador < palavras.size(); contador++) {
			this.itens.add(Item.criar(contador, palavras.get(contador)));
		}
    }

    private Rodada(long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
        super(id);
        this.itens = new ArrayList<Item>();
		for (int i = 0; i < palavras.size(); i++) {
			this.itens.add(Item.criar(i, palavras.get(i)));
        }
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
        if (itens.size() == 0) {
            throw new IllegalStateException("itens tem que conter ao menos um item");
        }
        return itens.get(0).getPalavra().getTema();
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

        Map<Item, Boolean> itensCertos = new HashMap<Item, Boolean>();
		LetraFactory letraFactory = Palavra.getLetraFactory();

		for(Item itemTemp: itens) {
			if(itemTemp.tentar(codigo)) {
				certas.add(letraFactory.getLetra(codigo));
				itensCertos.put(itemTemp, true);
			}else {
				itensCertos.put(itemTemp, false);
			}
		}
		if(!itensCertos.containsValue(true)) {
			erradas.add(letraFactory.getLetra(codigo));
		}
		if(encerrou()) {
			this.jogador.setPontuacao(this.calcularPontos());
		}
    }

    public void arriscar(List<String> palavras) {
        if (this.encerrou()) {
			return;
		}
        itens.get(0).arriscar(palavras.get(0));
		if(this.encerrou()) {
            this.jogador.setPontuacao(this.calcularPontos());
		}
    }
    
    public void exibirItens(Object contexto) {
        for(int i = 0;i < this.itens.size()/2;i++) {
            itens.get(i).exibir(itens.get(i));
            System.out.println();
        }
    }

    public void exibirBoneco(Object object) {
		boneco.exibir(object, getQtdeErros());

	}

	public void exibirPalavras(Object object) {
		for(Palavra palavraTemp: getPalavras()) {
			palavraTemp.exibir(palavraTemp);
			System.out.println();
		}
	}
    
    public void exibirLetrasErradas(Object contexto) {
        for (Letra letra : erradas) {
            letra.exibir(letra);
            System.out.print(" ");
        }
    }

    public Set<Letra> getTentativas() {
		Set<Letra> tentativasTemp = new HashSet<Letra>();
		tentativasTemp.addAll(certas);
		tentativasTemp.addAll(erradas);
		return tentativasTemp;
	}

	public Set<Letra> getCertas() {
		Set<Letra> certasTemp = new HashSet<Letra>();
		certasTemp.addAll(certas);
		return certasTemp;
	}

	public Set<Letra> getErradas() {
		Set<Letra> erradasTemp = new HashSet<Letra>();
		erradasTemp.addAll(erradas);
		return erradasTemp;
	}

	public int calcularPontos() {
		if(!descobriu()) {
			return 0;
		}

		int pontosTemp = getPontosQuandoDescobreTodasAsPalavras();
		for(Item itemTemp: itens) {
			pontosTemp = pontosTemp + itemTemp.calcularPontosLetrasEncobertas(getPontosPorLetraEncoberta());
		}
		return pontosTemp;

	}
    
    public boolean encerrou(){
        if (arriscou() || descobriu() || getQtdeErros() == maxErros) {
            return true;
        }
        return false;
    }

	public boolean descobriu() {
		for (Item i : this.itens) {
			if (i.descobriu()) {
				return true;
			}
		}
		return false;
	}
	
    public boolean arriscou(){
        for(Item i: itens) {
			if(i.arriscou()) {
				return true;
			}
		}
        return false;
    }

	public int getQtdeTentativaRestantes(){
		return maxErros - getQtdeErros();
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