import java.io.*;  
import java.util.*;
import java.util.Scanner;  
public class ReadingInCSVFile_v2{  
   public static void main(String[] args) throws Exception {  
      //parsing a CSV file into Scanner class constructor  
      Scanner sc = new Scanner(new File("C:/Users/Owner/Documents/GitHub/Programs/attemptAgainAgain/NotificationCentral/CSV test.csv"));  
      sc.useDelimiter(",");   //sets the delimiter pattern
      //String[][] listOfNotifications = new String[20];
      //List<String> notifications = new ArrayList<>();
      String[][] notifications = new String[20][3];     
      String nextSource;
      String nextMessage;
      String nextTimeStamp;
      int cnt = 0;
        
      while (sc.hasNext()){  //returns a boolean value  
         //String line = sc.next();
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
      
      
   }//end main  
}//end class  