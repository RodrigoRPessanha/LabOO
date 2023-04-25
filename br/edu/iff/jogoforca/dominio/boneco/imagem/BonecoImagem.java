package br.edu.iff.jogoforca.dominio.boneco.imagem;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoImagem implements Boneco {

    // Declarando a instância única da classe BonecoImagem como um atributo privado e estático, seguindo o padrão Singleton
    private static BonecoImagem soleInstance = null;

    // Definindo o construtor da classe BonecoImagem como privado para garantir que seja acessível apenas dentro da própria classe
    private BonecoImagem() {
    }

    // Definindo o método getSoleInstance() que retorna a instância única da classe BonecoImagem, seguindo o padrão Singleton
    public static BonecoImagem getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BonecoImagem();
        }
        return soleInstance;
    }

    // Implementando o método exibir() definido na interface Boneco
    @Override
    public void exibir(Object contexto, int partes) {

    }
}
