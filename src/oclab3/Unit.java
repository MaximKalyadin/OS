package oclab3;

import java.util.ArrayList;

public class Unit {

    private ArrayList<Page> tablePages;
    private ArrayList<Page> tablePageFrames;
    
	private int time;

    public Unit(int memRAM, int sizeOfPage){
        tablePages = new ArrayList<Page>();
        tablePageFrames = new ArrayList<Page>();

        for (int i = 0; i < (memRAM * 8) / sizeOfPage; i++){
            Page page = new Page();
            tablePages.add(page);
        }
        
        for (int i = 0; i < memRAM / sizeOfPage / 2; i++) {
        	tablePageFrames.add(tablePages.get(i));
        }
        
        time = 1;
    }

    public void addressToPage(int index){
        Page page = tablePages.get(index);
        
        if (!tablePageFrames.contains(page)) {
        	algorithm(page);
        }

        page.setUsed(true);
        page.setLastTime(time);
        
        time++;
        
        if (time % 8 == 0) {
        	clearUsed();
        }
        
        printPageFrames();
        printPages();
    }
    
    private void algorithm(Page page){
    	ArrayList<Page> candidatesForDeletion = new ArrayList<Page>();
    	
    	for (int i = 0; i < tablePageFrames.size(); i++) {
    		Page currentPage = tablePageFrames.get(i);
    		
    		if (!currentPage.isUsed()) {
    			candidatesForDeletion.add(currentPage);
    		}
    	}
    	
    	candidatesForDeletion = candidatesForDeletion.isEmpty() ? tablePageFrames : candidatesForDeletion;
    	Page pageForDeletion = candidatesForDeletion.get(0);
    	
    	for (int i = 0; i < candidatesForDeletion.size(); i++) {
    		Page currentPage = candidatesForDeletion.get(i);
    		
    		if (currentPage.getLastTime() < pageForDeletion.getLastTime()) {
    			pageForDeletion = currentPage;
    		}
    	}
    	
    	tablePageFrames.remove(pageForDeletion);
    	tablePageFrames.add(page);
    }
    
    private void clearUsed() {
    	for (int i = 0; i < tablePageFrames.size(); i++) {
    		Page currentPage = tablePageFrames.get(i);
    		currentPage.setUsed(false);
    	}
    }

    public int getSizePageTable(){
        return tablePages.size();
    }

    public void printPageFrames(){
        System.out.println("Таблица страничных блоков");
        System.out.println("i\tisUsed\tlastTime");
        
        for (int i = 0; i < tablePageFrames.size(); i++) {
    		Page currentPage = tablePageFrames.get(i);
            System.out.println(i + "\t" + currentPage.isUsed() + "\t" + currentPage.getLastTime());
        }
        
        System.out.println();
    }

    private void printPages(){
        System.out.println("Таблица страниц");
        System.out.println("i\tisUsed\tlastTime");
        
        for (int i = 0; i < tablePages.size(); i++) {
    		Page currentPage = tablePages.get(i);
            System.out.println(i + "\t" + currentPage.isUsed() + "\t" + currentPage.getLastTime());
        }
        
        System.out.println();
    }
}
