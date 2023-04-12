package br.edu.iff.jogoforca.dominio.rodada.emmemoria;

import br.edu.iff.jogoforca.dominio.jogador.Jogador;
import br.edu.iff.jogoforca.dominio.rodada.Rodada;
import br.edu.iff.jogoforca.dominio.rodada.RodadaRepository;
import br.edu.iff.repository.RepositoryException;

public class MemoriaRodadaRepository implements RodadaRepository {

    public MemoriaRodadaRepository(MemoriaRodadaRepository soleInstance) {
        this.soleInstance = soleInstance;
    }

    private MemoriaRodadaRepository soleInstance;

    public MemoriaRodadaRepository getSoleInstance() {
        MemoriaRodadaRepository sole = this.soleInstance;
        return sole;
    }

    @Override
    public Rodada getPorId(long id) {
        return null;
    }

    @Override
    public Rodada[] getPorJogador(Jogador jogador) {
        return null;
    }

    @Override
    public void inserir(Rodada rodada) throws RepositoryException {

    }

    @Override
    public void atualizar(Rodada rodada) throws RepositoryException {

    }

    @Override
    public void remover(Rodada rodada) throws RepositoryException {

    }

}
