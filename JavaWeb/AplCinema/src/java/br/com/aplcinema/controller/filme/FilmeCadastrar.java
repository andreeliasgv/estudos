package br.com.aplcinema.controller.filme;

import br.com.aplcinema.dao.FilmesDAO;
import br.com.aplcinema.model.Filme;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FilmeCadastrar", urlPatterns = {"/FilmeCadastrar"})
public class FilmeCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        try {
            FilmesDAO dao = new FilmesDAO();

            int id_filme = Integer.parseInt(request.getParameter("ID_FILME"));
            String nome_filme = request.getParameter("NOME_FILME");
            if (request.getParameter("DATA_LANCAMENTO") == null || request.getParameter("DATA_LANCAMENTO").isBlank()) {
                response.getWriter().write("5"); // dados inválidos
                return;
            }
            Date data_lancamento = Date.valueOf(request.getParameter("DATA_LANCAMENTO"));
            int duracao_minutos = Integer.parseInt(request.getParameter("DURACAO_MINUTOS"));

            // Validação simples
            if (nome_filme.isBlank() || duracao_minutos <= 0) {
                response.getWriter().write("5"); // dados inválidos
                return;
            }

            Filme filme = new Filme();
            filme.setId_filme(id_filme);
            filme.setNome_filme(nome_filme);
            filme.setData_lancamento(data_lancamento);
            filme.setDuracao_minutos(duracao_minutos);
            
            if (dao.cadastrar(filme)) {
                response.getWriter().write("1"); // sucesso
            } else {
                response.getWriter().write("0"); // erro
            }

        } catch (Exception ex) {
            System.out.println("Erro ao cadastrar: " + ex.getMessage());
            ex.printStackTrace();
            response.getWriter().write("0");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
