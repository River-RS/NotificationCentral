import java.util.*;

public class SearchArrayForString{

   public static void main(String args[]){
      System.out.println("hi"); //cool
      //so, the plan is to take an array, go through it and fid every value that matches a paramater, and return an array with those values/indices
      String[][] arrayExample = {{"hello","end"}, {"goodbye", "end"}, {"end", "start"}, {"go", "hello"}};
      List<Integer> listExample = new ArrayList<>();
      String param = "hello";
      for(int i = 0; i < arrayExample.length; i++){
         String buttonName = arrayExample[i][0];
         System.out.println(buttonName);
         //cool, that works
         //so, now for a 'search'
         if (buttonName.equals(param)){
             listExample.add(i);
         }//end if
      }//end for
      System.out.println(listExample);
      
      for(int i = 0; i < listExample.size(); i++){
         int index = listExample.get(i);
         System.out.println("First: " + arrayExample[index][0] + ", Second: " + arrayExample[index][1] + "."); 
      }//end for
            
   }//end main

}//end class
