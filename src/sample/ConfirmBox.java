package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window2 = new Stage();
        window2.initModality(Modality.APPLICATION_MODAL);
        window2.setTitle(title);
        window2.setMinWidth(250);
        Label label3 = new Label();
        label3.setText(message);

        //two buttons
        Button button1 = new Button("Yes");
        Button button2 = new Button("No");

        button1.setOnAction(e -> {
            answer = true;
            window2.close();
        });
        button2.setOnAction(e -> {
            answer = false;
            window2.close();
        });

        //layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label3, button1, button2);
        layout.setAlignment(Pos.CENTER);
        Scene scene = new Scene(layout);
        window2.setScene(scene);
        window2.showAndWait();

        return answer;
    }
}