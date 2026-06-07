package br.com.aplcinema.controller.funcionario;

import br.com.aplcinema.dao.FuncionariosDAO;
import br.com.aplcinema.model.Funcionario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FuncionarioCadastrar", urlPatterns = {"/FuncionarioCadastrar"})
public class FuncionarioCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        try {
            FuncionariosDAO dao = new FuncionariosDAO();

            int id_funcionario = Integer.parseInt(request.getParameter("ID_FUNCIONARIO"));
            String nome_funcionario = request.getParameter("NOME_FUNCIONARIO");
            String funcao = request.getParameter("FUNCAO");
            String telefone = request.getParameter("TELEFONE");
            String email = request.getParameter("EMAIL");

            // Validação simples
            if (nome_funcionario.isBlank() || funcao.isBlank() || telefone.isBlank() || email.isBlank()) {
                response.getWriter().write("5"); // dados inválidos
                return;
            }

            Funcionario funcionario = new Funcionario();
            funcionario.setId_funcionario(id_funcionario);
            funcionario.setNome_funcionario(nome_funcionario);
            funcionario.setFuncao(funcao);
            funcionario.setTelefone(telefone);
            funcionario.setEmail(email);
            
            if (dao.cadastrar(funcionario)) {
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
