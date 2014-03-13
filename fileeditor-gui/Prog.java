/** Written in tutorial **/

class Prog {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        LoadController c1 = new LoadController(view, model);
        SaveController c2 = new SaveController(view, model);

        view.load.addActionListener(c1);
        view.save.addActionListener(c2);
    }
}


