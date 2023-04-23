package br.edu.iff.jogoforca.dominio.boneco.texto;

import br.edu.iff.jogoforca.dominio.boneco.Boneco;

public class BonecoTexto implements Boneco {
    private static BonecoTexto  soleInstance = null;

	public static BonecoTexto getSoleInstance() {
		if (soleInstance == null) {
			soleInstance = new BonecoTexto();
		}
		return soleInstance;
	}
	private BonecoTexto() {
	}

    @Override
    public void exibir(Object contexto, int partes) {
        if (partes == 0) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||");
            System.out.println("||");
        }

        if (partes == 1) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /     \\");
            System.out.println("||  \\     /");

        }

        if (partes == 2) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /°    \\");
            System.out.println("||  \\     /");
        }

        if (partes == 3) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /°   °\\");
            System.out.println("||  \\     /");
        }

        if (partes == 4) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /° > °\\");
            System.out.println("||  \\     /");
        }

        if (partes == 5) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /° > °\\");
            System.out.println("||  \\  o  /");
        }

        if (partes == 6) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /° > °\\");
            System.out.println("||  \\  o  /");
            System.out.println("||     |  ");
            System.out.println("||    | |  ");
            System.out.println("||    | | ");
        }

        if (partes == 7) {

            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /° > °\\");
            System.out.println("||  \\  o  /");
            System.out.println("||     |  ");
            System.out.println("||  __| |  ");
            System.out.println("||    | | ");

        }

        if (partes == 8) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /° > °\\");
            System.out.println("||  \\  o  /");
            System.out.println("||     |  ");
            System.out.println("||  __| |__");
            System.out.println("||    | | ");
        }

        if (partes == 9) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /° > °\\");
            System.out.println("||  \\  o  /");
            System.out.println("||     |  ");
            System.out.println("||  __| |__");
            System.out.println("||    | | ");
            System.out.println("||     |   ");
            System.out.println("||    |   ");
            System.out.println("||   _|   ");
        }

        if (partes == 10) {
            System.out.println("||=====|");
            System.out.println("||     |");
            System.out.println("||  /° > °\\");
            System.out.println("||  \\  o  /");
            System.out.println("||     |  ");
            System.out.println("||  __| |__");
            System.out.println("||    | | ");
            System.out.println("||     |   ");
            System.out.println("||    | | ");
            System.out.println("||   _| |_");
        }
    }
}
