package customizados;

import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MinhaLabel extends Label {

	private static StringBuilder estilo;
	static {
		estilo = new StringBuilder();
		estilo.append("color: rgba(0,0,0,0.6);");
		estilo.append("-fx-effect: dropshadow 2px 8px 6px rgba(0,0,0,0.2), 10, 0, 0, 0;");
		// estilo.append("0px -5px 35px rgba(255,255,255,0.3);");

		// -fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0, 0, 0);
	}

	public MinhaLabel(String texto) {
		// TODO Auto-generated constructor stub
		this.setText(texto);
		this.setFont(new Font("Ubuntu", 30));
		// this.setPadding(new Insets(10));
		this.setTextFill(Color.WHITE);
		// this.setStyle(estilo.toString());

	}

}
