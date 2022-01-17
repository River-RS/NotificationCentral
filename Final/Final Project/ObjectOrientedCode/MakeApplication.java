import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.geometry.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MakeApplication extends Application{

   public static void main(String[] args) throws Exception{
      launch(args);
   }//end main

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        primaryStage.setTitle("Notification Central");
        primaryStage.setX(-7);
        primaryStage.setY(0);
        
        //generate buttons
        Button btn1 = new NotificationButton("Canvas", "canvas.png","canvas.csv");
        Button btn2 = new NotificationButton("Discord", "discord.png", "discord.csv");
        Button btn3 = new NotificationButton("Outlook", "outlook.png", "outlook.csv");
        Button btn4 = new NotificationButton("GitHub", "GitHub.png", "github.csv");
        Button btn5 = new NotificationButton("Junk", "junk.png", "junk.csv");
      
        //add an 'edit menu' button that calls UserSetup class and let's user select the 5 apps they want to see
        
        Group root = new Group();
        ScrollPane sc = new ScrollPane();
        VBox vbox = new VBox(5);
        
        sc.setFitToWidth(true);
        
        //add in buttons
        vbox.getChildren().add(btn1);
        vbox.getChildren().add(btn2);
        vbox.getChildren().add(btn3);
        vbox.getChildren().add(btn4);
        vbox.getChildren().add(btn5);
        
        vbox.setLayoutX(25);
        vbox.setLayoutY(150);
        vbox.setPrefWidth(250);
        vbox.setPrefHeight(650);
        sc.setContent(vbox);
        //create background image
        BackgroundImage image = new BackgroundImage(new Image(new FileInputStream("dandelion-lightblue2.PNG")), BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT,
        BackgroundPosition.CENTER, new BackgroundSize(250, 650, true, true, true, true));
        vbox.setBackground(new Background(image));
        sc.setPrefSize(250, 650);
        vbox.setAlignment(Pos.CENTER);
        
        sc.vvalueProperty().addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                  System.out.println(new_val.intValue());
          }
        });//end listener
        sc.hvalueProperty().addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
                  System.out.println(new_val.intValue());
          }
      });//end listener
        Scene scene = new Scene(root, 250, 650);
        primaryStage.setOpacity(0.75);
        scene.getStylesheets().add("style.css");           
        primaryStage.setScene(scene);
        root.getChildren().addAll(vbox, sc);
        primaryStage.show();
        
    }//end stage

}//end makeApplication