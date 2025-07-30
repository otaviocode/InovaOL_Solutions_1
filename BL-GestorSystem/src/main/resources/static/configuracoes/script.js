(function () {
    const form = document.getElementById('settingsForm');
    const message = document.querySelector('.message');

    // Simula carregar configurações do backend
    function loadSettings() {
        // Exemplo: preencher campos com dados simulados
        document.getElementById('systemName').value = "Inova Solutions";
        document.getElementById('defaultLanguage').value = "pt-BR";
        document.getElementById('timezone').value = "America/Sao_Paulo";
        document.getElementById('maintenanceMode').checked = false;

        document.getElementById('passwordMinLength').value = 8;
        document.getElementById('requireSpecialChars').checked = true;
        document.getElementById('requireNumbers').checked = true;
        document.getElementById('requireUppercase').checked = false;
        document.getElementById('sessionTimeout').value = 30;
        document.getElementById('enable2FA').checked = false;

        document.getElementById('smtpServer').value = "smtp.inovasolutions.com";
        document.getElementById('smtpPort').value = 587;
        document.getElementById('smtpUser').value = "no-reply@inovasolutions.com";
        document.getElementById('smtpPassword').value = "";
        document.getElementById('smtpSSL').checked = true;

        document.getElementById('themeSelection').value = "dark";
        document.getElementById('showTooltips').checked = true;
        document.getElementById('enableAnimations').checked = true;

        document.getElementById('backupFrequency').value = "daily";
        document.getElementById('logLevel').value = "info";
        document.getElementById('enableLogRotation').checked = true;
        document.getElementById('backupPath').value = "/var/backups/inova";

        document.getElementById('apiKey').value = "";
        document.getElementById('webhookUrl').value = "";
        document.getElementById('enableThirdParty').checked = false;
    }

    // Validação simples do formulário
    function validateForm() {
        // Valida campos obrigatórios
        const systemName = document.getElementById('systemName').value.trim();
        if (!systemName) {
            alert('Nome do sistema é obrigatório.');
            return false;
        }

        const smtpServer = document.getElementById('smtpServer').value.trim();
        if (!smtpServer) {
            alert('Servidor SMTP é obrigatório.');
            return false;
        }

        const smtpPort = document.getElementById('smtpPort').value.trim();
        if (!smtpPort || isNaN(smtpPort)) {
            alert('Porta SMTP deve ser um número válido.');
            return false;
        }

        const smtpUser = document.getElementById('smtpUser').value.trim();
        if (!smtpUser) {
            alert('Usuário SMTP é obrigatório.');
            return false;
        }

        const passwordMinLength = document.getElementById('passwordMinLength').value.trim();
        if (!passwordMinLength || isNaN(passwordMinLength) || parseInt(passwordMinLength) < 4) {
            alert('Tamanho mínimo da senha deve ser um número maior ou igual a 4.');
            return false;
        }

        const sessionTimeout = document.getElementById('sessionTimeout').value.trim();
        if (!sessionTimeout || isNaN(sessionTimeout) || parseInt(sessionTimeout) < 1) {
            alert('Tempo de sessão deve ser um número maior que zero.');
            return false;
        }

        return true;
    }

    form.addEventListener('submit', e => {
        e.preventDefault();
        if (!validateForm()) return;

        // Aqui iria chamada para salvar no backend (API REST, etc)
        // Simulando sucesso:
        message.style.display = 'block';
        setTimeout(() => message.style.display = 'none', 4000);
    });

    // Inicializa carregando dados simulados
    loadSettings();

})();