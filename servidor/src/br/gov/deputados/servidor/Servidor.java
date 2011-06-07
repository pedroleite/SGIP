package br.gov.deputados.servidor;

import java.io.IOException;

import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

public class Servidor {

	public static void main(String[] args) throws IOException {
		HttpServer server = HttpServerFactory.create("http://localhost:8080/");
		server.start();

		System.out.println("Servidor rodando ....");
		System.in.read();
		server.stop(0);
		System.out.println("Servidor parou ....");
	}
}
