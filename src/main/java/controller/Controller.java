package controller;

import ir.ac.kntu.Main;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.OurSolider;
import model.Studding;
import view.Level1;
import view.Level2;
import view.View;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Controller {
    public static Stage runLevel1() throws FileNotFoundException {
        Stage stage=new Stage();
        Image backGround=new Image(new FileInputStream("./src/main/java/khak.jpg"));
        ImageView khak=new ImageView(backGround);
        khak.setX(0);khak.setY(0);
        khak.setFitHeight(700);
        khak.setFitWidth(1100);
        Image image=new Image(new FileInputStream("./src/main/java/mnm3.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(600);
        imageView.setFitWidth(900);
        imageView.setPreserveRatio(true);
        Main.setLabelToOurSolider();
        Image containerImage=new Image(new FileInputStream("./src/main/java/container.png"));
        ImageView imageViewContainer=new ImageView(containerImage);
        Image truckImage=new Image(new FileInputStream("./src/main/java/truck.png"));
        ImageView imageViewTruck=new ImageView(truckImage);
        ArrayList<Label> labels=new ArrayList<>();
        labels.add(Main.ourSolider1.getLabel());labels.add(Main.ourSolider2.getLabel());labels.add(Main.ourSolider3.getLabel());labels.add(Main.ourSolider4.getLabel());labels.add(Main.ourSolider5.getLabel());labels.add(Main.ourSolider6.getLabel());labels.add(Main.ourSolider7.getLabel());labels.add(Main.ourSolider8.getLabel());labels.add(Main.ourSolider9.getLabel());labels.add(Main.ourSolider10.getLabel());labels.add(Main.ourSolider11.getLabel());labels.add(Main.ourSolider12.getLabel());
        VBox vBox=new VBox(Main.ourSolider1.getLabel(),Main.ourSolider2.getLabel(),Main.ourSolider3.getLabel(),Main.ourSolider4.getLabel(),Main.ourSolider5.getLabel(),Main.ourSolider6.getLabel());
        vBox.setSpacing(10);
        HBox hBox =new HBox(Main.ourSolider7.getLabel(),Main.ourSolider8.getLabel(),Main.ourSolider9.getLabel(),Main.ourSolider10.getLabel(),Main.ourSolider11.getLabel(),Main.ourSolider12.getLabel());
        hBox.setTranslateY(510);
        Label label1=new Label("These are your team members ");
        label1.setTranslateX(320);label1.setTextFill(Color.WHITE);label1.setFont(Font.font("Cambria",20));
        Label label2=new Label("Click to start!");
        label2.setTranslateX(320);label2.setFont(Font.font("Cambria",50));label2.setTextFill(Color.WHITE);label2.setTranslateY(15);
        label2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label2.setScaleY(1.2);
                label2.setScaleX(1.2);
            }
        });
        label2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label2.setScaleY(1);
                label2.setScaleX(1);
            }
        });
        label2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Level1.startLevel1(imageViewContainer,imageViewTruck,khak).show();
            }
        });
        for (Label label:labels){
            for (OurSolider ourSolider:Main.ourSoliders){
                if (label.getText().equals(ourSolider.getName())&& ourSolider.isEnabled()) {

                    label.setTextFill(Color.WHITE);
                    label.setOnMouseEntered(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            label.setScaleY(1.2);
                            label.setScaleX(1.2);
                        }
                    });
                    label.setOnMouseExited(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            label.setScaleY(1);
                            label.setScaleX(1);
                        }
                    });
                }
            }
        }
        Group group=new Group(imageView);
        group.getChildren().addAll(vBox,hBox,label1,label2);
        Scene scene=new Scene(group,900,600,Color.BLACK);
        stage.setScene(scene);
        return stage;
    }
    public static Stage runLevel2() throws FileNotFoundException {
        Stage stage=new Stage();
        Image backGround=new Image(new FileInputStream("./src/main/java/khak.jpg"));
        ImageView khak=new ImageView(backGround);
        khak.setX(0);khak.setY(0);
        khak.setFitHeight(700);
        khak.setFitWidth(1100);
        Image image=new Image(new FileInputStream("./src/main/java/mnm3.jpg"));
        ImageView imageView = new ImageView(image);
        imageView.setX(0);
        imageView.setY(0);
        imageView.setFitHeight(600);
        imageView.setFitWidth(900);
        imageView.setPreserveRatio(true);
        Main.setLabelToOurSolider();
        Image containerImage=new Image(new FileInputStream("./src/main/java/container.png"));
        ImageView imageViewContainer=new ImageView(containerImage);
        Image vanImage=new Image(new FileInputStream("./src/main/java/van.PNG"));
        ImageView imageViewVan=new ImageView(vanImage);
        ArrayList<Label> labels=new ArrayList<>();
        labels.add(Main.ourSolider1.getLabel());labels.add(Main.ourSolider2.getLabel());labels.add(Main.ourSolider3.getLabel());labels.add(Main.ourSolider4.getLabel());labels.add(Main.ourSolider5.getLabel());labels.add(Main.ourSolider6.getLabel());labels.add(Main.ourSolider7.getLabel());labels.add(Main.ourSolider8.getLabel());labels.add(Main.ourSolider9.getLabel());labels.add(Main.ourSolider10.getLabel());labels.add(Main.ourSolider11.getLabel());labels.add(Main.ourSolider12.getLabel());
        VBox vBox=new VBox(Main.ourSolider1.getLabel(),Main.ourSolider2.getLabel(),Main.ourSolider3.getLabel(),Main.ourSolider4.getLabel(),Main.ourSolider5.getLabel(),Main.ourSolider6.getLabel());
        vBox.setSpacing(10);
        HBox hBox =new HBox(Main.ourSolider7.getLabel(),Main.ourSolider8.getLabel(),Main.ourSolider9.getLabel(),Main.ourSolider10.getLabel(),Main.ourSolider11.getLabel(),Main.ourSolider12.getLabel());
        hBox.setTranslateY(510);
        Label label1=new Label("These are your team members ");
        label1.setTranslateX(320);label1.setTextFill(Color.WHITE);label1.setFont(Font.font("Cambria",20));
        Label label2=new Label("Click to start!");
        label2.setTranslateX(320);label2.setFont(Font.font("Cambria",50));label2.setTextFill(Color.WHITE);label2.setTranslateY(15);
        label2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label2.setScaleY(1.2);
                label2.setScaleX(1.2);
            }
        });
        label2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label2.setScaleY(1);
                label2.setScaleX(1);
            }
        });
        label2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Level2.startLevel2(imageViewContainer,imageViewVan,khak).show();
            }
        });
        for (Label label:labels){
            for (OurSolider ourSolider:Main.ourSoliders){
                if (label.getText().equals(ourSolider.getName())&& ourSolider.isEnabled()) {
            label.setTextFill(Color.WHITE);
            label.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    label.setScaleY(1.2);
                    label.setScaleX(1.2);
                }
            });
            label.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    label.setScaleY(1);
                    label.setScaleX(1);
                }
            });


        }
            }
        }
        Group group=new Group(imageView);
        group.getChildren().addAll(vBox,hBox,label1,label2);
        Scene scene=new Scene(group,900,600,Color.BLACK);
        stage.setScene(scene);
        return stage;
    }
    public static Stage missionMenu(ImageView imageView1){
        Group root1=new Group(imageView1);
        Stage stage=new Stage();
        Label level1=new Label("\t\t\t\tLevel 1");
        level1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                level1.setScaleX(1.2);
                level1.setScaleY(1.2);
            }
        });

        level1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                level1.setScaleX(1);
                level1.setScaleY(1);
            }
        });
        level1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Controller.runLevel1().show();
                }catch (FileNotFoundException e){
                    e.getStackTrace();
                }
            }
        });

        level1.setTextFill(Color.BLACK);
        level1.setFont(Font.font("Cambria",50));
        Label level2=new Label("\t\t\t\tLevel 2");
        level2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                level2.setScaleX(1.2);
                level2.setScaleY(1.2);
            }
        });
        level2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                level2.setScaleX(1);
                level2.setScaleY(1);
            }
        });
        level2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    Controller.runLevel2().show();
                }catch (FileNotFoundException e){
                    e.getStackTrace();
                }
            }
        });
        level2.setTextFill(Color.BLACK);
        level2.setFont(Font.font("Cambria",50));
        VBox vBox=new VBox(level1,level2);
        root1.getChildren().addAll(vBox);
        Scene scene1=new Scene(root1,900,600);
        stage.setScene(scene1);
        return stage;
    }
    public static Stage organizationMenu(ImageView imageView2) throws FileNotFoundException{
        Group root=new Group(imageView2);
        Stage stage=new Stage();
        Main.setLabelToOurSolider();
        ArrayList<Label> labels=new ArrayList<>();
        labels.add(Main.ourSolider1.getLabel());labels.add(Main.ourSolider2.getLabel());labels.add(Main.ourSolider3.getLabel());labels.add(Main.ourSolider4.getLabel());labels.add(Main.ourSolider5.getLabel());labels.add(Main.ourSolider6.getLabel());labels.add(Main.ourSolider7.getLabel());labels.add(Main.ourSolider8.getLabel());labels.add(Main.ourSolider9.getLabel());labels.add(Main.ourSolider10.getLabel());labels.add(Main.ourSolider11.getLabel());labels.add(Main.ourSolider12.getLabel());
        HBox hBox=new HBox(Main.ourSolider1.getLabel(),Main.ourSolider2.getLabel(),Main.ourSolider3.getLabel(),Main.ourSolider4.getLabel(),Main.ourSolider5.getLabel(),Main.ourSolider6.getLabel());
        HBox hBox1=new HBox(Main.ourSolider7.getLabel(),Main.ourSolider8.getLabel(),Main.ourSolider9.getLabel(),Main.ourSolider10.getLabel(),Main.ourSolider11.getLabel(),Main.ourSolider12.getLabel());
        hBox.setTranslateY(400);
        hBox1.setTranslateY(500);
        for (Label label:labels){
            label.setTextFill(Color.WHITE);
            label.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    label.setScaleY(1.2);
                    label.setScaleX(1.2);
                }
            });
            label.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    label.setScaleY(1);
                    label.setScaleX(1);
                }
            });
            label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for (OurSolider ourSolider: Main.ourSoliders){
                        if (label.getText().equals(ourSolider.getName())){
                            ourSolider.setEnabled(true);
                            label.setTextFill(Color.GREENYELLOW);
                        }
                    }
                }
            });
            label.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for (OurSolider ourSolider: Main.ourSoliders){
                        if (label.getText().equals(ourSolider.getName())){
                            ourSolider.setEnabled(false);
                            label.setTextFill(Color.WHITE);
                        }
                    }
                }
            });
        }
        Label label1=new Label("Choose the team member then ");
        label1.setTranslateX(320);label1.setTextFill(Color.CYAN);label1.setFont(Font.font("Cambria",20));label1.setTranslateY(20);
        Label label2=new Label("Click!");
        label2.setTranslateX(380);label2.setFont(Font.font("Cambria",50));label2.setTextFill(Color.WHITE);label2.setTranslateY(35);
        label2.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label2.setScaleY(1.2);
                label2.setScaleX(1.2);
            }
        });
        label2.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                label2.setScaleY(1);
                label2.setScaleX(1);
            }
        });
        label2.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                stage.close();
            }
        });
        root.getChildren().addAll(hBox,hBox1,label1,label2);
        Scene scene=new Scene(root,900,600);
        stage.setScene(scene);
        return stage;
    }
    public static Stage trainMenu(ImageView imageView3) throws FileNotFoundException{
        Group root=new Group(imageView3);
        Stage stage=new Stage();
        Main.setLabelToOurSolider();
        HBox hBox =new HBox(Main.ourSolider1.getLabel(),Main.ourSolider2.getLabel(),Main.ourSolider3.getLabel(),Main.ourSolider4.getLabel(),Main.ourSolider5.getLabel(),Main.ourSolider6.getLabel());
        HBox hBox1 =new HBox(Main.ourSolider7.getLabel(),Main.ourSolider8.getLabel(),Main.ourSolider9.getLabel(),Main.ourSolider10.getLabel(),Main.ourSolider11.getLabel(),Main.ourSolider12.getLabel());
        hBox1.setTranslateY(100);
        hBox.setSpacing(25);
        hBox1.setSpacing(25);
        ArrayList<Label> labels=new ArrayList<>();
        Text inf=new Text();
        Text news=new Text();
        Text upgrade=new Text();
        root.getChildren().addAll(inf,news,upgrade);
        labels.add(Main.ourSolider1.getLabel());labels.add(Main.ourSolider2.getLabel());labels.add(Main.ourSolider3.getLabel());labels.add(Main.ourSolider4.getLabel());labels.add(Main.ourSolider5.getLabel());labels.add(Main.ourSolider6.getLabel());labels.add(Main.ourSolider7.getLabel());labels.add(Main.ourSolider8.getLabel());labels.add(Main.ourSolider9.getLabel());labels.add(Main.ourSolider10.getLabel());labels.add(Main.ourSolider11.getLabel());labels.add(Main.ourSolider12.getLabel());
        for (Label label:labels){
            label.setTextFill(Color.WHITE);
            label.setFont(Font.font("Cambria",15));
            label.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    label.setScaleX(1.2);
                    label.setScaleY(1.2);
                }
            });
            label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for (OurSolider ourSolider:Main.ourSoliders){
                        if (label.getText().equals(ourSolider.getName())) {
                            inf.setText(ourSolider.getName()+"  Level : "+ourSolider.getLevel()+"   Health : "+ourSolider.getHealth()+"   Attack : "+ourSolider.getAttack());
                            inf.setTranslateY(400);
                            inf.setFont(Font.font("Cambria",30));
                            inf.setFill(Color.WHITE);
                            news.setText("You need "+10*ourSolider.getLevel()+"$ to level up And you have "+Main.totalMoney+"$");
                            news.setTranslateY(430);
                            news.setFont(Font.font("Cambria",22));
                            news.setFill(Color.WHITE);
                            upgrade.setText("Level Up!");
                            upgrade.setTranslateY(480);
                            upgrade.setTranslateX(100);
                            upgrade.setFont(Font.font("Cambria",30));
                            upgrade.setFill(Color.CYAN);
                            upgrade.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    upgrade.setScaleX(1.2);
                                    upgrade.setScaleY(1.2);

                                }
                            });
                            upgrade.setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    upgrade.setScaleX(1);
                                    upgrade.setScaleY(1);
                                }
                            });
                            upgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (Main.totalMoney>=10*ourSolider.getLevel()){
                                        Main.totalMoney-=10*ourSolider.getLevel();
                                        ourSolider.setLevel(ourSolider.getLevel()+1);
                                        ourSolider.setAttack(ourSolider.getAttack()*0.04+ourSolider.getAttack());
                                        ourSolider.setHealth(ourSolider.getHealth()*0.04+ourSolider.getHealth());
                                        inf.setText(ourSolider.getName()+"  Level : "+ourSolider.getLevel()+"   Health : "+ourSolider.getHealth()+"   Attack : "+ourSolider.getAttack());
                                        news.setText("You need "+10*ourSolider.getLevel()+"$ to level up And you have "+Main.totalMoney+"$");
                                    }
                                }
                            });

                        }
                    }
                }
            });
            label.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    label.setScaleX(1);
                    label.setScaleY(1);
                }
            });
        }
        Scene scene=new Scene(root,900,600);
        root.getChildren().addAll(hBox,hBox1);
        stage.setScene(scene);
        return stage;
    }
    public static Stage fortifyMenu(ImageView imageView4) throws FileNotFoundException{
        Group root=new Group(imageView4);
        Stage stage=new Stage();
        Main.setLabelToStudding();
        HBox hBox=new HBox(Main.container.getLabel(),Main.truck.getLabel(),Main.van.getLabel());
        hBox.setTranslateX(50);
        hBox.setTranslateY(30);
        hBox.setSpacing(100);
        root.getChildren().addAll(hBox);
        ArrayList<Label> studding=new ArrayList<>();
        Text inf=new Text();
        Text news=new Text();
        Text upgrade=new Text();
        root.getChildren().addAll(inf,news,upgrade);
        studding.add(Main.container.getLabel());studding.add(Main.truck.getLabel());studding.add(Main.van.getLabel());
        for (Label label:studding){
            label.setTextFill(Color.WHITE);
            label.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    label.setScaleX(1.2);
                    label.setScaleY(1.2);
                }
            });
            label.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    label.setScaleX(1);
                    label.setScaleY(1);
                }
            });
            label.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for (Studding studding1:Main.studdings){
                        if (label.getText().equals(studding1.getLabel().getText())){
                            inf.setText(" Level : "+studding1.getLevel()+" Durability : "+studding1.getDurability());
                            inf.setTranslateY(220);
                            inf.setFont(Font.font("Cambria",28));
                            inf.setFill(Color.DEEPPINK);
                            news.setText(" You have : "+100*studding1.getLevel()+"$  Needed : "+Main.totalMoney+"$");
                            news.setTranslateY(255);
                            news.setFont(Font.font("Cambria",22));
                            news.setFill(Color.LIGHTPINK);
                            upgrade.setText("Level Up!");
                            upgrade.setTranslateY(320);
                            upgrade.setTranslateX(50);
                            upgrade.setFont(Font.font("Cambria",40));
                            upgrade.setFill(Color.LIGHTSTEELBLUE);
                            upgrade.setOnMouseEntered(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    upgrade.setScaleX(1.2);
                                    upgrade.setScaleY(1.2);
                                }
                            });
                            upgrade.setOnMouseExited(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    upgrade.setScaleX(1);
                                    upgrade.setScaleY(1);
                                }
                            });
                            upgrade.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent mouseEvent) {
                                    if (Main.totalMoney>=100*studding1.getLevel()){
                                        Main.totalMoney-=100*studding1.getLevel();
                                        studding1.setLevel(studding1.getLevel()+1);
                                        studding1.setDurability(0.1*studding1.getDurability()+studding1.getDurability());
                                        inf.setText(" Level : "+studding1.getLevel()+" Durability : "+studding1.getDurability());
                                        news.setText(" You have : "+100*studding1.getLevel()+"$  Needed : "+Main.totalMoney+"$");
                                    }
                                }
                            });

                        }
                    }
                }
            });
        }
        Scene scene=new Scene(root,900,600);
        stage.setScene(scene);
        return stage;

    }
}


