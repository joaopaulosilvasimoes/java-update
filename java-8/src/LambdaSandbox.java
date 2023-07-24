import java.util.ArrayList;
import java.util.List;

@FunctionalInterface
interface CustomFunctionalInterfaceNoArgs
{

    void printOnScreen();

}

@FunctionalInterface
interface CustomFunctionalInterfaceWithArgs
{

    void mathOperator(Integer value1, Integer value2);

}

class CustomProduct
{

    String name;
    Double price;

    private String toStringFormat = "Product: %s - %f";

    public CustomProduct(String name, Double price)
    {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString()
    {
        return String.format(toStringFormat, name, price); 
    }

}

public class LambdaSandbox {

    public static void run()
    {

        //Old way.
        Thread thread1 = new Thread(new Runnable() {

            @Override
            public void run() {
   
                System.out.println("Thread 1 running");
            }
            
        });

        //New way.  
        Thread thread2 = new Thread(()-> System.out.println("Thread 2 running"));

        thread1.start();

        thread2.start();
     
        //Old way - No args.
        CustomFunctionalInterfaceNoArgs customFunctionalInterfaceNoArgs1 = new CustomFunctionalInterfaceNoArgs() {

            @Override
            public void printOnScreen() {
                 
                System.out.println("Print on screen 1");

            }

        };

        customFunctionalInterfaceNoArgs1.printOnScreen();

        //New way - No args.
        CustomFunctionalInterfaceNoArgs customFunctionalInterfaceNoArgs2 = () ->  System.out.println("Print on screen 2");

        customFunctionalInterfaceNoArgs2.printOnScreen();

        //Math Operations.

        //Old way - With args.
        CustomFunctionalInterfaceWithArgs sum = new CustomFunctionalInterfaceWithArgs() {

            @Override
            public void mathOperator(Integer value1, Integer value2) {
                 
                System.out.println("Sum: " + (value1 + value2));

            }

        };

        sum.mathOperator(1, 2);

        //New way - With args.
        CustomFunctionalInterfaceWithArgs subtract = (a, b) ->  System.out.println("Subtract: " + (a - b));

        subtract.mathOperator(1, 2);

        //New way - With args.
        CustomFunctionalInterfaceWithArgs multiply = (a, b) ->  System.out.println("Multiply: " + (a * b));

        multiply.mathOperator(1, 2);

        //New way - With args.
        CustomFunctionalInterfaceWithArgs divide = (Integer a, Integer b) ->  System.out.println("Divide: " + (a / b));

        divide.mathOperator(1, 2);

        //List.

        //New way - With args.
        List<CustomProduct> listCustomProduct = new ArrayList<CustomProduct>();

        listCustomProduct.add(new CustomProduct("Product 3", 3.0));
        listCustomProduct.add(new CustomProduct("Product 2", 2.0));
        listCustomProduct.add(new CustomProduct("Product 1", 1.0));

        //From interface: "java.util.Compatator", and method "compare"
        listCustomProduct.sort((p1, p2) -> p1.name.compareTo(p2.name));

        //Single statement.
        //From interface: "java.util.function.Consumer", and method "accept"
        listCustomProduct.forEach((p) -> System.out.println(p.toString()));

        //Multiples statements.
        listCustomProduct.forEach((p) -> 
        {
            System.out.println("---");
            System.out.println(p.toString());
        });

    }

}
