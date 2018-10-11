import java.util.Scanner;
import java.io.*;

public class DictionaryManagement {
    public void insertFromCommandline (){                                       //nhap du lieu tu ban phim 
        Scanner getData = new Scanner(System.in);
        int loop = getData.nextInt();
        getData.nextLine();
        for (int i=1;i<=loop;i++){
        String wordTarget= getData.nextLine();                                  //nhap tu tieng anh
        String wordExplain=getData.nextLine();                                  //nhap nghia
        word newWord = new word(wordTarget,wordExplain);                        //tao tu moi
        Dictionary.arrayWord.add(newWord);                                      //them tu moi vao mang du lieu
        }
    }
    public void insertFromFile (){                                              //nhap du lieu tu file
        File fileData = new File("dictionaries.txt");                           //tao flie
        try {
            Scanner sc = new Scanner(fileData);                                 
            while (sc.hasNextLine()){
            String str = sc.nextLine();                                         //lay du lieu cua mot tu
            boolean test = false;
            String elements [];
            elements = str.split("[\\t]");                                        //tach du lieu goc thanh tu tieng anh va nghia tieng viet
            word newWord = new word(elements[0], elements[1]);                      //tao tu moi
            Dictionary.arrayWord.add(newWord);                                  //them tu moi vao mang luu tru
            }
        } catch (FileNotFoundException e) {                                     //bao loi neu khong tim thay file
            System.out.println("Error");
        }
    }
    public void dictionaryLookup (){
        System.out.print("Nhap tu can tra: ");
        Scanner sc = new Scanner(System.in);
        String word_lookup = sc.nextLine();                                     //nhap tu can tim kiem
        for (word element: Dictionary.arrayWord){                               //duyet cac tu trong mang du lieu
            if ((element.word_target).equals(word_lookup)){                     //tim kiem
                System.out.println(element.word_explain);                       //in ra man hinh nghia cua tu can tim
            }
        }
    }
}
