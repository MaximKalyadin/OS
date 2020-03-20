package oclab2;

import java.util.ArrayList;

public class RunTimeSystem {
	private ArrayList<Thread> threads;
	private int time;
	private int count;

    public RunTimeSystem(String ProcessName, int quant) {
        count = 5;
        time = quant / count;
        threads = new ArrayList<Thread>();
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread();
            thread.setQuant(time);
            thread.setName(ProcessName + " " + "Thread " + (i + 1));
            threads.add(thread);
        }
    }

    public void RunThreads(){
        for (Thread thread: threads) {
            if(thread.getState() == State.Ready){
                thread.setState(State.Action);
                thread.Work();
            }
        }
    }

    public ArrayList<Thread> getThreads() {
        return threads;
    }	
}
