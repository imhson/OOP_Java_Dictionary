package eng_vie_dictionary;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;
import javafx.scene.image.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

/**
 *
 * @author Hoangson
 */
public class Eng_Vie_Dictionary extends Application {
    
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException, IOException {
        primaryStage.setTitle("ENG-VIE Dictionary");
        DictionaryManagement dicMana = new DictionaryManagement();
        DictionaryCommandline dicCo = new DictionaryCommandline();
        final int width = 800;
        final int height = 528;
        final int width_edit = 500;
        final int height_edit = 125;
        final int width_textField =250;
        
        Pane root = new Pane();
        //menu bar
        MenuBar menuBar = new MenuBar();
        menuBar.setLayoutX(0);
        menuBar.setLayoutY(0);
        menuBar.setPrefWidth(width);
        
        Menu menu_file = new Menu("File");
        
        Menu menu_edit = new Menu("Edit");
        MenuItem menuItem_addWord = new MenuItem("Add New Word");
        MenuItem menuItem_changeMeans = new MenuItem("Change Means");
        MenuItem menuItem_deleteWord = new MenuItem("Delete Word");
        menu_edit.getItems().addAll(menuItem_addWord,menuItem_changeMeans,menuItem_deleteWord);
        
        Menu menu_help = new Menu("Help");
        
        Menu menu_view = new Menu("View");
        MenuItem menuItem_allEnglishWords = new MenuItem("Show data");
        menu_view.getItems().addAll(menuItem_allEnglishWords);
        menuBar.getMenus().addAll(menu_file,menu_edit,menu_help,menu_view);
        
        //tao cac cua so them sua va xoa tu
        
        //cua so them tu
        menuItem_addWord.setOnAction(action -> {
            Stage stage_addWord = new Stage();
            stage_addWord.setTitle("Add new word");
            TextField textField_wordTarget = new TextField();
            TextField textField_wordExplain = new TextField();
            Pane pane_addWord = new Pane ();
            textField_wordTarget.setPrefWidth(width_textField);
            textField_wordTarget.setLayoutX(150);
            textField_wordTarget.setLayoutY(25);
            textField_wordExplain.setPrefWidth(width_textField);
            textField_wordExplain.setLayoutX(150);
            textField_wordExplain.setLayoutY(75);
            Label label_wordTarget = new Label("Word target: ");
            Label label_wordExpalin = new Label("Word explain: ");
            label_wordTarget.setLayoutX(50);
            label_wordTarget.setLayoutY(25);
            label_wordExpalin.setLayoutX(50);
            label_wordExpalin.setLayoutY(75);
            
            Button button_add = new Button("Add");
            button_add.setLayoutX(width_textField+175);
            button_add.setLayoutY(25);
            
            button_add.setOnAction(action_addWord ->{
                dicMana.dictionaryAddWord(textField_wordTarget.getText(), textField_wordExplain.getText());
                stage_addWord.close();
            });
            
            pane_addWord.getChildren().addAll(label_wordTarget,label_wordExpalin,textField_wordTarget,textField_wordExplain,button_add);
            Scene scene_addWord = new Scene(pane_addWord, width_edit, height_edit);
            stage_addWord.setScene(scene_addWord);
            stage_addWord.show();
        });
        
        //cua so tim kiem tu de chinh sua
        menuItem_changeMeans.setOnAction(action -> {
            Stage stage_findWord = new Stage();
            Pane pane_findWord = new Pane();
            stage_findWord.setTitle("Change mean");
            TextField textField_find = new TextField();
            textField_find.setPrefWidth(width_textField);
            textField_find.setLayoutX(150);
            textField_find.setLayoutY(50);
            Label label_findWord = new Label("Find word: ");
            label_findWord.setLayoutX(50);
            label_findWord.setLayoutY(50);
            
            Button button_findWord = new Button("Find");
            button_findWord.setLayoutX(width_textField+175);
            button_findWord.setLayoutY(50);
            button_findWord.setOnAction(action_findWord ->{
                //cua so them nghia
                if (dicMana.findWord(textField_find.getText())==true){
                    Stage stage_changeMeans = new Stage();
                    Pane pane_changeMeans = new Pane();
                    stage_changeMeans.setTitle("Change mean");
                    TextField textField_changeMeans = new TextField();
                    textField_changeMeans.setPrefWidth(width_textField);
                    textField_changeMeans.setLayoutX(150);
                    textField_changeMeans.setLayoutY(75);
                    Label label_oldMean = new Label("Old mean: \n" + dicMana.dictionaryLookup(textField_find.getText()));
                    label_oldMean.setLayoutX(30);
                    label_oldMean.setLayoutY(25);
                    
                    Label label_changeMeans = new Label("New word explain: ");
                    label_changeMeans.setLayoutX(25);
                    label_changeMeans.setLayoutY(75);
            
                    Button button_change = new Button("Change");
                    button_change.setLayoutX(width_textField+175);
                    button_change.setLayoutY(75);
                    button_change.setOnAction(action_change ->{
                        dicMana.dictionaryChangeMean(textField_find.getText(), textField_changeMeans.getText());
                        stage_changeMeans.close();
                        stage_findWord.close();
                    });
                    pane_changeMeans.getChildren().addAll(textField_changeMeans,label_changeMeans,label_oldMean,button_change);
                    Scene scene_changeMeans = new Scene(pane_changeMeans,width_edit,height_edit);
                    stage_changeMeans.setScene(scene_changeMeans);
                    stage_changeMeans.show();
                }
                
                //cua so bao tu chua ton tai
                else{
                    Stage stage_cantFind = new Stage();
                    Pane pane_cantFind = new Pane();
                    Label label_cantFind = new Label("Input word does not exist!!");
                    label_cantFind.setLayoutX(175);
                    label_cantFind.setLayoutY(50);
                    pane_cantFind.getChildren().add(label_cantFind);
                    Scene scene_cantFind = new Scene(pane_cantFind,width_edit,height_edit);
                    stage_cantFind.setScene(scene_cantFind);
                    stage_cantFind.show();
                }
            });
            
            pane_findWord.getChildren().addAll(textField_find,button_findWord,label_findWord);
            Scene scene_findWord = new Scene(pane_findWord,width_edit,height_edit);
            stage_findWord.setScene(scene_findWord);
            stage_findWord.show();
        });
        
        menuItem_deleteWord.setOnAction(action ->{
            //cua so xoa tu
            Stage stage_deleteWord = new Stage();
            stage_deleteWord.setTitle("Delete word");
            stage_deleteWord.setTitle("Delete word");
            TextField textField_find = new TextField();
            textField_find.setPrefWidth(width_textField);
            textField_find.setLayoutX(150);
            textField_find.setLayoutY(50);
            Label label_findWord = new Label("Find word: ");
            label_findWord.setLayoutX(50);
            label_findWord.setLayoutY(50);
            
            Button button_delete = new Button("Delete");
            button_delete.setLayoutX(width_textField+175);
            button_delete.setLayoutY(50);
            button_delete.setOnAction(action_deleteWord ->{
            Stage stage_confirm = new Stage();
            Pane pane_confirm = new Pane ();
            if (dicMana.findWord(textField_find.getText())==true){
                //cua so xac nhan xoa tu
                Label label_confirm = new Label("Do you really want to delete this word?\nWord: "+textField_find.getText() +"\nMean: " + dicMana.dictionaryLookup(textField_find.getText()));
                label_confirm.setPrefWidth(400);
                label_confirm.setLayoutX(25);
                label_confirm.setLayoutY(25);
                Button button_yes = new Button ("Yes");
                Button button_no = new Button ("No");
                button_yes.setLayoutX(125);
                button_yes.setLayoutY(75);
                button_no.setLayoutX(320);
                button_no.setLayoutY(75);
                button_yes.setOnAction(action_button_yes ->{
                    dicMana.dictionayDeleteWord(textField_find.getText());
                    stage_confirm.close();
                    stage_deleteWord.close();
                });
                button_no.setOnAction(action_button_no ->{
                    stage_confirm.close();
                });

                pane_confirm.getChildren().addAll(label_confirm,button_yes,button_no);
            }
            else{
                    //cua so thong bao tu khong ton tai
                    Label label_confirm = new Label("Input word does not exist!!");
                    label_confirm.setLayoutX(175);
                    label_confirm.setLayoutY(50);
                    pane_confirm.getChildren().add(label_confirm);
            }
            Scene scene_confirm = new Scene (pane_confirm,width_edit,height_edit);
            stage_confirm.setScene(scene_confirm);
            stage_confirm.show();
            });

            Pane pane_deleteWord = new Pane();
            pane_deleteWord.getChildren().addAll(textField_find, label_findWord, button_delete);
            Scene scene_deleteWord = new Scene(pane_deleteWord,width_edit,height_edit);
            stage_deleteWord.setScene(scene_deleteWord);
            stage_deleteWord.show();
        });
        
        menuItem_allEnglishWords.setOnAction(action_menuShowAll ->{
            Stage stage_showAll = new Stage ();
            stage_showAll.setTitle("Show data");
            Pane pane_showAll = new Pane();
            TextArea textArea_showAll = new TextArea(dicCo.showAllWords());
            textArea_showAll.setPrefSize(700, 500);
            pane_showAll.getChildren().add(textArea_showAll);
            Scene scene_showAll = new Scene(pane_showAll,700,500);
            stage_showAll.setScene(scene_showAll);
            stage_showAll.show();
        });
        //load anh
       
        Image image_background = new Image(getClass().getResourceAsStream("/resource/images/anh2.png"));       
        ImageView imageView_background = new ImageView(image_background);
        
        Image image_title = new Image(getClass().getResourceAsStream("/resource/images/Eng-Viet1.png"));
        ImageView imageView_title = new ImageView(image_title);
        Image image_loa = new Image(getClass().getResourceAsStream("/resource/images/phatam.png"));
        ImageView imageView_loa = new ImageView(image_loa);
        
        imageView_title.setLayoutX(330);
        imageView_title.setLayoutY(50);
       
        //text area
        TextArea textArea = new TextArea();
        textArea.setPrefSize(250, 290);
        textArea.setLayoutX(416);
        textArea.setLayoutY(160);

        //list view
        ListView listView = new ListView();
        listView.setPrefSize(190, 290);
        listView.setLayoutX(160);
        listView.setLayoutY(160);
          //phát âm
         
        Button speech= new Button();
        speech.setGraphic(imageView_loa);
        speech.setPrefWidth(12);
        speech.setPrefHeight(12);
        speech.setLayoutX(600);
        speech.setLayoutY(160);     
        speech.setOnMouseClicked(action ->{
         VoiceManager voiceManager;
         Voice voice;
         System.setProperty("mbrola.base", "C:/Users/Administrator/Downloads/speed/mbrola");
        
        voiceManager = VoiceManager.getInstance();
        voice= voiceManager.getVoice("mbrola_us1");
        voice.allocate();
        voice.speak(listView.getSelectionModel().getSelectedItems().toString());
        voice.deallocate();
        });
        //
        listView.getItems().addAll(dicCo.dictionarySearcher(""));
        listView.setOnMouseClicked(action ->{
            textArea.setText(listView.getSelectionModel().getSelectedItem().toString()+"\n\n\t-->  "+dicMana.dictionaryLookup(listView.getSelectionModel().getSelectedItem().toString()));
        
        });        

        //khu vuc search tu 
        TextField textField = new TextField();
        textField.setPrefSize(150, 30);
        textField.setLayoutX(160);
        textField.setLayoutY(110);
        textField.setOnKeyReleased(action ->{
            listView.getItems().clear();
            textArea.clear();
            listView.getItems().addAll(dicCo.dictionarySearcher(textField.getText()));
        });
               
        root.getChildren().addAll(imageView_background,imageView_title,menuBar,textField,listView,textArea,speech);

        
        Scene scene;
        scene = new Scene(root,width, height);
        
        primaryStage.setScene(scene);
        primaryStage.show();
        
    }

    public static void main(String[] args) {
        DictionaryManagement dicMana = new DictionaryManagement();
        dicMana.insertFromFile();
        launch(args);
        dicMana.dictionaryExportToFile();
    }
    
}
