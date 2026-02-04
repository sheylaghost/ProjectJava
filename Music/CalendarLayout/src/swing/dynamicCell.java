package swing;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class dynamicCell extends JFrame {

    public dynamicCell() {
        setTitle("Financial CRM - Modern UI");
        setSize(1100, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fundo lilás claro conforme a imagem
        getContentPane().setBackground(new Color(235, 235, 250));
        setLayout(new BorderLayout(20, 20));

        // 1. SIDEBAR (Esquerda)
        JPanel sidebar = criarSidebar();

        // 2. CONTEÚDO CENTRAL (Grid de Cards)
        JPanel centerPanel = criarPainelCentral();

        // 3. BARRA DIREITA (Perfil)
        JPanel rightPanel = criarBarraDireita();

        add(sidebar, BorderLayout.WEST);
        add(centerPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);
    }

    private JPanel criarSidebar() {
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBackground(Color.WHITE);
        sidebar.setLayout(new FlowLayout(FlowLayout.LEFT, 25, 30));

        JLabel logo = new JLabel("Financial CRM");
        logo.setFont(new Font("SansSerif", Font.BOLD, 18));
        logo.setForeground(new Color(90, 79, 207));
        sidebar.add(logo);

        return sidebar;
    }

    private JPanel criarPainelCentral() {
        JPanel centerPanel = new JPanel(new GridBagLayout());
        centerPanel.setOpaque(false);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.BOTH;

        // Card Roxo (Cartão)
        gbc.gridx = 0; gbc.gridy = 0; gbc.weightx = 0.4; gbc.weighty = 0.4;
        centerPanel.add(new RoundedCard("Credit Card", new Color(90, 79, 207), true), gbc);

        // Card Gráfico
        gbc.gridx = 1; gbc.gridy = 0; gbc.weightx = 0.6;
        centerPanel.add(new RoundedCard("Exchange Rates", Color.WHITE, false), gbc);

        // Card Custos
        gbc.gridx = 0; gbc.gridy = 1; gbc.weightx = 0.4; gbc.weighty = 0.6;
        centerPanel.add(new RoundedCard("Last Costs", Color.WHITE, false), gbc);

        // Card Eficiência
        gbc.gridx = 1; gbc.gridy = 1; gbc.weightx = 0.6;
        centerPanel.add(new RoundedCard("Efficiency", Color.WHITE, false), gbc);

        return centerPanel;
    }

    private JPanel criarBarraDireita() {
        JPanel rightPanel = new JPanel();
        rightPanel.setPreferredSize(new Dimension(280, 0));
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 30));

        JLabel profileName = new JLabel("Robert Washington");
        profileName.setFont(new Font("SansSerif", Font.BOLD, 14));
        rightPanel.add(profileName);

        return rightPanel;
    }

    // CLASSE DO CARD COM CORREÇÃO DE PINTURA E SOMBRA
    class RoundedCard extends JPanel {
        private Color bgColor;
        private boolean isDark;

        public RoundedCard(String title, Color bgColor, boolean isDark) {
            this.bgColor = bgColor;
            this.isDark = isDark;
            setOpaque(false);
            setLayout(new BorderLayout());
            setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            JLabel lbl = new JLabel(title);
            lbl.setForeground(isDark ? Color.WHITE : new Color(50, 50, 50));
            lbl.setFont(new Font("SansSerif", Font.BOLD, 17));
            add(lbl, BorderLayout.NORTH);
        }

        @Override
        protected void paintComponent(Graphics g) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Sombra suave (Efeito Neumórfico)
            g2.setColor(new Color(0, 0, 0, 10));
            g2.fillRoundRect(6, 6, getWidth() - 12, getHeight() - 12, 40, 40);

            // Fundo do Card
            g2.setColor(bgColor);
            g2.fillRoundRect(0, 0, getWidth() - 12, getHeight() - 12, 40, 40);

            g2.dispose();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new dynamicCell().setVisible(true));
    }
}
