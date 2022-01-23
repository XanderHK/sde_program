package Status;

public class OnStrategy implements CalculatorStatusStrategy{
    public String status = "ON";

    @Override
    public String getStatus() {
        return status;
    }
}
