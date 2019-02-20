package scenes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SceneSwitcher extends Application
{
    private Stage stage;

    @Override
    public void start(Stage stage) throws Exception
    {
        this.stage = stage;

        //common setup
        stage.setTitle("Switching Scenes");
        stage.setScene(getFirstScene()); //this changes my UI!
        stage.show();
    }

    private Scene getFirstScene()
    {
        //create layout
        VBox panel = new VBox();
        panel.setPadding(new Insets(30));

        //add some widgets (or nested layouts)
        Button button = new Button("Click");
        panel.getChildren().addAll(button, new Button("Me"));

        //practice switching scenes
        button.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                stage.setScene(getSecondScene());
            }
        });

        //create the scene
        return new Scene(panel);
    }

    private Scene getSecondScene()
    {
        VBox panel = new VBox();
        panel.setPadding(new Insets(30));

        Button goBack = new Button("Go Back");
        panel.getChildren().add(goBack);

        goBack.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent actionEvent)
            {
                stage.setScene(getFirstScene());
            }
        });

        return new Scene(panel);
    }
}
