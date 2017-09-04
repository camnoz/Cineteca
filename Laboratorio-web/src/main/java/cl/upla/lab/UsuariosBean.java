package cl.upla.lab;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import org.apache.ibatis.session.SqlSession;
import cl.upla.mybatis.config.MyBatisUtil;

@ManagedBean (name = "usuariosBean")
public class UsuariosBean {
	
	public Usuarios usuario;
	
	public UsuariosBean(){
		usuario = new Usuarios();
	}

	public void crearUsuario(){
		System.out.println("inicio metodo crear usuario");
		SqlSession session = new MyBatisUtil().getSession();
		if (session != null){
			try{
				session.insert("UsuariosMapper.crearUsuario", usuario);
				session.commit();
			}finally{
				session.close();
			}
		}else{
			System.out.println("Error session");
		}
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Contacto Creado"));
		System.out.println("fin metodo crear usuario");
	}


	public Usuarios getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}
}
