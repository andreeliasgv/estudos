package br.com.aplcurso.controller.estado;

import br.com.aplcurso.dao.EstadoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstadoVerificarSigla", urlPatterns = {"/EstadoVerificarSigla"})
public class EstadoVerificarSigla extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json;charset=iso-8859-1");
        try {
            EstadoDAO dao = new EstadoDAO();
            String sigla = request.getParameter("siglaEstado");
            int id = Integer.parseInt(request.getParameter("id"));
            if (dao.siglaExiste(sigla, id)) {
                response.getWriter().write("1");
            } else {
                response.getWriter().write("0");
            }
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao verificar sigla! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}