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
}
