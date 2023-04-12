package br.edu.iff.bancodepalavras.dominio.letra.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

public class LetraImagemFactory extends LetraFactoryImpl {
    LetraImagemFactory soleInstance;

    public LetraImagemFactory() {
    }

    public LetraImagemFactory(LetraImagemFactory soleInstance) {
        this.soleInstance = soleInstance;
    }

    @Override
    protected Letra criarLetra() {
        // TODO Auto-generated method stub
        return super.criarLetra();
    }
}
