package br.edu.iff.jogoforca.dominio.rodada.embdr;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRRodadaRepository implements RodadaRepository {

    public BDRRodadaRepository(BDRRodadaRepository soleInstance) {
        this.soleInstance = soleInstance;
    }

    private BDRRodadaRepository soleInstance;

    public BDRRodadaRepository getSoleInstance() {
        BDRRodadaRepository sole = this.soleInstance;
        return sole;
    }

    @Override
    public Rodada getPorId(long id) {
        return null;
    }

    @Override
    public Rodada[] getPorJogador(Jogador jogador) {
        return null;
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {

    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {

    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {

    }

}
