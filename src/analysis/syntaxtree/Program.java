package analysis.syntaxtree;
import analysis.visitors.TypeVisitor;
import analysis.visitors.Visitor;

public class Program {
    public MainClass mainC
    public ClassDeclList classList;

    public Program(MainClass ma, ClassDeclList cList) {
        mainC = ma;
        classList = cList;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
