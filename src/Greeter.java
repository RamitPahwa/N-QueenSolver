/**
 * Created by dellpc on 10/29/2016.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Greeter extends Application  {

    Stage window;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window=primaryStage;
        primaryStage.setTitle("N-Queen Solver");
        primaryStage.setOnCloseRequest(e->{
            e.consume();
            boolean quitResult=ConfirmBox.display("STOP","Are you sure you want to close the application?");
            if (quitResult)
            {
                closeProgram();
            }
        });
        TextField input =new TextField();
        input.setPadding(new Insets(10,10,10,10));
        input.setMaxWidth(80);
        Label label1=new Label("Enter the value of N (nof of queens):");
        Button solveButton =new Button("Solve");;
        Button quitButton = new Button("Quit !!");
        quitButton.setOnAction(e->{
            boolean quitResult=ConfirmBox.display("STOP","Are you sure you want to close the application?");
            if (quitResult)
            {
                closeProgram();
            }
        });
        solveButton.setOnAction(e -> {

            if (input.getText().isEmpty())
            {
                AlertBox.display("ERROR","Enter a number");
            }
            else if ( input.getText().matches("[0-9]+"))
            {
                int n=Integer.parseInt(input.getText());
                System.out.print(n);
                solver(n);
            }
            else
            {
                AlertBox.display("ERROR","Please enter a Valid Number");
            }

        });
        HBox bottom =createHBox(Pos.CENTER);
        bottom.getChildren().addAll(solveButton,quitButton);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(10,10,10,10));
        VBox center =new VBox(10);
        center.getChildren().addAll(label1,input);
        center.setAlignment(Pos.CENTER);

        BorderPane layout= new BorderPane();
        layout.setCenter(center);
        layout.setBottom(bottom);
        Scene newscene=new Scene(layout,300,250);
        primaryStage.setScene(newscene);
        primaryStage.show();

    }

    private void closeProgram()
    {
        System.out.println("File is saved");
        window.close();

    }
    private void solver(int n )
    {
        ChessBoard board =new ChessBoard(n);
        board.placeQueen(0);
        if(board.count==0)
        {
            AlertBox.display("Title","NO Solution exist");

        }
        else
        {   int i=0;
             display(board,n,i);
        }

    }
    public static HBox createHBox(Pos position ){

        HBox newHBox = new HBox();
        newHBox.setSpacing(20);
        newHBox.setAlignment(position);
        newHBox.setPadding(new Insets(20, 20, 20, 20));
        return newHBox;
    }


    public void display(ChessBoard chessboard,int n,int i)
        {
            GridPane newBoard;
            DrawChessboard tool = new DrawChessboard();
            newBoard = tool.draw(chessboard.solutions.get(i),n);

            Stage window = new Stage();
            BorderPane layout = new BorderPane();
            layout.setCenter(newBoard);
            Button next = new Button("Next");
            Button previous = new Button("Previous");
            Button quit=new Button("Quit");
            HBox options = createHBox(Pos.BOTTOM_CENTER);
            previous.setOnAction(e ->
            {
                window.close();
                if((i-1)>=0)
                {
                    display(chessboard,n,i-1);
                }
            });
            next.setOnAction(e ->
            {
                window.close();
                if((i+1)<chessboard.count)
                {
                    display(chessboard,n,i+1);
                }
            });
            quit.setOnAction(e->{
                boolean quitResult=ConfirmBox.display("STOP","Are you sure you want to close the application?");
                if (quitResult)
                {   window.close();
                    closeProgram();
                }
            });
            if(i != 0)
            {
                options.getChildren().add(previous);
            }
            if(i != (chessboard.count-1) )
            {
                options.getChildren().add(next);
            }
            if(i==(chessboard.count-1))
            {
                options.getChildren().add(quit);
            }
            layout.setBottom(options);
            Scene scene = new Scene(layout, 600, 600);
            window.setScene(scene);
            window.setTitle("Solution "+(i+1)+" of "+chessboard.count);
            window.show();
        }
    }

