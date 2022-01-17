//Test out the JavaFX list window

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.StackPane;
import javafx.stage.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
//import javafx.fxml.FXMLLoader;
import java.util.*;
import java.io.IOException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.*;


public class ListViewSample extends Application {
    
   public static final ObservableList names = 
        FXCollections.observableArrayList();
    public static final ObservableList data = 
        FXCollections.observableArrayList();
       
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("List View Sample");        
        //when you maximize the window, it sticks to the left of the screen
        final ListView listView = new ListView(data);
        primaryStage.setMaxWidth(250);
        listView.setEditable(true);
        
        /*FileInputStream input = new FileInputStream("ListTest/icons/canvas.png");
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(16);
        imageView.setFitHeight(16);
        Button btn1 = new Button("Canvas", imageView);
        //btn.setMinWidth(100);
        btn1.setMaxWidth(200);
        btn1.setMaxHeight(50);
        */
        names.addAll("Here is where more text would go", "If you select something, it changes button to that text", "It's not ideal, but it works");
         
        
        data.add("Discord");
        //data.add("G-mail");
        //data.add("Github");
        //data.add("Microsoft Exchange");
        //data.add("Discord");
        //data.add("Reddit");
        //data.add("Instagram");
        //data.add("Facebook");
        //data.add("YouTube");
        //data.add("Lyft");
        //data.add("Uber");
        //data.add("Google Drive");
        //data.add("Steam");
        //data.add("GroupMe");
        
          
        listView.setItems(data);
        listView.setCellFactory(ComboBoxListCell.forListView(names));              
               
        StackPane root = new StackPane();
        root.getChildren().add(listView);
        primaryStage.setScene(new Scene(root, 200, 250));
        primaryStage.show();
    }
}