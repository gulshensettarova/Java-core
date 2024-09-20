package Interview.Thread;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;

public class ParkingLotWithSemaphora {
    // Park yeri icazələrinin sayı (məsələn, 3 maşın yerinə icazə var)
    private static final  int PARKING_SPOTS=3;
    private static final Semaphore parkingLot=new Semaphore(PARKING_SPOTS);

    public static void main(String[] args) {
        // Park yerinə daxil olan 10 maşın nümunəsi
        for (int i = 1; i <= 10; i++) {
            final int carNumber=i;
            new Thread(()->{
                try{
                    // Park yerindən yer almağa çalışır
                    System.out.println("Maşın "+ carNumber+" park yerini almağa çalışır."+ LocalTime.now());
                    parkingLot.acquire();// Maşın park yerini alır (icazə alır)
                    System.out.println("Maşın " + carNumber + " park yerini aldı."+ LocalTime.now());

                    // Park yeri ilə işin simulyasiyası üçün gecikmə
                    Thread.sleep((int) (Math.random() * 2000));
                }
                catch (InterruptedException exception){
                    exception.printStackTrace();
                }
                finally {
                    // Park yerini boşaldır
                    System.out.println("Maşın " + carNumber + " park yerini boşaldır."+ LocalTime.now());
                    parkingLot.release(); // Maşın park yerini boşaldır (icazəni sərbəst buraxır)
                }
            }).start();
        }
    }
}
