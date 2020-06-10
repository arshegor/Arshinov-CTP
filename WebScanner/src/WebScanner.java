import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;


public class WebScanner{
    private LinkedList<URLDeep> Scanned=new LinkedList<URLDeep>();
    private LinkedList<URLDeep> NotScanned=new LinkedList<URLDeep>();
    public static void main (String args[]) {
        Scanner Str=new Scanner(System.in);
        URLReader scan=new URLReader();
        URLDeep site=new URLDeep(Str.nextLine(),Str.nextInt());
        WebScanner Al =new WebScanner();
        Al.addNotScanned(site);
        while (Al.getNotScanned().isEmpty()!=true){
            scan.Reading(Al.getNotScanned().getFirst(),Al);
        }
        try{
            File file=new File("Link.txt");
            FileWriter wfile=new FileWriter(file);
            BufferedWriter writer =new BufferedWriter(wfile);
            String line;
            for (URLDeep lines:Al.getScanned()){
                line=lines.getURL()+ " " + lines.getURL() + "\n\r";
                wfile.write(line);
            }
            wfile.close();
        }
        catch (IOException ex2){ex2.printStackTrace();}
    }

    public LinkedList<URLDeep> getNotScanned() {return NotScanned; }
    public LinkedList<URLDeep> getScanned() {return Scanned;}
    public void addScanned(URLDeep site){Scanned.add(site);}
    public void addNotScanned(URLDeep site){NotScanned.add(site);}
    public void remove(){NotScanned.removeFirst();}
}