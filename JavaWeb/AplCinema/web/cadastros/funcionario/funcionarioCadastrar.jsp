<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container mt-3">
    <h2>Cadastro de Funcionário</h2>

    <input type="hidden" id="ID_FUNCIONARIO" value="${funcionario.id_funcionario}"/>

    <div class="form-group">
        <label>Nome</label>
        <input type="text" id="NOME_FUNCIONARIO" class="form-control" value="${funcionario.nome_funcionario}"/>
    </div>
    <div class="form-group">
        <label>Função</label>
        <input type="text" id="FUNCAO" class="form-control" value="${funcionario.funcao}"/>
    </div>
    <div class="form-group">
        <label>Telefone</label>
        <input type="text" id="TELEFONE" class="form-control" value="${funcionario.telefone}"/>
    </div>
    <div class="form-group">
        <label>Email</label>
        <input type="text" id="EMAIL" class="form-control" value="${funcionario.email}"/>
    </div>

    <button class="btn btn-primary" onclick="salvar()">Salvar</button>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/FuncionarioListar">Cancelar</a>
</div>

<script>
function salvar() {
    var id_funcionario        = $("#ID_FUNCIONARIO").val();
    var nome_funcionario      = $("#NOME_FUNCIONARIO").val();
    var funcao                = $("#FUNCAO").val();
    var telefone              = $("#TELEFONE").val();
    var email                 = $("#EMAIL").val();

    $.ajax({
        type: "POST",
        url: "${pageContext.request.contextPath}/FuncionarioCadastrar",
        data: { ID_FUNCIONARIO: id_funcionario, NOME_FUNCIONARIO: nome_funcionario, FUNCAO: funcao, TELEFONE: telefone, EMAIL: email },
        success: function(retorno) {
            if (retorno == "1") {
                Swal.fire("Sucesso!", "Funcionário salvo com sucesso!", "success").then(function() {
                    window.location = "${pageContext.request.contextPath}/FuncionarioListar";
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