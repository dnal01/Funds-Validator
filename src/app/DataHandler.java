package app;

import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.Thread.currentThread;

public class DataHandler {

    String[] fruits = new DataRepository().getData();

    public void getOutput() {
        // критичний блок коду
        synchronized (this) {
            StringBuilder sb = new StringBuilder();
            AtomicInteger count = new AtomicInteger(1);
            for (String fruit : fruits) {
                sb.append(String.format("(%d) %s ",
                        count.get(), fruit));
            }
            System.out.println(currentThread().getName() + ": " + sb);
        }
    }
}
