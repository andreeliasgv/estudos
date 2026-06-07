<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container-fluid mt-3">
    <h1>Funcionários Cadastrados</h1>

    <a class="btn btn-success mb-3" href="${pageContext.request.contextPath}/FuncionarioNovo">
        <strong>+ Novo</strong>
    </a>

    <table id="datatable" class="display">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Função</th>
                <th>Telefone</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="funcionario" items="${funcionarios}">
                <tr>
                    <td>${funcionario.id_funcionario}</td>
                    <td>${funcionario.nome_funcionario}</td>
                    <td>${funcionario.funcao}</td>
                    <td>${funcionario.telefone}</td>
                    <td>${funcionario.email}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/FuncionarioExcluir?ID_FUNCIONARIO=${funcionario.id_funcionario}">
                            <button class="btn btn-danger btn-sm">Excluir</button>
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/FuncionarioCarregar?ID_FUNCIONARIO=${funcionario.id_funcionario}">
                            <button class="btn btn-warning btn-sm">Alterar</button>
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script>
    $(document).ready(function() {
        $('#datatable').DataTable({
            "oLanguage": {
                "sSearch": "Buscar:",
                "sZeroRecords": "Nenhum registro encontrado.",
                "sInfo": "Mostrando _START_ a _END_ de _TOTAL_ registros",
                "oPaginate": { "sPrevious": "Anterior", "sNext": "Próximo" }
            }
        });
    });
</script>

<%@include file="/footer.jsp"%>