import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class reversePolishCalculator {
    //(3+4)*5-6 => 3 4 + 5 * 6 -
    public static void main(String[] args) {
        String suffixExpression = "30 4 + 5 * 6 -";
        reversePolishCalculator calculator = new reversePolishCalculator();
        List<String> list = calculator.getlist(suffixExpression);
        int result = calculator.calculator(list);
        System.out.println(result);
    }

    public int calculator(List<String> list) {
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                String data1 = stack.pop();
                String data2 = stack.pop();
                int result = calculate(data1, data2, str);
                stack.push(result + "");
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public int calculate(String num1, String num2, String operation) {
        int data1 = Integer.parseInt(num1);
        int data2 = Integer.parseInt(num2);
        switch (operation) {
            case "+":
                return data1 + data2;
            case "-":
                return data2 - data1;
            case "*":
                return data1 * data2;
            case "/":
                return data2 / data1;
            default:
                throw new RuntimeException("操作符有误");
        }
    }

    public List<String> getlist(String Expression) {
        String[] split = Expression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String string : split) {
            list.add(string);
        }
        return list;
    }
}
