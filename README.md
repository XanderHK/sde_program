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
