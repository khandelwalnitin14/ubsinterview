import com.ubs.opsit.interviews.impl.BerlinClock;

public class BerlinClockRunner {
	
	 public static void main(String[] args) {

	        BerlinClock clock = new BerlinClock(); 

	        System.out.println("====== Berlin Clock ======");
	        clock.convertTime(args[0]);
	        clock.printClock();
	        System.out.println("==========================");
	    }

}
