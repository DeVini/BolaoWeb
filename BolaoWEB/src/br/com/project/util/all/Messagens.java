package br.com.project.util.all;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class Messagens extends FacesContext implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Messagens() {
		// TODO Auto-generated constructor stub
	}
	
	public static void responseOperation(EstatusPersistencia status){
		if(status != null && status.equals(EstatusPersistencia.SUCESSO)){
			sucesso();
		}else if(status != null  && status.equals(EstatusPersistencia.OBJETO_REFERENCIADO))
		{
			msgSeverityFatal(EstatusPersistencia.OBJETO_REFERENCIADO.toString());
		}else{
			erroNaOperacao();
		}
	}
	
	public static void erroNaOperacao(){
		if(facesContextValido()){
			msgSeverityFatal(Constante.ERRO_NA_OPERACAO);
		}
	}
	
	public static void sucesso(){
			msgSeverityFatal(Constante.SUCESSO);
	}
	
	public static void msg(String msg){
		if(facesContextValido()){
				getFacesContext().addMessage("msg", new FacesMessage(msg));
		}
	}
	
	public static FacesContext getFacesContext(){
		return FacesContext.getCurrentInstance();
	}

	private static boolean facesContextValido(){
		return getFacesContext() != null;
	}
	
	public static void msgSeverityWarn(String msg){
		if(facesContextValido()){
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_WARN, msg, msg));
		}
	}
	
	public static void msgSeverityFatal(String msg){
		if(facesContextValido()){
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_FATAL, msg, msg));
		}
	}
	
	public static void msgSeverityError(String msg){
		if(facesContextValido()){
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
		}
	}
	
	public static void msgSeverityInfo(String msg){
		if(facesContextValido()){
			getFacesContext().addMessage("msg", new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
		}
	}
}
