import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;


public class ConcurrencyExample extends Application {
  private boolean toggle = false;
  private int progressUpdate= 0;
  
  public static void main(String[] args) {
    launch(args);
  }

  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("JavaFX App");

    ProgressBar progressBar = new ProgressBar(0);
    Button btn = new Button("Hello!");
    
    btn.setMinWidth(200);
    btn.setMaxWidth(200);


    VBox vBox = new VBox();
    //VBox vBox = new VBox(progressBar);
    vBox.getChildren().addAll(btn,progressBar);
    Scene scene = new Scene(vBox, 960, 600);

    primaryStage.setScene(scene);
    primaryStage.show();

    Thread taskThread = new Thread(new Runnable() {
      @Override
      public void run() {
        double progress = 0;
        for(int i=0; i<10; i++){

          try {
            Thread.sleep(1000);
          }//end try
           catch (InterruptedException e) {
            e.printStackTrace();
          }//end catch

          progress += 0.1;
          final double reportedProgress = progress;

          Platform.runLater(new Runnable() {
            @Override
            public void run() {
              progressBar.setProgress(reportedProgress);
            }
          });
          progressUpdate = progressUpdate+1;
        }//end for
      }
    });

    taskThread.start();
    btn.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
         try{
         //NOTE TO PROGRAMMER: try making a stack data type to store data for notifications (first in, last out)                      
         if (toggle == false){
            System.out.println("You clicked the button" + "   " + toggle);
            largeDimensions(btn);
            btn.setWrapText(true);
            btn.setText("End of the line " + " " + progressUpdate);
            toggle = true;            
         }//end if
         else{
            System.out.println("You clicked the button again." + "   " + toggle);
            smallDimensions(btn);
            btn.setText("Hello again " + " " + progressUpdate);
            toggle = false;
         }//end else
      }//end try
      catch(Exception e){
         System.out.println("No new notifications at this time");
         btn.setText("No new notifications at this time");
      }//end catch   
                  
      }     
    });//end setAction

    
  }
  //resizing methods
    private void smallDimensions(Button btn){
        btn.setMinWidth(200);
        btn.setMinHeight(50);
    }//end smallDimensions
    private void largeDimensions(Button btn){
        btn.setMinWidth(200);
        btn.setMinHeight(200);
    }//end smallDimensions
  
}