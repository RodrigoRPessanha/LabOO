package br.edu.iff.jogoforca.embdr;

import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;
import br.edu.iff.jogoforca.RepositoryFactory;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;

public class BDRRepositoryFactory implements RepositoryFactory {
    // Define a única instância da classe BDRRepositoryFactory, seguindo o padrão Singleton
    private static BDRRepositoryFactory soleInstance = null;

    // Construtor privado para evitar que outras classes instanciem essa classe diretamente
    private BDRRepositoryFactory() {
    }

    // Método estático que retorna a única instância da classe BDRRepositoryFactory, seguindo o padrão Singleton
    public static BDRRepositoryFactory getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BDRRepositoryFactory();
        }
        return soleInstance;
    }

    @Override
    public PalavraRepository getPalavraRepository() {
        return null;
    }

    @Override
    public TemaRepository getTemaRepository() {
        return null;
    }

    @Override
    public RodadaRepository getRodadaRepository() {
        return null;
    }

    @Override
    public JogadorRepository getJogadorRepository() {
        return null;
    }

}
