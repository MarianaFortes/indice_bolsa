//Código escrito em conjunto por Leonardo Izaú (@Vladek96) e Mariana Fortes (@MarianaFortes)

import java.io.*;

public class BuscaIndiceOrdenado {
	public static void main (String[] args) throws Exception
	{	
		int i = 0, k, comp;
		long pos, inicio, fim, meio, tamIndice;
		String linha, colunas[];
		RandomAccessFile ft =  new RandomAccessFile("teste.ind", "rw");
		ElementoIndice et = new ElementoIndice("00013143523645", 1415);
		et.escreve(ft);
		tamIndice = ft.getFilePointer(); //para descobrir o tamanho em bytes do ElementoIndice
		ft.close();
		File x = new File("teste.ind");
		x.delete();
		if(args.length != 1)
		{
			System.err.println("Erro na chamada do comando.\n");
			System.err.println("Uso: java BuscaIndiceOrdenado [NIS_BUSCA]");
			System.exit(1);
		}
		ElementoIndice e1 = new ElementoIndice();
		e1.setNis(args[0]); 
		ft = new RandomAccessFile("bolsa.csv", "r");
		RandomAccessFile fi = new RandomAccessFile("bolsa_ordenado.ind", "r");
		pos = fi.length();
		inicio = 0;
		fim = (pos/tamIndice)-1;
		while(inicio <= fim)
		{
			i++;
			meio = (inicio + fim) / 2;
			fi.seek(meio * tamIndice);
			ElementoIndice e2 = new ElementoIndice();
			e2.le(fi);
			ComparaIndice c = new ComparaIndice();
			comp = c.compare(e1, e2);
			if(comp == 0) {
				ft.seek(e2.getPosicao());
				linha = ft.readLine();
				colunas = linha.split("\t");
				for(k = 0; k < colunas.length; k++) {
					System.out.println(colunas[k]);
				}
				break;
			}
			else {
				if (comp > 0)
					inicio = meio + 1;
				else
					fim = meio - 1;
			}
		}
		System.out.println("\nTotal de enderecos lidos: " +i);
		ft.close();
		fi.close();	
	}
}
