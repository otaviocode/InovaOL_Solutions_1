package gestorxpert.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ViewProduto extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtCodigo;
	private JTextField txtDescricao;
	private JFormattedTextField txtValor;
	private JTable table;
	private JButton btnSalvar, btnLimpar, btnExcluir, btnAlterar;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ViewProduto frame = new ViewProduto();
			frame.setVisible(true);
		});
	}

	public ViewProduto() {
		configureWindow();
		initComponents();
	}

	private void configureWindow() {
		setTitle("GestorXpert - Gerenciador de Produtos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(800, 500));
		setLocationRelativeTo(null);
	}

	private void initComponents() {
		Color bgColor = new Color(25, 25, 25);
		Color fgColor = Color.WHITE;
		Color inputColor = new Color(45, 45, 45);
		Font labelFont = new Font("SansSerif", Font.BOLD, 14);

		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(bgColor);
		mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

		// Painel superior com os campos
		JPanel inputPanel = new JPanel(new GridBagLayout());
		inputPanel.setBackground(bgColor);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Código
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		JLabel lblCodigo = new JLabel("Código");
		lblCodigo.setForeground(fgColor);
		lblCodigo.setFont(labelFont);
		inputPanel.add(lblCodigo, gbc);

		gbc.gridy = 1;
		txtCodigo = new JTextField();
		txtCodigo.setEditable(false);
		styleTextField(txtCodigo, inputColor, fgColor);
		inputPanel.add(txtCodigo, gbc);

		// Descrição do Produto
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.6;
		JLabel lblDescricao = new JLabel("Descrição do Produto");
		lblDescricao.setForeground(fgColor);
		lblDescricao.setFont(labelFont);
		inputPanel.add(lblDescricao, gbc);

		gbc.gridy = 1;
		txtDescricao = new JTextField();
		styleTextField(txtDescricao, inputColor, fgColor);
		inputPanel.add(txtDescricao, gbc);

		// Valor
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.2;
		JLabel lblValor = new JLabel("Valor (R$)");
		lblValor.setForeground(fgColor);
		lblValor.setFont(labelFont);
		inputPanel.add(lblValor, gbc);

		gbc.gridy = 1;
		txtValor = new JFormattedTextField(NumberFormat.getNumberInstance());
		txtValor.setBackground(inputColor);
		txtValor.setForeground(fgColor);
		txtValor.setCaretColor(fgColor);
		txtValor.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		inputPanel.add(txtValor, gbc);

		// Botão Salvar
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.CENTER;
		btnSalvar = new JButton("Salvar");
		styleButton(btnSalvar);
		inputPanel.add(btnSalvar, gbc);

		// Tabela
		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "Código", "Descrição Produto", "Quantidade", "Valor" }, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Dados de exemplo
		model.addRow(new Object[] { "001", "Notebook Dell Inspiron 15", 5, 3500.00 });
		model.addRow(new Object[] { "002", "Mouse Sem Fio Logitech", 12, 89.90 });
		model.addRow(new Object[] { "003", "Teclado Mecânico RGB", 8, 199.90 });
		model.addRow(new Object[] { "004", "Monitor 24\" Full HD", 3, 899.00 });

		table = new JTable(model);
		table.setBackground(bgColor);
		table.setForeground(fgColor);
		table.setFont(new Font("SansSerif", Font.PLAIN, 13));
		table.setGridColor(Color.DARK_GRAY);
		table.setRowHeight(24);
		table.setSelectionBackground(new Color(60, 60, 60));
		table.setSelectionForeground(Color.WHITE);

		// Configuração das colunas (Código | Descrição Produto | Quantidade | Valor)
		// A coluna Descrição será mais larga conforme solicitado
		table.getColumnModel().getColumn(0).setPreferredWidth(10); // Código
		table.getColumnModel().getColumn(1).setPreferredWidth(60); // Descrição (maior)
		table.getColumnModel().getColumn(2).setPreferredWidth(15); // Quantidade
		table.getColumnModel().getColumn(3).setPreferredWidth(15); // Valor

		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(40, 40, 40));
		header.setForeground(Color.WHITE);
		header.setFont(new Font("SansSerif", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setBackground(bgColor);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		// Painel inferior com botões
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
		buttonPanel.setBackground(bgColor);

		btnLimpar = new JButton("Limpar");
		btnExcluir = new JButton("Excluir");
		btnAlterar = new JButton("Alterar");
		styleButton(btnLimpar);
		styleButton(btnExcluir);
		styleButton(btnAlterar);

		buttonPanel.add(btnLimpar);
		buttonPanel.add(btnExcluir);
		buttonPanel.add(btnAlterar);

		// Montagem final
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		setContentPane(mainPanel);
		pack();
	}

	private void styleTextField(JTextField field, Color bg, Color fg) {
		field.setBackground(bg);
		field.setForeground(fg);
		field.setCaretColor(fg);
		field.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}

	private void styleButton(JButton button) {
		button.setBackground(new Color(70, 70, 70));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		button.setPreferredSize(new Dimension(100, 30));
	}
}