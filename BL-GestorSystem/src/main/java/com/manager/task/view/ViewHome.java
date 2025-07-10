package com.manager.task.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class ViewHome extends JFrame {

	private static final long serialVersionUID = 1L;

	public ViewHome() {
		setTitle("Inova Solutions - Sistema Profissional");
		setSize(1100, 750);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		// Cores e fontes
		Color bgColor = new Color(18, 18, 20);
		Color headerColor = new Color(28, 28, 30);
		Color panelColor = new Color(35, 36, 38);
		Color textColor = new Color(240, 240, 240);
		Color primaryColor = new Color(0, 120, 215);
		Color borderColor = new Color(60, 60, 60);
		Font fontText = new Font("Segoe UI", Font.PLAIN, 15);
		Font fontBold = new Font("Segoe UI", Font.BOLD, 16);

		// Header
		JPanel header = new JPanel(new BorderLayout());
		header.setBackground(headerColor);
		header.setPreferredSize(new Dimension(1100, 60));
		header.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, borderColor));

		JLabel logo = new JLabel("🧠 Inova Solutions");
		logo.setForeground(primaryColor);
		logo.setFont(new Font("Segoe UI", Font.BOLD, 22));
		logo.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 0));

		JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
		navPanel.setOpaque(false);
		String[] menu = { "Produtos", "Estoque", "Usuários", "Financeiro", "Relatórios", "Configurações", "Sobre nós",
				"Suporte" };
		for (String item : menu) {
			JButton btn = new JButton(item);
			btn.setForeground(textColor);
			btn.setBackground(headerColor);
			btn.setFont(fontText);
			btn.setBorder(BorderFactory.createEmptyBorder(6, 14, 6, 14));
			btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			navPanel.add(btn);
		}

		header.add(logo, BorderLayout.WEST);
		header.add(navPanel, BorderLayout.EAST);

		// Corpo principal
		JPanel content = new JPanel();
		content.setBackground(bgColor);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

		JLabel title = new JLabel("Bem-vindo ao sistema da Inova Solutions");
		title.setFont(new Font("Segoe UI", Font.BOLD, 28));
		title.setForeground(primaryColor);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));

		JLabel subtitle = new JLabel(
				"<html><div style='text-align: center;'>Controle completo e moderno para sua empresa.<br>Todos os recursos em um só lugar com a melhor experiência.</div></html>");
		subtitle.setFont(fontText);
		subtitle.setForeground(Color.LIGHT_GRAY);
		subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		subtitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 30, 0));

		JPanel cardsPanel = new JPanel(new GridLayout(2, 3, 20, 20));
		cardsPanel.setBackground(bgColor);
		cardsPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 40, 40));

		// Adicionando cards
		cardsPanel.add(createCard("Estoque", "📦", "Controle de entradas, saídas e relatórios de produtos", panelColor,
				textColor, primaryColor));
		cardsPanel.add(createCard("Produtos", "🏷️", "Catálogo, preços, descrições e gestão", panelColor, textColor,
				primaryColor));
		cardsPanel.add(createCard("Usuários", "👥", "Permissões, cargos e gestão de acesso", panelColor, textColor,
				primaryColor));
		cardsPanel.add(createCard("Financeiro", "💰", "Controle de contas, fluxo de caixa e despesas", panelColor,
				textColor, primaryColor));
		cardsPanel.add(createCard("Relatórios", "📊", "Indicadores de performance e exportações", panelColor, textColor,
				primaryColor));
		cardsPanel.add(createCard("Suporte", "🛠️", "Central de ajuda, tickets e assistência", panelColor, textColor,
				primaryColor));

		// Rodapé
		JLabel footer = new JLabel("© 2025 Inova Solutions - Todos os direitos reservados");
		footer.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		footer.setForeground(Color.GRAY);
		footer.setHorizontalAlignment(SwingConstants.CENTER);
		footer.setBorder(BorderFactory.createEmptyBorder(15, 0, 15, 0));

		// Montar tela
		content.add(title);
		content.add(subtitle);
		content.add(cardsPanel);

		add(header, BorderLayout.NORTH);
		add(content, BorderLayout.CENTER);
		add(footer, BorderLayout.SOUTH);
	}

	private JPanel createCard(String titulo, String emoji, String descricao, Color fundo, Color texto, Color icone) {
		JPanel card = new JPanel();
		card.setBackground(fundo);
		card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
		card.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(new Color(50, 50, 50), 1),
				BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel icon = new JLabel(emoji, SwingConstants.CENTER);
		icon.setFont(new Font("Segoe UI Emoji", Font.PLAIN, 36));
		icon.setAlignmentX(Component.CENTER_ALIGNMENT);
		icon.setForeground(icone);

		JLabel title = new JLabel(titulo);
		title.setFont(new Font("Segoe UI", Font.BOLD, 18));
		title.setForeground(texto);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		title.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));

		JLabel desc = new JLabel("<html><div style='text-align: center;'>" + descricao + "</div></html>");
		desc.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		desc.setForeground(Color.LIGHT_GRAY);
		desc.setAlignmentX(Component.CENTER_ALIGNMENT);
		desc.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));

		card.add(icon);
		card.add(title);
		card.add(desc);
		return card;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			ViewHome frame = new ViewHome();
			frame.setVisible(true);
		});
	}
}
