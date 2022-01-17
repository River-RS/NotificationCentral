import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;


public class NC extends Application{
   public static void main(String[] args){
      /*The command below launches the application calling the init and start method and 
      doesnt finished until the stop method is called
      */
      System.out.println( "Starting Program" );
      launch(args); 
      System.out.println( "Program has ended" );
   }//end main
   
   Button btn;
   
   @Override public void start( Stage primaryStage) {
      //Create the button
      btn = new Button();
      btn.setText( "FIX ME" );
      btn.setOnAction( e -> buttonClick() );
      
      //add the button to a layout pane
      BorderPane pane = new BorderPane();
      pane.setCenter(btn);
      //add the layout pane to a scene
      Scene scene = new Scene(pane, 300, 250);
      
      //Finalize and show the stage
      primaryStage.setScene(scene);
      primaryStage.setTitle( "Notification Central");
      primaryStage.show();
   }//end start
   
   public void buttonClick(){
      if(btn.getText() == "FIX ME" )
         btn.setText( "Fix me Please" );
      else
         btn.setText( "FIX ME" );

   }//end buttonClick
}//end Application