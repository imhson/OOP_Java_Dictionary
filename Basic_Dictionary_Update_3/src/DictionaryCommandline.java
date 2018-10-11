import java.util.Scanner;

public class DictionaryCommandline {
    public void showAllWords(){
        int count=1;
        System.out.println("No  |          English          |          Vietnamese");
        for (word elements: Dictionary.arrayWord){
            System.out.print(count+"   |"+elements.word_target);
            
            for (int tem=1;tem<=(27-elements.word_target.length());tem++)
                System.out.print(" ");
            System.out.println("|" + elements.word_explain);
            count++;
        }
    }
    public void dictionaryBasic(){                                      
        DictionaryManagement insert = new DictionaryManagement();
        insert.insertFromCommandline();
        showAllWords();
    }
    public void dictionaryAdvanced (){
        DictionaryManagement insert = new DictionaryManagement();
        insert.insertFromFile();
        showAllWords();
        insert.dictionaryLookup();
    }
    public void dictionarySearcher (){                                          //ham tim ca tu bat dau bang "..."
        System.out.print("type a part of word: ");
        Scanner sc = new Scanner(System.in);
        String inputAPartOfWord = sc.nextLine();                                //nhap cum tu bat dau
        int length_inputAPartOfWord = inputAPartOfWord.length();                //lay do dai cua cum tu do
        System.out.println("RESULT");
        for (word element: Dictionary.arrayWord){
            if ((element.word_target.substring(0,length_inputAPartOfWord).toUpperCase()).equals(inputAPartOfWord.toUpperCase())){
                System.out.println(element.word_target);
            }
        }
    }
}
