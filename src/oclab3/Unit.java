package oclab3;

import java.util.ArrayList;

public class Unit {
	
    private ArrayList<Page> tablePages;
    private ArrayList<Page> tablePageFrames;
    private int countPageFrames;
    private int k;

    public Unit(int memRAM, int sizeOfPage){
        tablePages = new ArrayList<Page>();
        tablePageFrames = new ArrayList<Page>();
        countPageFrames = memRAM / sizeOfPage;

        for(int i = 0; i < (memRAM * 8) / sizeOfPage; i++){
            Page page = new Page(false);
            page.setnumpage(Integer.MAX_VALUE);
            tablePages.add(page);
        }
        k = 0;
    }

    public void inputnumpage(int pageIndex){
        Page page = tablePages.get(pageIndex);
        if(!page.isabsence()){
        	k = pageIndex / countPageFrames;
            Algorithm(page);
        }
        
        printPageFrames();
        printPages();
    }
    
    private void Algorithm(Page page){
    	for (int i = 0; i < countPageFrames; i++) {
    		if (tablePageFrames.size() > i) {
	    		tablePageFrames.get(i).setabsence(false);
	            tablePageFrames.get(i).setnumpage(Integer.MAX_VALUE);
	            tablePageFrames.remove(i);
	            System.out.println("Выселение страницы с номером " + i);
    		}
            
            Page current = tablePages.get(k * countPageFrames + i);
            tablePageFrames.add(i, current);
            current.setnumpage(i);
            current.setabsence(true);
    	}
    	
    	if (!tablePageFrames.contains(page)) {
    		tablePageFrames.get(0).setabsence(false);
            tablePageFrames.get(0).setnumpage(Integer.MAX_VALUE);
            tablePageFrames.remove(0);
            tablePageFrames.add(0, page);
    	}
    }

    public int getSizePageTable(){
        return tablePages.size();
    }

    public void printPageFrames(){
        int i = 0;
        System.out.println("Таблица страничных блоков \n" + "| i  R  P_A |");
        for (Page current_page: tablePageFrames) {
            System.out.println("| " + i + " " + current_page.isabsence() + " |");
            i++;
        }
        System.out.println();
    }

    private void printPages(){
        System.out.println("Таблица страниц \n" + "| i   R    P_A   IndexFrame |");
        for(int i = 0; i<tablePages.size(); i++){
            System.out.println("| " + i + " " + tablePages.get(i).isabsence() + " " + tablePages.get(i).getnumpage() + " |");
        }
        System.out.println();
    }
}
