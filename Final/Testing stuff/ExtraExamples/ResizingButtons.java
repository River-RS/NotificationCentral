//package helloworld;
 
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.*;
import java.util.*;
 
public class ResizingButtons extends Application {
    private boolean toggle = false; //show small message
    private int countNotification = 0;
    private static String[][] notifications = new String[20][3];
    
    public static void main(String[] args) throws Exception{

        csvFileRead();
        launch(args);
    }//end main
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hello World!");
        primaryStage.setX(-7);
        primaryStage.setY(0);
        Button btn = new Button();
        //btn.setMinWidth(100);
        smallDimensions(btn);//call dimeninsions
        
        
        //btn.setText("Say 'Hello World'");
        btn.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
        System.out.println(btn.getText() + "   " + btn.getText().contains("Hello"));
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                //NOTE TO PROGRAMMER: try making a stack data type to store data for notifications (first in, last out)                      
                   if (toggle == false){
                      System.out.println("You clicked the button" + "   " + toggle);
                      largeDimensions(btn);
                      btn.setWrapText(true);
                      btn.setText("" + notifications[countNotification][0] + ": recieved at " + notifications[countNotification][2] + "  \n" + notifications[countNotification][1]);
                      
                      //btn.setText("End of the line");
                      toggle = true;
                      countNotification = countNotification+1;            
                   }//end if
                   else{
                      System.out.println("You clicked the button again." + "   " + toggle);
                      smallDimensions(btn);
                      btn.setText("" + notifications[countNotification][0] + ": " + notifications[countNotification][1].substring(0,10) + " -- recieved at " + notifications[countNotification][2]);
                      //btn.setText("Hello again");
                      toggle = false;
                   }//end else
                }//end try
                catch(Exception e){
                   System.out.println("No new notifications at this time");
                   btn.setText("No new notifications at this time");
                }//end catch   
                  
             }     
            });//end setAction
       

        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 250, 650));
        
        primaryStage.show();
    }//end stage
    
    
    
    
    
    //resizing methods
    private void smallDimensions(Button btn){
        btn.setMaxWidth(200);
        btn.setMaxHeight(50);
    }//end smallDimensions
    private void largeDimensions(Button btn){
        btn.setMaxWidth(200);
        btn.setMaxHeight(200);
    }//end smallDimensions
    
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
            System.out.println(notifications[i][0] + ": " + notifications[i][1] + " -- recieved at " + notifications[i][2]);
         }//end if
       }//end for
    }//end csvFileRead
    
    
    
    
    
    
}//end ResizingButtons class      
