package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;

public class BonecoTextoFactory implements BonecoFactory {

    // Uma instância única da classe BonecoTextoFactory, seguindo o padrão Singleton
    private static BonecoTextoFactory soleInstance = null;

    // Construtor privado para evitar que outras classes instanciem essa classe diretamente
    private BonecoTextoFactory() {
    }

    // Método estático que retorna a única instância da classe BonecoTextoFactory, seguindo o padrão Singleton
    public static BonecoTextoFactory getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BonecoTextoFactory();
        }
        return soleInstance;
    }

    // Implementação do método abstrato da interface BonecoFactory
    // Retorna a única instância da classe BonecoTexto, obtida através do método estático getSoleInstance()
    @Override
    public Boneco getBoneco() {
        return BonecoTexto.getSoleInstance();
    }
}
