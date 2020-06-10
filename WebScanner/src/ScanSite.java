import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ScanSite {
    public  ArrayList<String> Line=new ArrayList<String>(){};
    public ScanSite(){}
    public void Scanning (InputStream pack){
        ArrayList<String> Line1=new ArrayList<String>() {};
        InputStreamReader in=new InputStreamReader(pack);
        BufferedReader Scan= new BufferedReader(in);
        try{
            String linew;
            while ((linew=Scan.readLine())!=null){
                if (linew.length()>10) {
                    if (linew.indexOf("http://") > -1) {
                        linew = linew.substring(linew.indexOf("http://"));
                        Line1.add(linew.substring(0, linew.indexOf(" ")));
                    }
                }
            }
            Line=Line1;
        }
        catch(IOException ex) {Line=Line1;}
    }
    public ArrayList<String> getLine(){return Line;}
}