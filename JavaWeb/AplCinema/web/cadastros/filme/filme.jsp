<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container-fluid mt-3">
    <h1>Filmes Cadastrados</h1>

    <a class="btn btn-success mb-3" href="${pageContext.request.contextPath}/FilmeNovo">
        <strong>+ Novo</strong>
    </a>

    <table id="datatable" class="display">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Data de Lançamento</th>
                <th>Duração (minutos)</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="filme" items="${filmes}">
                <tr>
                    <td>${filme.id_filme}</td>
                    <td>${filme.nome_filme}</td>
                    <td>${filme.data_lancamento}</td>
                    <td>${filme.duracao_minutos}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/FilmeExcluir?ID_FILME=${filme.id_filme}">
                            <button class="btn btn-danger btn-sm">Excluir</button>
                        </a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/FilmeCarregar?ID_FILME=${filme.id_filme}">
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