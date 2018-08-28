package telas;

import static Util.Globais.DIAGONAL;
import static Util.Globais.DIAGONAL_INVERTIDA;
import static Util.Globais.HORIZONTAL;
import static Util.Globais.HORIZONTAL_INVERTIDA;
import static Util.Globais.TRANSVERSAL;
import static Util.Globais.TRANSVERSAL_INVERTIDA;
import static Util.Globais.VERTICAL;
import static Util.Globais.VERTICAL_INVERTIDA;
import static Util.IntegerUtil.ZERO;
import static com.relarorio.Relatorio.getMapParametros;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import Beans.BeanItemTablePalavra;
import Exception.ScreenException;
import Logger.ALogger;
import Util.Globais;
import customizados.MeuBotao;
import customizados.MinhaLabel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.geometry.VPos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Operacoes;

public class Main extends Application {

	private static ALogger log = ALogger.getLogger(Main.class);

	private static StringBuilder fundoTela;
	private static StringBuilder fundoTop;
	private static StringBuilder fundoButton;

	private MeuBotao btnAdicionar;
	private MeuBotao btnLimpar;
	private MeuBotao btnSair;
	private MeuBotao btnExcluir;
	private MeuBotao btnCriarDiagrama;

	private GridPane painelCentral;
	private GridPane painelButton;
	private GridPane painelTop;

	private MinhaLabel lblTitulo;
	private MinhaLabel lblInfo;
	private MinhaLabel lblQuantPalavras;
	private MinhaLabel lblTamanhoMatriz;
	private MinhaLabel lblLinha;
	private MinhaLabel lblColuna;

	private TextField txtPalavra;
	private TextField txtQauntidadaPalavras;
	private TextField txtLinhas;
	private TextField txtColunas;

	private CheckBox cbVertical;
	private CheckBox cbVerticalInvertida;
	private CheckBox cbHorizontal;
	private CheckBox cbHorizontalInvertida;
	private CheckBox cbDiagonal;
	private CheckBox cbDiagonalInvertida;
	private CheckBox cbTransverdal;
	private CheckBox cbTransversalInvertida;

	private HBox boxBollean1;
	private HBox boxBollean2;
	

	private TableView<BeanItemTablePalavra> tabela;
	private ObservableList<BeanItemTablePalavra> listaPalavras = FXCollections.observableArrayList();

	List<Integer> listaTiposEscritas = new ArrayList<>();

	char[][] matriz;

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

		log.info("Inciando tela principal da aplicação...");

		controladorTela.initStyle(StageStyle.UNDECORATED);

		final BorderPane painelPrincipal = new BorderPane();

		painelPrincipal.setStyle(fundoTela.toString());

		painelPrincipal.setCenter(getPaineCentro());
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

		log.info("Tela principal inicializada.");

	}

	private GridPane getPaineCentro() {
		log.info("Gerando painel central");

		if (painelCentral == null) {
			painelCentral = new GridPane();

			painelCentral.setHgap(10);
			painelCentral.setVgap(10);
			painelCentral.setPadding(new Insets(5, 5, 5, 5));

			painelCentral.setAlignment(Pos.CENTER);

			lblInfo = new MinhaLabel("Digite as palavras na forma que devem aparecer no diagrama.");
			lblInfo.setFont(new Font("Ubuntu", 14));
			painelCentral.add(lblInfo, 0, 0);
			GridPane.setColumnSpan(lblInfo, 2);

			txtPalavra = new TextField();
			txtPalavra.setMaxWidth(450);
			txtPalavra.setMinWidth(450);
			txtPalavra.setMinHeight(40);
			txtPalavra.setMaxHeight(40);
			painelCentral.add(txtPalavra, 0, 1);
			txtPalavra.textProperty().addListener((ov, oldValue, newValue) -> {
				txtPalavra.setText(newValue.toUpperCase());
			});

			btnAdicionar = new MeuBotao("Adicionar");
			btnAdicionar.setPrefSize(140, 40);
			painelCentral.add(btnAdicionar, 1, 1);
			GridPane.setColumnSpan(btnAdicionar, 2);

			btnLimpar = new MeuBotao("Limpar");
			btnLimpar.setPrefSize(140, 40);
			painelCentral.add(btnLimpar, 1, 2);
			GridPane.setColumnSpan(btnLimpar, 2);

			btnExcluir = new MeuBotao("Excluir");
			btnExcluir.setPrefSize(140, 40);
			painelCentral.add(btnExcluir, 1, 3);
			GridPane.setColumnSpan(btnExcluir, 2);

			btnCriarDiagrama = new MeuBotao("Diagrama");
			btnCriarDiagrama.setPrefSize(140, 40);
			painelCentral.add(btnCriarDiagrama, 1, 4);
			GridPane.setColumnSpan(btnCriarDiagrama, 2);

			lblTamanhoMatriz = new MinhaLabel("Tamanho da Matriz");
			lblTamanhoMatriz.setFont(new Font("Ubuntu", 14));
			painelCentral.add(lblTamanhoMatriz, 1, 5);
			GridPane.setColumnSpan(lblTamanhoMatriz, 2);

			lblLinha = new MinhaLabel("Linhas");
			lblLinha.setFont(new Font("Ubuntu", 14));
			painelCentral.add(lblLinha, 1, 6);

			lblColuna = new MinhaLabel("Colunas");
			lblColuna.setFont(new Font("Ubuntu", 14));
			painelCentral.add(lblColuna, 2, 6);

			txtLinhas = new TextField();
			txtLinhas.setMaxWidth(60);
			txtLinhas.setMinWidth(60);
			txtLinhas.setMinHeight(40);
			txtLinhas.setMaxHeight(40);
			txtLinhas.setText("20");
			txtLinhas.setFont(new Font("Ubuntu", 20));
			painelCentral.add(txtLinhas, 1, 7);

			txtColunas = new TextField();
			txtColunas.setMaxWidth(60);
			txtColunas.setMinWidth(60);
			txtColunas.setMinHeight(40);
			txtColunas.setMaxHeight(40);
			txtColunas.setText("20");
			txtColunas.setFont(new Font("Ubuntu", 20));
			painelCentral.add(txtColunas, 2, 7);

			lblQuantPalavras = new MinhaLabel("Quantidafe Palavras");
			lblQuantPalavras.setFont(new Font("Ubuntu", 14));
			painelCentral.add(lblQuantPalavras, 1, 8);
			GridPane.setVgrow(lblQuantPalavras, Priority.ALWAYS);
			GridPane.setValignment(lblQuantPalavras, VPos.BOTTOM);
			GridPane.setColumnSpan(lblQuantPalavras, 2);

			txtQauntidadaPalavras = new TextField();
			txtQauntidadaPalavras.setMaxWidth(140);
			txtQauntidadaPalavras.setMinWidth(140);
			txtQauntidadaPalavras.setMinHeight(40);
			txtQauntidadaPalavras.setMaxHeight(40);
			txtQauntidadaPalavras.setEditable(false);
			txtQauntidadaPalavras.setFont(new Font("Ubuntu", 20));
			painelCentral.add(txtQauntidadaPalavras, 1, 9);
			GridPane.setColumnSpan(txtQauntidadaPalavras, 2);

			tabela = new TableView<>();
			tabela.setEditable(true);

			TableColumn<BeanItemTablePalavra, String> colunaPalavra = new TableColumn<>("Lista de Palavras");
			colunaPalavra.setMaxWidth(440);
			colunaPalavra.setMinWidth(440);
			colunaPalavra.setCellValueFactory(new PropertyValueFactory<>("palavra"));

			tabela = new TableView<>();

			tabela.setItems(listaPalavras);
			tabela.getColumns().add(colunaPalavra);

			painelCentral.add(tabela, 0, 2);
			GridPane.setRowSpan(tabela, 8);

			cbDiagonal = new CheckBox("Diagonal");
			cbDiagonal.setMinSize(100, 40);
			cbDiagonalInvertida = new CheckBox("Diag inversa");
			cbDiagonalInvertida.setMinSize(100, 40);
			cbHorizontal = new CheckBox("Horizontal");
			cbHorizontal.setMinSize(100, 40);
			cbHorizontalInvertida = new CheckBox("Horiz inversa");
			cbHorizontalInvertida.setMinSize(100, 40);
			cbTransverdal = new CheckBox("Transversal");
			cbTransverdal.setMinSize(100, 40);
			cbTransversalInvertida = new CheckBox("Transv inversa");
			cbTransversalInvertida.setMinSize(100, 40);
			cbVertical = new CheckBox("Vertical");
			cbVertical.setMinSize(100, 40);
			cbVerticalInvertida = new CheckBox("Vert inversa");
			cbVerticalInvertida.setMinSize(100, 40);

			marcaTodosCheckBox();

			boxBollean1 = new HBox();
			boxBollean1.setPadding(new Insets(2, 2, 2, 2));
			boxBollean1.getChildren().add(cbVertical);
			boxBollean1.getChildren().add(cbVerticalInvertida);
			boxBollean1.getChildren().add(cbHorizontal);
			boxBollean1.getChildren().add(cbHorizontalInvertida);

			boxBollean2 = new HBox();
			boxBollean2.setPadding(new Insets(2, 2, 2, 2));
			boxBollean2.getChildren().add(cbDiagonal);
			boxBollean2.getChildren().add(cbDiagonalInvertida);
			boxBollean2.getChildren().add(cbTransverdal);
			boxBollean2.getChildren().add(cbTransversalInvertida);

			HBox.setMargin(cbVertical, new Insets(2, 2, 2, 2));
			HBox.setMargin(cbVerticalInvertida, new Insets(2, 2, 2, 2));
			HBox.setMargin(cbHorizontal, new Insets(2, 2, 2, 2));
			HBox.setMargin(cbHorizontalInvertida, new Insets(2, 2, 2, 2));
			HBox.setMargin(cbDiagonal, new Insets(2, 2, 2, 2));
			HBox.setMargin(cbDiagonalInvertida, new Insets(2, 2, 2, 2));
			HBox.setMargin(cbTransverdal, new Insets(2, 2, 2, 2));
			HBox.setMargin(cbTransversalInvertida, new Insets(2, 2, 2, 2));

			HBox.setMargin(lblLinha, new Insets(2, 2, 2, 2));
			HBox.setMargin(lblColuna, new Insets(2, 2, 2, 2));

			HBox.setMargin(txtLinhas, new Insets(2, 2, 2, 2));
			HBox.setMargin(txtColunas, new Insets(2, 2, 2, 2));

			painelCentral.add(boxBollean1, 0, 10);
			painelCentral.add(boxBollean2, 0, 11);

			btnAdicionar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					trataEventoBotaoAdicionar();
				}

			});

			btnLimpar.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					trataEventoBotaoLimpar();
				}

			});

			btnExcluir.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					trataEventoBotaoExcluir();
				}

			});

			btnCriarDiagrama.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
						trataEventoBotaoCriarDiagrama();
					
				}

			});

			installEventHandler(txtPalavra);

		}
		log.debug("Painel central concluído.");
		return painelCentral;
	}
	
	private void marcaTodosCheckBox() {
		cbVertical.setSelected(true);
		cbVerticalInvertida.setSelected(true);
		cbHorizontal.setSelected(true);
		cbHorizontalInvertida.setSelected(true);
		cbDiagonal.setSelected(true);
		cbDiagonalInvertida.setSelected(true);
		cbTransverdal.setSelected(true);
		cbTransversalInvertida.setSelected(true);
	}

	private void trataEventoBotaoAdicionar() {

		if (!StringUtils.isBlank(txtPalavra.getText())) {
			BeanItemTablePalavra item = new BeanItemTablePalavra();
			item.setPalavra(txtPalavra.getText());
			listaPalavras.add(item);
			txtPalavra.clear();
			txtQauntidadaPalavras.setText(String.valueOf(listaPalavras.size()));
		}

		txtPalavra.requestFocus();

		// List<String> palavras = new ArrayList<>();
		// palavras.add("ESTOUJO");
		// palavras.add("TRAVESSEIRO");
		// palavras.add("SABONETELIQUIDO");
		// palavras.add("TELEVISAO");
		// palavras.add("OCULOS");
		// palavras.add("APRESUNTADO");
		// palavras.add("MONITOR");
		// palavras.add("PROFESSOR");
		// palavras.add("SACOLA");
		// palavras.add("PLASTICO");
		// palavras.add("TERMICA");
		// palavras.add("TECLADO");
		// palavras.add("LENÇOL");
		// palavras.add("TRABALHO");
		// palavras.add("BIOLOGIA");
		// palavras.add("ANIVERSSÁRIO");
		// palavras.add("PÁSCOA");
		// palavras.add("INOCENTE");
		// palavras.add("CABEÇUDOEANTA");
		// palavras.add("ANIMAL");
		// palavras.add("PARA-OLIMPÍADAS");
		// palavras.add("ARLENE");
		// palavras.add("ALCELIO");
		// palavras.add("CARDIOVACULAR");
		// palavras.add("PARALELEPIPEDO");
		// palavras.add("ABESTADO");
		// palavras.add("CUIA");
		//
		//
		// for (String string : palavras) {
		// BeanItemTablePalavra item = new BeanItemTablePalavra();
		// item.setPalavra(string);
		// listaPalavras.add(item);
		// }
		//
		// txtQauntidadaPalavras.setText(String.valueOf(listaPalavras.size()));

	}

	private GridPane getPainelButton() {
		log.info("Desenhando painel de baixo.");

		if (painelButton == null) {
			painelButton = new GridPane();

			painelButton.setHgap(10);
			painelButton.setVgap(10);
			painelButton.setPadding(new Insets(10, 10, 10, 10));

			painelButton.setAlignment(Pos.BOTTOM_RIGHT);

			btnSair = new MeuBotao("Sair");

			btnSair.setFont(new Font("Ubuntu", 20));
			btnSair.setPrefSize(150, 60);
			painelButton.add(btnSair, 0, 0);
			btnSair.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					System.exit(0);

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

	private void trataEventoBotaoLimpar() {
		txtQauntidadaPalavras.clear();
		listaPalavras.clear();
		marcaTodosCheckBox();
		txtPalavra.requestFocus();
	}

	private void trataEventoBotaoExcluir() {
		listaPalavras.remove(tabela.getSelectionModel().getSelectedItem());
		txtQauntidadaPalavras.setText(String.valueOf(listaPalavras.size()));
		tabela.getSelectionModel().clearSelection();
		txtPalavra.requestFocus();

	}

	private void trataEventoBotaoCriarDiagrama() {
		
		String listaDicas="";

		try {

			testaDadosInseridos();
			

			try {
				matriz = getOperacaoes().criaMatriz(Integer.valueOf(txtLinhas.getText()),
						Integer.valueOf(txtColunas.getText()));
			} catch (Exception e) {
				throw new ScreenException("Erro ao solicitar a criação da matriz.", e);
			}

			for (BeanItemTablePalavra beanItemTablePalavra : listaPalavras) {
				matriz = getOperacaoes().escreveNaMatriz(matriz, beanItemTablePalavra.getPalavra(),
						getListaOpcoesEscrita());
					listaDicas = listaDicas + beanItemTablePalavra.getPalavra() +", ";
				
			}

			if (!getOperacaoes().getPalavrasNaoEscritas().isEmpty()) {
				System.out.println("Palavras não escritas: " + getOperacaoes().getPalavrasNaoEscritas().toString());
			}
			
			getMapParametros().put(Globais.parametroObjetivo, listaDicas);
			TelaApresentaDiagrama.abreTelaApresentacaoDiagrama(matriz);

		} catch (ScreenException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Ops...");
			alert.setContentText(e.getScreenMessage());
			alert.setHeaderText("Erro a gerar diagrama!");
			alert.showAndWait();
			txtPalavra.requestFocus();
		}

	}

	private void testaDadosInseridos() throws ScreenException {

		if (listaPalavras.isEmpty()) {
			throw new ScreenException("Cadê as palavras?");
		}

		if (getListaOpcoesEscrita().isEmpty()) {
			throw new ScreenException("Para prosseguir selecione algum tipo de escrita!");
		}

		if (StringUtils.isBlank(txtLinhas.getText()) || StringUtils.isBlank(txtColunas.getText())) {
			throw new ScreenException("Indique a quantidade de linhas/colunas.");
		}

		if (Integer.valueOf(txtLinhas.getText()).equals(ZERO) || Integer.valueOf(txtColunas.getText()).equals(ZERO)) {
			throw new ScreenException("O Valor \"ZERO\" não é permitido.");
		}
		
		if (Integer.valueOf(txtLinhas.getText()) > (new Integer(30)) || Integer.valueOf(txtColunas.getText())> (new Integer(30))) {
			throw new ScreenException("Otamanho máximo aceito é 30.");
		}

		for (BeanItemTablePalavra beanItemTablePalavra : listaPalavras) {
			if (beanItemTablePalavra.getPalavra().length() > Integer.valueOf(txtLinhas.getText())
					|| beanItemTablePalavra.getPalavra().length() > Integer.valueOf(txtColunas.getText())) {
				throw new ScreenException(
						"A palavra [" + beanItemTablePalavra.getPalavra() + "] excede o tamanho do diagrama.");

			}

		}

	}

	private void installEventHandler(final Node keyNode) {
		final EventHandler<KeyEvent> keyEventHandler = new EventHandler<KeyEvent>() {
			public void handle(final KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER) {
					trataEventoBotaoAdicionar();
				}
			}
		};

		keyNode.setOnKeyPressed(keyEventHandler);
		keyNode.setOnKeyReleased(keyEventHandler);
	}

	private List<Integer> getListaOpcoesEscrita() {
		List<Integer> lista = new ArrayList<>();

		if (cbHorizontal.isSelected()) {
			lista.add(Integer.valueOf(HORIZONTAL));
		}

		if (cbHorizontalInvertida.isSelected()) {
			lista.add(Integer.valueOf(HORIZONTAL_INVERTIDA));
		}

		if (cbVertical.isSelected()) {
			lista.add(Integer.valueOf(VERTICAL));
		}

		if (cbVerticalInvertida.isSelected()) {
			lista.add(Integer.valueOf(VERTICAL_INVERTIDA));
		}

		if (cbDiagonal.isSelected()) {
			lista.add(Integer.valueOf(DIAGONAL));
		}

		if (cbDiagonalInvertida.isSelected()) {
			lista.add(Integer.valueOf(DIAGONAL_INVERTIDA));
		}

		if (cbTransverdal.isSelected()) {
			lista.add(Integer.valueOf(TRANSVERSAL));
		}

		if (cbTransversalInvertida.isSelected()) {
			lista.add(Integer.valueOf(TRANSVERSAL_INVERTIDA));
		}
		return lista;
	}
}
