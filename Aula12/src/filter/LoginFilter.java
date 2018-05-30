package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Usuario;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/controller.do")
public class LoginFilter implements Filter {

    public LoginFilter() {  }

	public void destroy() { }

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		Usuario logado = (Usuario)session.getAttribute("logado");
		String path = req.getContextPath();
		String uri = req.getRequestURI();
		String comando = req.getParameter("command");
		
		if(comando == null) {
			comando = "";
		}/*
		else if(logado == null && !uri.equals(path + "/Login.jsp") && !comando.equals("FazerLogin")) {
			((HttpServletResponse)response).sendRedirect(path + "/Login.jsp");
		}
		else if(logado == null) {
			((HttpServletResponse)response).sendRedirect(path + "/Login.jsp");
		}/*
		else if(!uri.equals(path + "/Login.jsp")) {
			((HttpServletResponse)response).sendRedirect(path + "/Login.jsp");
		}
		else if(!uri.equals(path + "/CriarUsuario.jsp") |! !uri.equals(path + "/Login.jsp")) {
			((HttpServletResponse)response).sendRedirect(path + "/Login.jsp");
		}/*
		else if(!comando.equals("FazerLogin") || !comando.equals("CriarUsuario")) {
			if(!comando.equals("FazerLogin")) {
				((HttpServletResponse)response).sendRedirect(path + "/Login.jsp");
			}else {
				((HttpServletResponse)response).sendRedirect(path + "/CriarUsuario.jsp");
			}
		}*/
		else{
			System.out.println("---------- Logou !---------------");
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}
}