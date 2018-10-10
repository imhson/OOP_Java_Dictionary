import java.util.ArrayList;
import java.util.Scanner;
/*
nhap "lookup" de tra tu dien
nhap "searcher" de tra tu
nhap "show" de hien thi toan bo du lieu
nhap "edit" de chinh sua du lieu
+ nhap "add" de them tu moi
+ nhap "change" de chinh sua tu
+ nhap "delete" de xoa tu
nhap "close" de ket thuc chuong trinh
*/
public class Dictionary {
    public static ArrayList<word> arrayWord= new ArrayList<>();                 //tao mang word luu tru du lieu
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DictionaryCommandline dicCommand = new DictionaryCommandline();
        DictionaryManagement dicMana = new DictionaryManagement();
        dicMana.insertFromFile();
        String input = "";
        while (true){
        if (input.equals("close")){                                             //nhap vao lenh "close" thi ket thuc chuong trinh
            break;
        }
        input = sc.nextLine();
        while (true){
            if (input.equals("lookup")){                                        //nhap vao lenh "search" thi bat dau tim kiem
                System.out.println("-------------");
                dicMana.dictionaryLookup();
                input = sc.nextLine();
            }
            else
                break;
        }
        while (true){
            if (input.equals("edit")){                                          //nhap vao lenh "edit" 
                System.out.print("type command: ");                             //nhap vao lenh tiep theo de xu ly
                input = sc.nextLine();          
                dicMana.dictionaryEditor(input);                                //xu ly theo lenh tuong ung
                input = sc.nextLine();
            }
            else
                break;
        }
        if (input.equals("show")){                                              //lenh "show" hien thi toan bo du lieu
            dicCommand.showAllWords();
            input= sc.nextLine();
        }
        if (input.equals("searcher")){
            dicCommand.dictionarySearcher();
            input = sc.nextLine();
        }
            
        }
        dicMana.dictionaryExportToFile();                                       //chap nhat du lieu moi vao file
    }
}
