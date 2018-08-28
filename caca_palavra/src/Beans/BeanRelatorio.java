package Beans;
/**
 * Classe para carregar dados para gerar relatório
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 * 
 *@since 14/04/2017
 */
public class BeanRelatorio {
	
	private String nomeProfessor;
	private String titulo;
	private String nomeEscola;
	private char[][] matriz;
	/**
	 * @return the nomeProfessor
	 */
	public String getNomeProfessor() {
		return nomeProfessor;
	}
	/**
	 * @param nomeProfessor the nomeProfessor to set
	 */
	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the nomeEscola
	 */
	public String getNomeEscola() {
		return nomeEscola;
	}
	/**
	 * @param nomeEscola the nomeEscola to set
	 */
	public void setNomeEscola(String nomeEscola) {
		this.nomeEscola = nomeEscola;
	}
	/**
	 * @return the matriz
	 */
	public char[][] getMatriz() {
		return matriz;
	}
	/**
	 * @param matriz the matriz to set
	 */
	public void setMatriz(char[][] matriz) {
		this.matriz = matriz;
	}
	
	
	

}
