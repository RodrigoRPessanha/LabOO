package br.edu.iff.bancodepalavras.dominio.letra;

public interface LetraFactory {

    // Método que recebe o código da letra como parâmetro e retorna uma instância da classe Letra correspondente
    public Letra getLetra(char codigo);

    // Método que retorna uma instância da classe LetraEncoberta, que representa uma letra não revelada em um jogo de palavras
    public Letra getLetraEncoberta();
}
