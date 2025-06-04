package gestorxpert.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ViewLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField usernameField;
	private JButton btnLogin;
	private JButton btnExit;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			try {
				ViewLogin frame = new ViewLogin();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public ViewLogin() {
		configureWindow();
		initComponents();
		layoutComponents();
	}

	private void configureWindow() {
		setTitle("Gerenciador de Estoque - Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 350);
		setMinimumSize(new Dimension(400, 300));
		setLocationRelativeTo(null); // Centraliza na tela

		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// Ignora se não conseguir carregar o look and feel
		}
	}

	private void initComponents() {
		// Campo de usuário
		usernameField = new JTextField(20);
		usernameField.setToolTipText("Digite seu nome de usuário");

		// Campo de senha
		passwordField = new JPasswordField(20);
		passwordField.setToolTipText("Digite sua senha");

		// Botões
		btnLogin = createButton("Entrar", this::handleLogin);
		btnExit = createButton("Sair", e -> System.exit(0));

		// Estilo dos botões
		btnLogin.setBackground(new Color(0, 120, 215));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setOpaque(true);
		btnLogin.setBorderPainted(false);

		btnExit.setBackground(new Color(240, 240, 240));
		btnExit.setForeground(new Color(50, 50, 50));
		btnExit.setOpaque(true);
		btnExit.setBorderPainted(false);
	}

	private void layoutComponents() {
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Cabeçalho
		JLabel lblTitle = new JLabel("Gerenciador de Estoque", SwingConstants.CENTER);
		lblTitle.setFont(new Font("Segoe UI", Font.BOLD, 24));
		lblTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));

		// Formulário
		JPanel formPanel = new JPanel();
		formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
		formPanel.setBorder(BorderFactory.createEmptyBorder(10, 50, 10, 50));

		addFormField(formPanel, "Usuário:", usernameField);
		addFormField(formPanel, "Senha:", passwordField);

		// Painel de botões
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
		buttonPanel.add(btnExit);
		buttonPanel.add(btnLogin);

		// Montagem do layout
		mainPanel.add(lblTitle, BorderLayout.NORTH);
		mainPanel.add(formPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		setContentPane(mainPanel);
	}

	private void addFormField(JPanel panel, String labelText, JComponent field) {
		JPanel fieldPanel = new JPanel(new BorderLayout(5, 5));
		JLabel label = new JLabel(labelText);
		label.setFont(new Font("Segoe UI", Font.PLAIN, 14));

		fieldPanel.add(label, BorderLayout.NORTH);
		fieldPanel.add(field, BorderLayout.CENTER);
		fieldPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, field.getPreferredSize().height + 30));

		panel.add(fieldPanel);
		panel.add(Box.createRigidArea(new Dimension(0, 10)));
	}

	private JButton createButton(String text, java.awt.event.ActionListener action) {
		JButton button = new JButton(text);
		button.addActionListener(action);
		button.setPreferredSize(new Dimension(100, 30));
		button.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		return button;
	}

	private void handleLogin(ActionEvent e) {
		String username = usernameField.getText();
		char[] password = passwordField.getPassword();

		if (username.isEmpty() || password.length == 0) {
			JOptionPane.showMessageDialog(this, "Preencha todos os campos", "Erro", JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Autenticação simulada
		if ("admin".equals(username) && "1234".equals(new String(password))) {
			JOptionPane.showMessageDialog(this, "Login bem-sucedido!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(this, "Usuário ou senha inválidos", "Erro", JOptionPane.ERROR_MESSAGE);
		}

		Arrays.fill(password, '0'); // Limpa a senha
		passwordField.setText("");
	}
}