package oclab2;

import java.util.ArrayList;

public class Process {
	private State state;
    private RunTimeSystem RunTimeSystem;
    private String ProcessName;
    private int quantProcess;
    private int threadsTime;
    
    public Process(int time, String ProcessName){
        this.state = State.Ready;
        this.quantProcess = time;
        this.ProcessName = ProcessName;
        this.RunTimeSystem = new RunTimeSystem(ProcessName, time);
        threadTime();
    }

    public void threadTime(){
        this.threadsTime = 0;
        ArrayList<Thread> threadArrayList = RunTimeSystem.getThreads();
        for(int i = 0; i < threadArrayList.size(); i++){
            threadsTime += threadArrayList.get(i).getTime();
        }
    }

    public State getState() {
        return state;
    }
    
    public String getName() {
        return ProcessName;
    }

    public int getTime() {
        return threadsTime;
    }
    
    public void setState(State state){
        System.out.print(ProcessName + ": из " + this.state + " в ");
        this.state = state;
        System.out.println(state);
    }
    
    public void Work(){
        RunTimeSystem.RunThreads();
        threadsTime = threadsTime - quantProcess;
        if(threadsTime <= 0) {
        	 RunTimeSystem.RunThreads();
             setState(State.Finish);
            return;
        }
            setState(State.Ready);
    }
}
