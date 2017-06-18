package pw.jor.ops;

import java.nio.file.Paths;

public class Main {

    public static void main(String[] args){

        try{
            NasCleanup nasCleanup = new NasCleanup(Paths.get(args[0]));
            nasCleanup.cleanup();
        } catch (Exception e){
            System.out.println(e);
        }
    }
}
