package br.edu.iff.jogoforca.dominio.rodada.embdr;

import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class BDRRodadaRepository implements RodadaRepository {

    private static BDRRodadaRepository soleInstance = null;

    private BDRRodadaRepository() {
    }

    public static BDRRodadaRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BDRRodadaRepository();
        }
        return soleInstance;
    }

    @Override
    public Rodada getPorId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorId'");
    }

    @Override
    public List<Rodada> getPorJogador(Jogador jogador) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorJogador'");
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public long getProximoId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProximoId'");
    }

}
