
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
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setX(-7);
        primaryStage.setY(0);
        
        //generate buttons
        Button btnC = new NotificationButton("Canvas", "canvas.png");
        Button btnD = new NotificationButton("Discord", "discord.png");
        //Button btnO = new NotificationButton("Outlook", "outlook.png");
        //Button btnG = new NotificationButton("GitHub", "GitHub.png");
        //Button btnJ = new NotificationButton("Junk", "junk.png");
           
               
        //System.out.println(stackNotifications.pop());
        
        Group root = new Group();
        ScrollPane sc = new ScrollPane();
        VBox vbox = new VBox(5);
        
        sc.setFitToWidth(true);
        
        vbox.getChildren().add(btnC);
        vbox.getChildren().add(btnD);
        //vbox.getChildren().add(btnO);
        //vbox.getChildren().add(btnG);
        //vbox.getChildren().add(btnJ);
        
        vbox.setLayoutX(25);
        vbox.setLayoutY(150);
        sc.setContent(vbox);
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
        primaryStage.setScene(new Scene(root, 250, 650));
        root.getChildren().addAll(vbox, sc);


         primaryStage.show();
        
    }//end stage

}//end makeApplication