package oclab2;

public class Thread {
	private State state;
    private int quant;
    private String Name;
    private int time;

    public Thread(){
        state = State.Ready;
    }

    public String getName() {
        return Name;
    }

    public int getTime() { 
    	return time; 
    }
    
    public State getState() {
        return state;
    }
    
    public void setName(String Name) {
        this.Name = Name;
    }
    
    public void setQuant(int quant) {
        this.quant = quant;
        this.time = (int)(Math.random() * (quant + 40));
    }

    public void setState(State state){
        System.out.print(Name + ": из " + this.state + " в ");
        this.state = state;
        System.out.println(state);
    }
    
    public void Work() {
        time = time - quant;
        if(time <= 0 ) {
            setState(State.Finish);
            return;
        }
        setState(State.Ready);
    }
}
