
document.addEventListener('DOMContentLoaded', () => {
    const form = document.getElementById('loginForm');
    const alertBox = document.getElementById('alertBox');
    const btnExit = document.getElementById('btnExit');

    form.addEventListener('submit', e => {
        e.preventDefault();
        const user = document.getElementById('username').value.trim();
        const pass = document.getElementById('password').value.trim();

        if (!user || !pass) {
            showAlert('Preencha todos os campos.', 'error');
            return;
        }

        if (user === 'admin' && pass === '1234') {
            showAlert('Login bem-sucedido! Redirecionando...', 'success');
            setTimeout(() => {
                window.location.href = 'estoque.html';
            }, 1500);
        } else {
            showAlert('Usuário ou senha inválidos.', 'error');
        }
    });

    btnExit.addEventListener('click', () => {
        if (confirm('Deseja mesmo sair?')) window.close();
    });

    function showAlert(message, type) {
        alertBox.textContent = message;
        alertBox.className = `alert alert-${type}`;
        alertBox.style.display = 'block';
        setTimeout(() => (alertBox.style.display = 'none'), 3000);
    }
});
