package br.edu.iff.jogoforca.dominio.jogador.embdr;

import java.util.Collections;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRJogadorRepository implements JogadorRepository {
    // Define a única instância da classe BDRTemaRepository, seguindo o padrão Singleton
    private static BDRJogadorRepository soleInstance = null;

    // Construtor privado para evitar que outras classes instanciem essa classe diretamente
    private BDRJogadorRepository() {
    }

    // Método estático que retorna a única instância da classe BDRTemaRepository, seguindo o padrão Singleton
    public static BDRJogadorRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BDRJogadorRepository();
        }
        return soleInstance;
    }

    @Override
    public Jogador getPorId(long id) {
        return null;
    }

    @Override
    public Jogador getPorNome(String nome) {
        return null;
    }

    @Override
    public void inserir(Jogador jogador) throws RepositoryException {
    }

    @Override
    public void atualizar(Jogador jogador) throws RepositoryException {
    }

    @Override
    public void remover(Jogador jogador) throws RepositoryException {
    }

    @Override
    public long getProximoId() {
        return (Long) null;
    }

}
