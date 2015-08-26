package threads.pkg2.exercise4;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

/**
 * @author Lars Mortensen
 */
class DeadLockDetector extends Thread {

    ThreadMXBean bean = ManagementFactory.getThreadMXBean();

    @Override
    public void run() {
        while (true) {
            long[] threadIds = bean.findDeadlockedThreads();
            for (long threadId : threadIds) {
                System.out.println(threadId);
            }
        }
    }
}
