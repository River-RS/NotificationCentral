import java.io.*;
import java.util.*;

 
 
public class ReadInCSV {
   private static String currentFileName = "";
   private int countNotification = 0;
   private static int counter = 0;
   private String[][] notifications = new String[20][3];


 //csv reading method
    private void csvFileRead(String fileName){
       try{
          currentFileName = fileName;
          Scanner sc = new Scanner(new File(fileName));  
          sc.useDelimiter(",");   //sets the delimiter pattern
          String nextSource;
          String nextMessage;
          String nextTimeStamp;
          int cnt = 0;
          counter = 0;
        
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
          
          for(int i =0; i< notifications.length-1; i++){
             if (notifications[i][0] != null){
                //System.out.println("Notification ");
                counter = counter +1;
                System.out.println(notifications[i][0] + ": " + notifications[i][1] + " -- recieved at " + notifications[i][2]);
                
             }//end if
          }//end for
      }//end try
      catch (Exception e){
         System.out.println("Error csvFileRead: " + e);
      }//end ctach
    }//end csvFileRead

    public String[][] getNotification(String fileName){
       try{
          csvFileRead(fileName);
          return notifications;
       }//ed try
       catch(Exception e){
          System.out.println("Error getNotification: " + e);
          String[][] emptyArray = {{"null","null"}};
          return emptyArray;
       }//end catch
    }//end getNotificatio method
 
}//end multipleButtonsOOP class
 
