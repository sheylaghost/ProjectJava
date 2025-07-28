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

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class AppDeNotas extends JFrame {

    private JTextArea areaDeTexto;

    public AppDeNotas() {
        setTitle("📝 App de Anotações");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        areaDeTexto = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaDeTexto);
        add(scroll, BorderLayout.CENTER);

        criarMenu();

        setVisible(true);
    }

    private void criarMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuArquivo = new JMenu("Arquivo");
        JMenuItem novoItem = new JMenuItem("Novo");
        JMenuItem abrirItem = new JMenuItem("Abrir");
        JMenuItem salvarItem = new JMenuItem("Salvar");
        JMenuItem sairItem = new JMenuItem("Sair");

        novoItem.addActionListener(e -> areaDeTexto.setText(""));
        abrirItem.addActionListener(e -> abrirArquivo());
        salvarItem.addActionListener(e -> salvarArquivo());
        sairItem.addActionListener(e -> System.exit(0));

        menuArquivo.add(novoItem);
        menuArquivo.add(abrirItem);
        menuArquivo.add(salvarItem);
        menuArquivo.addSeparator();
        menuArquivo.add(sairItem);

        menuBar.add(menuArquivo);
        setJMenuBar(menuBar);
    }

    private void abrirArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        int opcao = fileChooser.showOpenDialog(this);

        if (opcao == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try (BufferedReader leitor = new BufferedReader(new FileReader(arquivo))) {
                areaDeTexto.read(leitor, null);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao abrir arquivo.");
            }
        }
    }

    private void salvarArquivo() {
        JFileChooser fileChooser = new JFileChooser();
        int opcao = fileChooser.showSaveDialog(this);

        if (opcao == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            try (BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivo))) {
                areaDeTexto.write(escritor);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao salvar arquivo.");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppDeNotas::new);
    }
}
