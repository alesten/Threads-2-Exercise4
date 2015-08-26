package threads.pkg2.exercise4;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

class ResourceUser1 extends Thread {

  ResourceContainer resource;

  ResourceUser1(ResourceContainer r) {
    resource = r;
  }
  boolean doRun = true;

  @Override
  public void run() {
    for (int i = 0; i < 100; i++) {
      try {
        System.out.println(Thread.currentThread().getName()+ " Get resource WORDS");
        List<String> words = resource.getResourceWords();
        words.add("Peter");
        words.add("Kurt");
        words.add("Hanne");
        resource.releaseResourceWords();
        System.out.println(Thread.currentThread().getName() + " Done with WORDS");

        Thread.sleep(1);//Simulate that using the resource takes som time 
        System.out.println(Thread.currentThread().getName()+ " Get resource NUMBERS");
        List<Integer> numbers = resource.getResourceNumbers();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        resource.releaseResourceNumbers();
        System.out.println(Thread.currentThread().getName() + " Done with NUMBERS");
      } catch (InterruptedException ex) {
        Logger.getLogger(ResourceUser1.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
