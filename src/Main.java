import java.util.Random;
public class Main {
    public static void main(String[] args) {
        int countNumbers = 20000;
        int countNumbersInArry = 1000;
        int[] arryTest = new int[countNumbers];

        for (int i = 0; i < countNumbers; i++) {
            Random random = new Random();
            int num = 1 + random.nextInt(9);
            arryTest[i] = num;
        }
        int countArrys = countNumbers / countNumbersInArry;

        Thread[] threads = new Thread[countArrys];
        int elementStart = 0;
        int elementFinish = 1000;

        for (int i = 0; i < countArrys; i++) {
            threads[i] = new Thread(new MyThread(elementStart, elementFinish, arryTest));
            elementStart = elementStart + 1000;
            elementFinish = elementFinish + 1000;
        }

       long timForLotTreadsStart = System.currentTimeMillis();

        for (int i = 0; i < countArrys; i++) {
            threads[i].start();
        }

        for (int i = 0; i < countArrys; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long timForLotTreadsFinish = System.currentTimeMillis();
        System.out.println(SumIfTread.getSumIfTread());
        System.out.println("Running time in multithreaded mode");
        System.out.println(timForLotTreadsFinish - timForLotTreadsStart);

        long timForStart = System.currentTimeMillis();
        Thread threadAllArry =new Thread(new TreadForAllArry(arryTest));
        threadAllArry.start();
        try {
            threadAllArry.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long timForFinish = System.currentTimeMillis();
        System.out.println();
        System.out.println("Single-threaded operating time" );
        System.out.println(SumNambersArryForOneTread.getSumIfTread());
        System.out.println(timForFinish-timForStart);
        long timForOneTreadStart = System.currentTimeMillis();
        int a = 0;
        for (int i = 0; i < arryTest.length; i++) {

            a = a + arryTest[i];

        }
        System.out.println();
        System.out.println(a);

        long timForOneTreadFinish = System.currentTimeMillis();
        System.out.println("main-threaded operating time");
        System.out.println(timForOneTreadFinish - timForOneTreadStart);
    }
}
