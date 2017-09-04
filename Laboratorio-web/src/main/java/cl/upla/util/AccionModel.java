package cl.upla.util;

import javax.inject.Singleton;

@Singleton
public class AccionModel {
	
	private static final String ACTION_LOGIN = "Login";
	private static final String ACTION_MENU_ADMINISTRADOR = "MenuAdministrador";
	private static final String ACTION_MENU_SUPERVISOR = "MenuSupervisor";
	private static final String ACTION_MENU_ANALISTA = "MenuAnalista";
	
	/* Constructor */
	private AccionModel() { 

	}
	/* Getters */

	public static String getActionLogin() {
		return ACTION_LOGIN;
	}

	public static String getActionMenuAdministrador() {
		return ACTION_MENU_ADMINISTRADOR;
	}

	public static String getActionMenuSupervisor() {
		return ACTION_MENU_SUPERVISOR;
	}

	public static String getActionMenuAnalista() {
		return ACTION_MENU_ANALISTA;
	}
	

}
