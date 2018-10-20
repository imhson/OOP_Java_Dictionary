package eng_vie_dictionary;

import java.util.ArrayList;

public class DictionaryCommandline {
    public String showAllWords(){
        String result = "|                                 English                              |          Vietnamese\n";
        for (word elements: Dictionary.arrayWord){
            result = result+"|"+elements.word_target;
            
            for (int tem=1;tem<=(70-elements.word_target.length());tem++)
                result = result+" ";
            result=result+"|" + elements.word_explain+"\n";
        }
        return result;
    }
    public ArrayList<String> dictionarySearcher (String inputAPartOfWord){                                          //ham tim ca tu bat dau bang "..."
        ArrayList<String> results = new ArrayList<>();
        int length_inputAPartOfWord = inputAPartOfWord.length();                //lay do dai cua cum tu do
        for (word element: Dictionary.arrayWord){
            if (element.word_target.length()>=inputAPartOfWord.length())
            if ((element.word_target.substring(0,length_inputAPartOfWord).toUpperCase()).equals(inputAPartOfWord.toUpperCase())){
                results.add(element.word_target);
            }
        }
        return results;
    }
}
