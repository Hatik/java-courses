import java.util.Scanner;
public class InteractRunner{

    public static void main(String[] arg)
    {
        Scanner input = new Scanner(System.in);
        try{
            Calculator calc = new Calculator();
            String exit = "no";
            while (!exit.equals("yes")){
                System.out.println("Enter first arg: ");
                String first = input.next();
                System.out.println("Enter second arg: ");
                String second = input.next();
                calc.add(Integer.valueOf(first), Integer.valueOf(second));
                System.out.println("Result: " + calc.getResult());
                calc.cleanResult();
                System.out.println("Exit: yes/no?");
                exit = input.next();
            }
        }
        finally {
            input.close();
        }
    }
}