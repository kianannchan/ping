package pingPkg;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class pingModel implements Runnable {

    private int start;
    private int end;
    private Map<Integer, Boolean> testResult = new HashMap<Integer, Boolean>();
    private String timeStamp;


    pingModel(int start, int end){
        this.start = start;
        this.end = end;
    }

    public void run() {
        try {

            while (true) {
                for (int index = start; index <= end; index++) {
                    InetAddress address = null;
                        boolean reachable = false;
                        address = InetAddress.getByName(new misc().getbaseIP() + index);
                        reachable = address.isReachable(5000);
                        //System.out.println("192.168.1." + index + ": " + reachable);
                        testResult.put(index, reachable);
                        timeStamp = new misc().timeStamp();

                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<Integer,Boolean> result(){
        return testResult;
    }

    public String time(){
        return timeStamp;
    }

}
