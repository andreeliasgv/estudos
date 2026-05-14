<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="iso-8859-1"%>
<jsp:include page="/header.jsp"/>
<jsp:include page="/menu.jsp"/>

<div class="container-fluid">
    <h1 class="h3 mb-2 text-gray-800">Estados</h1>
    <p class="mb-4">Formulário de Cadastro</p>

    <a class="btn btn-secondary mb-4" href="${pageContext.request.contextPath}/EstadoListar">
        <i class="fas fa-undo-alt"></i>
        <strong>Voltar</strong>
    </a>

    <div class="row">
        <div class="col-lg-6">
            <div class="card shadow mb-4">
                <div class="card-body">
                    <div class="form-group">
                        <label>Id</label>
                        <input class="form-control" type="text" name="id" id="id"
                               value="${estado.id}" readonly="readonly"/>
                    </div>
                    <div class="form-group">
                        <label>Nome do Estado</label>
                        <input class="form-control" type="text" name="nomeEstado" id="nomeEstado"
                               value="${estado.nomeEstado}" maxlength="100"/>
                    </div>
                    <div class="form-group">
                        <label>Sigla do Estado</label>
                        <input class="form-control" type="text" name="siglaEstado" id="siglaEstado"
                               value="${estado.siglaEstado}" maxlength="2" style="text-transform:uppercase; width:80px;"/>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-success" type="button" id="submit" onclick="validarCampos()">
                            Salvar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#nomeEstado').focus();

        $('#siglaEstado').on('keyup', function () {
            this.value = this.value.replace(/[^a-zA-Z]/g, '').toUpperCase();
        });

        $('#siglaEstado').blur(function () {
            var sigla = $('#siglaEstado').val().trim();
            var id = $('#id').val();

            if (sigla.length === 0) {
                return;
            }

            if (sigla.length < 2) {
                Swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: 'Sigla inválida!',
                    text: 'A sigla deve ter exatamente 2 letras.',
                    showConfirmButton: true,
                    timer: 4000
                }).then(function () {
                    $('#siglaEstado').val('').focus();
                });
                return;
            }

            $.ajax({
                type: 'get',
                url: '${pageContext.request.contextPath}/EstadoVerificarSigla',
                data: { siglaEstado: sigla, id: id },
                success: function (response) {
                    if (response == '1') {
                        Swal.fire({
                            position: 'center',
                            icon: 'warning',
                            title: 'Sigla já cadastrada!',
                            text: 'A sigla ' + sigla + ' já está em uso.',
                            showConfirmButton: true,
                            timer: 4000
                        }).then(function () {
                            $('#siglaEstado').val('').focus();
                        });
                    }
                },
                error: function () {
                    console.log('Erro ao verificar sigla no servidor.');
                }
            });
        });
    });

    function validarCampos() {
        var nome = $('#nomeEstado').val().trim();
        var sigla = $('#siglaEstado').val().trim();

        if (nome === '') {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe o nome do estado!',
                showConfirmButton: false,
                timer: 2000
            });
            $('#nomeEstado').focus();
            return;
        }

        if (sigla === '' || sigla.length < 2) {
            Swal.fire({
                position: 'center',
                icon: 'error',
                title: 'Informe a sigla com 2 letras!',
                showConfirmButton: false,
                timer: 2000
            });
            $('#siglaEstado').focus();
            return;
        }

        gravarDados();
    }

    function gravarDados() {
        $.ajax({
            type: 'post',
            url: '${pageContext.request.contextPath}/EstadoCadastrar',
            data: {
                id: $('#id').val(),
                nomeEstado: $('#nomeEstado').val().toUpperCase().trim(),
                siglaEstado: $('#siglaEstado').val().toUpperCase().trim()
            },
            success: function (data) {
                if (data == 1) {
                    Swal.fire({
                        position: 'center',
                        icon: 'success',
                        title: 'Sucesso',
                        text: 'Estado gravado com sucesso!',
                        showConfirmButton: true,
                        timer: 3000
                    }).then(function () {
                        window.location.href = '${pageContext.request.contextPath}/EstadoNovo';
                    });
                } else if (data == 3) {
                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: 'Sigla já cadastrada!',
                        text: 'Informe uma sigla diferente.',
                        showConfirmButton: true,
                        timer: 5000
                    }).then(function () {
                        $('#siglaEstado').val('').focus();
                    });
                } else if (data == 4) {
                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: 'Campos em branco!',
                        text: 'Preencha todos os campos.',
                        showConfirmButton: true,
                        timer: 5000
                    }).then(function () {
                        $('#nomeEstado').focus();
                    });
                } else {
                    Swal.fire({
                        position: 'center',
                        icon: 'error',
                        title: 'Não foi possível gravar o estado!',
                        showConfirmButton: true,
                        timer: 5000
                    }).then(function () {
                        $('#nomeEstado').focus();
                    });
                }
            },
            error: function () {
                Swal.fire({
                    position: 'center',
                    icon: 'error',
                    title: 'Erro de comunicação',
                    text: 'Falha na comunicação com o servidor.',
                    showConfirmButton: true,
                    timer: 5000
                });
            }
        });
    }
</script>
<jsp:include page="/footer.jsp"/>