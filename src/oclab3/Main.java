package oclab3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int indexpage;
		Unit U = new Unit(2048, 256);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите индекс страницы в таблице страниц :");
            indexpage = scanner.nextInt();
            if (indexpage >= 0 && indexpage < U.getSizePageTable()){
                U.inputnumpage(indexpage);
            }
        }
	}

}
