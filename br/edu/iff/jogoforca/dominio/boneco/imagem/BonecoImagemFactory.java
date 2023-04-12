package br.edu.iff.jogoforca.dominio.boneco.imagem;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;
import br.edu.iff.jogoforca.dominio.boneco.BonecoFactory;

public class BonecoImagemFactory implements BonecoFactory {
    BonecoImagemFactory soleInstance;

    public BonecoImagemFactory(BonecoImagemFactory soleInstance) {
        this.soleInstance = soleInstance;
    }

    public BonecoImagemFactory getSoleInstance() {
        BonecoImagemFactory sole = this.soleInstance;
        return sole;
    }

    @Override
    public Boneco getBoneco() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getBoneco'");
    }

}
