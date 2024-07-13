/*
2 Напишите программу, которая вычисляет какую-либо сложную функцию для каждого
целого числа от 1 до N, N – входной параметр (большое число, например, 10 000 000)
N – ввод с консоли. Результат выводится на экран. Поскольку N – большое, необходимо
разбить вычисления на несколько частей и каждую часть вычислить в отдельном потоке
параллельно. Для каждой части нужно создать объект Task, внутри которого запомнить
данные для начала вычислений, а так же сохранить результат после завершения
вычислений. Каждый поток работает со своим объектом Task.
Примеры функций (сходящиеся ряды, удобны тем, что можно проверить результат
вычислений программы):
 */

package function_calculation;

import java.util.Scanner;

public class Total {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int t = 5;
        double[] results = new double[5];

        ConvergentSeries series1 = new ConvergentSeries(0, n / 5, results[0]); //Runnable ничего не возвращает
        ConvergentSeries series2 = new ConvergentSeries(n / 5 + 1, 2 * n / 5, results[1]);// как положить в result сумму?
        ConvergentSeries series3 = new ConvergentSeries(2 * n / 5 + 1, 3 * n / 5,results[2]);
        ConvergentSeries series4 = new ConvergentSeries(3 * n / 5 + 1, 4 * n / 5,results[3]);
        ConvergentSeries series5 = new ConvergentSeries(4 * n / 5 + 1, n, results[4]);

        Thread task1 = new Thread(series1);
        Thread task2 = new Thread(series2);
        Thread task3 = new Thread(series3);
        Thread task4 = new Thread(series4);
        Thread task5 = new Thread(series5);

        task1.start();
        task2.start();
        task3.start();
        task4.start();
        task5.start();

        task1.join();
        task2.join();
        task3.join();
        task4.join();
        task5.join();

    }
}
