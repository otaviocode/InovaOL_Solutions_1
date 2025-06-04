package gestorxpert.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class ViewUsuario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField txtCodigo;
    private JTextField txtNome;
    private JTextField txtLogin;
    private JPasswordField passwordField;
    private JTable table;
    private JButton btnSalvar, btnLimpar, btnExcluir, btnAlterar;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ViewUsuario frame = new ViewUsuario();
            frame.setVisible(true);
        });
    }

    public ViewUsuario() {
        configureWindow();
        initComponents();
    }

    private void configureWindow() {
        setTitle("GestorXpert - Gerenciador de Usuários");
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

        // Painel superior com os campos
        JPanel inputPanel = new JPanel(new GridBagLayout());
        inputPanel.setBackground(bgColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        txtCodigo = createTextField(inputColor, fgColor);
        txtNome = createTextField(inputColor, fgColor);
        txtLogin = createTextField(inputColor, fgColor);
        passwordField = new JPasswordField();
        passwordField.setBackground(inputColor);
        passwordField.setForeground(fgColor);
        passwordField.setCaretColor(fgColor);
        passwordField.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        addField(inputPanel, gbc, 0, "Código:", txtCodigo, labelFont, fgColor, bgColor);
        addField(inputPanel, gbc, 1, "Nome:", txtNome, labelFont, fgColor, bgColor);
        addField(inputPanel, gbc, 2, "Login:", txtLogin, labelFont, fgColor, bgColor);
        addField(inputPanel, gbc, 3, "Senha:", passwordField, labelFont, fgColor, bgColor);

        btnSalvar = new JButton("Salvar");
        styleButton(btnSalvar);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 4;
        inputPanel.add(btnSalvar, gbc);

        // Painel da tabela
        DefaultTableModel model = new DefaultTableModel(
                new Object[]{"Código", "Nome", "Login"}, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        model.addRow(new Object[]{"001", "João Silva", "joao.silva"});
        model.addRow(new Object[]{"002", "Maria Souza", "maria.s"});
        model.addRow(new Object[]{"003", "Carlos Oliveira", "c.oliveira"});
        model.addRow(new Object[]{"004", "Ana Santos", "ana.s"});
        model.addRow(new Object[]{"005", "Pedro Costa", "pedrinho"});

        table = new JTable(model);
        table.setBackground(bgColor);
        table.setForeground(fgColor);
        table.setFont(new Font("SansSerif", Font.PLAIN, 13));
        table.setGridColor(Color.DARK_GRAY);
        table.setRowHeight(24);
        table.setSelectionBackground(new Color(60, 60, 60));
        table.setSelectionForeground(Color.WHITE);

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

    private JTextField createTextField(Color bg, Color fg) {
        JTextField field = new JTextField(20);
        field.setBackground(bg);
        field.setForeground(fg);
        field.setCaretColor(fg);
        field.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        return field;
    }

    private void addField(JPanel panel, GridBagConstraints gbc, int x, String label,
                          JComponent field, Font font, Color fg, Color bg) {
        gbc.gridx = x;
        gbc.gridy = 0;
        JLabel lbl = new JLabel(label);
        lbl.setForeground(fg);
        lbl.setFont(font);
        panel.add(lbl, gbc);

        gbc.gridy = 1;
        panel.add(field, gbc);
    }

    private void styleButton(JButton button) {
        button.setBackground(new Color(70, 70, 70));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        button.setPreferredSize(new Dimension(100, 30));
    }
}
