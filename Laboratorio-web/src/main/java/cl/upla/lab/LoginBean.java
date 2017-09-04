package cl.upla.lab;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import cl.upla.lab.ejb.LoginEjb;
import cl.upla.util.AccionModel;
import cl.upla.util.Utilidades;

@ManagedBean (name = "loginBean")
public class LoginBean {

	private static Logger log = Logger.getLogger(LoginBean.class);
	
	@EJB
	private LoginEjb loginEjb;
	
	@Inject
	private Utilidades utilidades;
	
	public Login login;
	
	public Usuarios usuario;
	
	public LoginBean(){
		login = new Login();
		usuario = new Usuarios();
	}
	
	public String validarLogin(){
		log.debug("inicio metodo crear usuario");
		if(login.getUsuario()!= null && !login.getUsuario().isEmpty()){
			if (login.getPassword()!= null && !login.getPassword().isEmpty()){
				usuario = loginEjb.validarLogin(login);
				if(usuario != null){
					switch (usuario.getNivel()) {
					case 0:
						log.error("Usuario desactivado");
						this.utilidades.addMsg("Login Error", "Usuario desactivado, Favor contactar al administrador", FacesMessage.SEVERITY_ERROR);
					break;
					case 1:
						log.debug("Usuario Administrador");
						this.utilidades.addMsg("Login Correcto", "Usuario Administrador", FacesMessage.SEVERITY_INFO);
						return AccionModel.getActionMenuAdministrador();
					case 2:
						log.debug("Usuario Supervisor");
						this.utilidades.addMsg("Login Correcto", "Usuario Supervisor", FacesMessage.SEVERITY_INFO);
						return AccionModel.getActionMenuAdministrador();
					case 3:
						log.debug("Usuario Analista");	
						this.utilidades.addMsg("Login Correcto", "Usuario Analista", FacesMessage.SEVERITY_INFO);
						return AccionModel.getActionMenuAdministrador();
					default:
						log.error("Usuario desactivado");
						this.utilidades.addMsg("Login Error", "Usuario desactivado", FacesMessage.SEVERITY_ERROR);
					}
				}else{
					log.error("Usuario y/o password incorrectos");
					this.utilidades.addMsg("Login Error", "Usuario y/o password incorrectos", FacesMessage.SEVERITY_ERROR);
				}
			}else{
				log.error("Debe ingresar una password");
				this.utilidades.addMsg("Login Error", "Debe ingresar una password", FacesMessage.SEVERITY_ERROR);
			}
		}else{
			log.error("Debe ingresar un usuario");
			this.utilidades.addMsg("Login Error", "Debe ingresar una usuario", FacesMessage.SEVERITY_ERROR);
		}
		log.debug("fin metodo crear usuario");
		return null;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public Usuarios getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}

	public LoginEjb getLoginEjb() {
		return loginEjb;
	}

	public void setLoginEjb(LoginEjb loginEjb) {
		this.loginEjb = loginEjb;
	}
}
