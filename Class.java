import java.util.Scanner;
public class Class {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        System.out.println("Input: ");
        String expression = scanner.nextLine();

        //expression = expression.replace("\"", " ");
        String[] data;
        char action;
        if (expression.contains("+")) {
            data = expression.split("\\+");
            action = '+';
        } else if (expression.contains("-")) {
            data = expression.split("-");
            action = '-';
        } else if (expression.contains("*")) {
            data = expression.split("\\*");
            action = '*';
        } else if (expression.contains("/")) {
            data = expression.split("/");
            action = '/';
        } else {
            throw new Exception("Invalid input");
        }
        if (action == '*' || action == '/'){
            if (data[1].contains("\""))
                throw new Exception("You can multiply or divide only in integer");
        }

        if (data[0].length() > 10 || data[1].length() > 10)
            throw new Exception("Input number or string is too large");
        data[0] = data[0].replace("\"", "");
        data[1] = data[1].replace("\"", "");
        String regex = "[^\\d]+";
        String[] str = data[0].split(regex);
        for(String st: str){
            throw new Exception("The first argument can not be a number");
        }


        for (int i=0; i<data.length; i++){
            data[i] = data[i].replace("\"", "");
        }
        if (action == '+') {
            System.out.println("Output: ");
            printInQuotes(data[0] + data[1]);
        }
        else if (action == '*') {
            int multiply = Integer.parseInt(data[1]);
            String result ="";
            for(int i=0; i< multiply; i++) {
                result+=data[0];
            }

            int length = result.length();
            if (length>40) {
                result = result.substring(0, 40);
                System.out.println("Output: ");
                printInQuotes(result + "...");
            }
            else {
                System.out.println("Output: ");
                printInQuotes(result);
            }
        }
        else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                printInQuotes(data[0]);
            }else{
                String result = data[0].substring(0,index);
                result+=data[0].substring(index+data[1].length());
                System.out.println("Output: ");
                printInQuotes(result);
            }
        }    else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            System.out.println("Output: ");
            printInQuotes(result);
        }

    }

    static void printInQuotes(String text){
        System.out.println("\""+text+"\"");
    }
}
