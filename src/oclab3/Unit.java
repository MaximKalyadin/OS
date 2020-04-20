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
        countPageFrames = memRAM/sizeOfPage;

        for(int i = 0; i <(memRAM * 2)/sizeOfPage; i++){
            Page page = new Page(false, false);
            page.setnumpage(Integer.MAX_VALUE);
            tablePages.add(page);
        }
        k = 0;
    }

    public void inputnumpage(int pageIndex){
        Page page = tablePages.get(pageIndex);
        if(!page.isabsence()){
            if(tablePageFrames.size() < countPageFrames){
                page.setabsence(true);
                page.setR(true);
                tablePageFrames.add(page);
                int indexOfPageFrames = tablePageFrames.indexOf(page);
                page.setnumpage(indexOfPageFrames);
            }else if(tablePageFrames.size() == countPageFrames){
                Algorithm(page);
            }
        }else{
            page.setR(true);
        }
        printPageFrames();
        printPages();
    }

    private void Algorithm(Page page){
        for (;;) {
            if(k == tablePageFrames.size()){
                k = 0;
            }
            if(tablePageFrames.get(k).isR()){
                tablePageFrames.get(k).setR(false);
                k++;
            }else{
                tablePageFrames.get(k).setabsence(false);
                tablePageFrames.get(k).setnumpage(Integer.MAX_VALUE);
                tablePageFrames.remove(k);
                tablePageFrames.add(k, page);
                page.setnumpage(k);
                page.setR(true);
                page.setabsence(true);
                System.out.println("Выселение страницы с номером " + k);
                k++;
                return;
            }
        }
    }

    public int getSizePageTable(){
        return tablePages.size();
    }

    public void printPageFrames(){
        int i = 0;
        System.out.println("Таблица страничных блоков \n" + "| i  R  P_A |");
        for (Page current_page: tablePageFrames) {
            System.out.println("| " + i + " " + current_page.isR() + " " + current_page.isabsence() + " |");
            i++;
        }
        System.out.println();
    }

    private void printPages(){
        System.out.println("Таблица страниц \n" + "| i   R    P_A   IndexFrame |");
        for(int i = 0; i<tablePages.size(); i++){
            System.out.println("| " + i + " " + tablePages.get(i).isR() + " "
                    + tablePages.get(i).isabsence() + " " + tablePages.get(i).getnumpage() + " |");
        }
        System.out.println();
    }
}
