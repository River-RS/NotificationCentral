import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.concurrent.ScheduledService;
import javafx.concurrent.Task;
import javafx.concurrent.Worker.State;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
 
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
import javafx.geometry.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class App extends Application {

  // maintain a strong reference to the service
  private UpdateCheckService service;

  @Override
  public void start(Stage primaryStage) {
    service = new UpdateCheckService();
    service.setPeriod(Duration.seconds(5));

    Label resultLabel = new Label();
    service.setOnRunning(e -> resultLabel.setText(null));
    service.setOnSucceeded(
        e -> {
          if (service.getValue()) {
            resultLabel.setText("UPDATES AVAILABLE");
          } else {
            resultLabel.setText("UP-TO-DATE");
          }
        });

    Label msgLabel = new Label();
    msgLabel.textProperty().bind(service.messageProperty());

    ProgressBar progBar = new ProgressBar();
    progBar.setMaxWidth(Double.MAX_VALUE);
    progBar.progressProperty().bind(service.progressProperty());
    progBar.visibleProperty().bind(service.stateProperty().isEqualTo(State.RUNNING));

    VBox box = new VBox(3, msgLabel, progBar);
    box.setMaxHeight(Region.USE_PREF_SIZE);
    box.setPadding(new Insets(3));

    StackPane root = new StackPane(resultLabel, box);
    StackPane.setAlignment(box, Pos.BOTTOM_LEFT);

    primaryStage.setScene(new Scene(root, 400, 200));
    primaryStage.show();

    service.start();
  }

  private static class UpdateCheckService extends ScheduledService<Boolean> {

    @Override
    protected Task<Boolean> createTask() {
      return new Task<>() {

        @Override
        protected Boolean call() throws Exception {
          updateMessage("Checking for updates...");
          for (int i = 0; i < 1000; i++) {
            updateProgress(i + 1, 1000);
            Thread.sleep(1L); // fake time-consuming work
          }
          return Math.random() < 0.5; // 50-50 chance updates are "available"
        }
      };
    }
  }
}