package view;
import ir.ac.kntu.Main;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.EnemySolider;
import model.GraySolider;
import model.OurSolider;
import model.RedSolider;
import java.util.*;

public class Level1 {
    private static ArrayList<EnemySolider> enemySoliders=new ArrayList<>();
    private static ArrayList<Circle> enemyCircles=new ArrayList<>();
    private static ArrayList<Circle> ourCircles=new ArrayList<>();
    private static Group root;
    private static Map<Circle,OurSolider> circleOurSoliderMap=new HashMap<>();
    private static Map<Circle,EnemySolider> circleRedSoliderHashMap=new HashMap<>();
    private static Scene scene;
    private static boolean isWin;
    public static void setIsWin(boolean isWin) {
        Level1.isWin = isWin;
    }
    public static boolean isWin() {
        return isWin;
    }
    public static Stage startLevel1(ImageView imageViewContainer, ImageView imageViewTruck,ImageView backGround){
        Stage stage=new Stage();
        root=new Group(backGround);
        for (int i=0;i<100;i++){
            RedSolider redSolider=new RedSolider(1000,500,1);
            redSolider.setAlive(true);
            enemySoliders.add(redSolider);
        }
        for (int i=100;i<180;i++){
            GraySolider graySolider=new GraySolider(1000,800,1);
            graySolider.setAlive(true);
            enemySoliders.add(graySolider);
        }
        EnemySolider bossLevel1=new EnemySolider(8000,5000,1);
        bossLevel1.setAlive(true);
        enemySoliders.add(bossLevel1);
        Circle circle1=new Circle(50,Color.WHITE);
        circle1.setCenterX(400);circle1.setCenterY(400);
        round1();
        boolean b=false;
        for (EnemySolider enemySolider:circleRedSoliderHashMap.values()){
          if (enemySolider.isAlive())
              b=true;
        }
        if (b){
            System.out.println("You Wine!");
            setIsWin(true);
        }
        imageViewContainer.setTranslateX(970);
        imageViewContainer.setTranslateY(140);
        imageViewTruck.setTranslateX(965);
        imageViewTruck.setTranslateY(370);
        scene=new Scene(root,1100,700);
        root.getChildren().addAll(imageViewContainer,imageViewTruck);
        stage.setScene(scene);
        return stage;
    }
    public static boolean round1(){
        int y=80;
        for (OurSolider ourSolider: Main.ourSoliders){
            if (ourSolider.isEnabled()){
                Circle circle=new Circle();
                circle.setFill(Color.CYAN);
                circle.setCenterY(y);
                circle.setCenterX(870);
                circle.setRadius(10);
                ourCircles.add(circle);
                ourSolider.setCircle(circle);
                circleOurSoliderMap.put(circle,ourSolider);
                y+=50;
            }
        }
        y=50;
        for (int i=0;i<25;i++){
                Circle circle=new Circle();
                circle.setFill(Color.RED);
                circle.setCenterY(y);
                circle.setCenterX(500);
                circle.setRadius(8);
                enemyCircles.add(circle);
                enemySoliders.get(i).setCircle(circle);
                circleRedSoliderHashMap.put(circle,enemySoliders.get(i));
                y+=30;
        }
        y=50;
        for (int i=25;i<50;i++){
                Circle circle=new Circle();
                circle.setFill(Color.RED);
                circle.setCenterY(y);
                circle.setCenterX(430);
                circle.setRadius(7);
                enemyCircles.add(circle);
                enemySoliders.get(i).setCircle(circle);
                circleRedSoliderHashMap.put(circle,enemySoliders.get(i));
                y+=30;

        }
        y=50;
        for (int i=50;i<75;i++){
            Circle circle=new Circle();
            circle.setFill(Color.RED);
            circle.setCenterY(y);
            circle.setCenterX(360);
            circle.setRadius(7);
            enemyCircles.add(circle);
            enemySoliders.get(i).setCircle(circle);
            circleRedSoliderHashMap.put(circle,enemySoliders.get(i));
            y+=30;
        }
        y=50;
        for (int i=75;i<100;i++){
            Circle circle=new Circle();
            circle.setFill(Color.RED);
            circle.setCenterY(y);
            circle.setCenterX(290);
            circle.setRadius(8);
            enemyCircles.add(circle);
            enemySoliders.get(i).setCircle(circle);
            circleRedSoliderHashMap.put(circle,enemySoliders.get(i));
            y+=30;
        }
        y=50;
        for (int i=100;i<125;i++){
            Circle circle=new Circle();
            circle.setFill(Color.GRAY);
            circle.setCenterY(y);
            circle.setCenterX(220);
            circle.setRadius(8);
            enemyCircles.add(circle);
            enemySoliders.get(i).setCircle(circle);
            circleRedSoliderHashMap.put(circle,enemySoliders.get(i));
            y+=30;
        }
        for (int i=125;i<150;i++){
            Circle circle=new Circle();
            circle.setFill(Color.GRAY);
            circle.setCenterY(y);
            circle.setCenterX(150);
            circle.setRadius(7);
            enemyCircles.add(circle);
            enemySoliders.get(i).setCircle(circle);
            circleRedSoliderHashMap.put(circle,enemySoliders.get(i));
            y+=30;
        }
        for (int i=150;i<180;i++){
            Circle circle=new Circle();
            circle.setFill(Color.GRAY);
            circle.setCenterY(y);
            circle.setCenterX(80);
            circle.setRadius(8);
            enemyCircles.add(circle);
            enemySoliders.get(i).setCircle(circle);
            circleRedSoliderHashMap.put(circle,enemySoliders.get(i));
            y+=30;
        }
        y=350;
        Circle circle=new Circle();
        circle.setFill(Color.GRAY);
        circle.setCenterY(y);
        circle.setCenterX(50);
        circle.setRadius(20);
        enemyCircles.add(circle);
        enemySoliders.get(180).setCircle(circle);
        circleRedSoliderHashMap.put(circle,enemySoliders.get(180));
        final int[] n = {0};
        AnimationTimer animationTimer;
        animationTimer=new AnimationTimer() {
            @Override
            public void handle(long l) {
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
                for (Circle circle:enemyCircles){
                    for (Circle circle1:ourCircles) {
                        if (circle.getCenterX() < circle1.getCenterX() - circleOurSoliderMap.get(circle1).getFieldOfView() * 10) {
                            circle.setCenterX(circle.getCenterX() + enemySoliders.get(0).getXSpeed() * 0.05);
                        } else {
                            if (circle1.getCenterY() < 650) {
                                circle1.setCenterX(circle.getCenterX()-0.0001);
                                circle1.setCenterY(circle1.getCenterY() + circleOurSoliderMap.get(circle1).getYSpeed() * 0.000005);}
                            else {
                                circle1.setCenterY(0);
                            }
                                circleOurSoliderMap.get(circle1).setHealth(circleOurSoliderMap.get(circle1).getHealth() - (0.005 ));
                                circleRedSoliderHashMap.get(circle).setHealth(circleRedSoliderHashMap.get(circle).getHealth() - (0.005 * circleOurSoliderMap.get(circle1).getAttack()));
                                if (circleRedSoliderHashMap.get(circle).getHealth()<=0) {
                                    circleRedSoliderHashMap.get(circle).setAlive(false);
                                    root.getChildren().remove(circle);
                                }

                                if (circleOurSoliderMap.get(circle1).getHealth()<=0){

                                    circleOurSoliderMap.get(circle1).setAlive(false);
                                    root.getChildren().remove(circle1);
                                }
                                if (circle.getCenterX()>970){
                                if (circle.getCenterY()>140 && circle.getCenterY()<350){
                                    Main.container.setDurability(Main.container.getDurability()-0.1*circleRedSoliderHashMap.get(circle).getAttack());
                                }
                                if (circle.getCenterY()>370 && circle.getCenterY()<550){
                                    Main.truck.setDurability(Main.truck.getDurability()-0.1*circleRedSoliderHashMap.get(circle).getAttack());
                                }
                            }
                        }
                    }
                }
            }
        };
        animationTimer.start();
        root.getChildren().addAll(enemyCircles);
        root.getChildren().addAll(ourCircles);
        return isWin;
    }
//    public static void round2(){
//        int y=100;
//        for (OurSolider ourSolider: Main.ourSoliders){
//            if (ourSolider.isEnabled()){
//                Circle circle=new Circle();
//                circle.setFill(Color.CYAN);
//                circle.setCenterY(y);
//                circle.setCenterX(850);
//                circle.setRadius(10);
//                ourCircles.add(circle);
//                ourSolider.setCircle(circle);
//                circleOurSoliderMap.put(circle,ourSolider);
//                y+=50;
//            }
//        }
//        y=50;
//        for (int i=0;i<20;i++){
//            for (RedSolider redSolider:redSoliders){
//                Circle circle=new Circle();
//                circle.setFill(Color.RED);
//                circle.setCenterY(y);
//                circle.setCenterX(50);
//                circle.setRadius(8);
//                redCircles.add(circle);
//                redSoliders.get(i).setCircle(circle);
//                circleRedSoliderHashMap.put(circle,redSolider);
//                y+=30;
//            }
//        }
//        final int[] i = {0};
//        final int[] n = {0};
//        AnimationTimer animationTimer;
//        animationTimer=new AnimationTimer() {
//            @Override
//            public void handle(long l) {
//                int z=0;
//                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//                    @Override
//                    public void handle(KeyEvent keyEvent) {
//                        if (keyEvent.getCode()== KeyCode.DOWN) {
//                            ourCircles.get(ourCircles.size()-1).setFill(Color.CYAN);
//                            for (int m=0;m<n[0];m++){
//                                ourCircles.get(m).setFill(Color.CYAN);
//                            }
//                            ourCircles.get(n[0]).setFill(Color.PINK);
//                            scene.setOnMouseClicked(e -> {
//                                for (Circle circle:ourCircles){
//                                    if (ourCircles.get(ourCircles.size()-1).getFill().equals(Color.PINK)){
//                                        ourCircles.get(ourCircles.size()-1).setCenterX(e.getX());
//                                        ourCircles.get(ourCircles.size()-1).setCenterY(e.getY());
//                                    }
//                                    if (circle.getFill().equals(Color.PINK)){
//                                        circle.setCenterX(e.getX());
//                                        circle.setCenterY(e.getY());
//                                    }
//                                }
//                            });
//                            if (n[0]==ourCircles.size()-1){
//
//                                n[0]=-1;
//                            }
//                            n[0]++;
//                        }
//                    }
//                });
//
//
//
//
//                    for (Circle circle:redCircles){
//                        for (Circle circle1:ourCircles) {
//                            if (circle.getCenterX() < circle1.getCenterX() - circleOurSoliderMap.get(circle1).getFieldOfView() * 10) {
//                                circle.setCenterX(circle.getCenterX() + redSoliders.get(0).getXSpeed() * 0.05);
//                            } else {
//                                if (circle1.getCenterY() < 680) {
//                                    circle1.setCenterX(circle.getCenterX());
//                                    circle1.setCenterY(circle1.getCenterY() + 0);}
//                                else {
//                                    circle1.setCenterY(0);
//                                }
//                                circleOurSoliderMap.get(circle1).setHealth(circleOurSoliderMap.get(circle1).getHealth() - (0.005 ));
//                                circleRedSoliderHashMap.get(circle).setHealth(circleRedSoliderHashMap.get(circle).getHealth() - (0.05 * circleOurSoliderMap.get(circle1).getAttack()));
//                                if (circleRedSoliderHashMap.get(circle).getHealth()<=0) {
//                                    circleRedSoliderHashMap.get(circle).setAlive(false);
//                                    root.getChildren().remove(circle);
//                                }
//                                if (circle.getCenterX()>970){
//                                    if (circle.getCenterY()>140 && circle.getCenterY()<350){
//                                        Main.container.setDurability(Main.container.getDurability()-0.1*circleRedSoliderHashMap.get(circle).getAttack());
//                                    }
//                                    if (circle.getCenterY()>370 && circle.getCenterY()<550){
//                                        Main.truck.setDurability(Main.truck.getDurability()-0.1*circleRedSoliderHashMap.get(circle).getAttack());
//                                    }
//                                }
//                                if (circleOurSoliderMap.get(circle1).getHealth()<=0){
//                                    circleOurSoliderMap.get(circle1).setAlive(false);
//                                    root.getChildren().remove(circle1);
//                                }
//                            }
//                        }
//                    }
//                }
//
//        };
//        animationTimer.start();
//        root.getChildren().addAll(redCircles);
//        root.getChildren().addAll(ourCircles);
//    }



}
