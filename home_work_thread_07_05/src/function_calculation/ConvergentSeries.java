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

public class ConvergentSeries implements Runnable{
    private final long first;
    private final long last;


    public ConvergentSeries(long first, long last, double sum) {
        this.first = first;
        this.last = last;
    }


    @Override
    public synchronized void run() {

        double  sum = 0.0;
        for ( long i = first; i <= last; i++) {
            sum = sum + Math.pow((double) 1/2,i);
        }

        System.out.println(Thread.currentThread().threadId() + " " +  sum);
    }

}
