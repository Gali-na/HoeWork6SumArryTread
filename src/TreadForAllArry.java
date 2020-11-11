public class TreadForAllArry  implements Runnable{
    private int []arry;

    public TreadForAllArry(int[] arry) {
        this.arry = arry;
    }

    public TreadForAllArry() {

    }

    private long sumArry(int []arry) {
        long rezult =0;
        for (int i=0;i<arry.length;i++){
            rezult =rezult+arry[i];
        }
        return rezult;
    }
    @Override
    public void run() {
     SumNambersArryForOneTread.setSumIfTread(sumArry(this.arry));
    }
}
