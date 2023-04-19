package br.edu.iff.jogoforca.dominio.rodada.emmemoria;

import java.util.ArrayList;
import java.util.List;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaRodadaRepository implements RodadaRepository {

    private static MemoriaRodadaRepository soleInstance = null;
    private List<Rodada> pool;

    private MemoriaRodadaRepository() {
        this.pool = new ArrayList<Rodada>();
    }

    public static MemoriaRodadaRepository getSoleInstance() {
        if (soleInstance == null) {
            soleInstance = new MemoriaRodadaRepository();
        }
        return soleInstance;
    }

    @Override
    public Rodada getPorId(long id) {
        for (Rodada rodada : this.pool) {
            if (rodada.getId() == id) {
                return rodada;
            }
        }
        throw new RuntimeException("Não existe nenhuma rodada com o id: " + id);
    }

    @Override
    public List<Rodada> getPorJogador(Jogador jogador) {
        List<Rodada> rodadaList = new ArrayList<>();
        for (Rodada rodada : this.pool) {
            if (rodada.getJogador() == jogador) {
                rodadaList.add(rodada);
            }
        }
        if (!rodadaList.isEmpty()) {
            return rodadaList;
        } else {
            throw new RuntimeException("Não existe nenhuma rodada com o seguinte jogador: " + jogador);
        }
    }

    @Override
    public long getProximoId() {
        int novaProxId = pool.size() + 1;
        return novaProxId;
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {
        if (this.pool.contains(rodada)) {
            throw new RepositoryException("Já existe a seguinte rodada: " + rodada + " no repositório");
        } else {
            this.pool.add(rodada);
        }
    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {
    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {
        if (this.pool.contains(rodada)) {
            this.pool.remove(rodada);
        } else {
            throw new RepositoryException("Não existe a seguinte: " + rodada + " no repositório");
        }
    }

}
