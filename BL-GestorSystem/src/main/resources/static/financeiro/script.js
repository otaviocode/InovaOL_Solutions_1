
const form = document.getElementById('financeForm');
const tabela = document.getElementById('tabelaFinanceiro');
const dados = [];

form.addEventListener('submit', e => {
    e.preventDefault();
    const nova = {
        tipo: document.getElementById('tipo').value,
        descricao: document.getElementById('descricao').value,
        categoria: document.getElementById('categoria').value,
        valor: parseFloat(document.getElementById('valor').value).toFixed(2),
        data: document.getElementById('data').value,
        metodo: document.getElementById('metodo').value,
        observacoes: document.getElementById('observacoes').value
    };
    dados.push(nova);
    atualizarTabela();
    form.reset();
});

function atualizarTabela() {
    tabela.innerHTML = '';
    dados.forEach((item, index) => {
        const tr = document.createElement('tr');
        tr.innerHTML = `
          <td>${item.tipo}</td>
          <td>${item.descricao}</td>
          <td>${item.categoria}</td>
          <td>R$ ${item.valor}</td>
          <td>${item.data}</td>
          <td>${item.metodo}</td>
          <td><button onclick="excluir(${index})" class="btn" style="padding: 5px 10px; font-size: 14px;">Excluir</button></td>
        `;
        tabela.appendChild(tr);
    });
}

function excluir(index) {
    if (confirm('Deseja excluir este lançamento?')) {
        dados.splice(index, 1);
        atualizarTabela();
    }
}
