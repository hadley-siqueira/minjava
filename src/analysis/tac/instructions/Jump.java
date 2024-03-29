package analysis.tac.instructions;

import analysis.tac.TABasicBlockVisitor;

public class Jump extends TAInstruction {
  private Label target;

  public Jump(Label l) {
    target = l;
  }

  public Label getTarget() {
    return target;
  }

  public void setTarget(Label l) {
    target = l;
  }

  @Override
  public String toString() {
    return "goto " + target.toString();
  }

  @Override
  public void accept(TABasicBlockVisitor v) {
    v.visit(this);
  }
}
