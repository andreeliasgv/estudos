package br.com.aplcurso.controller.estado;

import br.com.aplcurso.dao.EstadoDAO;
import br.com.aplcurso.model.Estado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EstadoCadastrar", urlPatterns = {"/EstadoCadastrar"})
public class EstadoCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        try {
            EstadoDAO dao = new EstadoDAO();

            int id = Integer.parseInt(request.getParameter("id"));
            String nomeEstado = request.getParameter("nomeEstado");
            String siglaEstado = request.getParameter("siglaEstado").toUpperCase().trim();

            if (nomeEstado == null || nomeEstado.isBlank() || siglaEstado.isEmpty()) {
                response.getWriter().write("4");
            } else if (dao.siglaExiste(siglaEstado, id)) {
                response.getWriter().write("3");
            } else {
                Estado oEstado = new Estado();
                oEstado.setId(id);
                oEstado.setNomeEstado(nomeEstado.toUpperCase().trim());
                oEstado.setSiglaEstado(siglaEstado);

                if (dao.cadastrar(oEstado)) {
                    response.getWriter().write("1");
                } else {
                    response.getWriter().write("0");
                }
            }
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Estado! Erro: " + ex.getMessage());
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