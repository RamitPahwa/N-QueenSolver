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
public class ConfirmBox {

    static boolean result;
    public static boolean display(String title,String message)
    {
        Stage confirmBox= new Stage();
        confirmBox.initModality(Modality.APPLICATION_MODAL);
        confirmBox.setTitle(title);
        confirmBox.setMinWidth(250);
        Label label1= new Label(message);
        Button yesButton =new Button("Yes");
        Button noButton= new Button("No");

       yesButton.setOnAction(e->{
           result=true;
           confirmBox.close();
       });

        noButton.setOnAction(e->{
            result=false;
            confirmBox.close();
        });
        VBox layout=new VBox(20);
        layout.getChildren().addAll(label1,yesButton,noButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(10.,10,10,10));
        Scene newscene=new Scene(layout,500,200);
        confirmBox.setScene(newscene);
        confirmBox.showAndWait(); //will not allow to work on previous window
        return result;

    }
}
