//Código escrito em colaboração por Leonardo Izaú e Mariana Fortes.

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class ElementoIndice {
	private String nis;
	private long posicao;
	
	public ElementoIndice() {
		
	}
	public ElementoIndice(String nis, long posicao) {
		this.nis = nis;
		this.posicao = posicao;
	}

	void escreve(DataOutput out) throws IOException {
    	out.writeUTF(this.nis);
    	out.writeLong(this.posicao);
	}
	void le(DataInput in) throws IOException {
		this.nis = in.readUTF();
		this.posicao = in.readLong();
	}
	
	public String getNis(){
		return nis;
	}
	public void setNis(String nis){
		this.nis = nis;
	}
	public long getPosicao(){
		return posicao;
	}
	public void setPosicao(long posicao){
		this.posicao = posicao;
	}
}
