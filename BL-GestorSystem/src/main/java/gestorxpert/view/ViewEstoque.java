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
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ViewEstoque extends JFrame {

	private static final long serialVersionUID = 1L;
	private JComboBox<String> comboBoxTipoMovimento;
	private JComboBox<String> comboBoxProduto;
	private JSpinner spinnerQuantidade;
	private JFormattedTextField textFieldValor;
	private JTextField textFieldPesquisa;
	private JComboBox<String> comboBoxFiltro;
	private JTable table;
	private JButton btnSalvar, btnPesquisar, btnGerarRelatorio;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ViewEstoque frame = new ViewEstoque();
			frame.setVisible(true);
		});
	}

	public ViewEstoque() {
		configureWindow();
		initComponents();
	}

	private void configureWindow() {
		setTitle("GestorXpert - Gerenciador de Estoque");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(900, 600));
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

		// Painel superior com os campos de movimentação
		JPanel movimentacaoPanel = new JPanel(new GridBagLayout());
		movimentacaoPanel.setBackground(bgColor);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(8, 8, 8, 8);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		// Tipo de Movimentação
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.15;
		JLabel lblTipoMovimento = new JLabel("Tipo de Movimentação");
		lblTipoMovimento.setForeground(fgColor);
		lblTipoMovimento.setFont(labelFont);
		movimentacaoPanel.add(lblTipoMovimento, gbc);

		gbc.gridy = 1;
		comboBoxTipoMovimento = new JComboBox<>(new String[] { "Entrada", "Saída" });
		styleComboBox(comboBoxTipoMovimento, inputColor, fgColor);
		movimentacaoPanel.add(comboBoxTipoMovimento, gbc);

		// Descrição do Produto
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.35;
		JLabel lblDescricaoProduto = new JLabel("Descrição do Produto");
		lblDescricaoProduto.setForeground(fgColor);
		lblDescricaoProduto.setFont(labelFont);
		movimentacaoPanel.add(lblDescricaoProduto, gbc);

		gbc.gridy = 1;
		comboBoxProduto = new JComboBox<>();
		styleComboBox(comboBoxProduto, inputColor, fgColor);
		movimentacaoPanel.add(comboBoxProduto, gbc);

		// Quantidade
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.weightx = 0.1;
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setForeground(fgColor);
		lblQuantidade.setFont(labelFont);
		movimentacaoPanel.add(lblQuantidade, gbc);

		gbc.gridy = 1;
		spinnerQuantidade = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
		styleSpinner(spinnerQuantidade, inputColor, fgColor);
		movimentacaoPanel.add(spinnerQuantidade, gbc);

		// Valor
		gbc.gridx = 3;
		gbc.gridy = 0;
		gbc.weightx = 0.2;
		JLabel lblValor = new JLabel("Valor (R$)");
		lblValor.setForeground(fgColor);
		lblValor.setFont(labelFont);
		movimentacaoPanel.add(lblValor, gbc);

		gbc.gridy = 1;
		textFieldValor = new JFormattedTextField(NumberFormat.getNumberInstance());
		textFieldValor.setBackground(inputColor);
		textFieldValor.setForeground(fgColor);
		textFieldValor.setCaretColor(fgColor);
		textFieldValor.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		textFieldValor.setColumns(10);
		movimentacaoPanel.add(textFieldValor, gbc);

		// Botão Salvar
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 4;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.CENTER;
		btnSalvar = new JButton("Salvar");
		styleButton(btnSalvar);
		movimentacaoPanel.add(btnSalvar, gbc);

		// Painel de pesquisa
		JPanel pesquisaPanel = new JPanel(new GridBagLayout());
		pesquisaPanel.setBackground(bgColor);
		GridBagConstraints gbcPesquisa = new GridBagConstraints();
		gbcPesquisa.insets = new Insets(8, 8, 8, 8);
		gbcPesquisa.fill = GridBagConstraints.HORIZONTAL;

		// Campo de pesquisa
		gbcPesquisa.gridx = 0;
		gbcPesquisa.gridy = 0;
		gbcPesquisa.weightx = 0.4;
		JLabel lblPesquisar = new JLabel("Pesquisar produto por nome");
		lblPesquisar.setForeground(fgColor);
		lblPesquisar.setFont(labelFont);
		pesquisaPanel.add(lblPesquisar, gbcPesquisa);

		gbcPesquisa.gridy = 1;
		textFieldPesquisa = new JTextField();
		styleTextField(textFieldPesquisa, inputColor, fgColor);
		pesquisaPanel.add(textFieldPesquisa, gbcPesquisa);

		// Filtro
		gbcPesquisa.gridx = 1;
		gbcPesquisa.gridy = 0;
		gbcPesquisa.weightx = 0.3;
		JLabel lblFiltro = new JLabel("Filtrar por categoria");
		lblFiltro.setForeground(fgColor);
		lblFiltro.setFont(labelFont);
		pesquisaPanel.add(lblFiltro, gbcPesquisa);

		gbcPesquisa.gridy = 1;
		comboBoxFiltro = new JComboBox<>(new String[] { "Todos", "Eletrônicos", "Alimentos", "Vestuário" });
		styleComboBox(comboBoxFiltro, inputColor, fgColor);
		pesquisaPanel.add(comboBoxFiltro, gbcPesquisa);

		// Botão Pesquisar
		gbcPesquisa.gridx = 2;
		gbcPesquisa.gridy = 1;
		gbcPesquisa.weightx = 0.2;
		btnPesquisar = new JButton("Pesquisar");
		styleButton(btnPesquisar);
		pesquisaPanel.add(btnPesquisar, gbcPesquisa);

		// Tabela
		DefaultTableModel model = new DefaultTableModel(
				new Object[] { "Código", "Produto", "Categoria", "Quantidade", "Valor Unit.", "Valor Total" }, 0) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		// Dados de exemplo
		model.addRow(new Object[] { "001", "Notebook Dell", "Eletrônicos", 5, 3500.00, 17500.00 });
		model.addRow(new Object[] { "002", "Arroz 5kg", "Alimentos", 50, 25.90, 1295.00 });
		model.addRow(new Object[] { "003", "Camiseta Branca", "Vestuário", 30, 39.90, 1197.00 });
		model.addRow(new Object[] { "004", "Mouse Sem Fio", "Eletrônicos", 15, 89.90, 1348.50 });

		table = new JTable(model);
		table.setBackground(bgColor);
		table.setForeground(fgColor);
		table.setFont(new Font("SansSerif", Font.PLAIN, 13));
		table.setGridColor(Color.DARK_GRAY);
		table.setRowHeight(24);
		table.setSelectionBackground(new Color(60, 60, 60));
		table.setSelectionForeground(Color.WHITE);

		// Configuração das colunas conforme solicitado (10% | 10% | 35% | 15% | 10% |
		// 20%)
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(10);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(10);
		table.getColumnModel().getColumn(5).setPreferredWidth(20);

		JTableHeader header = table.getTableHeader();
		header.setBackground(new Color(40, 40, 40));
		header.setForeground(Color.WHITE);
		header.setFont(new Font("SansSerif", Font.BOLD, 14));

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.getViewport().setBackground(bgColor);
		scrollPane.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

		// Botão Gerar Relatório
		JPanel relatorioPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		relatorioPanel.setBackground(bgColor);
		btnGerarRelatorio = new JButton("Gerar Relatório PDF");
		styleButton(btnGerarRelatorio);
		relatorioPanel.add(btnGerarRelatorio);

		// Montagem final
		JPanel formPanel = new JPanel(new BorderLayout());
		formPanel.setBackground(bgColor);
		formPanel.add(movimentacaoPanel, BorderLayout.NORTH);
		formPanel.add(pesquisaPanel, BorderLayout.CENTER);

		mainPanel.add(formPanel, BorderLayout.NORTH);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		mainPanel.add(relatorioPanel, BorderLayout.SOUTH);

		setContentPane(mainPanel);
		pack();
	}

	private void styleTextField(JTextField field, Color bg, Color fg) {
		field.setBackground(bg);
		field.setForeground(fg);
		field.setCaretColor(fg);
		field.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		field.setColumns(20);
	}

	private void styleComboBox(JComboBox<String> comboBox, Color bg, Color fg) {
		comboBox.setBackground(bg);
		comboBox.setForeground(fg);
		comboBox.setBorder(BorderFactory.createLineBorder(Color.GRAY));
	}

	private void styleSpinner(JSpinner spinner, Color bg, Color fg) {
		spinner.setBackground(bg);
		spinner.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		JSpinner.NumberEditor editor = new JSpinner.NumberEditor(spinner, "#");
		editor.getTextField().setForeground(fg);
		editor.getTextField().setBackground(bg);
		editor.getTextField().setCaretColor(fg);
		spinner.setEditor(editor);
	}

	private void styleButton(JButton button) {
		button.setBackground(new Color(70, 70, 70));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		button.setPreferredSize(new Dimension(180, 30));
	}
}