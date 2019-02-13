package layouts;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class StackPanePractice extends Application
{
    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Working with StackPane");
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene()
    {
        StackPane panel = new StackPane();

        //add a few elements
        Circle circle1 = new Circle(100);
        circle1.setFill(Color.AQUA);
        Circle circle2 = new Circle(50);
        circle2.setFill(Color.RED);
        Circle circle3 = new Circle(150);
        circle3.setFill(Color.PURPLE);
        Circle circle4 = new Circle(70);
        circle4.setFill(Color.GREEN);

        panel.getChildren().addAll(circle1, circle2, circle3, circle4);

        //align them
        StackPane.setAlignment(circle1, Pos.CENTER_LEFT);
        StackPane.setAlignment(circle2, Pos.TOP_RIGHT);
        StackPane.setAlignment(circle3, Pos.BOTTOM_LEFT);
        StackPane.setAlignment(circle4, Pos.BOTTOM_CENTER);

        return new Scene(panel, 400, 400);
    }
}
