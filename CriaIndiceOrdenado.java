//Código escrito em conjunto por Leonardo Izaú (@Vladek96) e Mariana Fortes (@MarianaFortes)

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class CriaIndiceOrdenado {
	public static void main(String[] args) throws Exception
	{
		String linha = "";
		String colunas[];
        long posicao;				
		RandomAccessFile f = new RandomAccessFile("bolsa.csv", "rw");
		RandomAccessFile fi = new RandomAccessFile("bolsa_ordenado.ind", "rw");
		ArrayList<ElementoIndice> a = new ArrayList<ElementoIndice>(14000000);
        linha = f.readLine();
        while(f.getFilePointer() < f.length())
        {
            posicao = f.getFilePointer();
            linha = f.readLine();
            colunas = linha.split("\t");
            ElementoIndice e = new ElementoIndice(colunas[7], posicao);
			a.add(e);
        }
		System.out.println("Lido = OK");
		Collections.sort(a, new ComparaIndice());
		System.out.println("Ordenado = OK");
        for(ElementoIndice e2: a)
		{
			e2.escreve(fi);
		}
		System.out.println("Escrito = OK");
		f.close();
	}
}
