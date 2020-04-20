package oclab3;

public class Page {
	
    private boolean absence;
    private int numpage;
    private boolean r;

    public Page(boolean absence, boolean r){
        this.r = r;
        this.absence = absence;
    }

    public boolean isabsence() {
        return absence;
    }
    
    public boolean isR() {
        return r;
    }

    public void setabsence(boolean absence) {
        this.absence = absence;
    }


    public void setR(boolean r) {
        this.r = r;
    }

    public int getnumpage() {
        return numpage;
    }

    public void setnumpage(int numpage) {
        this.numpage = numpage;
    }

   
}
