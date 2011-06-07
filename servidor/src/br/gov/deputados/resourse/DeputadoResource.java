package br.gov.deputados.resourse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.ProduceMime;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import br.gov.deputados.Deputado;
import br.gov.deputados.LerSiteCamara;

@Path("/deputados")
public class DeputadoResource {
	private static Map<String, Deputado> mapaDeputados = new HashMap<String, Deputado>();
	private static ArrayList<Deputado> listaDeputado;
	public DeputadoResource() {
		LerSiteCamara siteCamara = new LerSiteCamara();
		try {
			listaDeputado = siteCamara.getDeputadosSitCamara();

			for (Deputado deputado : listaDeputado) {
				if (deputado.getNome() != null
						&& !deputado.getNome().equals(""))
					mapaDeputados.put(deputado.getNome(), deputado);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access")
	@GET
	@ProduceMime( { "application/json" })
	@Path("{nome}")
	public JSONObject getDeputado(@PathParam("nome") String nome)
			throws JSONException {
		Deputado deputado = this.mapaDeputados.get(nome);
		return new JSONObject().put("nome", deputado.getNome()).put("partido",
				deputado.getPartido());
	}

	@GET
	@ProduceMime( { "application/json" })
	public JSONObject getDeputados() throws JSONException {
		JSONObject object = new JSONObject();
		object.put("tamanho", listaDeputado.size());
		int count = 0;
		for (Deputado deputado : listaDeputado) {

			object.put("deputado"+count, new JSONObject().put(
					"nome", deputado.getNome()).put("partido",
					deputado.getPartido()).put("estado",
							deputado.getEstado()));
			count++;
		}
		return object;
	}
}