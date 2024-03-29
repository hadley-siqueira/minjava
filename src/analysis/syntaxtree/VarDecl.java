package analysis.syntaxtree;
import analysis.visitors.TypeVisitor;
import analysis.visitors.Visitor;

public class VarDecl {
    public Type varType;
    public Identifier varId;

    public VarDecl(Type at, Identifier ai) {
        varType = at;
        varId = ai;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public Type accept(TypeVisitor v) {
        return v.visit(this);
    }
}
