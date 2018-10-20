package eng_vie_dictionary;

import java.io.*;
import java.util.Scanner;
import java.util.zip.InflaterInputStream;

public class DictionaryManagement {
public void insertFromFile (){                                              //nhap du lieu tu file
        try {
            File file = new File("");                           //tao flie
            File fileData = new File(file.getAbsolutePath()+"\\dictionaries.txt");
            BufferedReader br;
            System.out.println(fileData.getAbsolutePath());
            try (FileReader fr = new FileReader(fileData)) {
                br = new BufferedReader(fr);
                String lineData=br.readLine();                                      //lay du lieu cua mot tu
                while (lineData!=null){
                    String elements [];
                    elements = lineData.split("::");                                        //tach du lieu goc thanh tu tieng anh va nghia tieng viet
                    word newWord = new word(elements[0], elements[1]);                      //tao tu moi
                    Dictionary.arrayWord.add(newWord);                                  //them tu moi vao mang luu tru
                    lineData=br.readLine();
                }
            }
        } catch (IOException e) {                                     //bao loi neu khong tim thay file
            System.out.println("Error");
        }
    }    public String dictionaryLookup (String inputWord){
        for (word element: Dictionary.arrayWord){                               //duyet cac tu trong mang du lieu
            if ((element.word_target.toUpperCase()).equals(inputWord.toUpperCase())){                       //tim kiem
                return element.word_explain;                       //in ra man hinh nghia cua tu can tim
            }
        }
        return null;
    }
    
    public void dictionaryAddWord (String word_target, String word_explain){
        word newWord = new word(word_target, word_explain);
        Dictionary.arrayWord.add(newWord);
    }
    public void dictionayDeleteWord (String word_target){
        for (word element: Dictionary.arrayWord){                          
            if ((element.word_target.toUpperCase()).equals(word_target.toUpperCase())){                
                Dictionary.arrayWord.remove(element); 
                break;
                }
            }
    }
    public void dictionaryChangeMean (String word_target, String word_explain){
            for (word element: Dictionary.arrayWord){                          
                if ((element.word_target.toUpperCase()).equals(word_target.toUpperCase())){                
                    element.word_explain = word_explain;                       
                    break;
                }
            }

    }
    public boolean findWord (String word_target){
            for (word element: Dictionary.arrayWord){                          
            if ((element.word_target.toUpperCase()).equals(word_target.toUpperCase())){                
                return true;
                }
            }
            return false;
    }
    
    public void dictionaryExportToFile (){                                      //ham cap nhat du lieu moi
        File file = new File("");                           //tao flie
        File fileData = new File (file.getAbsolutePath()+"\\dictionaries.txt");
        try {
            try (FileWriter fw = new FileWriter(fileData)) {
                String lineData;
                for (word element: Dictionary.arrayWord){
                    lineData = element.word_target + "::" + element.word_explain+"\r\n";
                    fw.write(lineData);
                }
                System.out.println("_________________________");
            }
        } catch (IOException ex) {                                              //in ra "Error" neu phat hien loi
            System.out.println("Error!!");
        }
        
    }
}
