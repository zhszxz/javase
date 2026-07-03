public class Calculator {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        int result = calculator.calculator("700+200*10-400");
        System.out.println(result);
    }

    public int calculator(String expression) {
        Stack dataStack = new Stack();
        Stack symbolStack = new Stack();
        String keepNum = "";
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= '0' && ch <= '9') {//数字
                keepNum += ch;
                if (i == expression.length() - 1) {
                    dataStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                } else if (expression.charAt(i + 1) < '0' || expression.charAt(i + 1) > '9') {
                    dataStack.push(Integer.parseInt(keepNum));
                    keepNum = "";
                }
            } else if (symbolStack.isEmpty()) {//符号栈为空直接进符号栈
                symbolStack.push(ch);
            } else if (getPriority(ch) <= getPriority(symbolStack.peek())) {//当前符号优先级小于等于栈中符号，进行计算
                int data1 = dataStack.pop();
                int data2 = dataStack.pop();
                int operation = symbolStack.pop();
                int result = calculate(data1, data2, operation);
                dataStack.push(result);
                symbolStack.push(ch);
            } else {
                symbolStack.push(ch);
            }
        }
        while (!symbolStack.isEmpty()) {
            int data1 = dataStack.pop();
            int data2 = dataStack.pop();
            int operation = symbolStack.pop();
            int result = calculate(data1, data2, operation);
            dataStack.push(result);
        }
        return dataStack.pop();
    }

    public int getPriority(int operation) {
        if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '+' || operation == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public int calculate(int data1, int data2, int operation) {
        switch (operation) {
            case '+':
                return data1 + data2;
            case '-':
                return data2 - data1;
            case '*':
                return data1 * data2;
            case '/':
                return data2 / data1;
            default:
                throw new RuntimeException("操作符有误");
        }
    }

}
