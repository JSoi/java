package com.practice.functional;

public class ConsumerPractice {
    public static void main(String[] args) {
//        Consumer<Long> consumer = a -> System.out.println(a + " is the value");
//        consumer.accept(2L);
//        consumer.accept(3L);
//        consumer.accept(4L);
//        consumer.andThen(a -> System.out.println("I said " + a + " is the value")).accept(100L);
        ServiceManager sm = new ServiceManager(new MyTimer());
        Timeout timeoutInstance = sm.myTimeout(timeout -> System.out.println(timeout.toString()), 2L, 3L);

    }

    interface TimerTask {
        void run(Timeout timeout);
    }

    interface Timer {
        Timeout newTimeout(TimerTask task, long duration);
    }

    interface Timeout {
        TimerTask task();
        Timer timer();

    }

    static class MyTimer implements Timer {
        @Override
        public Timeout newTimeout(TimerTask task, long duration) {
            return new MyTimeOut(this);
        }
    }

    static class MyTimeOut implements Timeout {
        private final Timer timer;

        public MyTimeOut(Timer timer) {
            this.timer = timer;
        }

        public TimerTask task() {
            return null;
        }

        public Timer timer() {
            return null;
        }
    }

    static class ServiceManager {
        private final MyTimer myTimer;

        ServiceManager(MyTimer myTimer) {
            this.myTimer = myTimer;
        }

        Timeout myTimeout(TimerTask task, long delay, long duration) {
            return this.myTimer.newTimeout(task, duration);
        }
    }

}
