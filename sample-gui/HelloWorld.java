import javax.swing.*;

public class HelloWorld extends JFrame {
    public HelloWorld() {
        JButton button = new JButton("Hello World");
        this.getContentPane().add(button);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new HelloWorld();
    }
}
