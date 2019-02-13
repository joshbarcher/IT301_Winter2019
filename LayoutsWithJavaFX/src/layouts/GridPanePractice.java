package layouts;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class GridPanePractice extends Application
{
    public static final int WIN_SIZE = 600;

    @Override
    public void start(Stage stage) throws Exception
    {
        stage.setTitle("Grid pane example");
        stage.setScene(getScene());
        stage.show();
    }

    public Scene getScene()
    {
        GridPane panel = new GridPane();

        //add some white space between elements
        panel.setVgap(10);
        panel.setHgap(10);
        panel.setPadding(new Insets(8));

        //add widgets in columns and rows
        constraints(panel);

        addRowOfButtons(panel);
        addTextareaColumn(panel);
        addCheckboxColumn(panel);
        addImageColumn(panel);

        return new Scene(panel, WIN_SIZE, WIN_SIZE);
    }

    private void addImageColumn(GridPane panel)
    {
        Image image = new Image("garfield.jpg"); //represents the image
        ImageView viewer = new ImageView(image); //draws the image

        viewer.setPreserveRatio(true);
        viewer.setFitWidth(150);

        panel.add(viewer, 2, 1, 1, 3);
    }

    private void addCheckboxColumn(GridPane panel)
    {
        VBox checkPanel = new VBox();

        CheckBox check1 = new CheckBox("Option A");
        CheckBox check2 = new CheckBox("Option B");
        CheckBox check3 = new CheckBox("Option C");

        checkPanel.getChildren().addAll(check1, check2, check3);
        panel.add(checkPanel, 1, 1, 1, 3);
    }

    private void addTextareaColumn(GridPane panel)
    {
        TextArea area = new TextArea();
        area.setPrefColumnCount(10);
        panel.add(area, 0, 1, 1, 3); //col, row, colspan, rowspan
    }

    private void addRowOfButtons(GridPane panel)
    {
        Button firstButton = new Button("First");
        Button secondButton = new Button("Second");
        Button thirdButton = new Button("Third");

        firstButton.setPrefWidth(150);
        secondButton.setPrefWidth(300);

        panel.add(firstButton, 0, 0);
        panel.add(secondButton, 1, 0);
        panel.add(thirdButton, 2, 0);
    }

    private void constraints(GridPane panel)
    {
        double[] constraints = {WIN_SIZE / 4.0, WIN_SIZE / 2.0, WIN_SIZE / 4.0};

        for (int i = 0; i < constraints.length; i++)
        {
            panel.getColumnConstraints().add(new ColumnConstraints(constraints[i]));
        }

        constraints = new double[] {50, 100, 100, 100};

        for (int i = 0; i < constraints.length; i++)
        {
            panel.getRowConstraints().add(new RowConstraints(constraints[i]));
        }
    }
}
