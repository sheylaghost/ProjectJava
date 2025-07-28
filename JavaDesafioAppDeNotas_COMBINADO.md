Br-PT ## 💡 **Desafio do Dia: Criar um App de Notas em Java!**

---

### 🎯 Objetivo:

Hoje o seu desafio é criar um **aplicativo de anotações em Java**, que funcione como um bloquinho de notas — igual ao Notepad do Windows, só que feito por você!

Você vai usar **Java Swing**, a biblioteca gráfica padrão do Java, para construir a interface.

---

### 🧩 Requisitos do App:

1. **Área de Texto**
   → Um espaço onde o usuário pode digitar suas anotações.

2. **Menu "Arquivo"** com as opções:

   * **Novo**: limpa o campo de texto para começar do zero.
   * **Abrir**: permite abrir um arquivo .txt salvo no computador.
   * **Salvar**: salva a anotação atual em um arquivo .txt.
   * **Sair**: fecha o aplicativo.

---

### 🧠 Conceitos que você vai praticar:

✅ Java Swing (interface gráfica)
✅ Componentes gráficos: JTextArea, JScrollPane, JMenu, JMenuItem
✅ Manipulação de arquivos com BufferedReader e BufferedWriter
✅ Eventos com ActionListener
✅ Estrutura básica de um aplicativo com janela (JFrame)

---

### 🧪 Nível de dificuldade:

**Intermediário** – Ideal para quem já sabe usar classes, métodos e quer aprender a trabalhar com janelas e arquivos no Java.

---

### 🔨 Ferramentas recomendadas:

* **Java JDK 8 ou superior**
* **IntelliJ IDEA** ou qualquer editor de Java

---

### 📝 Dica:

Se você dominar esse desafio, poderá:

* Criar mais funções, como mudar a cor da fonte, salvar automaticamente, ou exportar em PDF!
* Usar o mesmo conhecimento para criar editores, chats, agendas ou diários.

---

### 🚀 Pronto para o desafio?

usa-EN 💡 Challenge of the Day: Build a Notes App in Java!
🎯 Objective:
Today’s challenge is to create a notes application in Java that works like a simple notepad — just like the Notepad on Windows, but made by you!

You’ll use Java Swing, the standard Java GUI library, to build the interface.

🧩 App Requirements:
Text Area
→ A space where users can type their notes.

"File" Menu with the following options:

New: clears the text area to start fresh.

Open: allows the user to open a saved .txt file.

Save: saves the current note into a .txt file.

Exit: closes the application.

🧠 Concepts You'll Practice:
✅ Java Swing (GUI)
✅ UI components: JTextArea, JScrollPane, JMenu, JMenuItem
✅ File handling with BufferedReader and BufferedWriter
✅ Event handling using ActionListener
✅ Basic app structure with JFrame

🧪 Difficulty Level:
Intermediate – Perfect for those who already understand classes, methods, and want to explore GUI and file handling in Java.

🔨 Recommended Tools:
Java JDK 8 or higher

IntelliJ IDEA or any Java IDE

📝 Tip:
Once you master this challenge, you can:

Add new features like font color, autosave, or even export to PDF!

Use the same knowledge to build editors, chat apps, calendars, or personal journals.

🚀 Ready for the challenge?
Note: Challenge proposed by ChatGPT

## 💻 Resultado/Resolucion (App.java):

```java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AppDeNotas extends JFrame {
    private JTextArea areaDeTexto;

    public AppDeNotas() {
        setTitle("📝 App de Anotações");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        areaDeTexto = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaDeTexto);
        add(scroll);

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opções");

        JMenuItem salvar = new JMenuItem("Salvar");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem limpar = new JMenuItem("Limpar");

        salvar.addActionListener(e -> salvarTexto());
        abrir.addActionListener(e -> abrirTexto());
        limpar.addActionListener(e -> areaDeTexto.setText(""));

        menu.add(salvar);
        menu.add(abrir);
        menu.add(limpar);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void salvarTexto() {
        try {
            FileWriter fw = new FileWriter("notas.txt");
            fw.write(areaDeTexto.getText());
            fw.close();
            JOptionPane.showMessageDialog(this, "Notas salvas com sucesso!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar!");
        }
    }

    private void abrirTexto() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("notas.txt"));
            areaDeTexto.read(br, null);
            br.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Erro ao abrir arquivo!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AppDeNotas().setVisible(true));
    }
}

```
