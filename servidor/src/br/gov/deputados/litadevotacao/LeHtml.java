package br.gov.deputados.litadevotacao;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

import com.linuxense.javadbf.DBFException;
import com.linuxense.javadbf.DBFReader;

public class LeHtml {

	private static ArrayList<LinhaDocumento> listaDocumento = new ArrayList<LinhaDocumento>();
	
	public static void main(String[] args) throws HttpException, IOException {
		String url = "http://www.camara.gov.br/internet/votacaodbf/54Primeira/CD110074.dbf";

		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod(url);
		client.executeMethod(get);
		try {

			DBFReader reader = new DBFReader(get.getResponseBodyAsStream());

			Object[] rowObjects;

			while ((rowObjects = reader.nextRecord()) != null) {


				
				listaDocumento.add(new LinhaDocumento(rowObjects[0].toString().trim(),
						rowObjects[1].toString().trim(), rowObjects[2].toString().trim()
								.equals("PRESENTE"), (String) rowObjects[3],
						 rowObjects[4].toString().trim()));

				
			}
			
			
			for (LinhaDocumento linhaDocumento : listaDocumento)
         {
			   System.out.println(linhaDocumento.getEstado()+""+linhaDocumento.isEstavaPresente());
         }
		
		} catch (DBFException e) {

			System.out.println(e.getMessage());
		} catch (IOException e) {

			System.out.println(e.getMessage());
		}
	}
}

// System.out.println(response);

