package analysis.tac.instructions;

import analysis.tac.TABasicBlockVisitor;
import analysis.tac.variables.TAVariable;

public class ParameterSetup extends TAInstruction {
  private TAVariable parameter;

  public ParameterSetup(TAVariable v) {
    parameter = v;
  }

  public TAVariable getParameter() {
    return parameter;
  }

  @Override
  public String toString() {
    return "param " + parameter;
  }

  @Override
  public void accept(TABasicBlockVisitor v) {
    v.visit(this);
  }
}
