import java.util.Scanner;

public class DictionaryManagement {
    public void insertFromCommandline (){
        Scanner getData = new Scanner(System.in);
        int loop = getData.nextInt();
        getData.nextLine();
        for (int i=1;i<=loop;i++){
        word newWord = new word();
        newWord.word_target= getData.nextLine();
        newWord.word_explain=getData.nextLine();
        Dictionary.arrayWord.add(newWord);
        }
    }
}
