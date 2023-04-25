package br.edu.iff.bancodepalavras.dominio.palavra;

import java.util.List;

import br.edu.iff.bancodepalavras.dominio.tema.Tema;
import br.edu.iff.bancodepalavras.dominio.tema.TemaRepository;

public class PalavraAppService {

  private static PalavraAppService soleInstance;
  private final TemaRepository temaRepository;
  private final PalavraRepository palavraRepository;
  private final PalavraFactory palavraFactory;

  private PalavraAppService(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
    this.temaRepository = temaRepository;
    this.palavraRepository = palavraRepository;
    this.palavraFactory = palavraFactory;
  }

  public static PalavraAppService getSoleInstance() {
    if (soleInstance == null) {
      throw new IllegalStateException("PalavraAppService not initialized");
    }
    return soleInstance;
  }

  public static void createSoleInstance(TemaRepository temaRepository, PalavraRepository palavraRepository, PalavraFactory palavraFactory) {
    if (soleInstance != null) {
      throw new IllegalStateException("PalavraAppService already initialized");
    }
    soleInstance = new PalavraAppService(temaRepository, palavraRepository, palavraFactory);
  }

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
  
  public List<Palavra> buscarPalavrasPorTema(Tema tema) {
	  return palavraRepository.getPorTema(tema);
	}

	public Palavra buscarPalavraPorId(long idPalavra) {
	  return palavraRepository.getPorId(idPalavra);
	}

	public boolean atualizarPalavra(long idPalavra, String novaPalavra) {
	  return true;
	}

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
