package br.edu.iff.jogoforca.dominio.rodada.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaRodadaRepository implements RodadaRepository {

    // Criação de uma única instância da classe MemoriaRodadaRepository, seguindo o padrão Singleton
    private static MemoriaRodadaRepository soleInstance = null;
     // Lista de rodadas em memória
    private List<Rodada> pool;

    // Construtor da classe que inicializa a lista de rodadas
    private MemoriaRodadaRepository() {
        this.pool = new ArrayList<Rodada>();
    }

    // Método estático para obter a única instância da classe MemoriaRodadaRepository, seguindo o padrão Singleton
    public static MemoriaRodadaRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaRodadaRepository();
        }
        return soleInstance;
    }

    // Retorna uma rodada com o ID informado, se existir
    @Override
    public Rodada getPorId(long id) {
        try {
            for (Rodada rodada : this.pool) {
                if (rodada.getId() == id) {
                    return rodada;
                }
            }
        } catch (Exception e) {
            return null;
        }
        return null;
    }

    // Retorna uma lista de rodadas associadas a um jogador específico
    @Override
    public List<Rodada> getPorJogador(Jogador jogador) {
        List<Rodada> rodadaList = new ArrayList<>();
        try {
            for (Rodada rodada : this.pool) {
                if (rodada.getJogador() == jogador) {
                    rodadaList.add(rodada);
                }
            }
            return rodadaList;
        } catch (Exception e) {
            return rodadaList;
        }
    }

    // Retorna o próximo ID disponível
    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    // Insere uma nova rodada na lista
    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
        if (this.pool.contains(rodada)) {
            throw new RepositoryException("Já existe a seguinte rodada: " + rodada + " no repositório");
        } else {
            this.pool.add(rodada);
        }
    }

    // Método para atualizar uma rodada no repositório (não implementado)
    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
    }
    // Método para remover uma rodada do repositório
    @Override
    public void remover(Rodada rodada) throws RepositoryException {
        if (this.pool.contains(rodada)) {
            this.pool.remove(rodada);
        } else {
            throw new RepositoryException("Não existe a seguinte: " + rodada + " no repositório");
        }
    }

}
