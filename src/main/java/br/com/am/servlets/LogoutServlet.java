package br.com.am.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.am.excecoes.Excecao;

@WebServlet(urlPatterns = "/logout")
public class LogoutServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) {
		HttpSession session = req.getSession();
		session.invalidate();
		try {
			req.getRequestDispatcher("login.jsp").forward(req, resp);
		} catch (Exception e) {
			new Excecao("O usuário não foi deslogado");
			new Excecao(e);
		}

	}
}
