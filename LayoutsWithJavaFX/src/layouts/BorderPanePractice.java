package layouts;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BorderPanePractice  extends Application
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
        BorderPane panel = new BorderPane();

        //assign our regions
        panel.setTop(getTop());
        panel.setBottom(getBottom());
        panel.setLeft(getLeft());
        panel.setRight(getRight());
        panel.setCenter(getCenter());

        return new Scene(panel, 500, 500);
    }

    //methods for each region... (a Node is a widget or panel)
    public Node getTop()
    {
        //store buttons horizontally in the top region
        HBox buttonBox = new HBox();

        for (int i = 0; i < 10; i++)
        {
            Button button = new Button("Button #" + i);
            buttonBox.getChildren().add(button);
        }

        return buttonBox;
    }

    public Node getBottom()
    {
        Label paragraph = new Label("Lorem ipsum dolor sit amet, consectetur adipiscing " +
                "elit. Cras euismod, tellus eget porttitor porttitor, odio leo cursus " +
                "erat, sed cursus libero leo at metus. Aliquam a tellus at magna euismod " +
                "tincidunt non sit amet sem. Quisque porttitor aliquet lectus, nec " +
                "fringilla elit pulvinar eu. Proin fermentum eleifend libero nec maximus. " +
                "Nullam et pulvinar velit. Nunc elementum at felis et elementum. " +
                "Pellentesque euismod tempus eros ut auctor. Nulla ut erat augue. " +
                "Ut ut est fermentum, convallis nibh vel, dapibus enim. Nulla " +
                "ullamcorper leo est, vel dictum lacus venenatis sit amet. Nulla " +
                "et enim nec elit mollis molestie eu ac tortor. Suspendisse suscipit " +
                "mauris eu scelerisque condimentum. Suspendisse pellentesque lacinia " +
                "urna, nec rutrum risus vulputate mattis. Morbi ac sem vitae est " +
                "iaculis egestas at ut enim. Sed tempus enim erat, et aliquet arcu " +
                "aliquet condimentum.");

        paragraph.setWrapText(true);

        return paragraph;
    }

    public Node getLeft()
    {
        VBox stackingBox = new VBox();

        for (int i = 0; i < 12; i++)
        {
            CheckBox checkBox = new CheckBox("Option #" + i);
            stackingBox.getChildren().add(checkBox);
        }

        return stackingBox;
    }

    public Node getRight()
    {
        VBox stackingBox = new VBox();

        for (int i = 0; i < 12; i++)
        {
            RadioButton radio = new RadioButton("Option #" + i);
            stackingBox.getChildren().add(radio);
        }

        return stackingBox;
    }

    public Node getCenter()
    {
        Image image = new Image("garfield.jpg");
        ImageView view = new ImageView(image);

        return view;
    }
}