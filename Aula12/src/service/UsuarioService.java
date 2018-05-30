package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	UsuarioDAO dao = new UsuarioDAO();
	
	public void novoUsuario(Usuario usuario) {
		try {
			dao.novoUsuario(usuario);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean validar(Usuario usuario) {
		return dao.validar(usuario);
	}
}
