package Operations;

public class AddStrategy implements OperationStrategy{
    @Override
    public Number operation(Number a, Number b){
        return a.doubleValue() + b.doubleValue();
    }
}
