package br.edu.iff.jogoforca.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class ElementoGraficoImagemFactory implements ElementoGraficoFactory {

    // Instância única da classe, seguindo o padrão Singleton
    private static ElementoGraficoImagemFactory soleInstance = null;

    // Método estático que retorna a instância única da classe
    public static ElementoGraficoImagemFactory getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new ElementoGraficoImagemFactory();
        }
        return soleInstance;
    }

    // Construtor privado, seguindo o padrão Singleton
    private ElementoGraficoImagemFactory() {
    }

    // Retorna um objeto Boneco
    @Override
    public Boneco getBoneco() {
        return null;
    }

    // Retorna uma letra específica
    @Override
    public Letra getLetra(char codigo) {
        return null;
    }

    // Retorna uma letra encoberta, para ser utilizada na interface gráfica do jogo
    @Override
    public Letra getLetraEncoberta() {
        return null;
    }

}
