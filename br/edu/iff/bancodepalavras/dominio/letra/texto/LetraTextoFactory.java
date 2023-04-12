package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

public class LetraTextoFactory extends LetraFactoryImpl {
    LetraTextoFactory soleInstance;

    public LetraTextoFactory() {
    }

    public LetraTextoFactory(LetraTextoFactory soleInstance) {
        this.soleInstance = soleInstance;
    }

    @Override
    protected Letra criarLetra() {
        // TODO Auto-generated method stub
        return super.criarLetra();
    }
}
