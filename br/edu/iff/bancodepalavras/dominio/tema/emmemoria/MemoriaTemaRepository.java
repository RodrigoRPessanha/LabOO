package br.edu.iff.bancodepalavras.dominio.tema.emmemoria;

import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.repository.RepositoryException;

public class MemoriaTemaRepository implements TemaRepository {

    // Criação de uma única instância da classe MemoriaTemaRepository, seguindo o padrão Singleton
    private static MemoriaTemaRepository soleInstance = null;
    // Lista de temas em memória
    private List<Tema> pool;

    // Construtor da classe que inicializa a lista de temas
    private MemoriaTemaRepository() {
        this.pool = new ArrayList<Tema>();
    }

    // Método estático para obter a única instância da classe MemoriaTemaRepository, seguindo o padrão Singleton
    public static MemoriaTemaRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaTemaRepository();
        }
        return soleInstance;
    }

    // Retorna um tema com o ID informado, se existir
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

    // Retorna uma lista de temas associadas a um nome específico
    @Override
    public List<Tema> getPorNome(String nome) {
        List<Tema> temaList = new ArrayList<>();
        try {
            for (Tema tema : this.pool) {
                if (tema.getNome().equalsIgnoreCase(nome)) {
                    temaList.add(tema);
                }
            }
            return temaList;
        } catch (Exception e) {
            return temaList;
        }
    }

    // Retorna todas os temas na lista, protegendo-a de modificações externas
    @Override
    public List<Tema> getTodos() {
        return Collections.unmodifiableList(this.pool);
    }

    // Retorna o próximo ID disponível
    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    // Insere uma nova palavra na lista
    @Override
    public void inserir(Tema tema) throws RepositoryException {
        if (this.pool.contains(tema)) {
            throw new RepositoryException("Já existe o seguinte tema: " + tema.getNome() + " no repositório");
        } else {
            this.pool.add(tema);
        }
    }

    // Método para atualizar uma palavra no repositório (não implementado)
    @Override
    public void atualizar(Tema tema) throws RepositoryException {
    }

    // Método para remover uma palavra do repositório
    @Override
    public void remover(Tema tema) throws RepositoryException {
        if (this.pool.contains(tema)) {
            this.pool.remove(tema);
        } else {
            throw new RepositoryException("Não existe o seguinte tema:" + tema.getNome() + " no repositório");
        }
    }

}
