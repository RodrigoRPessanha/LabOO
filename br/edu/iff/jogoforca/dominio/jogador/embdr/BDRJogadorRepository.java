package br.edu.iff.jogoforca.dominio.jogador.embdr;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRJogadorRepository implements JogadorRepository {

    public BDRJogadorRepository(BDRJogadorRepository soleInstance) {
        this.soleInstance = soleInstance;
    }

    private BDRJogadorRepository soleInstance;

    public BDRJogadorRepository getSoleInstance() {
        BDRJogadorRepository sole = this.soleInstance;
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
