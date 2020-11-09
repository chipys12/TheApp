package sample;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.Scene;

public class AlertBox {

    public static void display(String title, String message){
        Stage window2 = new Stage();

        window2.initModality(Modality.APPLICATION_MODAL);
        window2.setTitle(title);
        window2.setMinWidth(250);

        Label label3 = new Label();
        label3.setText(message);
        Button closeButton = new Button("OK");
        closeButton.setOnAction(e -> window2.close());

        //layout
        VBox layout = new VBox(10);
        layout.getChildren().addAll(label3, closeButton);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window2.setScene(scene);
        window2.showAndWait();
    }
}