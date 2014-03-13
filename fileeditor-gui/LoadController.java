import java.awt.event.*;

class LoadController implements ActionListener {
    View view;
    Model model;

    public LoadController(View view, Model model) {
        this.view = view;
        this.model = model;
    }

    public void actionPerformed(ActionEvent e) {
        model.filename = view.filename.getText();
        view.content.setText(model.getContent());
    }
}
