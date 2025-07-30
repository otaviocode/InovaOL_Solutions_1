
function abrirChamado(e) {
    e.preventDefault();
    const nome = document.getElementById('nome').value;
    const email = document.getElementById('email').value;
    const modulo = document.getElementById('modulo').value;
    const mensagem = document.getElementById('mensagem').value;
    const arquivos = document.getElementById('anexo').files;

    let arquivosInfo = "Nenhum anexo";
    if (arquivos.length > 0) {
        arquivosInfo = Array.from(arquivos).map(f => f.name).join(', ');
    }

    alert(`Chamado enviado com sucesso!\n\nNome: ${nome}\nEmail: ${email}\nMódulo: ${modulo}\nMensagem: ${mensagem}\nArquivos: ${arquivosInfo}`);
    e.target.reset();
}