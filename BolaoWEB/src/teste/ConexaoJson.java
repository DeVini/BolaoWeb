package teste;

import java.io.IOException;
import java.text.ParseException;
import org.json.JSONException;
import br.com.brasileirao.controller.StrutureFacade;
import br.com.brasileirao.enums.ServicesEnum;
import br.com.brasileirao.exception.ConnectionErrorException;
import br.com.brasileirao.model.Campeonato;

public class ConexaoJson {

	public static void main(String[] args) {
		
		try {
			
			StrutureFacade<Campeonato> facade = new StrutureFacade<Campeonato>();
			Campeonato campeonato = facade.returnObjects(ServicesEnum.UOL);
			System.out.println(campeonato.getAgrupamento().getEquipes().size());
			
		} catch (JSONException | IOException | ParseException | ConnectionErrorException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
