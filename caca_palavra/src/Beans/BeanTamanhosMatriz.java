package Beans;
/**
 * Classse que serve para carregar os tamanhos de uma matriz 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *@since 08/04/2017
 */
public class BeanTamanhosMatriz {
	
	private int linha;
	
	private int colunas;
	

	 public BeanTamanhosMatriz(char[][] matriz){
		this.linha = matriz.length;
		this.colunas = matriz[0].length;
	}

	/**
	 * @return the linha
	 */
	public int getLinha() {
		return linha;
	}

	/**
	 * @param linha the linha to set
	 */
	public void setLinha(int linha) {
		this.linha = linha;
	}

	/**
	 * @return the colunas
	 */
	public int getColunas() {
		return colunas;
	}

	/**
	 * @param colunas the colunas to set
	 */
	public void setColunas(int colunas) {
		this.colunas = colunas;
	}
	
	

}
