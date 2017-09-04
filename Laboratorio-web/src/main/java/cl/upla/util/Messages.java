package cl.upla.util;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import javax.inject.Singleton;

import org.apache.log4j.Logger;

@Singleton
public class Messages {
	
	/**
	 *  Instancia para escribir en el log
	 */
	private static Logger log = Logger.getLogger(Messages.class);
	
	/**
	 *  Variable final del tipo cadena de caracteres que permite manejar la ubicacion del archivo properties
	 */
	private static final String BUNDLE_NAME = "cl.upla.properties.mensajes_esp";
	
	/**
	 *  Variable final del tipo cadena de caracteres que permite manejar el recurso
	 */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
	
	/**
	 *  Constructor 
	 */
	private Messages() {
		
	}
	
	/**
	 * Metodo para el manejo de bundle 
	 * @param key Parametro de entrada del identificador
	 * @return Retorno de valores del archivo
	 */
	public String show(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
			
		} catch (MissingResourceException e) {
			log.error("Error obteniendo key "+key+": ");
			log.error(e);
			return "";
		}
	}
}
