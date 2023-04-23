package br.edu.iff.bancodepalavras.dominio.tema.embdr;

import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class BDRTemaRepository implements TemaRepository {
    private static BDRTemaRepository soleInstance = null;

    private BDRTemaRepository() {
    }

    public static BDRTemaRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BDRTemaRepository();
        }
        return soleInstance;
    }

    @Override
    public Tema getPorId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorNome'");
    }

    @Override
    public List<Tema> getTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorNome'");
    }

    @Override
    public void inserir(Tema tema) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorNome'");
    }

    @Override
    public void atualizar(Tema tema) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorNome'");
    }

    @Override
    public void remover(Tema tema) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorNome'");
    }

    @Override
    public List<Tema> getPorNome(String nome) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorNome'");
    }

    @Override
    public long getProximoId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProximoId'");
    }
}
