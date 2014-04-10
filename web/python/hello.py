from flask import Flask, request, render_template
import cgi

app = Flask(__name__)

@app.route("/")
def FirstPage():
    name = request.args.get('name', 'John Doe')
    return render_template("firstpage.html", name=name)

@app.route("/view")
def SecondPage():
    filename = request.args.get("file")
    if filename:
        return render_template("secondpage.html", 
            filename=filename, content=open(filename).read())
    else:
        return """ No file found """
    
if __name__ == '__main__':
    app.run(debug=True)
