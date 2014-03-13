import java.io.*;

class Model {
    public String filename;

    public Model() {
        this.filename = "";
    }

    public String getContent() {
        String content = "";
        try {
            String line;

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            line = reader.readLine();
            while(line != null) {
                content += line + "\n"; // this is slow, use StringBuffer for performant code
                line = reader.readLine();
            }
            reader.close();
        } catch(Exception e) {
            ;
        }
        return content;
    }
    public void saveContent(String content) {
        try {
            PrintStream writer = new PrintStream(new FileOutputStream(filename));
            writer.println(content);
        } catch(Exception e) {
        }
    }
}
