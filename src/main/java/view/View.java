package view;
import controller.Controller;
import ir.ac.kntu.Main;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Timer;
import java.util.TimerTask;
public class View extends Application {
    public void start(Stage stage) throws FileNotFoundException {
        Image image = new Image(new FileInputStream("./src/main/java/mnm.PNG"));
        ImageView imageView = new ImageView(image);
        String musicFile = "./src/main/java/music.mp3";
        Media sound = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.setVolume(20);
        mediaPlayer.play();
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(600);
        imageView.setFitWidth(900);
        imageView.setPreserveRatio(true);
        Image image1 = new Image(new FileInputStream("./src/main/java/mnm2.jpg"));
        ImageView imageView1 = new ImageView(image1);
        imageView1.setX(0);
        imageView1.setY(0);
        imageView1.setFitHeight(600);
        imageView1.setFitWidth(900);
        Image image2 = new Image(new FileInputStream("./src/main/java/mnm8.jpg"));
        ImageView imageView2 = new ImageView(image2);
        imageView2.setX(0);
        imageView2.setY(0);
        imageView2.setFitHeight(1000);
        imageView2.setFitWidth(1200);
        imageView2.setPreserveRatio(true);
        Image image3 = new Image(new FileInputStream("./src/main/java/mnm7.jpeg"));
        ImageView imageView3 = new ImageView(image3);
        imageView3.setX(0);
        imageView3.setY(0);
        imageView3.setFitHeight(800);
        imageView3.setFitWidth(1100);
        imageView3.setPreserveRatio(true);
        Image image4 = new Image(new FileInputStream("./src/main/java/mnm4.jpg"));
        ImageView imageView4 = new ImageView(image4);
        imageView4.setX(0);
        imageView4.setY(0);
        imageView4.setFitHeight(800);
        imageView4.setFitWidth(1100);
        imageView4.setPreserveRatio(true);
        Label missionsButton=new Label("  Missions");
        missionsButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                missionsButton.setScaleX(1.2);
                missionsButton.setScaleY(1.2);

            }
        });
        missionsButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                missionsButton.setScaleX(1);
                missionsButton.setScaleY(1);
            }
        });
        missionsButton.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent mouseEvent) {
               Controller.missionMenu(imageView1).show();
            }
        });
        missionsButton.setTextFill(Color.WHITE);
        missionsButton.setFont(Font.font("Cambria",50));


        Label trainButton=new Label("  Train");
        trainButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                trainButton.setScaleX(1.2);
                trainButton.setScaleY(1.2);
            }
        });
        trainButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                trainButton.setScaleX(1);
                trainButton.setScaleY(1);
            }
        });
        trainButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                try {
                    Controller.trainMenu(imageView3).show();
                }catch (FileNotFoundException f){
                    f.getStackTrace();
                }
            }
        });
        trainButton.setTextFill(Color.WHITE);
        trainButton.setFont(Font.font("Cambria",50));
        Label organizationButton=new Label("  Organization");
        organizationButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                organizationButton.setScaleX(1.2);
                organizationButton.setScaleY(1.2);
            }
        });
        organizationButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                organizationButton.setScaleX(1);
                organizationButton.setScaleY(1);
            }
        });
        organizationButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Controller.organizationMenu(imageView2).show();
                }catch (FileNotFoundException foundException){
                    foundException.getStackTrace();
                }

            }
        });
        organizationButton.setTextFill(Color.WHITE);
        organizationButton.setFont(Font.font("Cambria",50));
        Label fortifyButton=new Label("  Fortify HQ");
        fortifyButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fortifyButton.setScaleX(1.2);
                fortifyButton.setScaleY(1.2);
            }
        });
        fortifyButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                fortifyButton.setScaleX(1);
                fortifyButton.setScaleY(1);
            }
        });
        fortifyButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
               try {
                   Controller.fortifyMenu(imageView4).show();
               }catch (FileNotFoundException fileNotFoundException){
                   fileNotFoundException.getStackTrace();
               }
            }
        });
        fortifyButton.setTextFill(Color.WHITE);
        fortifyButton.setFont(Font.font("Cambria",50));
        VBox vBox=new VBox(missionsButton,organizationButton,trainButton,fortifyButton);
        Group root = new Group(imageView);
        Scene scene = new Scene(root, 900, 600);
        root.getChildren().addAll(vBox);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if (keyEvent.getCode()== KeyCode.ENTER){
                    stage.close();

                }
            }
        });
        stage.setTitle("Once upon a time in Kamurocho");
        stage.setScene(scene);
        stage.show();
    }
    public static void main() {
        launch();
    }

}

