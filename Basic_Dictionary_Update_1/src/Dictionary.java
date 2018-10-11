import java.util.ArrayList;
public class Dictionary {
    public static ArrayList<word> arrayWord= new ArrayList<>();                 //tao mang word luu tru du lieu
   
    public static void main(String[] args) {
        DictionaryCommandline test = new DictionaryCommandline();
        DictionaryManagement test2 = new DictionaryManagement();
        test2.insertFromFile();
        test2.dictionaryLookup();
    }
}
