package br.com.am.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.am.bo.CadastroBO;
import br.com.am.dao.RecuperarSenhaDAO;

@WebServlet(urlPatterns = "/recuperarSenha")
public class RecuperarSenha extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String filme = req.getParameter("filme");
		String email = req.getParameter("email");
		String novaSenha = req.getParameter("novaSenha");
		
		RecuperarSenhaDAO rsenha = null;
		
		try {
			 rsenha = new RecuperarSenhaDAO();
			 	int id = rsenha.retornaID(email);
			 	
			 	String retorno = rsenha.retornarRSeguranca(email);
			 	if(retorno == null) {
			 		req.setAttribute("emailInexistente", "E-mail não cadastrado!");
			 			RequestDispatcher dispatcher = req.getRequestDispatcher("recuperarSenha.jsp");
			 				dispatcher.forward(req, resp);
			 	}else
					if(retorno.equals(filme)) {
						rsenha.novaSenha(id, novaSenha);
						
					} else {
						req.setAttribute("erro", "e-mail ou resposta incorreta! Digite novamente");
							RequestDispatcher dispatcher = req.getRequestDispatcher("recuperarSenha.jsp");
								dispatcher.forward(req, resp);
					}
	}catch(Exception e){
			e.printStackTrace();
		}finally {
			try {
				rsenha.encerrar();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
}
