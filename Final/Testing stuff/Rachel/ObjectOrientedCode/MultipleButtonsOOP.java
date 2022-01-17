//package helloworld;
 
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

 
 
public class MultipleButtonsOOP extends Application {

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
 
 //csv reading method
    private static void csvFileRead() throws Exception {
       Scanner sc = new Scanner(new File("CSV test.csv"));  
       sc.useDelimiter(",");   //sets the delimiter pattern
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

 
 
}//end multipleButtonsOOP class
 
