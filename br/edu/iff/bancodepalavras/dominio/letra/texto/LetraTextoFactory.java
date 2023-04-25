package br.edu.iff.bancodepalavras.dominio.letra.texto;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

public class LetraTextoFactory extends LetraFactoryImpl {
    
    // Define a única instância da classe LetraImagemFactory, seguindo o padrão Singleton
    private static LetraTextoFactory soleInstance = null;

    // Construtor privado para evitar que outras classes instanciem essa classe diretamente
    private LetraTextoFactory() {
    }

    // Método estático que retorna a única instância da classe LetraImagemFactory, seguindo o padrão Singleton
    public static LetraTextoFactory getSoleInstance() {
        // Verifica se a instância já foi criada
        if (soleInstance == null) {
            soleInstance = new LetraTextoFactory();
        }

        return soleInstance;
    }

    // Implementa o método criarLetra da classe pai (LetraFactoryImpl)
    @Override
    protected Letra criarLetra(char codigo) {
        return new LetraTexto(codigo);
    }
}
