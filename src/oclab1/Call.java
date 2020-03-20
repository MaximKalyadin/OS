package oclab1;

import java.util.ArrayList;
import java.util.Arrays;

public class Call {
	private ArrayList <String> Arguments = new ArrayList<String>();

	public Call(String args) { 
		Arguments.add(args);
	}

	public ArrayList getArgs(){
		return Arguments;
	}
	
	public String getAr() {
		return Arguments.get(0);
	}
	public String Execute(){
		return "Вызов выполнен\n";
	}
}
