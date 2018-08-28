package Util;

import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.rmi.CORBA.Util;

import Logger.ALogger;

public class DateUtil {
	
	private static ALogger log = ALogger.getLogger(Util.class);
	
	
	static SimpleDateFormat dataHora;
	static SimpleDateFormat data;
	static SimpleDateFormat hora;
	static NumberFormat doisDigitos;

	static {
		dataHora = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		data = new SimpleDateFormat("dd/MM/yyyy");
		hora = new SimpleDateFormat("hh:mm:ss");
		doisDigitos = new DecimalFormat("###,##0,00");
	}

	
	/**
	 * Retorna a diferença do número de dias entre as datas
	 */
	public static Integer diffInDays(Date date1, Date date2) {
		Long dias = 0l;
		if (date1 != null && date2 != null) {
			long diff = 0l;
			if (date2.compareTo(date1) > 0)
				diff = date2.getTime() - date1.getTime();
			else
				diff = date1.getTime() - date2.getTime();
			dias = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
		}
		return dias.intValue();
	}
	
	/**
	 * Retorna a escrita do dia da semana, conforme número do dia da semana (Ex: 'Domingo' para 1, 'Segunda' p/2, etc.)
	 */
	public static String weekNameByNumber(Integer weekDay) {
		try {
			return new DateFormatSymbols().getWeekdays()[weekDay];
		} catch (Exception e) {
			return String.valueOf(weekDay);
		}
	}
	
	/**
	 * Converte uma data em string para um  @Date
	 * @param date 
	 * @return
	 * @throws Exception
	 */
	public static Date getConverteStringToDate(String date) throws Exception{
		Date dta = new Date();
		
		if(!date.equals(null)){
			try {
				dta = data.parse(date);
			} catch (ParseException e) {
				log.error("Erro ao converter uma string para data.");
			}
		}
		
		
		return dta;
		
	}
	/**
	 * Retora uma string com data e hora formato: dd/MM/yyyy hh:mm:ss 
	 * @param dt
	 * @return
	 */
	public static String getDataHora(Date dt) {
		return dataHora.format(dt);
	}

	/**
	 * Retorna uma string no formato data: dd/MM/yyyy
	 * @param dt
	 * @return
	 */
	public static String getData(Date dt) {
		return data.format(dt);

	}

	/**
	 * Retorna uma string no formato hora: hh:mm:ss
	 * @param dt
	 * @return
	 */
	public static String getHora(Date dt) {
		return hora.format(dt);

	}

	
}