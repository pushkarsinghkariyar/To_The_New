package com.company;

import java.io.*;

public class Question1 {
    public static void main(String[] args) throws IOException{

        InputStream is = null; OutputStream os = null;
        File source= new File("/home/pushkar/Desktop/file.txt");
        File destination= new File("/home/pushkar/Desktop/exercise_solutions/filecopy.txt");
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(destination);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = is.read(buf)) > 0) {
                os.write(buf, 0, bytesRead); }
        }
        finally{
            if(is!=null)
            is.close();
            if(os!=null)
            os.close();
        }
    }
}
