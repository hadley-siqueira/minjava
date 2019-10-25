package analysis.syntaxtree;
import analysis.visitors.TypeVisitor;
import analysis.visitors.Visitor;
import parser.Token;

public class Identifier extends Exp {
    public String name;
    private Token tok;

    public Identifier(Identifier i) {
        this(i.name, i.tok);
    }

    public Identifier(String as, Token token) {
        name = as;
        tok = token;
    }

    public Token getToken() {
        return tok;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }

    public String getDescriptor() {
        return name + ":" + tok.beginLine;
    }
}
