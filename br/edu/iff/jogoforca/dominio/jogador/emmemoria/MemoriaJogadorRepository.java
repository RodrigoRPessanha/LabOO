package br.edu.iff.jogoforca.dominio.jogador.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaJogadorRepository implements JogadorRepository {

    // Criação de uma única instância da classe MemoriaJogadorRepository, seguindo o padrão Singleton
    private static MemoriaJogadorRepository soleInstance = null;
    // Lista de jogadores em memória
    private List<Jogador> pool;

    // Construtor da classe que inicializa a lista de jogadores
    private MemoriaJogadorRepository() {
        this.pool = new ArrayList<Jogador>();
    }

    // Método estático para obter a única instância da classe MemoriaJogadorRepository, seguindo o padrão Singleton
    public static MemoriaJogadorRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaJogadorRepository();
        }
        return soleInstance;
    }

    // Retorna um jogador com o ID informado, se existir
    @Override
    public Jogador getPorId(long id) {
        try {
            for (Jogador jogador : this.pool) {
                if (jogador.getId() == id) {
                    return jogador;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    // Retorna uma lista de jogadores associadas a um nome específico
    @Override
    public Jogador getPorNome(String nome) {
        Jogador jogadorReturn = null;
        try {
            for (Jogador jogador : this.pool) {
                if (jogador.getNome().equalsIgnoreCase(nome)) {
                    jogadorReturn = jogador;
                }
            }
            return jogadorReturn;
        } catch (Exception e) {
            return jogadorReturn;
        }
    }

    // Retorna o próximo ID disponível
    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    // Insere um novo jogador na lista
    @Override
    public void inserir(Jogador jogador) throws RepositoryException {
        if (this.pool.contains(jogador)) {
            throw new RepositoryException("Já existe o seguinte jogador: " + jogador.getNome() + " no repositório");
        } else {
            this.pool.add(jogador);
        }
    }

    // Método para atualizar um jogador no repositório (não implementado)
    @Override
    public void atualizar(Jogador jogador) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    // Método para remover um jogador do repositório
    @Override
    public void remover(Jogador jogador) throws RepositoryException {
        if (this.pool.contains(jogador)) {
            this.pool.remove(jogador);
        } else {
            throw new RepositoryException("Não existe o seguinte jogador: " + jogador.getNome() + " no repositório");
        }
    }

}
