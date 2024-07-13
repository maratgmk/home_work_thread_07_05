/*
1 Создайте класс Траншея. У траншеи есть целевая длина и текущая длина. Создайте класс Землекоп, объекты
которого копают траншею (увеличивают текущую длину), пока не будет достигнута целевая длина. Каждый
землекоп может прокопать 1 м траншеи, а затем он отдыхает 10 секунд. В программе создайте траншею и
двух землекопов. Измерьте, за какое время траншею прокопает один землекоп и за какое время с такой же
траншеей управятся двое.
 */

import trench.Digger;
import trench.Trench;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Trench trench = new Trench(10);
        Digger digger1 = new Digger(trench);
        Digger digger2 = new Digger(trench);


        long startTime = System.currentTimeMillis();

        digger2.start();
        digger1.start();
        digger1.join();
        digger2.join();
        System.out.println("Trench was completed during " + (System.currentTimeMillis() - startTime));


        long startTimeII = System.currentTimeMillis();
        Trench trench1 = new Trench(10);
        Digger digger3 = new Digger(trench1);

        digger3.start();
        digger3.join();
        System.out.println("Trench was completed during " + (System.currentTimeMillis() - startTimeII));


    }
}