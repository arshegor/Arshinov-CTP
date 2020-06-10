import java.io.*;
import java.net.*;


public class URLReader {

    private final String prot="http://";
    int len=prot.length();
    public boolean check(String URl,int depth){
        if (URl.length()<10)
            return false ;
        String s="";
        if ((depth > 0) && (depth < 80)) {
            if (URl.substring(0, len).equals(prot)){
                s=URl.substring(len+1);
                if (s.length()>0)

                    return true;
            }
        }

        return false;
    }
    protected void Reading(URLDeep site, WebScanner web){
        try{
            if (check(site.getURL(),site.getDepth())==true){
                URL s=new URL(site.getURL());
                String host=s.getHost();
                String path=s.getPath();
                Socket sitechek=new Socket(host,80);
                OutputStream outStream = sitechek.getOutputStream();
                PrintWriter writer = new PrintWriter(new BufferedOutputStream(outStream));
                writer.print("GET "+path + "HTTP/1.1\n" + "Host:" +host+"\n");

                writer.flush();

                ScanSite scan=new ScanSite();
                scan.Scanning(sitechek.getInputStream());
                for (String siteLine: scan.getLine()){
                    if (check(siteLine,site.getDepth()-1)){
                        if (!(web.getScanned().contains(siteLine))){
                            if (!(web.getNotScanned().contains(siteLine))){
                                URLDeep site2=new URLDeep(siteLine,site.getDepth()-1);
                                web.addNotScanned(site2);}
                        }
                    }
                }
                web.addScanned(site);
                sitechek.close();
            }
            web.remove();
        }
    catch (SocketException ex){web.remove();}
    catch (IOException ex1){web.remove();}
    }
}