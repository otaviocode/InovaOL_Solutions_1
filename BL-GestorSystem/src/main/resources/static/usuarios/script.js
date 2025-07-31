
		// Estado do app
		let users = [];
		let editUserId = null;

		// Elementos
		const form = document.getElementById('userForm');
		const codigoInput = document.getElementById('codigo');
		const fotoInput = document.getElementById('foto');
		const fotoPreview = document.getElementById('fotoPreview');
		const nomeInput = document.getElementById('nome');
		const emailInput = document.getElementById('email');
		const loginInput = document.getElementById('login');
		const senhaInput = document.getElementById('senha');
		const perfilSelect = document.getElementById('perfil');
		const statusSelect = document.getElementById('status');
		const telefoneInput = document.getElementById('telefone');
		const dataNascimentoInput = document.getElementById('dataNascimento');
		const cepInput = document.getElementById('cep');
		const enderecoInput = document.getElementById('endereco');
		const numeroInput = document.getElementById('numero');
		const complementoInput = document.getElementById('complemento');
		const bairroInput = document.getElementById('bairro');
		const cidadeInput = document.getElementById('cidade');
		const estadoInput = document.getElementById('estado');

		const searchInput = document.getElementById('searchInput');
		const filterPerfil = document.getElementById('filterPerfil');
		const filterStatus = document.getElementById('filterStatus');

		const userTableBody = document.getElementById('userTableBody');
		const btnClear = document.getElementById('btnClear');
		const btnDelete = document.getElementById('btnDelete');
		const btnEdit = document.getElementById('btnEdit');

		const tabs = document.querySelectorAll('.tab');

		// Função para gerar ID único incremental
		function generateId() {
			return users.length ? Math.max(...users.map(u => u.id)) + 1 : 1;
		}

		// Atualiza preview da foto ao carregar arquivo
		fotoInput.addEventListener('change', e => {
			const file = e.target.files[0];
			if (!file) return;
			const reader = new FileReader();
			reader.onload = e => {
				fotoPreview.src = e.target.result;
			};
			reader.readAsDataURL(file);
		});

		// Limpando formulário
		function clearForm() {
			editUserId = null;
			codigoInput.value = '';
			fotoPreview.src = "https://via.placeholder.com/140?text=Foto";
			form.reset();
			btnDelete.disabled = true;
			btnEdit.disabled = true;
			clearRowSelection();
		}

		btnClear.addEventListener('click', e => {
			e.preventDefault();
			clearForm();
		});

		// Renderiza tabela baseado em filtro e pesquisa
		function renderTable() {
			const searchTerm = searchInput.value.toLowerCase();
			const perfilFilter = filterPerfil.value;
			const statusFilter = filterStatus.value;
			const tabPerfil = Array.from(tabs).find(t => t.classList.contains('active')).dataset.profile;

			userTableBody.innerHTML = '';

			let filteredUsers = users.filter(user => {
				// Filtra por aba
				if (tabPerfil !== 'all' && user.perfil !== tabPerfil) return false;
				// Filtra por pesquisa (nome, email, login)
				if (
					!user.nome.toLowerCase().includes(searchTerm) &&
					!user.email.toLowerCase().includes(searchTerm) &&
					!user.login.toLowerCase().includes(searchTerm)
				) return false;
				// Filtra por filtro perfil abaixo tabela
				if (perfilFilter !== 'all' && user.perfil !== perfilFilter) return false;
				// Filtra por status
				if (statusFilter !== 'all' && user.status !== statusFilter) return false;
				return true;
			});

			if (filteredUsers.length === 0) {
				const tr = document.createElement('tr');
				const td = document.createElement('td');
				td.colSpan = 11;
				td.style.textAlign = 'center';
				td.textContent = 'Nenhum usuário encontrado.';
				tr.appendChild(td);
				userTableBody.appendChild(tr);
				return;
			}

			filteredUsers.forEach(user => {
				const tr = document.createElement('tr');
				tr.dataset.id = user.id;

				tr.innerHTML = `
        <td>${user.id}</td>
        <td><img src="${user.foto}" alt="Foto de ${user.nome}" style="width:40px; height:40px; border-radius:50%; object-fit:cover;" /></td>
        <td>${user.nome}</td>
        <td>${user.email}</td>
        <td>${user.login}</td>
        <td>${user.perfil === 'admin' ? 'Administrador' : 'Usuário Comum'}</td>
        <td>${user.status === 'ativo' ? 'Ativo' : 'Inativo'}</td>
        <td>${user.telefone || '-'}</td>
        <td>${user.dataNascimento || '-'}</td>
        <td>${user.cidade || '-'}</td>
        <td>${user.estado || '-'}</td>
      `;
				tr.addEventListener('click', () => {
					clearRowSelection();
					tr.classList.add('selected');
					fillFormWithUser(user);
					btnDelete.disabled = false;
					btnEdit.disabled = false;
				});

				userTableBody.appendChild(tr);
			});
		}

		// Limpa seleção de linha
		function clearRowSelection() {
			userTableBody.querySelectorAll('tr').forEach(tr => tr.classList.remove('selected'));
		}

		// Preenche o formulário com os dados do usuário para edição
		function fillFormWithUser(user) {
			editUserId = user.id;
			codigoInput.value = user.id;
			fotoPreview.src = user.foto || "https://via.placeholder.com/140?text=Foto";
			nomeInput.value = user.nome;
			emailInput.value = user.email;
			loginInput.value = user.login;
			senhaInput.value = ''; // por segurança, não preencher senha
			perfilSelect.value = user.perfil;
			statusSelect.value = user.status;
			telefoneInput.value = user.telefone || '';
			dataNascimentoInput.value = user.dataNascimento || '';
			cepInput.value = user.cep || '';
			enderecoInput.value = user.endereco || '';
			numeroInput.value = user.numero || '';
			complementoInput.value = user.complemento || '';
			bairroInput.value = user.bairro || '';
			cidadeInput.value = user.cidade || '';
			estadoInput.value = user.estado || '';
		}

		// Validação básica do formulário
		function validateForm() {
			if (!nomeInput.value.trim()) {alert('Nome é obrigatório'); nomeInput.focus(); return false;}
			if (!emailInput.value.trim()) {alert('E-mail é obrigatório'); emailInput.focus(); return false;}
			if (!loginInput.value.trim()) {alert('Login é obrigatório'); loginInput.focus(); return false;}
			if (!editUserId && !senhaInput.value.trim()) {alert('Senha é obrigatória'); senhaInput.focus(); return false;}
			if (!perfilSelect.value) {alert('Perfil deve ser selecionado'); perfilSelect.focus(); return false;}
			if (!statusSelect.value) {alert('Status deve ser selecionado'); statusSelect.focus(); return false;}
			return true;
		}

		// Envio do formulário (novo ou edição)
		form.addEventListener('submit', e => {
			e.preventDefault();
			if (!validateForm()) return;

			let fotoData = fotoPreview.src;
			// Se nova foto foi selecionada, reader já atualizou a preview.

			if (editUserId === null) {
				// Novo usuário
				const newUser = {
					id: generateId(),
					foto: fotoData,
					nome: nomeInput.value.trim(),
					email: emailInput.value.trim(),
					login: loginInput.value.trim(),
					senha: senhaInput.value, // normalmente deve ser hash, aqui só para exemplo
					perfil: perfilSelect.value,
					status: statusSelect.value,
					telefone: telefoneInput.value.trim(),
					dataNascimento: dataNascimentoInput.value,
					cep: cepInput.value.trim(),
					endereco: enderecoInput.value.trim(),
					numero: numeroInput.value.trim(),
					complemento: complementoInput.value.trim(),
					bairro: bairroInput.value.trim(),
					cidade: cidadeInput.value.trim(),
					estado: estadoInput.value.trim().toUpperCase(),
				};
				/* users.push(newUser);
				 alert('Usuário cadastrado com sucesso!'); */

				// <!-------------------------------------------------------------->

				fetch("http://localhost:8080/usuarios", {
					method: "POST",
					headers: {
						"Content-Type": "application/json"
					},
					body: JSON.stringify({
						nome: nomeInput.value.trim(),
						email: emailInput.value.trim(),
						login: loginInput.value.trim(),
						senha: senhaInput.value,
						perfil: perfilSelect.value,
						status: statusSelect.value,
						telefone: telefoneInput.value.trim(),
						dataNascimento: dataNascimentoInput.value,
						cep: cepInput.value.trim(),
						endereco: enderecoInput.value.trim(),
						numero: numeroInput.value.trim(),
						complemento: complementoInput.value.trim(),
						bairro: bairroInput.value.trim(),
						cidade: cidadeInput.value.trim(),
						estado: estadoInput.value.trim().toUpperCase(),
						foto: fotoPreview.src // cuidado: isso é base64! precisa tratar no backend
					})
				})
					.then(res => {
						if (!res.ok) throw new Error("Erro ao salvar");
						return res.json();
					})
					.then(data => {
						alert("Usuário salvo com sucesso!");
						clearForm();
						// Aqui você pode também atualizar a tabela chamando renderTable se quiser
					})
					.catch(err => {
						console.error("Erro:", err);
						alert("Erro ao salvar usuário");
					});

				//------------------------------------------------------------------

			} else {
				// Editar usuário existente
				const userIndex = users.findIndex(u => u.id === editUserId);
				if (userIndex === -1) {
					alert('Usuário não encontrado!');
					clearForm();
					return;
				}
				users[userIndex] = {
					...users[userIndex],
					foto: fotoData,
					nome: nomeInput.value.trim(),
					email: emailInput.value.trim(),
					login: loginInput.value.trim(),
					senha: senhaInput.value ? senhaInput.value : users[userIndex].senha, // atualiza senha só se preenchida
					perfil: perfilSelect.value,
					status: statusSelect.value,
					telefone: telefoneInput.value.trim(),
					dataNascimento: dataNascimentoInput.value,
					cep: cepInput.value.trim(),
					endereco: enderecoInput.value.trim(),
					numero: numeroInput.value.trim(),
					complemento: complementoInput.value.trim(),
					bairro: bairroInput.value.trim(),
					cidade: cidadeInput.value.trim(),
					estado: estadoInput.value.trim().toUpperCase(),
				};
				alert('Usuário atualizado com sucesso!');
			}
			clearForm();
			renderTable();
		});

		// Filtrar tabela conforme pesquisa e filtros
		searchInput.addEventListener('input', renderTable);
		filterPerfil.addEventListener('change', renderTable);
		filterStatus.addEventListener('change', renderTable);

		// Filtrar por abas (perfil)
		tabs.forEach(tab => {
			tab.addEventListener('click', () => {
				tabs.forEach(t => t.classList.remove('active'));
				tab.classList.add('active');
				renderTable();
			});
			tab.addEventListener('keydown', e => {
				if (e.key === 'Enter' || e.key === ' ') {
					e.preventDefault();
					tab.click();
				}
			});
		});

		// Excluir usuário selecionado
		btnDelete.addEventListener('click', () => {
			if (editUserId === null) return alert('Selecione um usuário para excluir.');
			if (confirm('Confirma a exclusão do usuário selecionado?')) {
				users = users.filter(u => u.id !== editUserId);
				alert('Usuário excluído com sucesso.');
				clearForm();
				renderTable();
			}
		});

		// Editar usuário selecionado (popula formulário, já feito no clique na tabela)
		btnEdit.addEventListener('click', () => {
			if (editUserId === null) return alert('Selecione um usuário para editar.');
			window.scrollTo({top: 0, behavior: 'smooth'});
		});

		// Inicialização
		clearForm();
		renderTable();