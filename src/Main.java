import Adapter.InputAdapter;
import Adapter.StatusAdapter;
import Console.ConsoleReader;
import Console.ConsoleLoader;
import Utils.Pair;

public class Main {



    public static void main(String[] args){
        StatusAdapter statusAdapter = StatusAdapter.getInstance(new ConsoleReader());
        ConsoleLoader consoleLoader = new ConsoleLoader();

        statusAdapter.printStatement();
        if (statusAdapter.userInput() == 1){
            System.out.println("Turned ON");
            InputAdapter adapter = new InputAdapter(new ConsoleReader());
            Pair input = adapter.parse();
            Calculator calculator = Calculator.getInstance();

            int index = 0;
            Number result = null;
            for(String operator : input.y){
                if(result == null) result = input.x.get(index);
                result = calculator.calculate(result, input.x.get(index + 1), operator);
                index++;
            }

            consoleLoader.loading();
            System.out.println("This is the result:");
            System.out.println(result);

            main(null);
        } else if (statusAdapter.userInput() == 2){
            System.out.println("Turned OFF");

        } else if (statusAdapter.userInput() == 3){
            System.out.println("Getting a RESET");
            consoleLoader.loading();
            main(null);
        } else {
            System.out.println("Wrong values we will shut down...");
        }
    }
}
