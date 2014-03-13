import java.awt.event.*;

class SaveController implements ActionListener {
    View view;
    Model model;

    public SaveController(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {
        String content = this.view.content.getText();
        this.model.filename = this.view.filename.getText();
        this.model.saveContent(content);
    }
}
