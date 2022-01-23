## Creational Patterns

### Singleton Pattern (Xander)

```java
public class Calculator {
    //
    public static Calculator getInstance() {
        if (instance == null) {
            instance = new Calculator();
        }
        return instance;
    }
}
```
```
// To get access to the calculator instance, you invoke the static method "getInstance"
Calculator calculator = Calculator.getInstance();
```

Normally we would instantiate an instance of a class by using the `new` keyword, but by applying the Singleton Pattern to our code we can create and grab the instance by invoking `getInstance`. This ensures that we only have one instance, while also making it globally accessible. 

## Behavioral Patterns

### Strategy Pattern (Xander)

```java
public interface OperationStrategy {
    Number execute(Number a, Number b);
}

public class MultiplyStrategy implements OperationStrategy {
    @Override
    public Number execute(Number a, Number b){
        return a.doubleValue() * b.doubleValue();
    }
}

public class Calculator {
    
    private final HashMap<String, OperationStrategy> strategies;

    Calculator() {
        strategies = new HashMap<>();
        strategies.put("-", new SubtractStrategy());
        strategies.put("+", new AddStrategy());
        strategies.put("/", new DivideStrategy());
        strategies.put("*", new MultiplyStrategy());
    }
    
    public Number calculate(Number a, Number b, String operator) {
        return strategies.get(operator).execute(a, b);
    }
}
```
```
Calculator calculator = Calculator.getInstance();

calculator.calculate(5, 5, "+");
```
First off we declare an interface, which specifies the name and parameters of the method being implemented by the different strategies, then we create a class that implements the interface and the method declared by it. Finally, in our `Calculator` class we create a `Hashmap` (With String type for key and `OperationStrategy` type for value) containing all of our strategies as value and an arithmetic operator as key.

Once we invoke the `calculate` method and pass it 2 numbers and an operator (e.g. `+`) it will get the corresponding strategy to operator parameter we passed and then it will invoke the `execute` method on it.

## Structural Patterns

### Adapter Pattern (Xander)

java
public class InputAdapter {
private final ConsoleReader reader;

    public InputAdapter(ConsoleReader reader){
        this.reader = reader;
    }

    public Pair parse(){
        String rawInput = reader.readLine();
        String trimmed = rawInput.replaceAll("\\s+","");
        List<String> operators = new ArrayList<>();
        List<Number> numbers = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        for(int i = 0; i < trimmed.length(); i++) {
            String currentChar = Character.toString(trimmed.charAt(i));
            if (currentChar.matches("[+\\-*/.]")) {
                numbers.add(convertToNumber(temp.toString()));
                temp = new StringBuilder();
                operators.add(currentChar);
                continue;
            }

            temp.append(currentChar);

            if(i == (trimmed.length() - 1)) numbers.add(convertToNumber(temp.toString()));
        }

        return new Pair(numbers, operators);
    }
}

InputAdapter adapter = new InputAdapter(new ConsoleReader());
Pair input = adapter.parse();

This adapters makes the input from the ConsoleReader usable to our calculator. We give the string to the InputAdapter which it uses when we call parse() which turns it into a list of operators and numbers.

To make use of the adapter you create a new instance, pass it the ConsoleReader and call the parse() method



### Adapter & Singleton Pattern Rob

public class StatusAdapter {
public static CalculatorStatusStrategy statusStrategy;
private ConsoleReader reader;
private static StatusAdapter instance;

    public StatusAdapter(ConsoleReader reader){
        this.reader = reader;
    }

    public String viewStatus() {
        return statusStrategy.getStatus();
    }

    public void printStatement() {
        System.out.println("Type: 1 to turn the calculator ON");
        System.out.println("Type: 2 to turn the calculator OFF");
        System.out.println("Type: 3 to RESET");
    }

    public int userInput() {
        String rawInput = reader.readLine();
        int convertedNumber = Integer.parseInt(rawInput);
        return convertedNumber;
    }

    public static StatusAdapter getInstance(ConsoleReader reader){
        if(instance == null){
            instance = new StatusAdapter(reader);
        }
        return instance;
    }

}

Ik probeerde een Strategy te maken met ON OFF en RESET maar het bleek lastiger dan verwacht
dus heb ik het omgezet naar een Adapter (Structural Patterns). De adapter is nu zo gemaakt 
dat de user kan aangeven in de console wat hij wil doen of hij de calculator wilt activeren
deactiveren of opnieuw wilt opstarten (handig voor bij eventuele foutmeldingen).
Ook is de StatusAdapter een tussenweg voor zowel het aanspreken van de Strategy (die helaas niet werkt).
En de console reader dit zodat de main makkelijk gebruik zou kunnen maken van de strategy.

De Singleton zorgt ervoor dat de Adapter class maar 1x wordt aangemaakt. Om zo onnodige duplicatie te voorkomen.
Ook is deze globaal beschikbaar voor andere classes om zo te controleren wat de status is van de calculator (aan/uit/reset)

