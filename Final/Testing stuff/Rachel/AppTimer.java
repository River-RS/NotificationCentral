import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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


public class AppTimer extends Application{
  private static int cnt = 0;
  private static boolean toggleC = false;
  @Override
  public void start(Stage primaryStage) throws Exception{
    
  
    primaryStage.setTitle("Hello World!");
    primaryStage.setX(-7);
    primaryStage.setY(0);
        
        
        
    Button btnC = new Button("Canvas");
    Button btnD = new Button("Discord");
    Button btnO = new Button("Outlook");
    Button btnG = new Button("GitHub");
    Button btnJ = new Button("Junk");
    
    
    
    String[] notfifications = {"Canvas", "GitHub"};

    // toggle the visibility of 'rect' every 500ms
    AnimationTimer timer =
        new AnimationTimer() {

          private long lastToggle;

          @Override
          public void handle(long now){
            if (lastToggle == 0L) {
              lastToggle = now;
            }//end if 
            else {
              long diff = now - lastToggle;
              if (diff >= 500_000_000L) { // 500,000,000ns == 500ms
                 try{
                 EventHandler<ActionEvent> clickCanvas = new EventHandler<ActionEvent>(){
                       public void handle(ActionEvent event){
                          try{
                             if (toggleC == false){
                                System.out.println("C: You clicked the button" + "   " + toggleC);
                                largeDimensions(btnC);
                                btnC.setWrapText(true);
                                btnC.setText("Here's more info");
                                btnC.setText("" + notfifications[cnt]);
                                //btnC.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
                                toggleC = true;
                                //countNotification = countNotification+1;   
                             }//end if
                             else{
                                System.out.println("C: You clicked the button again." + "   " + toggleC);
                                smallDimensions(btnC);
                                btnC.setText("Canvas: New notification");
                                //btnC.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
                                toggleC = false;
                             }//end else
                          }//end try
                          catch(Exception e){
                             System.out.println("No new notifications at this time");
                             smallDimensions(btnC);
                             btnC.setText("No new notifications at this time");
                             System.out.println("Error: " + e);                 
                             //Platform.runLater(new Runnable() {
                               // @Override public void run() {
                                   //delay(3000);
                                   //System.out.println("Reset to default: Canvas");
                                   //btnC.setText("Canvas");
                                //}//end run
                             //});//end runLater
                          
                          }//end catch           
                       }//end event
                    };//end clickCanvas
    
    
    btnC.setOnAction(clickCanvas);
                    
                    
                    
                    
                   

                    
                    
                    
                    
                    
                    
                    lastToggle = now;
                    cnt = cnt +1;
                 }//end try
                 catch(Exception e){
                    btnC.setText("No new notificaions");
                    System.out.println("Error: " + e);
                 }//end catch
              }//end if
            }//end else
          }//end handle
        };//end time
    timer.start();
    
     
    

    // tile pane is created     
        VBox vbox = new VBox(5);
        //vbox.getChildren().addAll(sc);
        vbox.getChildren().add(btnC);
        vbox.getChildren().add(btnD);
        vbox.getChildren().add(btnO);
        vbox.getChildren().add(btnG);
        vbox.getChildren().add(btnJ);
        vbox.setAlignment(Pos.CENTER);     
        primaryStage.setScene(new Scene(vbox, 250, 650));
    primaryStage.show();
  }//end stage
  
  
  //resizing methods
    private void smallDimensions(Button btn){
        btn.setMinWidth(200);
        btn.setMinHeight(50);
    }//end smallDimensions
    private void largeDimensions(Button btn){
        btn.setMinWidth(200);
        btn.setMinHeight(200);
    }//end smallDimensions

  
}//end class