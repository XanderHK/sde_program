package Status;

public class OffStrategy implements CalculatorStatusStrategy{
    String status = "OFF";

    @Override
    public String getStatus() {
        return status;
    }

}
