import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class TesteGson {

	static final String dado = "[\n" + 
			"	{ \"numero\": \"00000.000000/0000-00\", \"finalidade\": \"Pesquisa em regime de contenção \", \"numeroCqb\": \"089/2017\", \"numeroProcesso\": \"103256/2017\", \"urgencia\": \"Sim\", \"sigilo\": \"Sim\", \"ultimaSolicitacao\": \"Extensão de CQB\", \"dataSolicitacao\": \"30/10/2017\",\"ultimaSolicitacao\": \"30/10/2017\", \"situacao\": \"Definição de Relator\" },\n" + 
			"	{ \"numero\": \"00000.000000/0000-00\", \"finalidade\": \"Ensino - Uso Comercial\", \"numeroCqb\": \"079/2017\", \"numeroProcesso\": \"103256/2017\", \"urgencia\": \"Não\", \"sigilo\": \"Sim\", \"ultimaSolicitacao\": \"Novo CQB\", \"dataSolicitacao\": \"30/10/2017\",\"ultimaSolicitacao\": \"30/10/2017\", \"situacao\": \"Deliberação\" },\n" + 
			"	{ \"numero\": \"00000.000000/0000-00\", \"finalidade\": \"Transporte - Armazenamento\", \"numeroCqb\": \"005/2017\", \"numeroProcesso\": \"103256/2017\", \"urgencia\": \"Sim\", \"sigilo\": \"Não\", \"ultimaSolicitacao\": \"Extensão de CQB\", \"dataSolicitacao\": \"30/10/2017\",\"ultimaSolicitacao\": \"30/10/2017\", \"situacao\": \"Informação Complementar\" },\n" + 
			"	{ \"numero\": \"00000.000000/0000-00\", \"finalidade\": \"Descarte\", \"numeroCqb\": \"012/2017\", \"numeroProcesso\": \"103256/2017\", \"urgencia\": \"Sim\", \"sigilo\": \"Sim\", \"ultimaSolicitacao\": \"Novo CQB\", \"dataSolicitacao\": \"30/10/2017\",\"ultimaSolicitacao\": \"30/10/2017\", \"situacao\": \"Cancelado\" },\n" + 
			"	{ \"numero\": \"00000.000000/0000-00\", \"finalidade\": \"Outras - Transporte\", \"numeroCqb\": \"096/2017\", \"numeroProcesso\": \"103256/2017\", \"urgencia\": \"Não\", \"sigilo\": \"Sim\", \"ultimaSolicitacao\": \"Extensão de CQB\", \"dataSolicitacao\": \"30/10/2017\",\"ultimaSolicitacao\": \"30/10/2017\", \"situacao\": \"Deferido\" }\n" + 
			"]\n";
	
	public static void main(String[] args) {
		Gson g = new Gson();
		
		List<Ver> list = g.fromJson(dado, new TypeToken<List<Ver>>(){}.getType());
		for (Ver ver : list) {
			System.out.println(ver);
		}
	}
	
	class Ver{
		String numero;
		String finalidade;
		
		public String toString() {
			return numero+": "+finalidade;

		}
	}
}
