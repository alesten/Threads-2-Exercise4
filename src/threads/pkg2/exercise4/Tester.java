package threads.pkg2.exercise4;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Tester {
  public static void main(String[] args) {
      
      new DeadLockDetector().start();
      
    try {
      ResourceContainer resources = new ResourceContainer();
      ResourceUser1 t1 = new ResourceUser1(resources);
      ResourceUser2 t2 = new ResourceUser2(resources);
      t1.start();
      t2.start();
          
      t1.join();
      t2.join();
      
      System.out.println("Done");
      System.out.println("Words produced: "+resources.getResourceWords().size());
      System.out.println("Numbers produced: "+resources.getResourceNumbers().size());
    } catch (InterruptedException ex) {
      Logger.getLogger(Tester.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}

/*
    Programmet giver en deadlock efter threads prøver at få 
    resources men den anden ikke har givet slip på dem endnu

    I stedet for at unlock begge resources på en gang
    tager jeg og unlocker dem når de ikke længere er brugt
*/
