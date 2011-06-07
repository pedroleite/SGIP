package br.gov.deputados;

import java.util.HashMap;
import java.util.Map;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class LerSiteTerraEleicoes2010 {

	public Map<String, String> mapEstados = new HashMap<String, String>();

	{
		mapEstados.put("AC", "acre");
		mapEstados.put("AL", "alagoas");
		mapEstados.put("AP", "amapa");
		mapEstados.put("AM", "amazonas");
		mapEstados.put("BA", "bahia");
		mapEstados.put("CE", "ceara");
		mapEstados.put("DF", "distrito-federal");
		mapEstados.put("ES", "espirito-santo");
		mapEstados.put("GO", "goias");
		mapEstados.put("MA", "maranhao");
		mapEstados.put("MT", "mato-grosso");
		mapEstados.put("MS", "mato-grosso-do-sul");
		mapEstados.put("MG", "minas-gerais");
		mapEstados.put("PA", "para");
		mapEstados.put("PB", "paraiba");
		mapEstados.put("PR", "parana");
		mapEstados.put("PE", "pernambuco");
		mapEstados.put("PI", "piaui");
		mapEstados.put("RJ", "rio-de-janeiro");
		mapEstados.put("RN", "rio-grande-do-norteR");
		mapEstados.put("RS", "rio-grande-do-sul");
		mapEstados.put("RO", "rondonia");
		mapEstados.put("RR", "roraima");
		mapEstados.put("SC", "santa-catarina");
		mapEstados.put("SE", "sergipe");
		mapEstados.put("SP", "sao-paulo");
		mapEstados.put("TO", "tocantins");

	}

	public static void main(String[] args) throws Exception {
		new LerSiteTerraEleicoes2010().getDeputadosEleicoes2010();
	}

	public void getDeputadosEleicoes2010() throws Exception {
		WebClient webClient = new WebClient();

		HtmlPage page = null;
		try {
			page = (HtmlPage) webClient
					.getPage("http://eleicoes.terra.com.br/apuracao/2010/1turno/acre/#/deputado-federal/");

		} catch (Exception e) {

		}

		HtmlElement elemento = (HtmlElement) page
				.getHtmlElementById("mod-482-gov");

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
		}
	}

}
