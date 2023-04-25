package br.edu.iff.bancodepalavras.dominio.tema;

public interface TemaFactory {
    // Este método retorna um objeto Tema com base no nome do tema fornecido como parâmetro
    public Tema getTema(String nome);
}
