package br.com.bahia.backend.notificacao.util;

public class Validador {
	
	public static boolean valideNotNullAndNotBlank(String s) {
		if(s == null || s.isBlank()) {
			return false;
		}
		return true;
	}
	
	public static boolean valideNotNullAndNotBlank(Integer s) {
		if(s == null) {
			return false;
		}
		return true;
	}

}
