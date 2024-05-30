import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static char action;

    public static void main(String[] args) throws Exception {
        System.out.println("Input: ");
        String userInput = scanner.nextLine();
        action = metodOperation(userInput);
        System.out.println("Output: ");
        String[] data;
        data = userInput.split("[+\\-*/]");

        for (int i=0; i<data.length; i++) {
            if (data[0].length() > 10 || data[1].length() > 10)
                throw new Exception("Input number or string is too large");
            String regex = "[^\\d]+";
            String[] str = data[0].split(regex);
            for (String st : str) {
                throw new Exception("The first argument can not be a number");
            }
        }
        if (action == '+') {
            data = userInput.split("\\+");
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replace("\"", "");
            }
            inQuotes.printInQuotes(data[0] + data[1]);
        } else if (action == '*') {
            data = userInput.split("\\*");
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replace("\"", "");
            }
            int multiply = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiply; i++) {
                result += data[0];
            }
            int length = result.length();
            if (length > 40) {
                result = result.substring(0, 40);
                inQuotes.printInQuotes(result + "...");
            } else {
                inQuotes.printInQuotes(result);
            }
        } else if (action == '-') {
            data = userInput.split("\"-");
            for (int i = 0; i < data.length; i++) {
               data[i] = data[i].replace("\"", "");
            }
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                inQuotes.printInQuotes(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                inQuotes.printInQuotes(result);
            }
        } else if (action == '/') {
            data = userInput.split("/");
            for (int i = 0; i < data.length; i++) {
                data[i] = data[i].replace("\"", "");
            }
            int newLen = data[0].length() / Integer.parseInt(data[1]);
            String result = data[0].substring(0, newLen);
            inQuotes.printInQuotes(result);
        }
    }

    //         Метод поиска знака операции
    private static char metodOperation(String userInput) throws Exception {

        char action;
        String[] data;
        
//      Заполняем символьный массив символами строки которую ввел пользователь и по ходу ловим знак операции
        if (userInput.contains("+")) {
            data = userInput.split("\\+");
            action = '+';
        } else if (userInput.contains("-")) {
            data = userInput.split("-");
            action = '-';
        } else if (userInput.contains("*")) {
            data = userInput.split("\\*");
            action = '*';
        } else if (userInput.contains("/")) {
            data = userInput.split("/");
            action = '/';
        } else {
            throw new Exception("Invalid input");
        }
        return action;
    }
}
class inQuotes {
    static void printInQuotes(String text) {
        System.out.println("\"" + text + "\"");
    }
}
