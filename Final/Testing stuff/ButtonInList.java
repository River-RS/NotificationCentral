//Create a list of buttons

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.cell.ComboBoxListCell;

public class ButtonInList extends Application {

    public static final ObservableList data = 
        FXCollections.observableArrayList();
    public static final ObservableList items =
       FXCollections.observableArrayList();
    @Override
    public void start(Stage primaryStage) {
         //when you maximize the window, it sticks to the left of the screen
        final ListView listView = new ListView(items);
        primaryStage.setMaxWidth(200);
        primaryStage.setWidth(150);   
        listView.setMaxWidth(300);
        listView.setEditable(true);
        
        items.addAll(
           "Discord", "G-mail", "Github", "Microsoft Exchange", "Discord", "Reddit",
           "Instagram", "Facebook", "YouTube", "Lyft", "Uber", "Google Drive", "Steam",
           "GroupMe");
           
        data.addAll("Expand for more text here");

        listView.setCellFactory(new Callback<ListView<String>, 
                ListCell<String>>()
                 {
                    @Override
                    public ListCell<String> call(ListView<String> list) {
                        return new ButtonCell(); 
                    }
                });

       ObservableList settings =
       FXCollections.observableArrayList();
       settings.addAll("dark mode", "contrast", "text size", "tile order");
       Button refButton = new Button("Settings");
       refButton.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent arg0) {
               refButton.setText("insert menu bar");
                
            }
        }); 

        Pane root = new VBox();
        root.getChildren().addAll(refButton, listView);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();

    }

static class ButtonCell extends ListCell<String> {

  
        final Button button = new Button();
        ButtonCell() {
            button.setOnAction(new EventHandler<ActionEvent>() {  
                @Override  
                public void handle(ActionEvent arg0) {  
                    System.out.println(getItem() + " Button Handler");
                    button.setText("We can click to display more info in the message");
                    
                    //button.setMaxWidth(200);
                    //button.setMaxHeight(250);  
                }  
            });              
        }
        @Override  
        public void updateItem(final String item, boolean empty) {  //throws Exception {  
            /*FileInputStream input = new FileInputStream("ListTest/icons/canvas.png");
            Image image = new Image(input);
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(16);
            imageView.setFitHeight(16);
            */
            super.updateItem(item, empty);  
            if (item != null) {  
                button.setText(item);
                setGraphic(button);  
            }  else {
                setGraphic(null); // you should always do this too
            }
        }  
    } 
    public static void main(String[] args) {
        launch(args);
    }
}