package br.edu.iff.jogoforca.dominio.rodada;

import java.util.ArrayList;
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
    private List<Item> itens;
    private Jogador jogador;
    

    private Rodada(long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
        super(id);
    }

    public Rodada(long id, List<Palavra>palavras, Jogador jogador) {
        super(id);
    }

    public static Rodada reconstituir(long id, List<Item> itens, List<Letra> erradas, Jogador jogador) {
        Rodada rodada = new Rodada(id, itens, erradas, jogador);
        return rodada;
    }
    
    public static Rodada criar(long id, List<Palavra> palavras, Jogador jogador) {
        Rodada rodada = new Rodada(id, palavras, jogador);
        return rodada;
    }
    
    public void exibirItens(Object contexto) {
        for(Item itemTemp : itens) {
            itemTemp.exibir(contexto);
            System.out.println();
        }
    }
}
  
    