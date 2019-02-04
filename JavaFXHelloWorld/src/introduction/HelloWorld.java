package introduction;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloWorld extends Application
{
    @Override
    public void start(Stage stage)
    {
        stage.setTitle("Our first Java FX program");
        stage.setScene(getScene());
        stage.show();
    }

    private Scene getScene()
    {
        //create a panel to hold our widgets, add a text box
        //and return a new scene
        VBox panel = new VBox();
        Text textHeader = new Text("Hello world!");
        Button clickMe = new Button("Click Me!");
        ColorPicker colorPicker = new ColorPicker();
        DatePicker datePicker = new DatePicker();

        //set some style settings for the panel
        panel.setAlignment(Pos.CENTER);
        panel.setSpacing(15);

        //adds the text widget to the panel
        panel.getChildren().addAll(textHeader, clickMe, colorPicker, datePicker);

        Text text = new Text("Enter information");
        text.setFont(Font.font("Vani", FontWeight.BOLD, 30));
        text.setUnderline(true);
        

        return new Scene(panel, 400, 500);
    }
}
