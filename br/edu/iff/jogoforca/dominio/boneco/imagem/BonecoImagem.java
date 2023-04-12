package br.edu.iff.jogoforca.dominio.boneco.imagem;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoImagem implements Boneco {
    private static BonecoImagem soleInstance = new BonecoImagem();

    private BonecoImagem() {
    }

    public static BonecoImagem getSoleInstance() {
        return soleInstance;
    }

    @Override
    public void exibir(Object contexto, int partes) {
        // Implementação da exibição do boneco como imagem
    }
}
