public class MyThread  implements Runnable{
  private int indexBegin;
  private int indexFinsh;
  private int []arry;


    public MyThread(int indexStart, int indexStop, int[] arry) {
        this.indexBegin = indexStart;
        this.indexFinsh = indexStop;
        this.arry = arry;

    }

 public MyThread() {
 }


    private long sumArry(int []arry,int indexBegin,int indexFinsh) {
        long rezult =0;
        for (int i=indexBegin;i<indexFinsh;i++){
            rezult =rezult+arry[i];
        }
        return rezult;
    }


    @Override
    public void run() {
        SumIfTread.setSumIfTread(sumArry(this.arry,this.indexBegin,this.indexFinsh));
    }
}
