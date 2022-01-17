package Operations;

public class DivideStrategy implements OperationStrategy{
    @Override
    public Number execute(Number a, Number b){
        return a.doubleValue() / b.doubleValue();
    }
}
