package Status;

public class ResetStrategy implements CalculatorStatusStrategy {
    public String status = "RESET";

    @Override
    public String getStatus() {
        return status;
    }

}
