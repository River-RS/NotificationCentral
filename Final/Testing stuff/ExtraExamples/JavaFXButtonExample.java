//Java program to display multiple buttons with an event handler
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.control.Button;
//sample class
public class JavaFXButtonExample extends Application {
//  application launches here
public void start(Stage s) throws Exception
{
// Title for the stage is set
s.setTitle(" JavaFX Button Sample ");
//create a cancel button and set it
Button cb=new Button("This is an example of a cancel button...Please click me !!!");
cb.setCancelButton(true);
//create a default button and set it
Button db = new Button("This is an example of a default button...Please click me !!!");
// set default button
db.setDefaultButton(true);
// tile pane is created
TilePane tp = new TilePane();
// label is created
Label lb = new Label(" Click any one button ");
// an event handler creation
EventHandler<ActionEvent> ev = new EventHandler<ActionEvent>() {
public void handle(ActionEvent e)
{
lb.setText(" You have selected cancel button ");
}
};
// an event handler creation
EventHandler<ActionEvent> evn = new EventHandler<ActionEvent>() {
public void handle(ActionEvent e)
{
lb.setText(" You have selected default button ");
}
};
// In button, event is set
cb.setOnAction(ev);
db.setOnAction(evn);
tp.getChildren().add(cb);
tp.getChildren().add(db);
tp.getChildren().add(lb);
// Scene creation and adding it  to the scene graph
//create a scene
Scene sc=new Scene(tp,200,200);
//set the scene
s.setScene(sc);
//display the results
s.show();
}
public static void main(String args[])
{
// launch the application
launch(args);
}
}