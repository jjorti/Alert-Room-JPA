package co.jjortiz.aplicacion;

import co.jjortiz.dao.UsuariosDAO;

public class Principal {

	public static void main(String[] args) {
		
		UsuariosDAO miUsuarioDao=new UsuariosDAO();
		
		miUsuarioDao.consultarLoginUsuario("111", "111");
	
	}

}
