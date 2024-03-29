package analysis.syntaxtree;
import analysis.visitors.TypeVisitor;
import analysis.visitors.Visitor;

public interface ClassDecl {
    public void accept(Visitor v);
    public Type accept(TypeVisitor v);
}
