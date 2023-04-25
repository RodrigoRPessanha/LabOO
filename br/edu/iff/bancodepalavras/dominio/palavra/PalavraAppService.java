package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

public class PalavraAppService {

  private static PalavraAppService soleInstance; // Instância única do serviço
  private final TemaRepository temaRepository; // Repositório de temas
  private final PalavraRepository palavraRepository; // Repositório de palavras
  private final PalavraFactory palavraFactory; // Fábrica de palavras

  // Construtor privado que recebe os três objetos que precisamos para inicializar a instância única do serviço
  private PalavraAppService(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
    this.temaRepository = temaRepository;
    this.palavraRepository = palavraRepository;
    this.palavraFactory = palavraFactory;
  }

  // Retorna a instância única do serviço. Lança uma exceção se o serviço ainda não foi inicializado
  public static PalavraAppService getSoleInstance() {
    if (soleInstance == null) {
      throw new IllegalStateException("PalavraAppService not initialized");
    }
    return soleInstance;
  }

  // Cria a instância única do serviço. Lança uma exceção se o serviço já foi inicializado.
  public static void createSoleInstance(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
    if (soleInstance != null) {
      throw new IllegalStateException("PalavraAppService already initialized");
    }
    soleInstance = new PalavraAppService(temaRepository, palavraRepository, palavraFactory);
  }

  // Adiciona uma nova palavra ao repositório. Retorna true se a inserção foi bem-sucedida e false caso contrário.
  public boolean novaPalavra(String palavra, long idTema) {
    Tema tema = temaRepository.getPorId(idTema);
    if (tema == null) {
      return false;
    }
    Palavra novaPalavra = palavraFactory.getPalavra(palavra, tema);
    try {
      palavraRepository.inserir(novaPalavra);
			return true;
		} catch (Exception e) {
			return false;
		}
  }
  
  // Retorna uma lista de palavras para um determinado tema.
  public List<Palavra> buscarPalavrasPorTema(Tema tema) {
	  return palavraRepository.getPorTema(tema);
	}

  // Retorna uma palavra para um determinado ID.
	public Palavra buscarPalavraPorId(long idPalavra) {
	  return palavraRepository.getPorId(idPalavra);
	}

   // Atualiza uma palavra existente para uma nova palavra.
	public boolean atualizarPalavra(long idPalavra, String novaPalavra) {
	  return true;
	}

  // Remove uma palavra do repositório. Retorna true se a remoção foi bem-sucedida e false caso contrário.
	public boolean removerPalavra(long idPalavra) {
	  Palavra palavra = palavraRepository.getPorId(idPalavra);
	  if (palavra == null) {
	    return false;
	  }
	  try {
			palavraRepository.remover(palavra);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}