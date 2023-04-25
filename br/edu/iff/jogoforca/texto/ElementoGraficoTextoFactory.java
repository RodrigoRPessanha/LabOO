package br.edu.iff.jogoforca.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.texto.LetraTextoFactory;
import br.edu.iff.jogoforca.ElementoGraficoFactory;
import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.texto.BonecoTextoFactory;

public class ElementoGraficoTextoFactory implements ElementoGraficoFactory {

    // Instância única da classe, seguindo o padrão Singleton
    private static ElementoGraficoTextoFactory soleInstance = null;

    // Fábrica de bonecos em formato de texto
    private BonecoTextoFactory bonecoTextoFactory;

    // Fábrica de letras em formato de texto
    private LetraTextoFactory letraTextoFactory;

    // Construtor privado, que inicializa as fábricas de bonecos e letras em formato de texto, seguindo o padrão Singleton
    public ElementoGraficoTextoFactory() {
        this.letraTextoFactory = LetraTextoFactory.getSoleInstance();
        this.bonecoTextoFactory = BonecoTextoFactory.getSoleInstance();
    }

    // Método estático que retorna a instância única da classe
    public static ElementoGraficoTextoFactory getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new ElementoGraficoTextoFactory();
        }

        return soleInstance;
    }

    // Retorna um objeto Boneco em formato de texto
    @Override
    public Boneco getBoneco() {
        return this.bonecoTextoFactory.getBoneco();
    }

    // Retorna uma letra específica em formato de texto
    @Override
    public Letra getLetra(char codigo) {
        return this.letraTextoFactory.getLetra(codigo);
    }

    // Retorna uma letra encoberta em formato de texto, para ser utilizada na interface gráfica do jogo
    @Override
    public Letra getLetraEncoberta() {
        return this.letraTextoFactory.getLetraEncoberta();
    }

}
