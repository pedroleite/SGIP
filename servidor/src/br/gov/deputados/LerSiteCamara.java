package br.gov.deputados;

import java.util.ArrayList;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class LerSiteCamara {

	private static ArrayList<Deputado> listaDeputados = null;

	public static void main(String[] args) throws Exception {
		new LerSiteCamara().getDeputadosSitCamara();
	}

	public ArrayList<Deputado> getDeputadosSitCamara() throws Exception {
		if (listaDeputados == null) {
			montaListaDeputado();
		}

		return listaDeputados;
	}

	public void montaListaDeputado() throws Exception {
		listaDeputados = new ArrayList<Deputado>();
		WebClient webClient = new WebClient();

		HtmlPage page = null;
		try {
			page = (HtmlPage) webClient
					.getPage("http://www.camara.gov.br/internet/deputado/Dep_Lista.asp?Legislatura=51&Partido=QQ&SX=QQ&Todos=None&UF=QQ&condic=QQ&forma=lista&nome=&ordem=nome&origem=");

		} catch (Exception e) {
			// TODO: handle exception
		}

		HtmlElement elemento = (HtmlElement) page.getHtmlElementById("content");

		Iterable<HtmlElement> allHtmlChildElements = elemento
				.getChildElements();

		for (HtmlElement htmlElement : allHtmlChildElements) {
			Deputado deputado = new Deputado();

			int fim = 0;
			boolean isDeputadoValido = false;
			String linha = htmlElement.asText();
			if (linha.contains("Gabinete")) {
				isDeputadoValido = true;
				deputado.setDeputadoEmExercicio(true);
				fim = linha.indexOf("\r\n");
				deputado.setNome(linha.substring(0, fim));

				linha = linha.substring(fim + 2);

				fim = linha.indexOf("\r\n");

				deputado.setEmail(linha.substring(fim + 2));

				linha = linha.substring(0, fim);
				String[] subLinha = linha.split(":");

				String[] partidoEsdado = subLinha[1].split("/");
				
				deputado.setPartido(partidoEsdado[0]);
				deputado.setEstado(partidoEsdado[1].split("-")[0]);
				
				deputado.setGabiente(subLinha[3]);
				deputado.setTelefoneGabinete(subLinha[5]);
			} else if (linha.contains("licenciado")) {
				isDeputadoValido = true;
				deputado.setDeputadoEmExercicio(false);
				fim = linha.indexOf("\r\n");
				deputado.setNome(linha.substring(0, fim));
				linha = linha.substring(fim + 2);
				String[] partidoEsdado = linha.split(":")[1].split("/");
				deputado.setPartido(partidoEsdado[0]);
				String[] estado = partidoEsdado[1].split(" ");
				deputado.setEstado(estado[0]);

			}
			if (isDeputadoValido) {
				listaDeputados.add(deputado);
			}
		}

	}

}
