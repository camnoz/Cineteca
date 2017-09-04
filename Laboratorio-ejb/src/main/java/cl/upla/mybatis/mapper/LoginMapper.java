package cl.upla.mybatis.mapper;

import cl.upla.lab.Login;
import cl.upla.lab.Usuarios;

public interface LoginMapper {

	public Usuarios validarLogin(Login login);
}
