package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoTexto implements Boneco {
    private static BonecoTexto soleInstance = new BonecoTexto();

    private BonecoTexto() {
    }

    public static BonecoTexto getSoleInstance() {
        return soleInstance;
    }

    @Override
    public void exibir(Object contexto, int partes) {
        // Implementação da exibição do boneco como texto
    }
}
