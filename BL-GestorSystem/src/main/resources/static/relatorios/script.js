
function gerarRelatorio() {
    const modulo = document.getElementById('modulo').value;
    const dataInicio = document.getElementById('dataInicio').value;
    const dataFim = document.getElementById('dataFim').value;
    const palavra = document.getElementById('palavraChave').value;

    const tabela = document.querySelector('#tabelaRelatorio tbody');
    tabela.innerHTML = '';

    for (let i = 1; i <= 5; i++) {
        const tr = document.createElement('tr');
        tr.innerHTML = `
          <td>${modulo}</td>
          <td>${modulo.charAt(0).toUpperCase() + modulo.slice(1)} exemplo ${i}</td>
          <td>${new Date().toLocaleDateString()}</td>
          <td>Detalhes ${i}</td>
        `;
        tabela.appendChild(tr);
    }
}