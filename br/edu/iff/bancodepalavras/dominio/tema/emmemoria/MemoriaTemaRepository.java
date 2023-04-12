package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class MemoriaTemaRepository implements TemaRepository {

    public MemoriaTemaRepository(MemoriaTemaRepository soleInstance) {
        this.soleInstance = soleInstance;
    }

    private MemoriaTemaRepository soleInstance;

    public MemoriaTemaRepository getSoleInstance() {
        MemoriaTemaRepository sole = this.soleInstance;
        return sole;
    }

    @Override
    public Tema getPorId(long id) {
        return null;
    }

    @Override
    public Tema[] getPorNome(Tema tema) {
        return null;
    }

    @Override
    public Tema[] getTodos() {
        return null;
    }

    @Override
    public void inserir(Tema tema) throws RepositoryException {
    }

    @Override
    public void atualizar(Tema tema) throws RepositoryException {
    }

    @Override
    public void remover(Tema tema) throws RepositoryException {
    }

}
