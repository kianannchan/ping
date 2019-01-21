package pingPkg;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class controller {

    private ArrayList <pingModel> pingObject = new ArrayList<pingModel>();

    public void checkIP(){
        ExecutorService executor = Executors.newFixedThreadPool(100);
        for(int index = 0; index < 255; index += 5) {
            pingModel ping = new pingModel(index, index + 4);
            executor.execute(ping);
            pingObject.add(ping);
        }
    }

    public ArrayList <pingModel> getPingObject(){
            return pingObject;
    }

    public void writeToFile(String content)  {
        File file = new File("log.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            BufferedWriter br = new BufferedWriter(fr);
            br.write(content);
            br.newLine();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
