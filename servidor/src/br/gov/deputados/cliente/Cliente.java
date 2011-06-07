package br.gov.deputados.cliente;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

public class Cliente {

	public static void main(String[] args) throws HttpException, IOException {

	//String url = "http://localhost:8080/deputados/RUY CARNEIRO";
		String url = "http://localhost:8080/deputados";
		
		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(url);
		client.executeMethod(get);
		
		String response = get.getResponseBodyAsString();

		System.out.println(response);
		
	}

}
