package customizados;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class MeuBotao extends Button {
	static StringBuilder estilo;
	static StringBuilder estiloEntered;
	static StringBuilder estiloExitded;
	static StringBuilder EstiloClicked;
	static {

		estilo = new StringBuilder();
		estilo.append("-fx-background-color:#090a0c,");
		estilo.append("linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),");
		estilo.append("linear-gradient(#20262b, #191d22),");
		estilo.append("radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9),");
		estilo.append("rgba(255,255,255,0));");
		estilo.append("-fx-background-radius: 5,4,3,5;");
		estilo.append("-fx-background-insets: 0,1,2,0;");
		estilo.append("-fx-text-fill: white;");
		estilo.append("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 ,0,1 );");
		estilo.append("-fx-font-family: \"Ubuntu\";");
		estilo.append("-fx-text-fill: linear-gradient(white, #d0d0d0);");
		estilo.append("-fx-font-size: 16px;");
		estilo.append("-fx-padding: 10 20 10 20;");

		estiloExitded = new StringBuilder();
		estiloExitded.append("-fx-background-color:#090a0c,");
		estiloExitded.append("linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),");
		estiloExitded.append("linear-gradient(#20262b, #191d22),");
		estiloExitded.append("radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9),");
		estiloExitded.append("rgba(255,255,255,0));");
		estiloExitded.append("-fx-background-radius: 5,4,3,5;");
		estiloExitded.append("-fx-background-insets: 0,1,2,0;");
		estiloExitded.append("-fx-text-fill: white;");
		estiloExitded.append("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 ,0,1 );");
		estiloExitded.append("-fx-font-family: \"Ubuntu\";");
		estiloExitded.append("-fx-text-fill: linear-gradient(white, #d0d0d0);");
		estiloExitded.append("-fx-font-size: 16px;");
		estiloExitded.append("-fx-padding: 10 20 10 20;");

		estiloEntered = new StringBuilder();
		estiloEntered.append("-fx-background-color: #090a0c, ");
		estiloEntered.append("linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),");
		estiloEntered.append("linear-gradient(#20262b, #191d22),");
		estiloEntered.append("radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9),");
		estiloEntered.append("rgba(255,255,255,0));");
		estiloEntered.append("-fx-background-radius: 5,4,3,5;");
		estiloEntered.append("-fx-background-insets: 0,1,2,0;");
		estiloEntered.append("-fx-text-fill: white;");
		estiloEntered.append("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 ,0,1 );");
		estiloEntered.append("-fx-font-family: \"Ubuntu\";");
		estiloEntered.append("-fx-text-fill: linear-gradient(white, #d0d0d0);");
		estiloEntered.append("-fx-font-size: 16px;");
		estiloEntered.append("-fx-padding: 10 20 10 20;");
		estiloEntered.append("-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 );");

		EstiloClicked = new StringBuilder();
		EstiloClicked.append("-fx-background-color: #090a0c, ");
		EstiloClicked.append("linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),");
		EstiloClicked.append("linear-gradient(#20262b, #191d22),");
		EstiloClicked.append("radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9),");
		EstiloClicked.append("rgba(255,255,255,0));");
		EstiloClicked.append("-fx-background-radius: 5,4,3,5;");
		EstiloClicked.append("-fx-background-insets: 0,1,2,0;");
		EstiloClicked.append("-fx-text-fill: white;");
		EstiloClicked.append("-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 ,0,1 );");
		EstiloClicked.append("-fx-font-family: \"Ubuntu\";");
		EstiloClicked.append("-fx-text-fill: linear-gradient(white, #d0d0d0);");
		EstiloClicked.append("-fx-font-size: 16px;");
		EstiloClicked.append("-fx-padding: 10 20 10 20;");
		EstiloClicked.append("-fx-effect: dropshadow( one-pass-box , rgba(0,0,0,0.9) , 1, 0.0 , 0 , 1 );");

	}

	public MeuBotao(String caption) {
		// TODO Auto-generated constructor stub
		this.setText(caption);
		this.setPrefSize(200, 40);

		this.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStyle(estiloEntered.toString());
			}
		});

		this.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				// final DropShadow shadow = new DropShadow();
				// shadow.setColor(Color.WHITE);
				// setEffect(shadow);
				setStyle(estiloExitded.toString());
			}
		});

		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setStyle(EstiloClicked.toString());
			}
		});

		setStyle(estilo.toString());

	}

}
