package oclab3;

public class Page {

    private boolean absence;
    private int numpage;

    public Page(boolean absence){
        this.absence = absence;
    }

    public boolean isabsence() {
        return absence;
    }

    public void setabsence(boolean absence) {
        this.absence = absence;
    }

    public int getnumpage() {
        return numpage;
    }

    public void setnumpage(int numpage) {
        this.numpage = numpage;
    }
}
