package oclab1;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Stack stack = new Stack();
		Kernel kernel = new Kernel(stack);
		while(true){
			String line = scanner.nextLine();
			if (line.equals("all")) {
				kernel.Calls();
			} else {
				String[] lineSplit = line.split(" ");
				if (!lineSplit[0].equals("call")) {
					System.out.print("Неверная команда\n");
				} else {
					int id = Integer.parseInt(lineSplit[1]);
					stack.push(lineSplit[2]);
					kernel.ExecuteCall(id);
				}
			}
		}
	}

}
