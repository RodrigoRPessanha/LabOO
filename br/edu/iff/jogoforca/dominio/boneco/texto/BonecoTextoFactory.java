package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;

public class BonecoTextoFactory implements BonecoFactory {
    BonecoTextoFactory soleInstance;

    public BonecoTextoFactory(BonecoTextoFactory soleInstance) {
        this.soleInstance = soleInstance;
    }

    public BonecoTextoFactory getSoleInstance() {
        BonecoTextoFactory sole = this.soleInstance;
        return sole;
    }

    @Override
    public Boneco getBoneco() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoneco'");
    }
}
