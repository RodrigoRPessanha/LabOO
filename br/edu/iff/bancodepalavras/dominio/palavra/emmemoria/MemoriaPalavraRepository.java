package br.edu.iff.bancodepalavras.dominio.palavra.emmemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class MemoriaPalavraRepository implements PalavraRepository {

    private static MemoriaPalavraRepository soleInstance = null;
    private List<Palavra> pool;

    private MemoriaPalavraRepository() {
        this.pool = new ArrayList<Palavra>();
    }

    public static MemoriaPalavraRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaPalavraRepository();
        }
        return soleInstance;
    }

    @Override
    public Palavra getPorId(long id) {
        try {
            for (Palavra palavra : this.pool) {
                if (palavra.getId() == id) {
                    return palavra;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    @Override
    public List<Palavra> getPorTema(Tema tema) {
        List<Palavra> palavraList = new ArrayList<>();
        try {
            for (Palavra palavra : this.pool) {
                if (palavra.getTema() == tema) {
                    palavraList.add(palavra);
                }
            }
            return palavraList;
        } catch (Exception e) {
            return palavraList;
        }

    }

    @Override
    public List<Palavra> getTodas() {
        return Collections.unmodifiableList(this.pool);
    }

    @Override
    public Palavra getPalavra(String palavra) {

        for (Palavra palavraList : this.pool) {
            if (palavraList.comparar(palavra)) {
                return palavraList;
            }
        }

        throw new RuntimeException("Não existe a seguinte palavra: " + palavra + "no repositório:");

    }

    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    @Override
    public void inserir(Palavra palavra) throws RepositoryException {
        if (this.pool.contains(palavra)) {
            throw new RepositoryException("Já existe a seguinte palavra: " + palavra + "no repositório");
        } else {
            this.pool.add(palavra);
        }
    }

    @Override
    public void atualizar(Palavra palavra) throws RepositoryException {

    }

    @Override
    public void remover(Palavra palavra) throws RepositoryException {
        if (this.pool.contains(palavra)) {
            this.pool.remove(palavra);
        } else {
            throw new RepositoryException("Não existe a seguinte palavra: " + palavra + " nno repositório");
        }
    }

}
