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


<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
public class NotificationButton extends Button implements EventHandler<ActionEvent>{
   private static ReadInCSV readInCSV = new ReadInCSV();
   private static String[][] notifications; //get notifications from prev class 
   private static List<Integer> buttonNotificationIndices;//get teh indeces for the
=======
public class NotificationButton extends Button implements EventHandler<ActionEvent> {
   private static MultipleButtonsOOP multipleButtons = new MultipleButtonsOOP();
   private static String[][] notifications = multipleButtons.notifications; //get notifications from prev class 
>>>>>>> parent of 416bd4d (update for object oriented code)
=======
public class NotificationButton extends Button implements EventHandler<ActionEvent> {
   private static MultipleButtonsOOP multipleButtons = new MultipleButtonsOOP();
   private static String[][] notifications = multipleButtons.notifications; //get notifications from prev class 
>>>>>>> parent of 416bd4d (update for object oriented code)
=======
public class NotificationButton extends Button implements EventHandler<ActionEvent> {
   private static MultipleButtonsOOP multipleButtons = new MultipleButtonsOOP();
   private static String[][] notifications = multipleButtons.notifications; //get notifications from prev class 
>>>>>>> parent of 416bd4d (update for object oriented code)
   private int countNotification = 0;
   private static int counter = 0;
   private Image icon;
   private boolean toggle = true;
   private String platformName;
    
   public NotificationButton(String platformName, String fileName, String csvFileName){
      super(platformName);
      String name = platformName;
      this.icon = new Image(fileName);
      this.platformName = platformName;//update instance variable
      ImageView imgView = new ImageView(this.icon);
      imgView.setFitWidth(18);
      imgView.setFitHeight(18);
      this.setGraphic(imgView);
      this.setOnAction(this);
      this.smallDimensions(this);
      notifications = readInCSV.getNotification(csvFileName);
      buttonNotificationIndices = readInCSV.getNotificationForButton(name);

   }//end conctructor
    
   EventHandler<ActionEvent> clickButton = new EventHandler<ActionEvent>(){
   public void handle(ActionEvent event){
      try{
         //basically, what i need to i is read through each platofrm name from the notification, and if the 
         if (toggle == false){
            System.out.println(platformName + " You clicked the button" + "   " + toggle);
            largeDimensions(this);
            this.setWrapText(true);
            //int index = buttonNotificationIndices.get(countNotification);
            //System.out.println("First: " + notifications[index][0] + ", Second: " + notifications[index][1] + ", Third: " + notifications[index][2]); 
            this.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
            toggle = true;
            countNotification = countNotification+1;   
         }//end if
         else{
            System.out.println(platformName + " You clicked the button again." + "   " + toggle);
            smallDimensions(this);
            this.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
            toggle = false;
          }//end else
      }//end try
      catch(Exception e){
         System.out.println("No new notifications at this time");
         smallDimensions(this);
         this.setText("No new notifications at this time");                            
      }//end catch           
   }//end method
   };//end event action
    
   //resizing methods
    private void smallDimensions(Button btn){
       btn.setMinWidth(200);
       btn.setMaxWidth(200);
       btn.setMinHeight(50);
    }//end smallDimensions
    private void largeDimensions(Button btn){
       btn.setMinWidth(200);
       btn.setMaxWidth(200);
       btn.setMinHeight(200);
    }//end smallDimensions
 
    //delay method
    private void delay(int time){
       try{
          Thread.sleep(time);
       }//end try
       catch(Exception e){
          Thread.currentThread().interrupt();
       }//end catch
    }//end delay method
    

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setX(-7);
        primaryStage.setY(0);
        
        //generate buttons
        Button btnC = new NotificationButton("Canvas", "canvas.png");
        Button btnD = new NotificationButton("Discord", "discord.png");
        Button btnO = new NotificationButton("Outlook", "outlook.png");
        Button btnG = new NotificationButton("GitHub", "GitHub.png");
        Button btnJ = new NotificationButton("Junk", "junk.png");
           
        //call method to set event to each button   
        
        //create events to buttons
        btnC.setOnAction(clickButton);
        btnD.setOnAction(clickButton);
        btnO.setOnAction(clickButton);
        btnG.setOnAction(clickButton);
        btnJ.setOnAction(clickButton);

        
        System.out.println(stackNotifications.pop());
        
        Group root = new Group();
        ScrollPane sc = new ScrollPane();
        VBox vbox = new VBox(5);
        
        sc.setFitToWidth(true);
        
        vbox.getChildren().add(btnC);
        vbox.getChildren().add(btnD);
        vbox.getChildren().add(btnO);
        vbox.getChildren().add(btnG);
        vbox.getChildren().add(btnJ);
        
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
    

}//end Notification class