import java.util.Stack;

public class Main {
    public static int pairwiseSum(Stack<Integer> numbers) {
        // пока в стеке больше одного элемента, выполняем попарное суммирование
        while (numbers.size() > 1) {
            Stack<Integer> tempStack = new Stack<>();

            // берём числа попарно из стека
            while (numbers.size() > 1) {
                int num1 = numbers.pop();
                int num2 = numbers.pop();
                tempStack.push(num1 + num2); // результат суммирования пары отправляем во временный стек
            }

            // если остался один элемент, добавляем его в следующий этап
            if (!numbers.isEmpty()) {
                tempStack.push(numbers.pop());
            }

            // переход к следующему этапу суммирования
            numbers = tempStack;
            System.out.println("Промежуточный результат: " + numbers); // выводим текущие значения
        }
        // оставшееся число в стеке - итоговый результат
        return numbers.pop();
    }

    public static void main(String[] args) {
        // пример чисел для суммирования
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(2);
        numbers.push(3);
        numbers.push(4);
        numbers.push(5);
        numbers.push(6);
        numbers.push(7);

        // выполняем попарное суммирование
        int result = pairwiseSum(numbers);
        System.out.println("Итоговое значение: " + result);
    }
}