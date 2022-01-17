package Operations;

public class MultiplyStrategy implements OperationStrategy {
    @Override
    public Number execute(Number a, Number b){
        return a.doubleValue() * b.doubleValue();
    }
}
