package Module_5_2;

import java.util.ArrayList;
import java.util.List;

class ThreadSafeArray<E> {
    private final List<E> list = new ArrayList<>();

    public synchronized void addElement(E element) {
        list.add(element);
    }

    public synchronized int getSize() {
        return list.size();
    }

    public synchronized void removeElement(E element) {
        list.remove(element);
    }
}

public class ThreadSafeArrayMain {
    public static void main(String[] args) {
        ThreadSafeArray<String> threadSafeList = new ThreadSafeArray<>();

        Thread addThread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                threadSafeList.addElement("Element " + i);
            }
        });

        Thread addThread2 = new Thread(() -> {
            for (int i = 1000; i < 2000; i++) {
                threadSafeList.addElement("Element " + i);
            }
        });

        Thread removeThread1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                threadSafeList.removeElement("Element " + i);
            }
        });

        Thread removeThread2 = new Thread(() -> {
            for (int i = 500; i < 1000; i++) {
                threadSafeList.removeElement("Element " + i);
            }
        });

        addThread1.start();
        addThread2.start();
        removeThread1.start();
        removeThread2.start();

        try {
            addThread1.join();
            addThread2.join();
            removeThread1.join();
            removeThread2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        int finalSize = threadSafeList.getSize();
        System.out.printf("Final size of the collection: %d\n", finalSize);
    }
}
