package telas;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;

import com.relarorio.Relatorio;

import Beans.BeanDadosMatriz;
import Logger.ALogger;
import Util.Globais;
import customizados.MeuBotao;
import customizados.MinhaLabel;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Operacoes;
import net.sf.jasperreports.engine.JRException;

/**
 * Classe que implementa a tela dpara informas dados do cabeçalho de impressão.
 * 
 * @author "Alcélio Gomes {@link doalcelio@gmail.com}"
 *
 * @since 15/04/2017
 */

public class TelaDadosCabelho extends Application {

	private static ALogger log = ALogger.getLogger(TelaDadosCabelho.class);

	private static StringBuilder fundoTela;
	private static StringBuilder fundoTop;
	private static StringBuilder fundoButton;

	public Stage stage;

	private MeuBotao btnContinuar;

	private GridPane painelCentro;
	private GridPane painelButton;
	private GridPane painelTop;

	private MinhaLabel lblTitulo;

	private MinhaLabel lblNomeProfessor;
	private MinhaLabel lblObjetivos;
	private MinhaLabel lblNomeEscola;

	private TextField txtNomeProfessor;
	private TextArea txtObjetivos;
	private TextField txtNomeEscola;

	private static java.util.List<BeanDadosMatriz> listaRecebida = new ArrayList<>();

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

		log.info("Inciando tela para informar dados cabeçalho");

		controladorTela.initStyle(StageStyle.UNDECORATED);

		final BorderPane painelPrincipal = new BorderPane();

		painelPrincipal.setStyle(fundoTela.toString());

		painelPrincipal.setCenter(getPainelCentro());
		painelPrincipal.setBottom(getPainelButton());
		painelPrincipal.setTop(getPainelTop());

		controladorTela.setHeight(500);
		controladorTela.setWidth(500);

		controladorTela.centerOnScreen();

		Scene scene = new Scene(painelPrincipal);

		controladorTela.setScene(scene);
		controladorTela.setTitle("Dados cabeçalho diagrama");
		controladorTela.show();

		log.info("Tela para informar dados cabeçalho concluída");

	}

	private GridPane getPainelCentro() {
		log.info("Gerando painel completo");

		if (painelCentro == null) {
			painelCentro = new GridPane();

			painelCentro.setHgap(0);
			painelCentro.setVgap(0);
			painelCentro.setPadding(new Insets(10, 10, 10, 10));

			painelCentro.setAlignment(Pos.CENTER);

			lblNomeProfessor = new MinhaLabel("Nome do professor:");
			lblNomeProfessor.setFont(new Font("ubuntu", 15));
			lblNomeEscola = new MinhaLabel("Nome da escola:");
			lblNomeEscola.setFont(new Font("ubuntu", 15));
			lblObjetivos = new MinhaLabel("Objetivos de aprendizagem:");
			lblObjetivos.setFont(new Font("ubuntu", 15));

			txtNomeEscola = new TextField();
			txtNomeEscola.setMaxWidth(450);
			txtNomeEscola.setMinWidth(450);
			txtNomeEscola.setMinHeight(40);
			txtNomeEscola.setMaxHeight(40);
			txtNomeEscola.textProperty().addListener((ov, oldValue, newValue) -> {
				txtNomeEscola.setText(newValue.toUpperCase());
			});

			txtNomeProfessor = new TextField();
			txtNomeProfessor.setMaxWidth(450);
			txtNomeProfessor.setMinWidth(450);
			txtNomeProfessor.setMinHeight(40);
			txtNomeProfessor.setMaxHeight(40);
			txtNomeProfessor.textProperty().addListener((ov, oldValue, newValue) -> {
				txtNomeProfessor.setText(newValue.toUpperCase());
			});

			txtObjetivos = new TextArea();
			txtObjetivos.setMaxWidth(450);
			txtObjetivos.setMinWidth(450);
			txtObjetivos.setMinHeight(120);
			txtObjetivos.setMaxHeight(120);
			txtObjetivos.textProperty().addListener((ov, oldValue, newValue) -> {
				txtObjetivos.setText(newValue.toUpperCase());
			});

			painelCentro.add(lblNomeEscola, 0, 0);
			painelCentro.add(txtNomeEscola, 0, 1);

			painelCentro.add(lblNomeProfessor, 0, 2);
			painelCentro.add(txtNomeProfessor, 0, 3);

			painelCentro.add(lblObjetivos, 0, 4);
			painelCentro.add(txtObjetivos, 0, 5);

		}
		log.debug("Painel completo concluido.");
		return painelCentro;
	}

	private GridPane getPainelButton() {
		log.info("Desenhando painel de baixo.");

		if (painelButton == null) {
			painelButton = new GridPane();

			painelButton.setHgap(10);
			painelButton.setVgap(10);
			painelButton.setPadding(new Insets(10, 10, 10, 10));

			painelButton.setAlignment(Pos.BOTTOM_RIGHT);

			btnContinuar = new MeuBotao("Continuar");

			btnContinuar.setFont(new Font("Ubuntu", 20));
			btnContinuar.setPrefSize(170, 60);
			painelButton.add(btnContinuar, 2, 0);
			btnContinuar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					trataEventoBotaoContinuar();
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
	 * Metodo que execura a abertura da tela para inserção de dados do cabeçalho
	 * 
	 * @param matrizGabarito
	 */
	public static void abreTelaDadosCabeclho(java.util.List<BeanDadosMatriz> lista) {
		TelaDadosCabelho tela = new TelaDadosCabelho();
		TelaDadosCabelho.listaRecebida = lista;
		try {

			tela.start(new Stage());

		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ops...");
			alert.setHeaderText("Erro ao abrir tela!");
			alert.showAndWait();
			log.error("Erro ao abrir tela de apresentação.", e);
		}
	}

	private void trataEventoBotaoContinuar() {

		try {
			if (!StringUtils.isBlank(txtNomeEscola.getText())) {
				Relatorio.getMapParametros().put(Globais.parametroNomeEscola, txtNomeEscola.getText());
			}
			
			if (!StringUtils.isBlank(txtNomeProfessor.getText())) {
				Relatorio.getMapParametros().put(Globais.parametroNomeProfessor, txtNomeProfessor.getText());
			}
			
			if (!StringUtils.isBlank(txtObjetivos.getText())) {
				Relatorio.getMapParametros().put(Globais.parametroObjetivo, txtObjetivos.getText());
			}
			stage.close();
			
			Relatorio rel = new Relatorio();
			
			rel.geraRelarotioCompleto(TelaDadosCabelho.listaRecebida);
		
		} catch (JRException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Ops...");
			alert.setHeaderText("Erro solicitar impressão do diagrama!");
			alert.showAndWait();
			log.error("Erro solicitar impressão do diagrama.");
		}
	}
}
