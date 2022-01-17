import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class First extends Application {
    Stage mainStage;
    Scene mainScene;

    Button mainButton;
    Button mainButton2;
    Label mainLabel;

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage stage) throws Exception {

        mainStage = stage;
        mainButton = new Button("Begin!");
        mainButton2 = new Button("Begin2!");
        mainLabel = new Label("Ready");

        VBox box = new VBox(50);
        box.getChildren().addAll(mainLabel, mainButton, mainButton2);

        mainScene = new Scene(box, 200, 200);
        mainStage.setScene(mainScene);
        mainStage.setTitle("Test Program");
        mainStage.show();


        mainButton.setOnAction(e -> {
            final Second s = new Second();

            mainLabel.textProperty().bindBidirectional(s.getProperty());

            Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    s.count();
                }
            }), new KeyFrame(Duration.seconds(Second.DURATION)));

            timeline.setCycleCount(11);
            timeline.play();

        });

        mainButton2.setOnAction(event -> {
            final Second s = new Second();
            s.count2(mainLabel);

        });

        //
    }
}

class Second {

    private StringProperty strP = new SimpleStringProperty(this, "strProperty", "");
    private int myCount;
    public static float DURATION = 0.25F;
    public static long DURATION_SEC = (long)DURATION * 1000;

    Second()
    {
        myCount = 0;
    }

    public void count2(final Label mainLabel) {
        Task<Void> task = new Task<Void>() {
            @Override 
            public Void call() throws Exception {
                for (int i=1; i<=10; i++) {
                    updateMessage("Count: "+i);
                    //mainButton.setText("Begin! "+ i);
                    Thread.sleep(DURATION_SEC);
                }
                return null ;
            }
        };

        task.messageProperty().addListener((obs, oldMessage, newMessage) -> mainLabel.setText(newMessage));
        new Thread(task).start();
    }

    // Get Property
    public StringProperty getProperty() {
        return strP;
    }

    // Get String
    public String getString() {
        return strP.get();
    }

    public void count()
    {
        this.strP.set("Count: "+myCount++);
    }

}