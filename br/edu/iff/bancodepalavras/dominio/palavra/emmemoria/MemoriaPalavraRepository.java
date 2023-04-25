package br.edu.iff.bancodepalavras.dominio.palavra.emmemoria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.palavra.Palavra;
import br.edu.iff.bancodepalavras.dominio.palavra.PalavraRepository;
import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class MemoriaPalavraRepository implements PalavraRepository {

    // Criação de uma única instância da classe MemoriaPalavraRepository, seguindo o padrão Singleton
    private static MemoriaPalavraRepository soleInstance = null;
    // Lista de palavras em memória
    private List<Palavra> pool;

    // Construtor da classe que inicializa a lista de palavras
    private MemoriaPalavraRepository() {
        this.pool = new ArrayList<Palavra>();
    }

    // Método estático para obter a única instância da classe MemoriaPalavraRepository, seguindo o padrão Singleton
    public static MemoriaPalavraRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaPalavraRepository();
        }
        return soleInstance;
    }

    // Retorna uma palavra com o ID informado, se existir
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

    // Retorna uma lista de palavras associadas a um tema específico
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

    // Retorna todas as palavras na lista, protegendo-a de modificações externas
    @Override
    public List<Palavra> getTodas() {
        return Collections.unmodifiableList(this.pool);
    }

    // Retorna uma palavra com o nome informado, se existir
    @Override
    public Palavra getPalavra(String palavra) {

        for (Palavra palavraList : this.pool) {
            if (palavraList.comparar(palavra)) {
                return palavraList;
            }
        }

        throw new RuntimeException("Não existe a seguinte palavra: " + palavra + "no repositório:");

    }

    // Retorna o próximo ID disponível
    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    // Insere uma nova palavra na lista
    @Override
    public void inserir(Palavra palavra) throws RepositoryException {
        if (this.pool.contains(palavra)) {
            throw new RepositoryException("Já existe a seguinte palavra: " + palavra + "no repositório");
        } else {
            this.pool.add(palavra);
        }
    }

    // Método para atualizar uma palavra no repositório (não implementado)
    @Override
    public void atualizar(Palavra palavra) throws RepositoryException {

    }

    // Método para remover uma palavra do repositório
    @Override
    public void remover(Palavra palavra) throws RepositoryException {
        if (this.pool.contains(palavra)) {
            this.pool.remove(palavra);
        } else {
            throw new RepositoryException("Não existe a seguinte palavra: " + palavra + " nno repositório");
        }
    }

}
