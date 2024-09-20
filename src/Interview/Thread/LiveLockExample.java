package Interview.Thread;

public class LiveLockExample {
    static class Person {
        private boolean givingWay = false;

        public boolean isGivingWay() {
            return givingWay;
        }

        public void giveWay() {
            givingWay = true;
            System.out.println(Thread.currentThread().getName() + " is giving way.");
        }

        public void pass() {
            givingWay = false;
            System.out.println(Thread.currentThread().getName() + " has passed.");
        }
    }

    public static void main(String[] args) {
        final Person person1 = new Person();
        final Person person2 = new Person();

        Thread thread1 = new Thread(() -> {
            while (!person1.isGivingWay()) {
                if (!person2.isGivingWay()) {
                    person1.giveWay();
                }
                try {
                    Thread.sleep(100); // small delay to better observe the livelock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Person 1");

        Thread thread2 = new Thread(() -> {
            while (!person2.isGivingWay()) {
                if (!person1.isGivingWay()) {
                    person2.giveWay();
                }
                try {
                    Thread.sleep(100); // small delay to better observe the livelock
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "Person 2");

        thread1.start();
        thread2.start();
    }
}
