/*
==========================================
🇧🇷 DESAFIO: APP DE NOTAS EM JAVA
==========================================

💡 Desafio do Dia: Criar um App de Notas em Java!

🎯 OBJETIVO:
Hoje o seu desafio é criar um aplicativo de anotações em Java, que funcione como um 
bloquinho de notas — igual ao Notepad do Windows, só que feito por você!
Você vai usar Java Swing, a biblioteca gráfica padrão do Java, para construir a interface.

📋 REQUISITOS DO APP:

1. 📝 ÁREA DE TEXTO
   → Um espaço onde o usuário pode digitar suas anotações.

2. 📁 MENU "ARQUIVO" com as opções:
   • Novo: limpa o campo de texto para começar do zero.
   • Abrir: permite abrir um arquivo .txt salvo no computador.
   • Salvar: salva a anotação atual em um arquivo .txt.
   • Sair: fecha o aplicativo.

🧠 CONCEITOS QUE VOCÊ VAI PRATICAR:
✅ Java Swing (interface gráfica)
✅ Componentes gráficos: JTextArea, JScrollPane, JMenu, JMenuItem
✅ Manipulação de arquivos com BufferedReader e BufferedWriter
✅ Eventos com ActionListener
✅ Estrutura básica de um aplicativo com janela (JFrame)

🧪 NÍVEL DE DIFICULDADE:
Intermediário – Ideal para quem já sabe usar classes, métodos e quer aprender a 
trabalhar com janelas e arquivos no Java.

🔨 FERRAMENTAS RECOMENDADAS:
• Java JDK 8 ou superior
• IntelliJ IDEA ou qualquer editor de Java

📝 DICA:
Se você dominar esse desafio, poderá:
• Criar mais funções, como mudar a cor da fonte, salvar automaticamente, ou exportar em PDF!
• Usar o mesmo conhecimento para criar editores, chats, agendas ou diários.

==========================================
🇺🇸 CHALLENGE: NOTES APP IN JAVA
==========================================

💡 Challenge of the Day: Build a Notes App in Java!

🎯 OBJECTIVE:
Today's challenge is to create a notes application in Java that works like a simple 
notepad — just like the Notepad on Windows, but made by you!
You'll use Java Swing, the standard Java GUI library, to build the interface.

📋 APP REQUIREMENTS:

1. 📝 TEXT AREA
   → A space where users can type their notes.

2. 📁 "FILE" MENU with the following options:
   • New: clears the text area to start fresh.
   • Open: allows the user to open a saved .txt file.
   • Save: saves the current note into a .txt file.
   • Exit: closes the application.

🧠 CONCEPTS YOU'LL PRACTICE:
✅ Java Swing (GUI)
✅ UI components: JTextArea, JScrollPane, JMenu, JMenuItem
✅ File handling with BufferedReader and BufferedWriter
✅ Event handling using ActionListener
✅ Basic app structure with JFrame

🧪 DIFFICULTY LEVEL:
Intermediate – Perfect for those who already understand classes, methods, and want to 
explore GUI and file handling in Java.

🔨 RECOMMENDED TOOLS:
• Java JDK 8 or higher
• IntelliJ IDEA or any Java IDE

📝 TIP:
Once you master this challenge, you can:
• Add new features like font color, autosave, or even export to PDF!
• Use the same knowledge to build editors, chat apps, calendars, or personal journals.

==========================================
💻 SOLUÇÃO COMPLETA / COMPLETE SOLUTION
==========================================
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;

public class AppDeNotas extends JFrame {

    private JTextArea areaDeTexto;
    private boolean arquivoModificado = false;
    private File arquivoAtual = null;

    public AppDeNotas() {
        // Configurações básicas da janela
        setTitle("📝 App de Anotações - Notes App");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Ícone da aplicação (opcional)
        try {
            setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
        } catch (Exception e) {
            // Ícone não encontrado, continua sem ele
        }

        // Configurar componentes
        configurarComponentes();
        criarMenu();
        configurarEventos();

        setVisible(true);
    }

    private void configurarComponentes() {
        // Área de texto principal
        areaDeTexto = new JTextArea();
        areaDeTexto.setFont(new Font("Consolas", Font.PLAIN, 14));
        areaDeTexto.setLineWrap(true);
        areaDeTexto.setWrapStyleWord(true);
        
        // Scroll pane para a área de texto
        JScrollPane scroll = new JScrollPane(areaDeTexto);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        add(scroll, BorderLayout.CENTER);

        // Barra de status
        JLabel statusBar = new JLabel(" Pronto - Ready");
        statusBar.setBorder(BorderFactory.createLoweredBevelBorder());
        add(statusBar, BorderLayout.SOUTH);
    }

    private void criarMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menu Arquivo / File
        JMenu menuArquivo = new JMenu("Arquivo / File");
        menuArquivo.setMnemonic(KeyEvent.VK_A);

        // Itens do menu
        JMenuItem novoItem = new JMenuItem("🆕 Novo / New");
        novoItem.setMnemonic(KeyEvent.VK_N);
        novoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem abrirItem = new JMenuItem("📂 Abrir / Open");
        abrirItem.setMnemonic(KeyEvent.VK_O);
        abrirItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem salvarItem = new JMenuItem("💾 Salvar / Save");
        salvarItem.setMnemonic(KeyEvent.VK_S);
        salvarItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

        JMenuItem salvarComoItem = new JMenuItem("💾 Salvar Como / Save As");
        salvarComoItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, 
            KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));

        JMenuItem sairItem = new JMenuItem("🚪 Sair / Exit");
        sairItem.setMnemonic(KeyEvent.VK_X);
        sairItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK));

        // Eventos dos itens do menu
        novoItem.addActionListener(e -> novoArquivo());
        abrirItem.addActionListener(e -> abrirArquivo());
        salvarItem.addActionListener(e -> salvarArquivo());
        salvarComoItem.addActionListener(e -> salvarComo());
        sairItem.addActionListener(e -> sairAplicacao());

        // Adicionar itens ao menu
        menuArquivo.add(novoItem);
        menuArquivo.addSeparator();
        menuArquivo.add(abrirItem);
        menuArquivo.addSeparator();
        menuArquivo.add(salvarItem);
        menuArquivo.add(salvarComoItem);
        menuArquivo.addSeparator();
        menuArquivo.add(sairItem);

        // Menu Editar / Edit
        JMenu menuEditar = new JMenu("Editar / Edit");
        menuEditar.setMnemonic(KeyEvent.VK_E);

        JMenuItem desfazerItem = new JMenuItem("↶ Desfazer / Undo");
        JMenuItem copiarItem = new JMenuItem("📋 Copiar / Copy");
        JMenuItem colarItem = new JMenuItem("📄 Colar / Paste");
        JMenuItem cortarItem = new JMenuItem("✂️ Cortar / Cut");

        desfazerItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK));
        copiarItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));
        colarItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK));
        cortarItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK));

        copiarItem.addActionListener(e -> areaDeTexto.copy());
        colarItem.addActionListener(e -> areaDeTexto.paste());
        cortarItem.addActionListener(e -> areaDeTexto.cut());

        menuEditar.add(desfazerItem);
        menuEditar.addSeparator();
        menuEditar.add(cortarItem);
        menuEditar.add(copiarItem);
        menuEditar.add(colarItem);

        // Menu Sobre / About
        JMenu menuSobre = new JMenu("Sobre / About");
        JMenuItem sobreItem = new JMenuItem("ℹ️ Sobre este App / About this App");
        sobreItem.addActionListener(e -> mostrarSobre());
        menuSobre.add(sobreItem);

        // Adicionar menus à barra
        menuBar.add(menuArquivo);
        menuBar.add(menuEditar);
        menuBar.add(menuSobre);

        setJMenuBar(menuBar);
    }

    private void configurarEventos() {
        // Detectar mudanças no texto
        areaDeTexto.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void insertUpdate(javax.swing.event.DocumentEvent e) { arquivoModificado = true; }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { arquivoModificado = true; }
            public void changedUpdate(javax.swing.event.DocumentEvent e) { arquivoModificado = true; }
        });

        // Confirmar antes de fechar se houver mudanças não salvas
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                sairAplicacao();
            }
        });
    }

    private void novoArquivo() {
        if (arquivoModificado) {
            int opcao = JOptionPane.showConfirmDialog(this,
                "Deseja salvar as alterações antes de criar um novo arquivo?\n" +
                "Do you want to save changes before creating a new file?",
                "Salvar / Save", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (opcao == JOptionPane.YES_OPTION) {
                salvarArquivo();
            } else if (opcao == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        
        areaDeTexto.setText("");
        arquivoAtual = null;
        arquivoModificado = false;
        setTitle("📝 App de Anotações - Notes App");
    }

    private void abrirArquivo() {
        if (arquivoModificado) {
            int opcao = JOptionPane.showConfirmDialog(this,
                "Deseja salvar as alterações antes de abrir outro arquivo?\n" +
                "Do you want to save changes before opening another file?",
                "Salvar / Save", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (opcao == JOptionPane.YES_OPTION) {
                salvarArquivo();
            } else if (opcao == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Arquivos de Texto / Text Files (*.txt)", "txt"));
        
        int opcao = fileChooser.showOpenDialog(this);

        if (opcao == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
                areaDeTexto.setText("");
                areaDeTexto.read(leitor, null);
                arquivoAtual = arquivo;
                arquivoModificado = false;
                setTitle("📝 " + arquivo.getName() + " - App de Anotações");
                
                JOptionPane.showMessageDialog(this, 
                    "Arquivo aberto com sucesso!\nFile opened successfully!",
                    "Sucesso / Success", JOptionPane.INFORMATION_MESSAGE);
                    
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, 
                    "Erro ao abrir arquivo: " + e.getMessage() + "\n" +
                    "Error opening file: " + e.getMessage(),
                    "Erro / Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void salvarArquivo() {
        if (arquivoAtual == null) {
            salvarComo();
        } else {
            salvarArquivoEm(arquivoAtual);
        }
    }

    private void salvarComo() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Arquivos de Texto / Text Files (*.txt)", "txt"));
        
        int opcao = fileChooser.showSaveDialog(this);

        if (opcao == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            
            // Adicionar extensão .txt se não tiver
            if (!arquivo.getName().toLowerCase().endsWith(".txt")) {
                arquivo = new File(arquivo.getParentFile(), arquivo.getName() + ".txt");
            }
            
            salvarArquivoEm(arquivo);
            arquivoAtual = arquivo;
            setTitle("📝 " + arquivo.getName() + " - App de Anotações");
        }
    }

    private void salvarArquivoEm(File arquivo) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))) {
            areaDeTexto.write(escritor);
            arquivoModificado = false;
            
            JOptionPane.showMessageDialog(this, 
                "Arquivo salvo com sucesso!\nFile saved successfully!",
                "Sucesso / Success", JOptionPane.INFORMATION_MESSAGE);
                
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, 
                "Erro ao salvar arquivo: " + e.getMessage() + "\n" +
                "Error saving file: " + e.getMessage(),
                "Erro / Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void sairAplicacao() {
        if (arquivoModificado) {
            int opcao = JOptionPane.showConfirmDialog(this,
                "Você tem alterações não salvas. Deseja salvar antes de sair?\n" +
                "You have unsaved changes. Do you want to save before exiting?",
                "Sair / Exit", JOptionPane.YES_NO_CANCEL_OPTION);
            
            if (opcao == JOptionPane.YES_OPTION) {
                salvarArquivo();
                if (arquivoModificado) return; // Se não conseguiu salvar, não saia
            } else if (opcao == JOptionPane.CANCEL_OPTION) {
                return;
            }
        }
        System.exit(0);
    }

    private void mostrarSobre() {
        String mensagem = 
            "📝 App de Anotações v1.0\n" +
            "🇧🇷 Um simples editor de texto em Java\n" +
            "🇺🇸 A simple text editor in Java\n\n" +
            "Desenvolvido com Java Swing\n" +
            "Developed with Java Swing\n\n" +
            "Funcionalidades / Features:\n" +
            "• Novo, Abrir, Salvar arquivos\n" +
            "• New, Open, Save files\n" +
            "• Atalhos de teclado\n" +
            "• Keyboard shortcuts\n" +
            "• Interface bilíngue\n" +
            "• Bilingual interface";

        JOptionPane.showMessageDialog(this, mensagem, 
            "Sobre / About", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Configurar Look and Feel do sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            // Se não conseguir, usa o padrão
        }

        // Executar na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            new AppDeNotas();
        });
    }
}
