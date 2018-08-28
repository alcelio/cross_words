package Util;

public class Globais {
	
	final public static String parametroNumColunas = "totalColunas";
	
	final public static String parametroNomeEscola = "nomeEscola";
	
	final public static String parametroDataImpressao = "dataImpressao";
	
	final public static String parametroNomeProfessor = "nomeProfessor";
	
	final public static String parametroObjetivo = "descricaoObjetivo";
	
	/***
	 * Todas as opções 
	 */
	final public static int OPCOES_DE_ESCRITA = 8;
	
	/**
	 *Guarda o caracter usado para considerar a celula limpa 
	 */
	final public static char LIMPO='.';
	
	/**
	 * Indica que palavra deve ser escrita na horizontal
	 */
	final public static int HORIZONTAL = 1;

	/**
	 * Indica que palavra deve ser escrita na ordem horizontal de traz para frente
	 */
	final public static int HORIZONTAL_INVERTIDA = 2;

	/**
	 * Indica que palavra deve ser escrita na vertical
	 */
	final public static int VERTICAL = 3;
	
	/**
	 * Indica que palavra deve ser escrita na ordem vertical de baixo para cima
	 */
	final public static int VERTICAL_INVERTIDA = 4;
	
	
	/**
	 * Indica que palavra deve ser escrita na diagonal
	 */
	final public static int DIAGONAL = 5;
	
	/**
	 * Indica que palavra deve ser escrita na diagonal mas de traz para frente
	 */
	final public static int DIAGONAL_INVERTIDA = 6;

	/**
	 * Indica que palavra deve ser escrita transversal
	 */
	final public static int TRANSVERSAL = 7;

	/**
	 * Indica que palavra deve ser escrita na transversal mas de traz para frente
	 */
	final public static int TRANSVERSAL_INVERTIDA = 8;
}
