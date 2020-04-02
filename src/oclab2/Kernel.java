package oclab2;

import java.util.ArrayList;
import java.util.HashMap;

public class Kernel {
	private ArrayList<Process> ProcessArrayList;
	ArrayList<Thread> threadArrayList; 
	int timeThreads;
    private int time;

    public Kernel(int time){
    	threadArrayList = new ArrayList<Thread>();
        int count = 2;
        ProcessArrayList = new ArrayList<Process>();
       
        for(int i = 0; i < count; i++) {
            Process Process = new Process(time, "Process" + (i + 1), this);
            ProcessArrayList.add(Process);
        }
    }

    private void processTime(){
        time = 0;
        for (Process Process: ProcessArrayList) {
            time += Process.getTime();
        }
    }

    public void RunProcess(){
        for (Process Process: ProcessArrayList) {
            if(Process.getState() == State.Ready) {
            	Process.setState(State.Action);
            	Process.Work();
            }
        }
    }
    
    public void RunThreads(ArrayList<Thread> threadArrayList) {
        for (Thread thread:  threadArrayList) {
            if(thread.getState() == State.Ready){
                thread.setState(State.Action);
                thread.Work();
            }
        }
    }
    
    public boolean CheckAll(){
        processTime();
        if(time <= 0){
            return true;
        }
        return false;
    }
}
