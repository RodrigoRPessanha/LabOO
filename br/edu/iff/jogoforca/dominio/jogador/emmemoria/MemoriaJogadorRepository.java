package br.edu.iff.jogoforca.dominio.jogador.emmemoria;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaJogadorRepository implements JogadorRepository {

    public MemoriaJogadorRepository(MemoriaJogadorRepository soleInstance) {
        this.soleInstance = soleInstance;
    }

    private MemoriaJogadorRepository soleInstance;

    public MemoriaJogadorRepository getSoleInstance() {
        MemoriaJogadorRepository sole = this.soleInstance;
        return sole;
    }

    @Override
    public Jogador getPorId(long id) {
        return null;
    }

    @Override
    public Jogador[] getPorJogador(String nome) {
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

}
