package model;

import static Util.Globais.DIAGONAL;
import static Util.Globais.DIAGONAL_INVERTIDA;
import static Util.Globais.HORIZONTAL;
import static Util.Globais.HORIZONTAL_INVERTIDA;
import static Util.Globais.OPCOES_DE_ESCRITA;
import static Util.Globais.TRANSVERSAL;
import static Util.Globais.TRANSVERSAL_INVERTIDA;
import static Util.Globais.VERTICAL;
import static Util.Globais.VERTICAL_INVERTIDA;
import static Util.IntegerUtil.ZERO;
import static java.lang.Integer.MAX_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Beans.BeanDadosMatriz;
import Beans.BeanPosicao;
import Beans.BeanTamanhosMatriz;
import Exception.MatrizException;
import Logger.ALogger;

public class Operacoes {

	private final char limpo = '.';

	private static char[][] matriz;

	private static ALogger log = ALogger.getLogger(Operacoes.class);

	private List<String> palavrasNaoEscritas = new ArrayList<>();

	private List<Integer> listaOpcoesRecebidas = new ArrayList<>();

	private List<String> palavrasEscritas = new ArrayList<>();
	
	
	public List<BeanDadosMatriz> formataParaImpressao(char[][] matriz) throws Exception{
		
		log.debug("Iniciando processo de forma��o para a impress�o.");
		
		List<BeanDadosMatriz> listaDados = new ArrayList<>();
		
		BeanTamanhosMatriz tamanho = new BeanTamanhosMatriz(matriz);
		char[][] mtz = new char[tamanho.getLinha()][tamanho.getColunas()];
		
		
		for (int linha = 0; linha < tamanho.getLinha(); linha++) {
			for (int coluna = 0; coluna < tamanho.getColunas(); coluna++) {
				mtz[linha][coluna] = matriz[linha][coluna];
			}
		}
		
		

		for (int coluna = 0; coluna < tamanho.getColunas(); coluna++ ) {
			int cont = 0;
			BeanDadosMatriz bean  = new BeanDadosMatriz();
				if(tamanho.getLinha() > cont){
					bean.setField_1(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_2(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_3(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_4(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_5(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_6(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_7(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_8(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_9(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_10(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_11(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_12(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_13(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_14(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_15(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_16(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_17(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_18(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_19(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_20(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_21(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_22(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_23(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_24(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_25(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_26(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_27(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_28(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_29(String.valueOf(mtz[coluna][cont++]));
				}
				if(tamanho.getLinha() > cont){
					bean.setField_30(String.valueOf(mtz[coluna][cont++]));
				}
				listaDados.add(bean);
		}
		
		log.debug("Processo de forma��o de matriz para a impress�o realizado com sucesso.");
		
		return listaDados;
	}

	/**
	 * Recebe uma matriz e preenche os espçaos vazios com caracteres.
	 * 
	 * @param matriz
	 * @return
	 */
	public char[][] completaMatriz(char[][] matriz) {
		BeanTamanhosMatriz tamanho = new BeanTamanhosMatriz(matriz);
		char[][] mtz = new char[tamanho.getLinha()][tamanho.getColunas()];

		for (int i = 0; i < mtz.length; i++) {
			for (int j = 0; j < mtz[0].length; j++) {
				mtz[i][j] = matriz[i][j];
			}
		}

		Random random = new Random();

		for (int i = 0; i < mtz.length; i++) {
			for (int j = 0; j < mtz[0].length; j++) {
				if (mtz[i][j] == limpo) {
					mtz[i][j] = (char) (random.nextInt(25) + 65);
				}
			}
		}
		return mtz;
	}

	/**
	 * Recebe uma matriz gabarito e substitui os pontos marcados com "limpo" por
	 * espaço em branco
	 * 
	 * @param matriz
	 * @return
	 */
	public char[][] geraGabaritoLimpo(char[][] matriz) {
		BeanTamanhosMatriz tamanho = new BeanTamanhosMatriz(matriz);
		char[][] mtz = new char[tamanho.getLinha()][tamanho.getColunas()];

		for (int i = 0; i < mtz.length; i++) {
			for (int j = 0; j < mtz[0].length; j++) {
				mtz[i][j] = matriz[i][j];
			}
		}

		for (int i = 0; i < mtz.length; i++) {
			for (int j = 0; j < mtz[0].length; j++) {
				if (mtz[i][j] == limpo) {
					mtz[i][j] = ' ';
				}
			}
		}
		return mtz;
	}

	/**
	 * Cria uma matriz de char com os tamanhos indicados nos parametros
	 * 
	 * @param qtLinha
	 * @param qtColuna
	 * @return
	 * @throws Exception
	 */
	public char[][] criaMatriz(int qtLinha, int qtColuna) throws Exception {
		log.info("Inciando criação de matriz.");

		char[][] mtz = new char[qtLinha][qtColuna];

		for (int i = 0; i < qtLinha; i++) {
			for (int j = 0; j < qtColuna; j++) {
				mtz[i][j] = limpo;
			}
		}
		log.info("Matriz criada com sucesso.");
		return mtz;
	}

	/**
	 * Execura uma ordem de imprimir uma palavra na matriz, numa posicao
	 * indicada no paramentro "pos".Tenta escrever em todos os sentidos a
	 * palavra . Se nao conseguir retorana false, se conseguir retorna true.
	 * 
	 * @param pos
	 * @param palavra
	 * @return
	 * @throws MatrizException
	 */
	private boolean escreveNaPosicao(BeanPosicao pos, String palavra) throws MatrizException {
		boolean isEscreveu = false;
		List<Integer> listaOpcoes = new ArrayList<>();

		// Carrega a lista de opçoes oginal recebida
		for (Integer i : getListaOpcoesRecebidas()) {
			listaOpcoes.add(i);
		}

		log.info("Solicitando escrita aleatória para posição  [" + pos.getLinha() + "," + pos.getColuna()
				+ "] - palavra :[" + palavra + "]");

		try {

			while (!isEscreveu || (listaOpcoes.isEmpty())) {
				Integer opcao = sorteiaOpcaoDeEscrita(listaOpcoes);

				switch (opcao) {
				case DIAGONAL:
					isEscreveu = escreveDiagonal(pos, palavra);
					listaOpcoes.remove((Integer) DIAGONAL);
					break;
				case DIAGONAL_INVERTIDA:
					isEscreveu = escreveDiagonalInvertida(pos, palavra);
					listaOpcoes.remove((Integer) DIAGONAL_INVERTIDA);
					break;
				case VERTICAL:
					isEscreveu = escreveVertical(pos, palavra);
					listaOpcoes.remove((Integer) VERTICAL);
					break;
				case VERTICAL_INVERTIDA:
					isEscreveu = escreveVerticalInvertida(pos, palavra);
					listaOpcoes.remove((Integer) VERTICAL_INVERTIDA);
					break;
				case HORIZONTAL:
					isEscreveu = escreveHorizontal(pos, palavra);
					listaOpcoes.remove((Integer) HORIZONTAL);
					break;
				case HORIZONTAL_INVERTIDA:
					isEscreveu = escreveHorozintalInvertida(pos, palavra);
					listaOpcoes.remove((Integer) HORIZONTAL_INVERTIDA);
					break;
				case TRANSVERSAL:
					isEscreveu = escreveTransversal(pos, palavra);
					listaOpcoes.remove((Integer) TRANSVERSAL);
					break;
				case TRANSVERSAL_INVERTIDA:
					isEscreveu = escreveTransversalInvertida(pos, palavra);
					listaOpcoes.remove((Integer) TRANSVERSAL_INVERTIDA);
					break;

				case 0:
					log.debug("Retornou opçao zero.");
					return isEscreveu;
				}

			}

		} catch (Exception e) {
			log.error("Erro solicitar escrita aleatória na matriz", e);
			throw new MatrizException("Não foi possivel escrever a palavra: [" + palavra + "]");
		}

		return isEscreveu;
	}

	/**
	 * Incializa o processo de escrita de uma palavra na matriz, testa as formas
	 * de escritas em todas as posições possiveis
	 * 
	 * @param m
	 * @param palavra
	 * @param opcoesEscrita
	 * @return
	 * @throws MatrizException
	 */
	public char[][] escreveNaMatriz(char[][] m, String palavra, List<Integer> opcoesEscrita) throws MatrizException {
		// TODO Estudar forma de avisar quando plavra não cabe ou não houve
		// espaço para a mesma

		matriz = m;

		setListaOpcoesRecebidas(opcoesEscrita);

		log.debug("Inciando processo de escrita...");

		List<BeanPosicao> listaPosicoesTestadas = new ArrayList<BeanPosicao>();

		BeanTamanhosMatriz tamanhosMatriz = new BeanTamanhosMatriz(matriz);

		Integer limiteSorteio = new Integer(MAX_VALUE);
		if (tamanhosMatriz != null) {
			limiteSorteio = tamanhosMatriz.getColunas() * tamanhosMatriz.getLinha();
		}

		BeanPosicao posicao;

		boolean isEscreveu = false;

		while (!isEscreveu && (listaPosicoesTestadas.size() <= limiteSorteio)) {
			// sorteia posicao
			posicao = sorteiaPosicao(listaPosicoesTestadas, tamanhosMatriz.getLinha(), tamanhosMatriz.getColunas());
			listaPosicoesTestadas.add(posicao);
			// solicita a escrita
			try {
				isEscreveu = escreveNaPosicao(posicao, palavra);
			} catch (MatrizException e) {
				log.error("Erro ao solicitar escrita da palavra [" + palavra + "] na matriz.", e);
				throw new MatrizException("Erro ao processar escrita na matriz");
			}

		}

		if (!isEscreveu) {
			getPalavrasNaoEscritas().add(palavra);
			System.out.println("************ ERRROOOO ********");
			System.out.println("NÃO ESCREVEU: " + palavra);
			System.out.println("************ ERRROOOO ********");

		}

		log.info("Processo de esctira finalizado...");
		return matriz;
	}

	/**
	 * Método responsável por escrever uma palavra na direção vertical a partir
	 * da posicao solicitada no parametro posicao . Retorna true se conseguir
	 * escrever e false quando não consegue
	 * 
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean escreveVertical(BeanPosicao posicao, String palavra) throws Exception {
		boolean isEscreveu = false;
		boolean isPodeEscrever = false;

		log.info("Iniciando ESCRITA VERTICAL...");
		log.info(
				"Escrevendo na  [" + posicao.getLinha() + "," + posicao.getColuna() + "] - palavra :[" + palavra + "]");

		boolean isTemEspaco = false;
		isTemEspaco = vereficaEspacoVertical(matriz, posicao.getLinha(), palavra);

		if (isTemEspaco) {
			isPodeEscrever = isSobrescritaLiberada(matriz, posicao, palavra);
		}

		if (isTemEspaco && isPodeEscrever) {
			executaEscritaVertical(posicao, palavra);
			isEscreveu = true;
			getPalavrasEscritas().add(palavra);
		}

		log.info("Concluida a escrita na VERTICAL");
		return isEscreveu;
	}

	/**
	 * Método responsável por escrever uma palavra na direção vertical invertida
	 * a partir da posicao solicitada no parametro posicao . Retorna true se
	 * conseguir escrever e false quando não consegue
	 * 
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean escreveVerticalInvertida(BeanPosicao posicao, String palavra) throws Exception {
		boolean isEscreveu = false;
		boolean isPodeEscrever = false;

		log.info("Iniciando escrita VERTICAL_INVERTIDA...");
		log.info(
				"Escrevendo na  [" + posicao.getLinha() + "," + posicao.getColuna() + "] - palavra :[" + palavra + "]");

		boolean isTemEspaco = false;
		isTemEspaco = vereficaEspacoVerticalInvertida(matriz, posicao.getLinha(), palavra);

		if (isTemEspaco) {
			isPodeEscrever = testaSobrescritaVerticalInvertida(matriz, posicao, palavra);
		}

		if (isTemEspaco && isPodeEscrever) {
			executaEscritaVerticalInvertida(posicao, palavra);
			isEscreveu = true;
			getPalavrasEscritas().add(palavra);
		}

		log.info("Concluida a escrita na VERTICAL_INVERTIDA");
		return isEscreveu;
	}

	/**
	 * Método responsável por escrever uma palavra na direção horizontal a
	 * partir da posicao solicitada no parametro posicao . Retorna true se
	 * conseguir escrever e false quando não consegue
	 * 
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean escreveHorizontal(BeanPosicao posicao, String palavra) throws Exception {
		boolean isEscreveu = false;
		boolean isPodeEscrever = false;

		log.info("Iniciando escrita HORIZONTAL...");
		log.info(
				"Escrevendo na  [" + posicao.getLinha() + "," + posicao.getColuna() + "] - palavra :[" + palavra + "]");

		boolean isTemEspaco = false;
		isTemEspaco = vereficaEspacoHorizontal(matriz, posicao.getColuna(), palavra);

		if (isTemEspaco) {
			isPodeEscrever = testaSobrescritaHorizontal(matriz, posicao, palavra);
		}

		if (isTemEspaco && isPodeEscrever) {
			executaEscritaHorizontal(posicao, palavra);
			isEscreveu = true;
			getPalavrasEscritas().add(palavra);
		}

		log.info("Concluida a escrita na HORIZONTAL");
		return isEscreveu;
	}

	/**
	 * Método responsável por escrever uma palavra na direção horizontal
	 * invertida a partir da posicao solicitada no parametro posicao . Retorna
	 * true se conseguir escrever e false quando não consegue
	 * 
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean escreveHorozintalInvertida(BeanPosicao posicao, String palavra) throws Exception {
		boolean isEscreveu = false;
		boolean isPodeEscrever = false;

		log.info("Iniciando escrita HORIZONTAL_INVERTIDA...");
		log.info(
				"Escrevendo na  [" + posicao.getLinha() + "," + posicao.getColuna() + "] - palavra :[" + palavra + "]");

		boolean isTemEspaco = false;
		isTemEspaco = vereficaEspacoHorizontalInvertida(matriz, posicao.getColuna(), palavra);

		if (isTemEspaco) {
			isPodeEscrever = testaSobrescritaHorizontalInvertida(matriz, posicao, palavra);
		}

		if (isTemEspaco && isPodeEscrever) {
			executaEscritaHorizontalInvertida(posicao, palavra);
			isEscreveu = true;
			getPalavrasEscritas().add(palavra);
		}

		log.info("Concluida a escrita na HORIZONTAL_INVERTIDA");
		return isEscreveu;
	}

	/**
	 * Método responsável por escrever uma palavra na direção diagonal a partir
	 * da posicao solicitada no parametro posicao . Retorna true se conseguir
	 * escrever e false quando não consegue
	 * 
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean escreveDiagonal(BeanPosicao posicao, String palavra) throws Exception {
		boolean isEscreveu = false;
		boolean isPodeEscrever = false;

		log.info("Iniciando escrita DIAGONAL...");
		log.info("Escrevendo na posição: [" + posicao.getLinha() + "," + posicao.getColuna() + "] - palavra :["
				+ palavra + "]");

		boolean isTemEspaco = false;
		isTemEspaco = vereficaEspacoDiagonal(posicao, palavra);

		if (isTemEspaco) {
			isPodeEscrever = testaSobrescritaDiagonal(matriz, posicao, palavra);
		}

		if (isTemEspaco && isPodeEscrever) {
			executaEscritaDiagonal(posicao, palavra);
			isEscreveu = true;
			getPalavrasEscritas().add(palavra);
		}

		log.info("Concluida a escrita na DIAGONAL");
		return isEscreveu;
	}

	/**
	 * Método responsável por escrever uma palavra na direção diagonal invertida
	 * a partir da posicao solicitada no parametro posicao . Retorna true se
	 * conseguir escrever e false quando não consegue
	 * 
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean escreveDiagonalInvertida(BeanPosicao posicao, String palavra) throws Exception {
		boolean isEscreveu = false;
		boolean isPodeEscrever = false;

		log.info("Iniciando escrita DIAGONAL...");
		log.info("Escrevendo na posição: [" + posicao.getLinha() + "," + posicao.getColuna() + "] - palavra :["
				+ palavra + "]");

		boolean isTemEspaco = false;
		isTemEspaco = vereficaEspacoDiagonalInvertida(posicao, palavra);

		if (isTemEspaco) {
			isPodeEscrever = testaSobrescritaDiagonalInvertida(matriz, posicao, palavra);
		}

		if (isTemEspaco && isPodeEscrever) {
			executaEscritaDiagonalInvertida(posicao, palavra);
			isEscreveu = true;
			getPalavrasEscritas().add(palavra);
		}

		log.info("Concluida a escrita na DIAGONAL");
		return isEscreveu;
	}

	/**
	 * Método responsável por escrever uma palavra na direção transversal a
	 * partir da posicao solicitada no parametro posicao . Retorna true se
	 * conseguir escrever e false quando não consegue
	 * 
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean escreveTransversal(BeanPosicao posicao, String palavra) throws Exception {
		boolean isEscreveu = false;
		boolean isPodeEscrever = false;

		log.info("Iniciando TRANSVERSAL...");
		log.info("Escrevendo na posição [" + posicao.getLinha() + "," + posicao.getColuna() + "] - palavra :[" + palavra
				+ "]");

		boolean isTemEspaco = false;
		isTemEspaco = vereficaEspacoTransversal(posicao, palavra);

		if (isTemEspaco) {
			isPodeEscrever = testaSobrescritaTransversal(matriz, posicao, palavra);
		}

		if (isTemEspaco && isPodeEscrever) {
			executaEscritaTransversal(posicao, palavra);
			isEscreveu = true;
			getPalavrasEscritas().add(palavra);
		}

		log.info("Concluida a escrita na TRANSVERSAL");
		return isEscreveu;
	}

	/**
	 * Método responsável por escrever uma palavra na direção transversal
	 * invertida a partir da posicao solicitada no parametro posicao . Retorna
	 * true se conseguir escrever e false quando não consegue
	 * 
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean escreveTransversalInvertida(BeanPosicao posicao, String palavra) throws Exception {
		boolean isEscreveu = false;
		boolean isPodeEscrever = false;

		log.info("Iniciando TRANSVERSAL INVERTIDA...");
		log.info("Escrevendo na posição [" + posicao.getLinha() + "," + posicao.getColuna() + "] - palavra :[" + palavra
				+ "]");

		boolean isTemEspaco = false;
		isTemEspaco = vereficaEspacoTransversalInvertida(posicao, palavra);

		if (isTemEspaco) {
			isPodeEscrever = testaSobrescritaTransversalInvertida(matriz, posicao, palavra);
		}

		if (isTemEspaco && isPodeEscrever) {
			executaEscritaTransversalInvertida(posicao, palavra);
			isEscreveu = true;

		}

		log.info("Concluida a escrita na TRANSVERSAL INVERTIDA");
		return isEscreveu;
	}

	/**
	 * Método que efetua o sorteio de um Integer entre os valores informados no
	 * parametro e retorna este valor.
	 * 
	 * @param liberados
	 * @return
	 */
	private Integer sorteiaOpcaoDeEscrita(List<Integer> liberados) {
		Random r = new Random();
		Integer sorteado = new Integer(0);
		log.info("Inicando função de sorteio.");

		if (!liberados.isEmpty()) {
			while (!liberados.contains(sorteado)) {
				sorteado = (Integer) r.nextInt(OPCOES_DE_ESCRITA) + 1;
			}
		}
		log.info("Sorteada opção de escrita: [" + sorteado + "]");
		return sorteado;

	}

	/**
	 * Métido que sorteio uma nova posição e retorna a mesma.
	 * 
	 * 
	 * @param posicoesTestadas
	 * @param tamLinha
	 * @param tamColula
	 * @return
	 */
	private BeanPosicao sorteiaPosicao(List<BeanPosicao> posicoesTestadas, int tamLinha, int tamColula) {
		Random r = new Random();
		boolean isUtilizada = false;

		BeanPosicao posicaoSorteda = new BeanPosicao();

		while (!isUtilizada) {
			posicaoSorteda.setColuna((Integer) r.nextInt(tamColula));
			posicaoSorteda.setLinha((Integer) r.nextInt(tamLinha));

			// Testa se a posição ja consta na lista de utilizadas
			if (posicoesTestadas != null && posicoesTestadas.size() == 0) {
				isUtilizada = true;

			} else {

				for (BeanPosicao beanPosicao : posicoesTestadas) {
					if (beanPosicao.getColuna().equals(posicaoSorteda.getColuna())
							&& beanPosicao.getLinha().equals(posicaoSorteda.getLinha())) {
						isUtilizada = false;
						break;
					}
				}
			}

			isUtilizada = true;

		}

		return posicaoSorteda;

	}

	/**
	 * Executa a imressão na matriz no console
	 * 
	 * @param matriz
	 */
	public void imprimeMatriz(char[][] matriz) {

		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[0].length; j++) {
				System.out.print("   " + matriz[i][j]);
			}
			System.out.println("\n");
		}
	}
	/**
	 * Método que executa a escrita na matriz na direção vertical
	 * 
	 * @param posicao
	 * @param palavra
	 * @throws MatrizException
	 */
	private void executaEscritaVertical(BeanPosicao posicao, String palavra) throws MatrizException {
		char[] palavraEscrever = palavra.toCharArray();
		int count = 0;

		log.info("Escrevendo a palavra[" + palavra + "] na coluna: [" + posicao.getColuna() + "]");
		try {
			for (int i = posicao.getLinha(); i < palavra.length() + posicao.getLinha(); i++) {
				log.debug("Escrevendo a letra[" + palavraEscrever[count] + "] na linha: [" + i + "]");
				matriz[i][posicao.getColuna()] = palavraEscrever[count];
				count++;
			}

		} catch (Exception e) {
			log.error("Erro durante execução de escrita na vertical.", e);
			throw new MatrizException("Erro durante execução de escrita na vertical");

		}
	}

	/**
	 * Método que executa a escrita na matriz na direção horizontal
	 * 
	 * @param posicao
	 * @param palavra
	 * @throws MatrizException
	 */
	private void executaEscritaHorizontal(BeanPosicao posicao, String palavra) throws MatrizException {
		char[] palavraEscrever = palavra.toCharArray();
		int count = 0;

		log.info("Escrevendo a palavra[" + palavra + "] na linha: [" + posicao.getLinha() + "]");
		try {
			for (int i = posicao.getColuna(); i < palavra.length() + posicao.getColuna(); i++) {
				log.debug("Escrevendo a letra[" + palavraEscrever[count] + "] na coluna: [" + i + "]");
				matriz[posicao.getLinha()][i] = palavraEscrever[count];
				count++;
			}

		} catch (Exception e) {
			log.error("Erro durante execução de escrita na horizontal", e);
			throw new MatrizException("Erro durante execução de escrita na horizontal");

		}
	}

	/**
	 * Método que executa a escrita na matriz na direção Diagonal
	 * 
	 * @param posicao
	 * @param palavra
	 * @throws MatrizException
	 */
	private void executaEscritaDiagonal(BeanPosicao posicao, String palavra) throws MatrizException {
		char[] palavraEscrever = palavra.toCharArray();
		int count = 0;

		log.info("Escrevendo a palavra[" + palavra + "] na posição: [" + posicao.getLinha() + "," + posicao.getColuna()
				+ "]");
		try {

			for (int i = 0; i < palavra.length(); i++) {
				log.debug("Escrevendo a letra[" + palavraEscrever[count] + "] na posição: [" + (posicao.getLinha() + i)
						+ "," + (posicao.getColuna() + i) + "]");
				matriz[posicao.getLinha() + i][posicao.getColuna() + i] = palavraEscrever[count];
				count++;
			}

		} catch (Exception e) {
			log.error("Erro durante execução de escrita na diagonal", e);
			throw new MatrizException("Erro durante execução de escrita na diagonal");

		}
	}

	/**
	 * Método que executa a escrita na matriz na direção transversal
	 * 
	 * @param posicao
	 * @param palavra
	 * @throws MatrizException
	 */
	private void executaEscritaTransversal(BeanPosicao posicao, String palavra) throws MatrizException {
		char[] palavraEscrever = palavra.toCharArray();
		int count = 0;

		log.info("Escrevendo a palavra[" + palavra + "] na posição: [" + posicao.getLinha() + "," + posicao.getColuna()
				+ "]");
		try {

			for (int i = 0; i < palavra.length(); i++) {
				log.debug("Escrevendo a letra[" + palavraEscrever[count] + "] na posição: [" + (posicao.getLinha() + i)
						+ "," + (posicao.getColuna() - i) + "]");
				matriz[posicao.getLinha() + i][posicao.getColuna() - i] = palavraEscrever[count];
				count++;
			}

		} catch (Exception e) {
			log.error("Erro durante execução de escrita na transversal", e);
			throw new MatrizException("Erro durante execução de escrita na transversal");

		}
	}
	/**
	 * Método que executa a escrita na matriz na direção transversal invertida
	 * 
	 * @param posicao
	 * @param palavra
	 * @throws MatrizException
	 */
	private void executaEscritaTransversalInvertida(BeanPosicao posicao, String palavra) throws MatrizException {
		char[] palavraEscrever = palavra.toCharArray();
		int count = 0;

		log.info("Escrevendo a palavra[" + palavra + "] na posição: [" + posicao.getLinha() + "," + posicao.getColuna()
				+ "]");
		try {

			for (int i = 0; i < palavra.length(); i++) {
				log.debug("Escrevendo a letra[" + palavraEscrever[count] + "] na posição: [" + (posicao.getLinha() - i)
						+ "," + (posicao.getColuna() + i) + "]");
				matriz[posicao.getLinha() - i][posicao.getColuna() + i] = palavraEscrever[count];
				count++;
			}

		} catch (Exception e) {
			log.error("Erro durante execução de escrita na transversal invertida", e);
			throw new MatrizException("Erro durante execução de escrita na transversal invertida");

		}
	}

	/**
	 * Método que executa a escrita na matriz na direção diagonal invertida
	 * 
	 * @param posicao
	 * @param palavra
	 * @throws MatrizException
	 */
	private void executaEscritaDiagonalInvertida(BeanPosicao posicao, String palavra) throws MatrizException {
		char[] palavraEscrever = palavra.toCharArray();
		int count = 0;

		log.info("Escrevendo a palavra[" + palavra + "] na posição: [" + posicao.getLinha() + "," + posicao.getColuna()
				+ "]");
		try {

			for (int i = 0; i < palavra.length(); i++) {
				log.debug("Escrevendo a letra[" + palavraEscrever[count] + "] na posição: [" + (posicao.getLinha() - i)
						+ "," + (posicao.getColuna() - i) + "]");
				matriz[posicao.getLinha() - i][posicao.getColuna() - i] = palavraEscrever[count];
				count++;
			}

		} catch (Exception e) {
			log.error("Erro durante execução de escrita na diagonal", e);
			throw new MatrizException("Erro durante execução de escrita na diagonal");

		}
	}
	
	/**
	 * Método que executa a escrita na matriz na direção vertical invertida
	 * 
	 * @param posicao
	 * @param palavra
	 * @throws MatrizException
	 */

	private void executaEscritaVerticalInvertida(BeanPosicao posicao, String palavra) throws MatrizException {
		char[] palavraEscrever = palavra.toCharArray();
		int count = 0;

		log.info("Escrevendo a palavra[" + palavra + "] na coluna: [" + posicao.getColuna() + "]");
		try {
			for (int i = posicao.getLinha(); i > posicao.getLinha() - palavra.length(); i--) {
				log.debug("Escrevendo a letra[" + palavraEscrever[count] + "] na linha: [" + i + "]");
				matriz[i][posicao.getColuna()] = palavraEscrever[count];
				count++;
			}

		} catch (Exception e) {
			log.error("Erro as escrever letras da palavra na matriz.", e);
			throw new MatrizException("Erro as escrever letras da palavra na matriz...");

		}
	}

	/**
	 * Método que executa a escrita na matriz na direção horizontal invertida
	 * 
	 * @param posicao
	 * @param palavra
	 * @throws MatrizException
	 */
	private void executaEscritaHorizontalInvertida(BeanPosicao posicao, String palavra) throws MatrizException {
		char[] palavraEscrever = palavra.toCharArray();
		int count = 0;

		log.info("Escrevendo a palavra[" + palavra + "] na linha: [" + posicao.getLinha() + "]");
		try {
			for (int i = posicao.getColuna(); i > posicao.getColuna() - palavra.length(); i--) {
				log.debug("Escrevendo a letra[" + palavraEscrever[count] + "] na coluna: [" + i + "]");
				matriz[posicao.getLinha()][i] = palavraEscrever[count];
				count++;
			}

		} catch (Exception e) {
			log.error("Erro as escrever letras da palavra na matriz.", e);
			throw new MatrizException("Erro as escrever letras da palavra na matriz...");

		}
	}
	/**
	 * Método que testa sé ha espaço para ecrever na direção vertical a partir da posiao informada.
	 * @param mtz
	 * @param linhaInicio
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean vereficaEspacoVertical(char[][] mtz, int linhaInicio, String palavra) throws Exception {

		log.info("Efetuando teste de espaço vertical...");
		if (mtz == null) {
			throw new MatrizException("Impossível operar com matriz nula.");
		}

		if (palavra.equals(null)) {
			throw new MatrizException("Impossível calcular tamanho de palavra nula.");
		}

		try {
			int tamanhoPalavra = palavra.length();
			if (linhaInicio + tamanhoPalavra <= mtz.length) {
				log.debug("Encontrado espaço para a palavra");
				return true;
			} else {
				log.debug("Não há espaço para a palavra");
				return false;
			}

		} catch (Exception e) {
			log.error("Erro ao calcular sepaço para a palavra na vertical.", e);
			throw new MatrizException("Erro ao calcular sepaço para a palavra na vertical", e);
		}

	}
	/**
	 * Método que testa sé ha espaço para ecrever na direção diagonal a partir da posiao informada.
	 * @param mtz
	 * @param linhaInicio
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean vereficaEspacoDiagonal(BeanPosicao pos, String palavra) throws Exception {

		log.info("Efetuando teste de espaço na diagonal...");

		BeanTamanhosMatriz tamanhosMatriz = new BeanTamanhosMatriz(matriz);

		try {
			int tamanhoPalavra = palavra.length();
			if (tamanhoPalavra + pos.getColuna() <= tamanhosMatriz.getColunas()
					&& tamanhoPalavra + pos.getLinha() <= tamanhosMatriz.getLinha()) {
				log.debug("Encontrado esapço para a palavra");
				return true;
			} else {
				log.debug("Não há espaço para a palavra");
				return false;
			}

		} catch (Exception e) {
			log.error("Erro ao calcular sepaço para a palavra na diagonal.", e);
			throw new MatrizException("Erro ao calcular sepaço para a palavra na diagonal", e);
		}

	}

	/**
	 * Método que testa sé ha espaço para ecrever na direção transversal a partir da posiao informada.
	 * @param mtz
	 * @param linhaInicio
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean vereficaEspacoTransversal(BeanPosicao pos, String palavra) throws Exception {

		log.info("Efetuando teste de espaço na tranversal...");

		BeanTamanhosMatriz tamanhosMatriz = new BeanTamanhosMatriz(matriz);

		try {
			int tamanhoPalavra = palavra.length();
			if (pos.getColuna() - tamanhoPalavra >= 0
					&& pos.getLinha() + tamanhoPalavra <= tamanhosMatriz.getColunas()) {
				log.debug("Encontrado espaço para a palavra");
				return true;
			} else {
				log.debug("Não há espaço para a palavra");
				return false;
			}

		} catch (Exception e) {
			log.error("Erro ao calcular sepaço para a palavra na transversal.", e);
			throw new MatrizException("Erro ao calcular sepaço para a palavra na transversal", e);
		}

	}

	/**
	 * Método que testa sé ha espaço para ecrever na direção transversal invertida a partir da posiao informada.
	 * @param mtz
	 * @param linhaInicio
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean vereficaEspacoTransversalInvertida(BeanPosicao pos, String palavra) throws Exception {

		log.info("Efetuando teste de espaço na tranversal invertida...");

		BeanTamanhosMatriz tamanhosMatriz = new BeanTamanhosMatriz(matriz);

		try {
			int tamanhoPalavra = palavra.length();
			if (pos.getColuna() + tamanhoPalavra <= tamanhosMatriz.getColunas()
					&& pos.getLinha() - tamanhoPalavra >= 0) {
				log.debug("Encontrado espaço para a palavra");
				return true;
			} else {
				log.debug("Não há espaço para a palavra");
				return false;
			}

		} catch (Exception e) {
			log.error("Erro ao calcular sepaço para a palavra na transversal invertida.", e);
			throw new MatrizException("Erro ao calcular sepaço para a palavra na transversal invertida", e);
		}

	}

	/**
	 * Método que testa sé ha espaço para ecrever na direção diagonal invertida a partir da posiao informada.
	 * @param mtz
	 * @param linhaInicio
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean vereficaEspacoDiagonalInvertida(BeanPosicao pos, String palavra) throws Exception {

		log.info("Efetuando teste de espaço na diagonal invertida...");

		try {
			int tamanhoPalavra = palavra.length();
			if (pos.getColuna() - tamanhoPalavra >= 0 && pos.getLinha() - tamanhoPalavra >= 0) {
				log.debug("Encontrado esapaço para a palavra");
				return true;
			} else {
				log.debug("Não há espaço para a palavra");
				return false;
			}

		} catch (Exception e) {
			log.error("Erro ao calcular sepaço para a palavra na diagonal.", e);
			throw new MatrizException("Erro ao calcular sepaço para a palavra na diagonal", e);
		}

	}
	/**
	 * Método que testa sé ha espaço para ecrever na direção horizontal a partir da posiao informada.
	 * @param mtz
	 * @param linhaInicio
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean vereficaEspacoHorizontal(char[][] mtz, int colunaInicio, String palavra) throws Exception {

		log.info("Efetuando teste de espaço horizontal...");
		if (mtz == null) {
			throw new MatrizException("Impossível operar com matriz nula.");
		}

		if (palavra.equals(null)) {
			throw new MatrizException("Impossível calcular tamanho de palavra nula.");
		}

		try {
			int tamanhoPalavra = palavra.length();
			// Verefica se palavra cabe apa rtir da posição indicada (linha
			// coluna)
			if (colunaInicio + tamanhoPalavra <= mtz.length) {
				log.debug("Encontrado espaço para a palavra");
				return true;
			} else {
				log.debug("Não há espaço para a palavra");
				return false;
			}

		} catch (Exception e) {
			log.error("Erro ao calcular sepaço para a palavra na vertical.", e);
			throw new MatrizException("Erro ao calcular sepaço para a palavra na vertical", e);
		}

	}
	/**
	 * Método que testa sé ha espaço para ecrever na direção vertical invertida a partir da posiao informada.
	 * @param mtz
	 * @param linhaInicio
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean vereficaEspacoVerticalInvertida(char[][] mtz, int linhaInicio, String palavra) throws Exception {

		log.info("Efetuando teste de espaço para escrever VERTICAL_INVERTIDA...");
		if (mtz == null) {
			throw new MatrizException("Impossível operar com matriz nula.");
		}

		if (palavra.equals(null)) {
			throw new MatrizException("Impossível calcular tamanho de palavra nula.");
		}

		try {
			int tamanhoPalavra = palavra.length();
			if (linhaInicio - tamanhoPalavra >= ZERO) {
				log.debug("Encontrado espaço para a palavra");
				return true;
			} else {
				log.debug("Não há espaço para a palavra");
				return false;
			}

		} catch (Exception e) {
			log.error("Erro ao calcular sepaço para a palavra na vertical.", e);
			throw new MatrizException("Erro ao calcular sepaço para a palavra na vertical", e);
		}

	}
	/**
	 * Método que testa sé ha espaço para ecrever na direção horizoontal invertida a partir da posiao informada.
	 * @param mtz
	 * @param linhaInicio
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean vereficaEspacoHorizontalInvertida(char[][] mtz, int colunaInicio, String palavra) throws Exception {

		log.info("Efetuando teste de espaço para escrever HORIZONTAL_INVERTIDA...");
		if (mtz == null) {
			throw new MatrizException("Impossível operar com matriz nula.");
		}

		if (palavra.equals(null)) {
			throw new MatrizException("Impossível calcular tamanho de palavra nula.");
		}

		try {
			int tamanhoPalavra = palavra.length();
			// Verefica se palavra cabe apa rtir da posição indicada (linha
			// coluna)
			if ((colunaInicio + 1) - tamanhoPalavra >= ZERO) {
				log.debug("Há espaço para a palavra");
				return true;
			} else {
				log.debug("Não há espaço para a palavra");
				return false;
			}

		} catch (Exception e) {
			log.error("Erro ao calcular sepaço para a palavra na vertical.", e);
			throw new MatrizException("Erro ao calcular sepaço para a palavra na vertical", e);
		}

	}
	/**
	 * Método que evita a sobrescrita na direção vertical, retorana true quando nao gera sobrescrita
	 * @param mtz
	 * @param posicao
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	private boolean isSobrescritaLiberada(char[][] mtz, BeanPosicao posicao, String palavra) throws Exception {
		log.info("Iniciando teste de sobrescrita vertical...");
		char[] nomeArray = palavra.toCharArray();

		int pos = 0;

		for (int i = posicao.getLinha(); i < palavra.length() + posicao.getLinha(); i++) {
			if (mtz[i][posicao.getColuna()] != limpo && mtz[i][posicao.getColuna()] != nomeArray[pos]) {
				log.info("Escrita não permitida na posição pois gera sobrescrita.");
				return false;
			}
			pos++;
		}

		return true;
	}

	private boolean testaSobrescritaDiagonal(char[][] mtz, BeanPosicao posicao, String palavra) throws Exception {
		log.info("Iniciando teste de sobrescrita diagonal...");
		char[] nomeArray = palavra.toCharArray();

		for (int i = 0; i < palavra.length(); i++) {
			if (mtz[posicao.getLinha() + i][posicao.getColuna() + i] != limpo
					&& mtz[posicao.getLinha() + i][posicao.getColuna() + 1] != nomeArray[i]) {
				log.info("Escrita não permitida na posição pois gera sobrescrita.");
				return false;
			}

		}

		return true;
	}

	private boolean testaSobrescritaDiagonalInvertida(char[][] mtz, BeanPosicao posicao, String palavra)
			throws Exception {
		log.info("Iniciando teste de sobrescrita diagonal invertida...");
		char[] nomeArray = palavra.toCharArray();

		for (int i = 0; i < palavra.length(); i++) {
			if (mtz[posicao.getLinha() - i][posicao.getColuna() - i] != limpo
					&& mtz[posicao.getLinha() - i][posicao.getColuna() - i] != nomeArray[i]) {
				log.info("Escrita não permitida na posição pois gera sobrescrita.");
				return false;
			}

		}

		return true;
	}

	private boolean testaSobrescritaTransversal(char[][] mtz, BeanPosicao posicao, String palavra) throws Exception {
		log.info("Iniciando teste de sobrescrita transversal...");
		char[] nomeArray = palavra.toCharArray();

		for (int i = 0; i < palavra.length(); i++) {
			if (mtz[posicao.getLinha() + i][posicao.getColuna() - i] != limpo
					&& mtz[posicao.getLinha() + i][posicao.getColuna() - i] != nomeArray[i]) {
				log.info("Escrita não permitida na posição pois gera sobrescrita.");
				return false;
			}
		}

		return true;
	}

	private boolean testaSobrescritaTransversalInvertida(char[][] mtz, BeanPosicao posicao, String palavra)
			throws Exception {
		log.info("Iniciando teste de sobrescrita transversal invertida...");
		char[] nomeArray = palavra.toCharArray();

		for (int i = 0; i < palavra.length(); i++) {
			if (mtz[posicao.getLinha() - i][posicao.getColuna() + i] != limpo
					&& mtz[posicao.getLinha() - i][posicao.getColuna() + i] != nomeArray[i]) {
				log.info("Escrita não permitida na posição pois gera sobrescrita.");
				return false;
			}

		}

		return true;
	}

	private boolean testaSobrescritaHorizontal(char[][] mtz, BeanPosicao posicao, String palavra) throws Exception {
		log.info("Efetuando calculo para evitar sobrescrita horizontal...");
		char[] nomeArray = palavra.toCharArray();

		int pos = 0;

		for (int i = posicao.getColuna(); i < palavra.length() + posicao.getColuna(); i++) {
			if (mtz[posicao.getLinha()][i] != limpo && mtz[posicao.getLinha()][i] != nomeArray[pos]) {
				log.info("Escrita não permitida na posição pois gera sobrescrita.");
				return false;
			}
			pos++;
		}

		return true;
	}

	private boolean testaSobrescritaHorizontalInvertida(char[][] mtz, BeanPosicao posicao, String palavra)
			throws Exception {
		log.info("Efetuando calculo para evitar sobrescrita na horizontal invertida...");
		char[] nomeArray = palavra.toCharArray();

		int pos = 0;

		for (int i = posicao.getColuna(); i > posicao.getColuna() - palavra.length(); i--) {
			if (mtz[posicao.getLinha()][i] != limpo && mtz[posicao.getLinha()][i] != nomeArray[pos]) {
				log.info("Escrita não permitida na posição pois gera sobrescrita.");
				return false;
			}
			pos++;
		}

		return true;
	}

	private boolean testaSobrescritaVerticalInvertida(char[][] mtz, BeanPosicao posicao, String palavra)
			throws Exception {
		log.info("Iniciando teste de sobrescrita vertical invertida");
		char[] nomeArray = palavra.toCharArray();

		int pos = 0;

		for (int i = posicao.getLinha(); i > posicao.getLinha() - palavra.length(); i--) {
			if (mtz[i][posicao.getColuna()] != limpo && mtz[i][posicao.getColuna()] != nomeArray[pos]) {
				log.info("Escrita não permitida na posição pois gera sobrescrita.");
				return false;
			}
			pos++;
		}

		return true;
	}

	/**
	 * @return the palavrasNaoEscritas
	 */
	public List<String> getPalavrasNaoEscritas() {
		return palavrasNaoEscritas;
	}

	/**
	 * @param palavrasNaoEscritas
	 *            the palavrasNaoEscritas to set
	 */
	public void setPalavrasNaoEscritas(List<String> palavrasNaoEscritas) {
		this.palavrasNaoEscritas = palavrasNaoEscritas;
	}

	/**
	 * @return the listaOpcoesRecebidas
	 */
	public List<Integer> getListaOpcoesRecebidas() {
		return listaOpcoesRecebidas;
	}

	/**
	 * @param listaOpcoesRecebidas
	 *            the listaOpcoesRecebidas to set
	 */
	public void setListaOpcoesRecebidas(List<Integer> listaOpcoesRecebidas) {
		this.listaOpcoesRecebidas = listaOpcoesRecebidas;
	}

	/**
	 * @return the palavrasEscritas
	 */
	public List<String> getPalavrasEscritas() {
		return palavrasEscritas;
	}

	/**
	 * @param palavrasEscritas
	 *            the palavrasEscritas to set
	 */
	public void setPalavrasEscritas(List<String> palavrasEscritas) {
		this.palavrasEscritas = palavrasEscritas;
	}

}
