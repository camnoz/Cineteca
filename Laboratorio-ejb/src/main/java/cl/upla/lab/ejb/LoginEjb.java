package cl.upla.lab.ejb;

import javax.ejb.Stateless;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cl.upla.lab.Login;
import cl.upla.lab.Usuarios;
import cl.upla.mybatis.config.MyBatisUtil;

@Stateless
public class LoginEjb {

	private static Logger log = Logger.getLogger(LoginEjb.class);

	public Usuarios validarLogin(Login login) {
		Usuarios usuario = null;
		SqlSession session = new MyBatisUtil().getSession();
		if (session != null){
			try{
				usuario = session.selectOne("LoginMapper.validarLogin", login);
			}finally{
				session.close();
			}
		}else{
			log.error("Error session");
		}
		return usuario;
	}
	
}
