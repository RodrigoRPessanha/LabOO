package br.edu.iff.bancodepalavras.dominio.letra.imagem;

import br.edu.iff.bancodepalavras.dominio.letra.Letra;
import br.edu.iff.bancodepalavras.dominio.letra.LetraFactoryImpl;

public class LetraImagemFactory extends LetraFactoryImpl {

    // Define a única instância da classe LetraImagemFactory, seguindo o padrão Singleton
    private static LetraImagemFactory soleInstance = null;

    // Construtor privado para evitar que outras classes instanciem essa classe diretamente
    private LetraImagemFactory() {
    }

    // Método estático que retorna a única instância da classe LetraImagemFactory, seguindo o padrão Singleton
    public static LetraImagemFactory getSoleInstance() {
        // Verifica se a instância já foi criada
        if (soleInstance == null) {
            soleInstance = new LetraImagemFactory();
        }

        return soleInstance;
    }

    // Implementa o método criarLetra da classe pai (LetraFactoryImpl)
    @Override
    protected Letra criarLetra(char codigo) {
        return null;
    }

}
