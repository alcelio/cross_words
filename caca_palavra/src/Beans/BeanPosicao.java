package Beans;
/**
 * Classe para guardar o posição de uma celula em uma matriz
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 */
public class BeanPosicao {
	
	private Integer linha;
	
	private Integer coluna;

	/**
	 * @return the linha
	 */
	public Integer getLinha() {
		return linha;
	}

	/**
	 * @param linha the linha to set
	 */
	public void setLinha(Integer linha) {
		this.linha = linha;
	}

	/**
	 * @return the coluna
	 */
	public Integer getColuna() {
		return coluna;
	}

	/**
	 * @param coluna the coluna to set
	 */
	public void setColuna(Integer coluna) {
		this.coluna = coluna;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coluna == null) ? 0 : coluna.hashCode());
		result = prime * result + ((linha == null) ? 0 : linha.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BeanPosicao other = (BeanPosicao) obj;
		if (coluna == null) {
			if (other.coluna != null)
				return false;
		} else if (!coluna.equals(other.coluna))
			return false;
		if (linha == null) {
			if (other.linha != null)
				return false;
		} else if (!linha.equals(other.linha))
			return false;
		return true;
	}

	
	

}
