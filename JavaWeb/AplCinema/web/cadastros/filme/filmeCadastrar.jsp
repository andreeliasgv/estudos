<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container mt-3">
    <h2>Cadastro de Filme</h2>

    <input type="hidden" id="ID_FILME" value="${filme.id_filme}"/>

    <div class="form-group">
        <label>Nome</label>
        <input type="text" id="NOME_FILME" class="form-control" value="${filme.nome_filme}"/>
    </div>
    <div class="form-group">
        <label>Data de Lançamento</label>
        <input type="date" id="DATA_LANCAMENTO" class="form-control" value="${filme.data_lancamento}"/>
    </div>
    <div class="form-group">
        <label>Duração (minutos)</label>
        <input type="number" id="DURACAO_MINUTOS" class="form-control" value="${filme.duracao_minutos}"/>
    </div>

    <button class="btn btn-primary" onclick="salvar()">Salvar</button>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/FilmeListar">Cancelar</a>
</div>

<script>
function salvar() {
    var id_filme        = $("#ID_FILME").val();
    var nome_filme      = $("#NOME_FILME").val();
    var data_lancamento = $("#DATA_LANCAMENTO").val();
    var duracao_minutos = $("#DURACAO_MINUTOS").val();

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/FilmeCadastrar",
        data: { ID_FILME: id_filme, NOME_FILME: nome_filme, DATA_LANCAMENTO: data_lancamento, DURACAO_MINUTOS: duracao_minutos },
        success: function(retorno) {
            if (retorno == "1") {
                Swal.fire("Sucesso!", "Filme salvo com sucesso!", "success").then(function() {
                    window.location = "${pageContext.request.contextPath}/FilmeListar";
                });
            } else if (retorno == "5") {
                Swal.fire("Atenção!", "Preencha todos os campos corretamente.", "warning");
            } else {
                Swal.fire("Erro!", "Não foi possível salvar.", "error");
            }
        },
        error: function() {
            Swal.fire("Erro!", "Falha na comunicação com o servidor.", "error");
        }
    });
}
</script>

<%@include file="/footer.jsp"%>