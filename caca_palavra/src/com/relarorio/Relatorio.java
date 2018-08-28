package com.relarorio;

import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Beans.BeanDadosMatriz;
import Util.DateUtil;
import Util.Globais;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class Relatorio {

	private static Map<String, Object> parametros;

	public static HashMap<String, Object> getMapParametros() {

		if (parametros == null) {
			parametros = new HashMap<String, Object>();
		}
		return (HashMap<String, Object>) parametros;
	}
	
	

	public void geraRelarotioCompleto(List<BeanDadosMatriz> lista) throws JRException {

		getMapParametros().put(Globais.parametroNumColunas, lista.size());

		getMapParametros().put(Globais.parametroDataImpressao, DateUtil.getDataHora(new Date()));
		

		InputStream arq = Relatorio.class.getResourceAsStream("/Relatorio/relatorio.jasper");

		JasperPrint print = JasperFillManager.fillReport(arq, getMapParametros(),
				new JRBeanCollectionDataSource(lista));

		JasperViewer.viewReport(print, false);
		
		//JasperPrintManager.printPage(print, 0, true);
		//JasperExportManager.exportReportToPdf(print);

		
//		InputStream arq = Relatorio.class.getResourceAsStream("/Relatorio/relatorio.jrxml");
//
//		JasperReport report = JasperCompileManager.compileReport(arq);
//
//		JasperPrint print = JasperFillManager.fillReport(report, getMapParametros(),
//				new JRBeanCollectionDataSource(lista));
//
//		JasperViewer.viewReport(print, false);

	}
	
	public void geraRelarotioGabarito(List<BeanDadosMatriz> lista) throws JRException {

		getMapParametros().put(Globais.parametroNumColunas, lista.size());
		
		InputStream arq = Relatorio.class.getResourceAsStream("/Relatorio/gabarito.jasper");


		JasperPrint print = JasperFillManager.fillReport(arq, getMapParametros(),
				new JRBeanCollectionDataSource(lista));

		JasperViewer.viewReport(print, false);

		//JasperPrintManager.printPage(print, 0, true);
		
		
//		InputStream arq = Relatorio.class.getResourceAsStream("/Relatorio/gabarito.jrxml");
//
//		JasperReport report = JasperCompileManager.compileReport(arq);
//
//		JasperPrint print = JasperFillManager.fillReport(report, getMapParametros(),
//				new JRBeanCollectionDataSource(lista));
//
//		JasperViewer.viewReport(print, false);

	}

}
