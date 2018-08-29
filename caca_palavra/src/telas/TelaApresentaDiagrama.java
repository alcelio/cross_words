package telas;

import static javafx.geometry.Pos.CENTER;

import java.util.ArrayList;
import java.util.List;

import com.relarorio.Relatorio;

import Beans.BeanDadosMatriz;
import Beans.BeanTamanhosMatriz;
import Logger.ALogger;
import customizados.MeuBotao;
import customizados.MinhaLabel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Operacoes;

/**
 * Classe que implementa a tela de vizualização de diagrama.
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 * @since 15/04/2017
 */

public class TelaApresentaDiagrama extends Application {

	private static ALogger log = ALogger.getLogger(TelaApresentaDiagrama.class);

	private static StringBuilder fundoTela;
	private static StringBuilder fundoTop;
	private static StringBuilder fundoButton;

	public Stage stage;

	private MeuBotao btnVoltar;

	private MeuBotao btnGeraIMpressapGabarito;

	private MeuBotao btnGeraImpressaoDiagrama;

	private GridPane painelGabarito;
	private GridPane painelDiagrama;
	private GridPane painelCompleto;
	private GridPane painelButton;
	private GridPane painelTop;

	private MinhaLabel lblTitulo;

	private static char[][] mRecebida;
	private static char[][] mGabaritoLimpa;
	private static char[][] mCompleta;

	private static Operacoes operacoes = null;

	public static Operacoes getOperacaoes() {
		if (operacoes == null) {
			operacoes = new Operacoes();
		}
		return operacoes;

	}

	static {
		fundoTela = new StringBuilder();
		fundoTop = new StringBuilder();
		fundoButton = new StringBuilder();

		fundoTela.append("-fx-background-color: linear-gradient(#363A4C, #BBB7B0);");
		fundoButton.append("-fx-background-color: linear-gradient(#060606, #0A0F26);");
		fundoTop.append("-fx-background-color: linear-gradient(#0A0F26, #060606);");
	}

	@Override
	public void start(Stage controladorTela) throws Exception {

		stage = controladorTela;

		log.info("Inciando tela de apresentação dos diagramas");

		controladorTela.initStyle(StageStyle.UNDECORATED);

		final BorderPane painelPrincipal = new BorderPane();

		painelPrincipal.setStyle(fundoTela.toString());

		painelPrincipal.setCenter(getPainelCompleto());
		painelPrincipal.setBottom(getPainelButton());
		painelPrincipal.setTop(getPainelTop());

		Rectangle2D tamanhoTelaMonitor = Screen.getPrimary().getVisualBounds();
		controladorTela.setX(tamanhoTelaMonitor.getMinX());
		controladorTela.setY(tamanhoTelaMonitor.getMinY());
		controladorTela.setWidth(tamanhoTelaMonitor.getWidth());
		controladorTela.setHeight(tamanhoTelaMonitor.getHeight());

		Scene scene = new Scene(painelPrincipal);

		// scene.
		controladorTela.setScene(scene);
		controladorTela.setTitle("Controle Bancário");
		controladorTela.show();

		log.info("Tela de apresentação dos diagramas inicializada.");

	}

	private GridPane getPainelCompleto() {
		log.info("Gerando painel completo");

		if (painelCompleto == null) {
			painelCompleto = new GridPane();

			painelCompleto.setHgap(0);
			painelCompleto.setVgap(0);
			painelCompleto.setPadding(new Insets(10, 10, 10, 10));

			painelCompleto.setAlignment(Pos.CENTER);

			painelCompleto.add(getPainelGabarito(), 0, 0);
			painelCompleto.add(getPainelDiagrama(), 1, 0);

		}
		log.debug("Painel completo concluido.");
		return painelCompleto;
	}

	private GridPane getPainelGabarito() {
		log.info("Gerando painel de gabarito");

		if (painelGabarito == null) {
			painelGabarito = new GridPane();

			painelGabarito.setHgap(0);
			painelGabarito.setVgap(0);
			painelGabarito.setPadding(new Insets(10, 10, 10, 10));

			painelGabarito.setAlignment(Pos.CENTER);

			BeanTamanhosMatriz tam = new BeanTamanhosMatriz(mGabaritoLimpa);
			for (int linha = 0; linha < tam.getColunas(); linha++) {
				for (int coluna = 0; coluna < tam.getLinha(); coluna++) {
					TextField tf = new TextField();
					tf.setPrefHeight(25);
					tf.setPrefWidth(25);
					tf.setFont(new Font("Ubuntu", 12));
					tf.setAlignment(CENTER);
					tf.setEditable(false);
					tf.setText(String.valueOf(mGabaritoLimpa[linha][coluna]));

					GridPane.setRowIndex(tf, linha);
					GridPane.setColumnIndex(tf, coluna);
					painelGabarito.getChildren().add(tf);
				}
			}

		}
		log.debug("Painel gabarito concluido.");
		return painelGabarito;
	}

	private GridPane getPainelDiagrama() {
		log.info("Gerando painel diagrama");

		if (painelDiagrama == null) {
			painelDiagrama = new GridPane();

			painelDiagrama.setHgap(0);
			painelDiagrama.setVgap(0);
			painelDiagrama.setPadding(new Insets(10, 10, 10, 10));

			painelDiagrama.setAlignment(Pos.CENTER);

			BeanTamanhosMatriz tam = new BeanTamanhosMatriz(mGabaritoLimpa);
			for (int linha = 0; linha < tam.getColunas(); linha++) {
				for (int coluna = 0; coluna < tam.getLinha(); coluna++) {
					TextField tf = new TextField();
					tf.setPrefHeight(25);
					tf.setPrefWidth(25);
					tf.setFont(new Font("Ubuntu", 12));
					tf.setAlignment(CENTER);
					tf.setEditable(false);
					tf.setText(String.valueOf(mCompleta[linha][coluna]));

					GridPane.setRowIndex(tf, linha);
					GridPane.setColumnIndex(tf, coluna);
					painelDiagrama.getChildren().add(tf);
				}
			}

		}
		log.debug("Painel diagrama concluído.");
		return painelDiagrama;
	}

	private GridPane getPainelButton() {
		log.info("Desenhando painel de baixo.");

		if (painelButton == null) {
			painelButton = new GridPane();

			painelButton.setHgap(10);
			painelButton.setVgap(10);
			painelButton.setPadding(new Insets(10, 10, 10, 10));

			painelButton.setAlignment(Pos.BOTTOM_RIGHT);

			btnGeraIMpressapGabarito = new MeuBotao("Imprime Gabarito");

			btnGeraIMpressapGabarito.setFont(new Font("Ubuntu", 20));
			btnGeraIMpressapGabarito.setPrefSize(172, 60);
			painelButton.add(btnGeraIMpressapGabarito, 0, 0);
			btnGeraIMpressapGabarito.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					trataEventoBotaoGeraImpressaoGabarito();
				}
			});

			btnGeraImpressaoDiagrama = new MeuBotao("Imprime Diagrama");

			btnGeraImpressaoDiagrama.setFont(new Font("Ubuntu", 20));
			btnGeraImpressaoDiagrama.setPrefSize(172, 60);
			painelButton.add(btnGeraImpressaoDiagrama, 1, 0);
			btnGeraImpressaoDiagrama.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					trataEventoBotaoGeraImpressaoDiagrama();
				}
			});

			btnVoltar = new MeuBotao("Voltar");

			btnVoltar.setFont(new Font("Ubuntu", 20));
			btnVoltar.setPrefSize(170, 60);
			painelButton.add(btnVoltar, 2, 0);
			btnVoltar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					stage.close();
				}
			});
		}
		// -fx-background-color: linear-gradient(#060606, #0A0F26);
		painelButton.setStyle(fundoButton.toString());
		log.info("Conluído painel de baixo");
		return painelButton;
	}

	public static void main(String[] args) {
		launch(args);
	}

	private GridPane getPainelTop() {
		log.info("Desenhando painel do topo.");

		if (painelTop == null) {
			painelTop = new GridPane();

			painelTop.setAlignment(Pos.TOP_CENTER);

			lblTitulo = new MinhaLabel("Caça palavras.");
			painelTop.add(lblTitulo, 0, 0);

			painelTop.setStyle(fundoTop.toString());

		}
		log.info("Concluído painel do topo.");
		return painelTop;
	}

	@SuppressWarnings("unused")
	private void installEventHandler(final Node keyNode) {
		final EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
			public void handle(final KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER) {

				}
			}
		};

		keyNode.setOnKeyPressed(keyEventHandler);
		keyNode.setOnKeyReleased(keyEventHandler);
	}

	/**
	 * Metodo que execura a abertura da tela para visualixaçao do diagrama
	 * 
	 * @param matrizGabarito
	 */
	public static void abreTelaApresentacaoDiagrama(char[][] matrizGabarito) {
		TelaApresentaDiagrama tela = new TelaApresentaDiagrama();
		log.info("Abrindo tela de apresentação de diagrama...");

		mRecebida = matrizGabarito;
		mGabaritoLimpa = getOperacaoes().geraGabaritoLimpo(mRecebida);
		mCompleta = getOperacaoes().completaMatriz(mRecebida);

		try {

			tela.start(new Stage());
			log.debug("Tela aberta com sucesso...");
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ops...");
			alert.setHeaderText("Erro ao abrir tela de apresentação...!");
			// alert.setContentText(e.getCause().toString());
			alert.showAndWait();
			log.error("Erro ao abrir tela de apresentação.", e);
		}
	}
	/**
	 * Método que efetua a impressão do diagrama
	 *
	 */
	private void trataEventoBotaoGeraImpressaoDiagrama() {
		List<BeanDadosMatriz> listaImpressao = new ArrayList<>();
		try {
			log.debug("Iniciando processo de impressão de diagrama.");
			listaImpressao = getOperacaoes().formataParaImpressao(mCompleta);
			
			Relatorio rel = new Relatorio();
			rel.geraRelarotioCompleto(listaImpressao);
			log.debug("Geração de impressão enviada para o sistema operacional com sucesso!");
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ops...");
			alert.setHeaderText("Erro ao abrir relatório de impressão...!");
			// alert.setContentText(e.getCause().toString());
			alert.showAndWait();
			log.error("Erro ao abrir tela de apresentação.", e);
		}

	}
	/**
	 * Método que envia um diagrama de gabarito para a impressão.
	 *
	 */
	private void trataEventoBotaoGeraImpressaoGabarito() {

		List<BeanDadosMatriz> listaImpressao = new ArrayList<>();
		try {
			log.debug("Iniciando processo de impressão de gabarito.");
			listaImpressao = getOperacaoes().formataParaImpressao(mGabaritoLimpa);
			Relatorio rel = new Relatorio();
			rel.geraRelarotioGabarito(listaImpressao);
			log.debug("Geração de impressão enviada para o sistema operacional com sucesso!");
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ops...");
			alert.setHeaderText("Erro ao abrir relatório de impressão...!");
			// alert.setContentText(e.getCause().toString());
			alert.showAndWait();
			log.error("Erro ao abrir tela de apresentação.", e);
		}
		

	}

}
