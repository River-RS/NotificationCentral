//package helloworld;
import javafx.scene.input.ScrollEvent;
import javafx.scene.Node;
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
import javafx.scene.input.*;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.VBox;
import javafx.geometry.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

 
 
public class MultipleButtonsScrollbar extends Application {
    private boolean toggleC = false;
    private boolean toggleD = false;
    private boolean toggleO = false;
    private boolean toggleG = false;
    private boolean toggleJ = false;
    
    private int countNotification = 0;
    private static int counter = 0;
    private static String[][] notifications = new String[20][3];
    private static Stack<String> stackNotifications = new Stack<String>();
    
    public static void main(String[] args) throws Exception{
        csvFileRead();
        System.out.println("************************************************************************");
        stackNotifications.add(notifications[0][0] + "!!");
        stackNotifications.add(notifications[1][0] + "!!");
        stackNotifications.add(notifications[2][0] + "!!");
        stackNotifications.add(notifications[3][0] + "!!");
        stackNotifications.add(notifications[4][0] + "!!");
        stackNotifications.add(notifications[5][0] + "!!");
        stackNotifications.add(notifications[6][0] + "!!");
        launch(args);
        
    }//end main
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setX(-7);
        primaryStage.setY(0);
        
        
        
        Button btnC = new Button("Canvas");
        Button btnD = new Button("Discord");
        Button btnO = new Button("Outlook");
        Button btnG = new Button("GitHub");
        Button btnJ = new Button("Junk");
        
        //VBox vbox = new VBox(5); // dist between boxes
        
        //call dimeninsions
        smallDimensions(btnC);
        smallDimensions(btnD);
        smallDimensions(btnO);
        smallDimensions(btnG);
        smallDimensions(btnJ);
       
        //set button icons
        Image imgC = new Image("canvas.png");
        ImageView imgCView = new ImageView(imgC);
        imgCView.setFitWidth(18);
        imgCView.setFitHeight(18);
        btnC.setGraphic(imgCView);

        Image imgD = new Image("discord.png");
        ImageView imgDView = new ImageView(imgD);
        imgDView.setFitWidth(18);
        imgDView.setFitHeight(18);
        btnD.setGraphic(imgDView);        
        
        Image imgO = new Image("outlook.png");
        ImageView imgOView = new ImageView(imgO);
        imgOView.setFitWidth(18);
        imgOView.setFitHeight(18);
        btnO.setGraphic(imgOView);
        
        Image imgG = new Image("GitHub.png");
        ImageView imgGView = new ImageView(imgG);
        imgGView.setFitWidth(18);
        imgGView.setFitHeight(18);
        btnG.setGraphic(imgGView);        
                
        Image imgJ = new Image("junk.png");
        ImageView imgJView = new ImageView(imgJ);
        imgJView.setFitWidth(18);
        imgJView.setFitHeight(18);
        btnJ.setGraphic(imgJView);        
        
        
        EventHandler<ActionEvent> clickCanvas = new EventHandler<ActionEvent>(){
           public void handle(ActionEvent event){
              try{
                 if (toggleC == false){
                    System.out.println("C: You clicked the button" + "   " + toggleC);
                    largeDimensions(btnC);
                    btnC.setWrapText(true);
                    //btnC.setText("Here's more info");
                    btnC.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
                    toggleC = true;
                    countNotification = countNotification+1;   
                 }//end if
                 else{
                    System.out.println("C: You clicked the button again." + "   " + toggleC);
                    smallDimensions(btnC);
                    //btnC.setText("Canvas: New notification");
                    btnC.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
                    toggleC = false;
                 }//end else
              }//end try
              catch(Exception e){
                 System.out.println("No new notifications at this time");
                 smallDimensions(btnC);
                 btnC.setText("No new notifications at this time");                 
                 //Platform.runLater(new Runnable() {
                   //@Override public void run() {
                      //delay(3000);
                      //System.out.println("Reset to default: Canvas");
                      //btnC.setText("Canvas");
                    //}//end run
                 //});//end runLater
              
              }//end catch           
           }//end event
        };//end clickCanvas
        
        
        EventHandler<ActionEvent> clickDiscord = new EventHandler<ActionEvent>(){
           public void handle(ActionEvent event){
              try{
                 if (toggleD == false){
                    System.out.println("D: You clicked the button" + "   " + toggleD);
                    largeDimensions(btnD);
                    btnD.setWrapText(true);
                    btnD.setText("Here's more info");
                    //btnD.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
                    toggleD = true;
                    //countNotification = countNotification+1;   
                 }//end if
                 else{
                    System.out.println("D: You clicked the button again." + "   " + toggleD);
                    smallDimensions(btnD);
                    btnD.setText("Discord: New notification");
                    //btnD.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
                    toggleD = false;
                 }//end else
              }//end try
              catch(Exception e){
                 System.out.println("No new notifications at this time");
                 smallDimensions(btnD);
                 btnD.setText("No new notifications at this time");                 
                 //Platform.runLater(new Runnable() {
                   // @Override public void run() {
                       //delay(3000);
                       //System.out.println("Reset to default: Canvas");
                       //btnD.setText("Canvas");
                    //}//end run
                 //});//end runLater
              }//end catch
           }//end event
        };//end clickDiscord


        EventHandler<ActionEvent> clickOutlook = new EventHandler<ActionEvent>(){
           public void handle(ActionEvent event){
              try{
                 if (toggleO == false){
                    System.out.println("O: You clicked the button " + "   " + toggleO);
                    largeDimensions(btnO);
                    btnO.setWrapText(true);
                    btnO.setText("Here's more info");
                    //btnO.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
                    toggleO = true;
                    //countNotification = countNotification+1;   
                 }//end if
                 else{
                    System.out.println("O: You clicked the button again." + "   " + toggleO);
                    smallDimensions(btnO);
                    btnO.setText("Outlook: New notification");
                    //btnO.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
                    toggleO = false;
                 }//end else
              }//end try
              catch(Exception e){
                 System.out.println("No new notifications at this time");
                 smallDimensions(btnO);
                 btnO.setText("No new notifications at this time");                 
                 //Platform.runLater(new Runnable() {
                   // @Override public void run() {
                       //delay(3000);
                       //System.out.println("Reset to default: Canvas");
                       //btnO.setText("Canvas");
                    //}//end run
                 //});//end runLater
              }//end catch
           }//end event
        };//end clickOutlook
        
        
        EventHandler<ActionEvent> clickGitHub = new EventHandler<ActionEvent>(){
           public void handle(ActionEvent event){
              try{
                 if (toggleG == false){
                    System.out.println("G You clicked the button" + "   " + toggleG);
                    largeDimensions(btnG);
                    btnG.setWrapText(true);
                    btnG.setText("Here's more info");
                    //btnG.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
                    toggleG = true;
                    //countNotification = countNotification+1;   
                 }//end if
                 else{
                    System.out.println("G: You clicked the button again." + "   " + toggleG);
                    smallDimensions(btnG);
                    btnG.setText("GitHub: New notification");
                    //btnG.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
                    toggleG = false;
                 }//end else
              }//end try
              catch(Exception e){
                 System.out.println("No new notifications at this time");
                 smallDimensions(btnG);
                 btnG.setText("No new notifications at this time");                 
                 //Platform.runLater(new Runnable() {
                   // @Override public void run() {
                       //delay(3000);
                       //System.out.println("Reset to default: Canvas");
                       //btnG.setText("Canvas");
                    //}//end run
                 //});//end runLater
              }//end catch
           }//end event
        };//end clickGitHub
        
        
        EventHandler<ActionEvent> clickJunk = new EventHandler<ActionEvent>(){
           public void handle(ActionEvent event){
              try{
                 if (toggleJ == false){
                    System.out.println("J: You clicked the button" + "   " + toggleJ);
                    largeDimensions(btnJ);
                    btnJ.setWrapText(true);
                    btnJ.setText("Here's more info");
                    //btnD.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
                    toggleJ = true;
                    //countNotification = countNotification+1;   
                 }//end if
                 else{
                    System.out.println("J: You clicked the button again." + "   " + toggleJ);
                    smallDimensions(btnJ);
                    btnJ.setText("Junk: New notification");
                    //btnJ.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
                    toggleJ = false;
                 }//end else
              }//end try
              catch(Exception e){
                 System.out.println("No new notifications at this time");
                 smallDimensions(btnJ);
                 btnJ.setText("No new notifications at this time");                 
                 //Platform.runLater(new Runnable() {
                   // @Override public void run() {
                       //delay(3000);
                       //System.out.println("Reset to default: Canvas");
                       //btnJ.setText("Canvas");
                    //}//end run
                 //});//end runLater
              }//end catch
           }//end event
        };//end clickDiscord        
          

        
        //create events to buttons
        btnC.setOnAction(clickCanvas);
        btnD.setOnAction(clickDiscord);
        btnO.setOnAction(clickOutlook);
        btnG.setOnAction(clickGitHub);
        btnJ.setOnAction(clickJunk);

        
        System.out.println(stackNotifications.pop());
        
        Group root = new Group();
        //ScrollBar sc = new ScrollBar();
        ScrollPane sc = new ScrollPane();
        sc.setFitToWidth(true);
        //sc.setMin(0);
        //sc.setMax(650);
        //sc.setPrefHeight(200);
        //sc.setOrientation(Orientation.VERTICAL);
        // tile pane is created     
        VBox vbox = new VBox(5);
        vbox.getChildren().add(btnC);
        vbox.getChildren().add(btnD);
        vbox.getChildren().add(btnO);
        vbox.getChildren().add(btnG);
        vbox.getChildren().add(btnJ);
        vbox.setLayoutX(25);
        vbox.setLayoutY(150);
        //root.setLayoutY(15);
        sc.setContent(vbox);
        //sc.setLayoutX(20);
        sc.setPrefSize(250, 650);
        sc.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        //sc.setLayoutX(1);
        sc.vvalueProperty().addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue<? extends Number> ov,
              Number old_val, Number new_val) {
                  System.out.println(new_val.intValue());
          }
        });
        sc.hvalueProperty().addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue<? extends Number> ov,
              Number old_val, Number new_val) {
                  System.out.println(new_val.intValue());
          }
      });        
        primaryStage.setScene(new Scene(root, 250, 650));
        root.getChildren().addAll(vbox, sc);
         /*sc.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov,
               Number old_val, Number new_val) {
                  vbox.setLayoutY(-new_val.doubleValue());
               }
            });        */

         primaryStage.show();
        
    }//end stage
    
        public void addMouseScrolling(Node node) {
        node.setOnScroll((ScrollEvent event) -> {
            // scroll up or down
            node.setTranslateY(node.getTranslateY() + event.getDeltaY());
         
        });
    }
            
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
      
    //csv reading method
    private static void csvFileRead() throws Exception {
       Scanner sc = new Scanner(new File("CSV test.csv"));  
       sc.useDelimiter(",");   //sets the delimiter pattern
       //String[][] notifications = new String[20][3];     
       String nextSource;
       String nextMessage;
       String nextTimeStamp;
       int cnt = 0;
        
       while (sc.hasNext()){  //returns a boolean value  
         nextSource = sc.next().replaceAll("[\\n\\t\\r]", "");//remove newline characters etc
         nextMessage = sc.next().replaceAll("[\\n\\t\\r]", "");//remove newline characters etc
         nextTimeStamp = sc.next().replaceAll("[\\n\\t\\r]", "");//remove newline characters etc
         
         notifications[cnt][0] = nextSource;
         notifications[cnt][1] = nextMessage;
         notifications[cnt][2] = nextTimeStamp;
         
         cnt = cnt + 1;
       }//end while     
       sc.close();  //closes the scanner  
      
       for(int i =0; i< notifications.length; i++){
         if (notifications[i][0] != null){
            //System.out.println("Notification ");
            counter = counter +1;
            System.out.println(notifications[i][0] + ": " + notifications[i][1] + " -- recieved at " + notifications[i][2]);
         }//end if
       }//end for
    }//end csvFileRead
    
    
    
}//end MultipleButtonsScrollbar class      



