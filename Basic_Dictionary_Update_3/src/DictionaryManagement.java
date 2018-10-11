import java.io.*;
import java.util.Scanner;

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
        try {
            File file = new File("");                           //tao flie
            File fileData = new File (file.getAbsolutePath()+"\\dictionaries.txt");
            BufferedReader br;
            try (FileReader fr = new FileReader(fileData)) {
                br = new BufferedReader(fr);
                int count=0;
                String lineData=br.readLine();                                      //lay du lieu cua mot tu
                while (lineData!=null){
                    String[] elements;
                    count++;
                    elements = lineData.split("::");                                        //tach du lieu goc thanh tu tieng anh va nghia tieng viet
                    word newWord;                      //tao tu moi
                    newWord = new word(elements[0],elements[1]);
                    Dictionary.arrayWord.add(newWord);                                  //them tu moi vao mang luu tru
                    lineData=br.readLine();
                }
            }
            br.close();
        } catch (IOException e) {                                     //bao loi neu khong tim thay file
            System.out.println("Error");
        }
    }
    public void dictionaryLookup (){
        Scanner sc = new Scanner(System.in);
        String inputWord;
        System.out.print("Input Word: ");
        inputWord = sc.nextLine();
        for (word element: Dictionary.arrayWord){                               //duyet cac tu trong mang du lieu
            if ((element.word_target.toUpperCase()).equals(inputWord.toUpperCase())){                       //tim kiem
                System.out.println("Output Meaning: " + element.word_explain);                       //in ra man hinh nghia cua tu can tim
            }
        }
    }
    
    public void dictionaryEditor (String inputCommand){                         //ham xu ly du lieu
        Scanner scanInput = new Scanner(System.in);
        if (inputCommand.equals("add")){                                        //them tu moi
            System.out.print("Word target is: ");
            String word_target = scanInput.nextLine();
            System.out.print("Word explain is: ");
            String word_explain = scanInput.nextLine();
            word newWord = new word(word_target, word_explain);
            Dictionary.arrayWord.add(newWord); 
            System.out.println("Sucessful!");
        }
        
        if (inputCommand.equals("change")){                                     //sua tu
            System.out.print("Word target is: ");
            String word_target = scanInput.nextLine();
            System.out.print("Word explain change into: ");
            String word_explain = scanInput.nextLine();
            for (word element: Dictionary.arrayWord){                          
                if ((element.word_target.toUpperCase()).equals(word_target.toUpperCase())){                
                    element.word_explain = word_explain;                       
                    break;
                }
            }
            System.out.println("Sucessful!");
        }
  
        if (inputCommand.equals("delete")){                                     //xoa tu
            System.out.print("Delete: ");
            String word_target = scanInput.nextLine();
            int count=0;
            for (word element: Dictionary.arrayWord){                          
                if ((element.word_target.toUpperCase()).equals(word_target.toUpperCase())){                
                    Dictionary.arrayWord.remove(element); 
                    System.out.println("Complete!");
                    break;
                }
            }
            System.out.println("Sucessful!");
        }
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
