package br.edu.iff.factory;

import br.edu.iff.repository.Repository;

public abstract class EntityFactory {
    public EntityFactory(Repository repository) {
        this.repository = repository;
    }

    private Repository repository;

    protected Repository getRepository() {
        return repository;
    }

    protected long getProximoId() {
        return repository.getProximoId();
    }
}
