package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class MemoriaTemaRepository implements TemaRepository {

    private static MemoriaTemaRepository soleInstance = null;
    private List<Tema> pool;

    private MemoriaTemaRepository() {
        this.pool = new ArrayList<Tema>();
    }

    public MemoriaTemaRepository getSoleInstance() {
        if (soleInstance == null) {
            this.soleInstance = soleInstance;
        }
        return this.soleInstance;
    }

    @Override
    public Tema getPorId(long id) {
        try {
            for (Tema tema : this.pool) {
                if (tema.getId() == id) {
                    return tema;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Não existe nenhuma palavra com o id: " + id);
        }
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
