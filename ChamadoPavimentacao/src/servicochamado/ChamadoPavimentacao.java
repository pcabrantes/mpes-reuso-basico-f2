package servicochamado;

import java.util.HashMap;
import java.util.Map;

import servico.IServicoChamado;

public class ChamadoPavimentacao implements IServicoChamado {

	@Override
	public String getSigla() {
		return "PP";
	}

	@Override
	public String getDescricao() {
		return "Pavimentação Pública";
	}

	@Override
	public Map<String, String> getAtributosInput() {

		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put("descricao", "text");
		atributos.put("latitude", "double");
		atributos.put("longitude", "double");
		return atributos;
	}

}
