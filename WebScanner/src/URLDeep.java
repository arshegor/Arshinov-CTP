public class URLDeep {
    private String URl;
    private int depth;
    public URLDeep() {
        depth=0;
        URl="";
    }
    public URLDeep(String URL,int depth) {
        this.depth=depth;
        this.URl=URL;
    }
    public void setDepth(int depth) {
        this.depth = depth;
    }
    public void setURL(String URl){
        this.URl=URl;
    }
    public int getDepth() {
        return depth;
    }
    public String getURL(){
        return URl;
    }
}