package oclab1;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Kernel {
	Stack stack;
	public HashMap<Integer, Call> SystemCalls;
	
	public Kernel(Stack stack) {
		this.stack = stack;
		SystemCalls = new HashMap<>();
		SystemCalls.put(10,new Call("av"));
		SystemCalls.put(11,new Call("nv"));
		SystemCalls.put(12,new Call("iv"));
		SystemCalls.put(13,new Call("ov"));
		SystemCalls.put(14,new Call("byv"));
	}
	
	public void ExecuteCall(int id){
		if (!SystemCalls.containsKey(id)) {
			System.out.print("Вызов номер "+ id +" не существует\n");
			return;
		}
		
		if (!stack.pop().equals(SystemCalls.get(id).getAr())) {
			System.out.print("Аргументы не совпадают\n");
			return;
		}
		
		System.out.print(SystemCalls.get(id).Execute());
	}
	
	public void Calls() {
		for (Entry<Integer, Call> entry : SystemCalls.entrySet()) {
			System.out.println(entry.getKey() + " "+" "+ entry.getValue().getArgs());
		}
	}
	
	
}
