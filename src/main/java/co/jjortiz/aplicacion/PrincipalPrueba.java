package co.jjortiz.aplicacion;

import co.jjortiz.dao.UsuariosDAO;

public class PrincipalPrueba {

	public static void main(String[] args) {
		UsuariosDAO u = new UsuariosDAO();
		u.consultarLoginUsuario("1","1");
	}
}
