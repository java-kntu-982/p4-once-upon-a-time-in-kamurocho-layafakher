package view;
import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import java.util.Timer;

public class Level2 {
    private static boolean isWin;

    public static boolean isWin() {
        return isWin;
    }
    public static Stage startLevel2(ImageView imageViewContainer,ImageView imageViewVan,ImageView backGround){
        Stage stage=new Stage();
        Group root=new Group(backGround);
        imageViewContainer.setTranslateX(970);
        imageViewContainer.setTranslateY(140);
        imageViewVan.setTranslateX(965);
        imageViewVan.setTranslateY(370);
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
        root.getChildren().addAll(imageViewContainer,imageViewVan,rectangle,circle);
        stage.setScene(scene);
        return stage;
    }

}
