package br.com.bahia.backend.notificacao.handler;

public class ErrorInfo {
	
	public final String url;
	public final String exception;
	
	public ErrorInfo(String url, String exception) {
		this.url = url;
		this.exception = exception;
	}
	
}
