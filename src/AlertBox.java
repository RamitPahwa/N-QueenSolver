import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Created by ramit  on 10/29/2016.
 */
public class AlertBox {

    public static void display(String title,String message)
    {
        Stage alertBox= new Stage();

        alertBox.initModality(Modality.APPLICATION_MODAL);
        alertBox.setTitle(title);
        alertBox.setMinWidth(250);

        Label label1= new Label(message);
        Button quitButton =new Button("OK");
        quitButton.setOnAction(e->alertBox.close());

        VBox layout=new VBox(20);
        layout.getChildren().addAll(label1,quitButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10.,10,10,10));
        Scene newscene=new Scene(layout,200,200);
        alertBox.setScene(newscene);
        alertBox.showAndWait(); //will not allow to work on previous window


    }
}
