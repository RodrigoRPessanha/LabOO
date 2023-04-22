package br.edu.iff.jogoforca.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class ElementoGraficoImagemFactory implements br.edu.iff.jogoforca.ElementoGraficoFactory {

    private static ElementoGraficoImagemFactory soleInstance = null;

    public static ElementoGraficoImagemFactory getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new ElementoGraficoImagemFactory();
        }

        return soleInstance;
    }

    private ElementoGraficoImagemFactory() {

    }

    @Override
    public Boneco getBoneco() {
        return null;

    }

    @Override
    public Letra getLetra(char codigo) {
        return null;

    }

    @Override
    public Letra getLetraEncoberta() {
        return null;

    }

}
