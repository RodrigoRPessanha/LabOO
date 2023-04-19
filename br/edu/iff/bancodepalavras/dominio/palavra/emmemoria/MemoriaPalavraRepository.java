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

    public MemoriaPalavraRepository getSoleInstance() {
        if (soleInstance == null) {
            this.soleInstance = soleInstance;
        }
        return this.soleInstance;
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
            throw new RuntimeException("Não existe nenhuma palavra com o id: " + id);
        }
    }

    @Override
    public List<Palavra> getPorTema(Tema tema) {
        try {
            List<Palavra> palavraList = new ArrayList<>();
            for (Palavra palavra : this.pool) {
                if (palavra.getTema() == tema) {
                    palavraList.add(palavra);
                }
            }
            return palavraList;
        } catch (Exception e) {
            throw new RuntimeException("Não existe nenhuma palavra com o Tema: " + tema);
        }
    }

    @Override
    public List<Palavra> getTodas() {
        return Collections.unmodifiableList(this.pool);
    }

    @Override
    public Palavra getPalavra(String palavra) {
        try {
            for (Palavra palavraList : this.pool) {
                if (palavraList.comparar(palavra)) {
                    return palavraList;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Não existe essa" + palavra + "no repositório:");
        }
    }

    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    @Override
    public void inserir(Palavra palavra) throws RepositoryException {
        if (this.pool.contains(palavra)) {
            throw new RepositoryException("Não existe essa" + palavra + "na pool");
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
            System.out.printf("Não existe essa" + palavra + " na pool");
        }
    }

}
