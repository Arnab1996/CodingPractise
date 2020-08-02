
public class Test1 {
	 private synchronized static void methodA() {
	        System.out.println("within A");
	        methodB();
	    }
	    
	    
	    private synchronized static void methodB() {
	        System.out.println("within B");
	    }
	  
	    
	    public static void main(String args[])
	    {
	       new Thread(()-> methodA()).start();
	       new Thread(()-> methodB()).start();
	    }
    

}
