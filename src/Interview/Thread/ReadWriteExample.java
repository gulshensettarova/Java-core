package Interview.Thread;

import java.util.ServiceConfigurationError;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteExample {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private String data="Gulshan";

    public String readData(){
        lock.readLock().lock();
        try{
            return data;
        }
        finally {
            lock.readLock().unlock();
        }
    }

    public void writeData(String newData){
        lock.writeLock().lock();
        try {
            data=newData;
        }
        finally {
            lock.writeLock().unlock();
        }
    }

}
