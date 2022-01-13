package Operations;

public class SubtractStrategy implements OperationStrategy{
    @Override
    public Number operation(Number a, Number b){
        return a.doubleValue() - b.doubleValue();
    }
}