package br.com.project.controller.geral;

import java.util.HashMap;
import javax.faces.bean.ApplicationScoped;
import javax.servlet.http.HttpSession;

@ApplicationScoped
public class SessionControllerImpl implements SessionController{

	private static final long serialVersionUID = 1L;

	private HashMap<String, HttpSession> hashMap = new HashMap<String,HttpSession>();
	
	@Override
	public void addSession(String keyLoginUser, HttpSession httpSession) {
		
		hashMap.put(keyLoginUser, httpSession);
		
	}

	@Override
	public void invalidateSession(String keyLoginUser) {
		
		HttpSession session = hashMap.get(keyLoginUser);
		if(session != null){//remove sess�o do usu�rio passado como parametro
		
			try{
				session.invalidate();
			}catch(Exception erro){
				erro.printStackTrace();
			}
			
		}else{
			
			System.out.println("n�o tem usuario");
		}
		
		
		hashMap.remove(keyLoginUser);
		
	}
	
	
	
}