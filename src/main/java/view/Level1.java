package view;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.GraySolider;
import model.RedSolider;

import java.util.ArrayList;
import java.util.Timer;

public class Level1 {
    private static boolean isWin;
    public static boolean isWin() {
        return isWin;
    }

    public static Stage startLevel1(ImageView imageViewContainer, ImageView imageViewTruck,ImageView backGround){
        Stage stage=new Stage();
        Group root=new Group(backGround);
        ArrayList<RedSolider> redSoliders=new ArrayList<>();
        ArrayList<GraySolider> graySoliders=new ArrayList<>();
        for (int i=0;i<60;i++){
            RedSolider redSolider=new RedSolider(1000,500,1);
            redSoliders.add(redSolider);
        }
        for (int i=0;i<120;i++){
            GraySolider graySolider=new GraySolider(1000,800,1);
            graySoliders.add(graySolider);
        }
        ArrayList<Circle> redCircles=new ArrayList<>();
        Circle circle1=new Circle(50,Color.WHITE);
        circle1.setCenterX(400);circle1.setCenterY(400);
        root.getChildren().addAll(circle1);
//        Rectangle ground=new Rectangle(1095,695);
//        ground.setStroke(Color.BLACK);
//        ground.setFill(Color.KHAKI);
//        ground.setStrokeWidth(15);
        imageViewContainer.setTranslateX(970);
        imageViewContainer.setTranslateY(140);
        imageViewTruck.setTranslateX(965);
        imageViewTruck.setTranslateY(370);
        Scene scene=new Scene(root,1100,700,Color.KHAKI);
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
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                rectangle.setRotate(rectangle.getRotate() + 5);
            }
        }.start();
        Timer timer = new Timer();
        root.getChildren().addAll(imageViewContainer,imageViewTruck,circle, rectangle);
        stage.setScene(scene);
        return stage;
    }
}
