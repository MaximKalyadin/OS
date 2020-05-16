package oclab3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int index;
		Unit U = new Unit(2048, 256);
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Введите индекс страницы в таблице страниц :");
            index = scanner.nextInt();
            if (index >= 0 && index < U.getSizePageTable()){
                U.addressToPage(index);
            }
        }
	}

}
