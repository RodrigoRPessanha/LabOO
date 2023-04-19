package br.edu.iff.jogoforca.dominio.jogador.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.jogador.JogadorRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaJogadorRepository implements JogadorRepository {

    private static MemoriaJogadorRepository soleInstance = null;
    private List<Jogador> pool;

    private MemoriaJogadorRepository() {
        this.pool = new ArrayList<Jogador>();
    }

    public static MemoriaJogadorRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaJogadorRepository();
        }
        return soleInstance;
    }

    @Override
    public Jogador getPorId(long id) {
        for (Jogador jogador : this.pool) {
            if (jogador.getId() == id) {
                return jogador;
            }
        }
        throw new RuntimeException("Não existe nenhuma rodada com o id: " + id);
    }

    @Override
    public List<Jogador> getPorNome(String nome) {
        List<Jogador> jogadorList = new ArrayList<>();
        for (Jogador jogador : this.pool) {
            if (jogador.getNome().equalsIgnoreCase(nome)) {
                jogadorList.add(jogador);
            }
        }
        if (!jogadorList.isEmpty()) {
            return jogadorList;
        } else {
            throw new RuntimeException("Não existe nenhum jogador com o seguinte nome: " + nome);
        }
    }

    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    @Override
    public void inserir(Jogador jogador) throws RepositoryException {
        if (this.pool.contains(jogador)) {
            throw new RepositoryException("Já existe o seguinte jogador: " + jogador.getNome() + " no repositório");
        } else {
            this.pool.add(jogador);
        }
    }

    @Override
    public void atualizar(Jogador jogador) throws RepositoryException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public void remover(Jogador jogador) throws RepositoryException {
        if (this.pool.contains(jogador)) {
            this.pool.remove(jogador);
        } else {
            throw new RepositoryException("Não existe o seguinte jogador: " + jogador.getNome() + " no repositório");
        }
    }

}
