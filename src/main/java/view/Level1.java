package view;
import ir.ac.kntu.Main;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import model.GraySolider;
import model.OurSolider;
import model.RedSolider;

import java.util.*;

public class Level1 {
    private static ArrayList<RedSolider> redSoliders=new ArrayList<>();
    private static ArrayList<GraySolider> graySoliders=new ArrayList<>();
    private static ArrayList<Circle> redCircles=new ArrayList<>();
    private static ArrayList<Circle> ourCircles=new ArrayList<>();
    private static Group root;
    private static Map<Circle,OurSolider> circleOurSoliderMap=new HashMap<>();
    private static Map<Circle,RedSolider> circleRedSoliderHashMap=new HashMap<>();
    private static Scene scene;
    private static boolean isWin;
    public static boolean isWin() {
        return isWin;
    }
    public static Stage startLevel1(ImageView imageViewContainer, ImageView imageViewTruck,ImageView backGround){
        Stage stage=new Stage();
        root=new Group(backGround);


        for (int i=0;i<60;i++){
            RedSolider redSolider=new RedSolider(1000,500,1);
            redSoliders.add(redSolider);
        }
        for (int i=0;i<120;i++){
            GraySolider graySolider=new GraySolider(1000,800,1);
            graySoliders.add(graySolider);
        }
        Circle circle1=new Circle(50,Color.WHITE);
        circle1.setCenterX(400);circle1.setCenterY(400);
        round1();
        circle1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
            }
        });
        imageViewContainer.setTranslateX(970);
        imageViewContainer.setTranslateY(140);
        imageViewTruck.setTranslateX(965);
        imageViewTruck.setTranslateY(370);
        scene=new Scene(root,1100,700);
        Circle circle = new Circle(100, Color.rgb(128, 50, 110, 0.9));
        Rectangle rectangle = new Rectangle(40, 40, Color.web("0x01abff"));
        circle.setCenterX(200);
        circle.setCenterY(200);
        rectangle.setX(400);
        rectangle.setY(400);
        circle.addEventHandler(MouseEvent.MOUSE_EXITED, e -> {
            double dx = e.getX() - circle.getCenterX();
            double dy = e.getY() - circle.getCenterY();
            circle.setCenterX(circle.getCenterX() + dx);
            circle.setCenterY(circle.getCenterY() + dy);
        });

        scene.addEventHandler(MouseEvent.MOUSE_MOVED, e -> {
            rectangle.setX(e.getX() - 20);
            rectangle.setY(e.getY() - 20);
        });
        scene.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
            if (e.isAltDown()) {
                e.consume();
            }
        });
        Timer timer = new Timer();
        root.getChildren().addAll(imageViewContainer,imageViewTruck);
        stage.setScene(scene);
        return stage;
    }
    public static void round1(){
        int y=100;
        for (OurSolider ourSolider: Main.ourSoliders){
            if (ourSolider.isEnabled()){
                Circle circle=new Circle();
                circle.setFill(Color.CYAN);
                circle.setCenterY(y);
                circle.setCenterX(850);
                circle.setRadius(10);
                ourCircles.add(circle);
                ourSolider.setCircle(circle);
                circleOurSoliderMap.put(circle,ourSolider);
                y+=50;
            }
        }
        y=50;
        for (int i=0;i<20;i++){
            for (RedSolider redSolider:redSoliders){
                Circle circle=new Circle();
                circle.setFill(Color.RED);
                circle.setCenterY(y);
                circle.setCenterX(50);
                circle.setRadius(8);
                redCircles.add(circle);
                redSoliders.get(i).setCircle(circle);
                circleRedSoliderHashMap.put(circle,redSolider);
                y+=30;
            }
        }
        final int[] i = {0};
        final int[] n = {0};
        AnimationTimer animationTimer;
        animationTimer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                int z=0;
                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        if (keyEvent.getCode()== KeyCode.DOWN) {
                            ourCircles.get(ourCircles.size()-1).setFill(Color.CYAN);
                            for (int m=0;m<n[0];m++){
                                ourCircles.get(m).setFill(Color.CYAN);
                            }
                            ourCircles.get(n[0]).setFill(Color.PINK);
                            scene.setOnMouseClicked(e -> {
                                for (Circle circle:ourCircles){
                                    if (ourCircles.get(ourCircles.size()-1).getFill().equals(Color.PINK)){
                                        ourCircles.get(ourCircles.size()-1).setCenterX(e.getX());
                                        ourCircles.get(ourCircles.size()-1).setCenterY(e.getY());

                                    }
                                    if (circle.getFill().equals(Color.PINK)){
                                        circle.setCenterX(e.getX());
                                        circle.setCenterY(e.getY());
                                    }
                                }
                            });
                            if (n[0]==ourCircles.size()-1){

                               n[0]=-1;
                            }
                            n[0]++;
                        }
                        }
                });

                for (Circle circle:redCircles){
                    for (Circle circle1:ourCircles) {
                        if (circle.getCenterX() < circle1.getCenterX() - circleOurSoliderMap.get(circle1).getFieldOfView() * 10) {
                            circle.setCenterX(circle.getCenterX() + redSoliders.get(0).getXSpeed() * 0.05);
                        } else {
                            if (circle1.getCenterY() < 650) {
                                circle1.setCenterX(circle.getCenterX());
                                circle1.setCenterY(circle1.getCenterY() + circleOurSoliderMap.get(circle1).getYSpeed() * 0.0005);}
                            else {
                                circle1.setCenterY(0);
                            }
                                circleOurSoliderMap.get(circle1).setHealth(circleOurSoliderMap.get(circle1).getHealth() - (0.005 ));
                                circleRedSoliderHashMap.get(circle).setHealth(circleRedSoliderHashMap.get(circle).getHealth() - (0.05 * circleOurSoliderMap.get(circle1).getAttack()));
                                if (circleRedSoliderHashMap.get(circle).getHealth()<=0) {
                                    circleRedSoliderHashMap.get(circle).setAlive(false);
                                    root.getChildren().remove(circle);
                                }
                                if (circleOurSoliderMap.get(circle1).getHealth()<=0){
                                    circleOurSoliderMap.get(circle1).setAlive(false);
                                    root.getChildren().remove(circle1);
                                }
                        }
                    }
                }


            }
        };
        animationTimer.start();
        root.getChildren().addAll(redCircles);
        root.getChildren().addAll(ourCircles);
    }
    public static void round2(){
        int y=100;
        for (OurSolider ourSolider: Main.ourSoliders){
            if (ourSolider.isEnabled()){
                Circle circle=new Circle();
                circle.setFill(Color.CYAN);
                circle.setCenterY(y);
                circle.setCenterX(850);
                circle.setRadius(10);
                ourCircles.add(circle);
                ourSolider.setCircle(circle);
                circleOurSoliderMap.put(circle,ourSolider);
                y+=50;
            }
        }
        y=50;
        for (int i=0;i<20;i++){
            for (RedSolider redSolider:redSoliders){
                Circle circle=new Circle();
                circle.setFill(Color.RED);
                circle.setCenterY(y);
                circle.setCenterX(50);
                circle.setRadius(8);
                redCircles.add(circle);
                redSoliders.get(i).setCircle(circle);
                circleRedSoliderHashMap.put(circle,redSolider);
                y+=30;
            }
        }
        final int[] i = {0};
        final int[] n = {0};
        AnimationTimer animationTimer;
        animationTimer=new AnimationTimer() {
            @Override
            public void handle(long l) {
                int z=0;
                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                    @Override
                    public void handle(KeyEvent keyEvent) {
                        if (keyEvent.getCode()== KeyCode.DOWN) {
                            ourCircles.get(ourCircles.size()-1).setFill(Color.CYAN);
                            for (int m=0;m<n[0];m++){
                                ourCircles.get(m).setFill(Color.CYAN);
                            }
                            ourCircles.get(n[0]).setFill(Color.PINK);
                            scene.setOnMouseClicked(e -> {
                                for (Circle circle:ourCircles){
                                    if (ourCircles.get(ourCircles.size()-1).getFill().equals(Color.PINK)){
                                        ourCircles.get(ourCircles.size()-1).setCenterX(e.getX());
                                        ourCircles.get(ourCircles.size()-1).setCenterY(e.getY());

                                    }
                                    if (circle.getFill().equals(Color.PINK)){
                                        circle.setCenterX(e.getX());
                                        circle.setCenterY(e.getY());
                                    }
                                }
                            });
                            if (n[0]==ourCircles.size()-1){

                                n[0]=-1;
                            }
                            n[0]++;
                        }
                    }
                });
                for (RedSolider redSolider:circleRedSoliderHashMap.values()){
                    if (redSolider.isAlive()){
                        for (Circle circle:redCircles){
                            for (Circle circle1:ourCircles) {
                                if (circle.getCenterX() < circle1.getCenterX() - circleOurSoliderMap.get(circle1).getFieldOfView() * 10) {
                                    circle.setCenterX(circle.getCenterX() + redSoliders.get(0).getXSpeed() * 0.05);
                                } else {
                                    if (circle1.getCenterY() < 680) {
                                        circle1.setCenterX(circle.getCenterX());
                                        circle1.setCenterY(circle1.getCenterY() + circleOurSoliderMap.get(circle1).getYSpeed() * 0.0005);}
                                    else {
                                        circle1.setCenterY(0);
                                    }
                                    circleOurSoliderMap.get(circle1).setHealth(circleOurSoliderMap.get(circle1).getHealth() - (0.005 ));
                                    circleRedSoliderHashMap.get(circle).setHealth(circleRedSoliderHashMap.get(circle).getHealth() - (0.05 * circleOurSoliderMap.get(circle1).getAttack()));
                                    if (circleRedSoliderHashMap.get(circle).getHealth()<=0) {
                                        circleRedSoliderHashMap.get(circle).setAlive(false);
                                        root.getChildren().remove(circle);
                                    }
                                    if (circle.getCenterX()>970){
                                        if (circle.getCenterY()>140&&circle.getCenterY()<350){

                                        }
                                    }
                                    if (circleOurSoliderMap.get(circle1).getHealth()<=0){
                                        circleOurSoliderMap.get(circle1).setAlive(false);
                                        root.getChildren().remove(circle1);
                                    }
                                }
                            }
                        }
                    }
                    else {
                        isWin=true;
                    }
                }



            }
        };
        animationTimer.start();
        root.getChildren().addAll(redCircles);
        root.getChildren().addAll(ourCircles);

    }



}
