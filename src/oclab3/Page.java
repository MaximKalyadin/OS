package oclab3;

public class Page {
	private boolean used = false;
    private long lastTime = 0;

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean absence) {
        this.used = absence;
    }
    
    public long getLastTime() {
    	return lastTime;
    }
    
    public void setLastTime(long time) {
    	lastTime = time;
    }
}
