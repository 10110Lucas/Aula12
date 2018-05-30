package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;
import service.UsuarioService;

public class CriarUsuario implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		
		String sNome = request.getParameter("Login");
		if(sNome != null ) {
			System.out.println("--------------- Classe CriarUsuario ----");
		}
		String sSenha = request.getParameter("Senha");
		
		Usuario usuario = new Usuario();
		usuario.setNome(sNome);
		usuario.setSenha(sSenha);
		
		UsuarioService service = new UsuarioService();
		service.novoUsuario(usuario);
		boolean valida = service.validar(usuario);
		if(valida == true) {
			HttpSession session = request.getSession();
			session.setAttribute("logado", usuario);
			System.out.println("\n------ Logou" + usuario);
		}
		response.sendRedirect("index.jsp");
	}
}
