package br.edu.iff.bancodepalavras.dominio.palavra.embdr;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class BDRPalavraRepository implements PalavraRepository {

    private static BDRPalavraRepository soleInstance = null;

    private BDRPalavraRepository() {
    }

    public static BDRPalavraRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new BDRPalavraRepository();
        }
        return soleInstance;
    }

    @Override
    public Palavra getPorId(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorId'");
    }

    @Override
    public List<Palavra> getPorTema(Tema tema) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPorTema'");
    }

    @Override
    public List<Palavra> getTodas() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTodas'");
    }

    @Override
    public Palavra getPalavra(String palavra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPalavra'");
    }

    @Override
    public void inserir(Palavra palavra) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inserir'");
    }

    @Override
    public void atualizar(Palavra palavra) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void remover(Palavra palavra) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'remover'");
    }

    @Override
    public long getProximoId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProximoId'");
    }

}
