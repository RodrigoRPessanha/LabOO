package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class MemoriaTemaRepository implements TemaRepository {

    private static MemoriaTemaRepository soleInstance = null;
    private List<Tema> pool;

    private MemoriaTemaRepository() {
        this.pool = new ArrayList<Tema>();
    }

    public static MemoriaTemaRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaTemaRepository();
        }
        return soleInstance;
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
            return null;
        }
        return null;
    }

    @Override
    public List<Tema> getPorNome(String nome) {
        List<Tema> temaList = new ArrayList<>();
        try {
            for (Tema tema : this.pool) {
                if (tema.getNome().toUpperCase() == nome.toUpperCase()) {
                    temaList.add(tema);
                }
            }
            return temaList;
        } catch (Exception e) {
            return temaList;
        }
    }

    @Override
    public List<Tema> getTodos() {
        return Collections.unmodifiableList(this.pool);
    }

    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    @Override
    public void inserir(Tema tema) throws RepositoryException {
        if (this.pool.contains(tema)) {
            throw new RepositoryException("Já existe o seguinte tema: " + tema.getNome() + " no repositório");
        } else {
            this.pool.add(tema);
        }
    }

    @Override
    public void atualizar(Tema tema) throws RepositoryException {
    }

    @Override
    public void remover(Tema tema) throws RepositoryException {
        if (this.pool.contains(tema)) {
            this.pool.remove(tema);
        } else {
            throw new RepositoryException("Não existe o seguinte tema:" + tema.getNome() + " no repositório");
        }
    }

}
