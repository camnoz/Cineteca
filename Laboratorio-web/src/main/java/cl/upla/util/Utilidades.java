package cl.upla.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Singleton;

@Singleton
public class Utilidades {
	
	/**
	 *  Metodo que Muestra pop-up de error/informacion al usuario 
	 */
	public void addMsg(String tituloMensaje, String descripcionMensaje, FacesMessage.Severity severity) {
		FacesMessage popup = new FacesMessage(severity, tituloMensaje, descripcionMensaje);
		FacesContext.getCurrentInstance().addMessage(null, popup);
	}
	
	/** 
	 * Metodo que Retorna TRUE si el objeto es igual a NULL, FALSE en caso contrario 
	 */
	public boolean isNull(Object object){
		return object == null ? true : false;
	}
	
	/**
	 * Metodo que Devuelve defaultValue si objeto es nulo, valor del objeto concatenado en caso contrario 
	 */
	public String concatenatedValueIfNotNull(Object object, Object concatenation, Object defaultValue) {
		return object != null ? String.valueOf(object) + String.valueOf(concatenation) : String.valueOf(defaultValue);
	}
}
