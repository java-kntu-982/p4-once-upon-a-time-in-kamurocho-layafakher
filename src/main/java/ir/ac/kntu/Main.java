package ir.ac.kntu;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import model.*;
import view.View;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main  {
    public static long totalMoney=100;
    public static String []arg;
    public static ArrayList<OurSolider> ourSoliders=new ArrayList<>();
    public static OurSolider ourSolider1=new OurSolider("Sohei",3000,3000,1,1);
    public static OurSolider ourSolider2=new OurSolider("Ryuji",5000,5000,1,2);
    public static OurSolider ourSolider3=new OurSolider("Samaya",5500,3200,3,3);
    public static OurSolider ourSolider4=new OurSolider("Osamu",4000,3000,2,1);
    public static OurSolider ourSolider5=new OurSolider("Goro",4000,4500,3,4);
    public static OurSolider ourSolider6=new OurSolider("Daigo",4000,4000,1,2);
    public static OurSolider ourSolider7=new OurSolider("Taiga",7000,5000,1,1);
    public static OurSolider ourSolider8=new OurSolider("Shintaro",4500,4500,2,1);
    public static OurSolider ourSolider9=new OurSolider("Makoto",4500,1800,2,3);
    public static OurSolider ourSolider10=new OurSolider("Kaoru",4500,4500,2,4);
    public static OurSolider ourSolider11=new OurSolider("Futoshi",4200,4000,2,1);
    public static OurSolider ourSolider12=new OurSolider("Ryo",3600,3800,1,1);
    public static ArrayList<Studding> studdings=new ArrayList<>();
    public static Van van=new Van(6000);
    public static Container container=new Container(3000);
    public static Truck truck=new Truck(5000);



    public static void main(String args[]) {
        arg=args;
        ourSoliders.add(ourSolider1);ourSoliders.add(ourSolider2);ourSoliders.add(ourSolider3);ourSoliders.add(ourSolider4);ourSoliders.add(ourSolider5);ourSoliders.add(ourSolider6);ourSoliders.add(ourSolider7);ourSoliders.add(ourSolider8);ourSoliders.add(ourSolider9);ourSoliders.add(ourSolider10);ourSoliders.add(ourSolider11);ourSoliders.add(ourSolider12);
        studdings.add(van);
        studdings.add(container);
        studdings.add(truck);
        View.main();
    }
    public static void setLabelToOurSolider() throws FileNotFoundException {
        Image image1=new Image(new FileInputStream("./src/main/java/1.PNG"));
        ImageView imageView1 = new ImageView(image1);
        Label soheiName=new Label("Sohei",imageView1);Main.ourSolider1.setLabel(soheiName);
        Image image2=new Image(new FileInputStream("./src/main/java/2.PNG"));
        ImageView imageView2=new ImageView(image2);
        Label ryujiName=new Label("Ryuji",imageView2);Main.ourSolider2.setLabel(ryujiName);
        Image image3=new Image(new FileInputStream("./src/main/java/3.PNG"));
        ImageView imageView3=new ImageView(image3);
        Label samayaName=new Label("Samaya",imageView3);Main.ourSolider3.setLabel(samayaName);
        Image image4=new Image(new FileInputStream("./src/main/java/4.PNG"));
        ImageView imageView4=new ImageView(image4);
        Label osamuName=new Label("Osamu",imageView4);Main.ourSolider4.setLabel(osamuName);
        Image image5=new Image(new FileInputStream("./src/main/java/5.PNG"));
        ImageView imageView5=new ImageView(image5);
        Label goroName=new Label("Goro",imageView5);Main.ourSolider5.setLabel(goroName);
        Image image6=new Image(new FileInputStream("./src/main/java/6.PNG"));
        ImageView imageView6=new ImageView(image6);
        Label daigoName=new Label("Daigo",imageView6);Main.ourSolider6.setLabel(daigoName);
        Image image7=new Image(new FileInputStream("./src/main/java/7.PNG"));
        ImageView imageView7=new ImageView(image7);
        Label taigaName=new Label("Taiga",imageView7);Main.ourSolider7.setLabel(taigaName);
        Image image8=new Image(new FileInputStream("./src/main/java/8.PNG"));
        ImageView imageView8=new ImageView(image8);
        Label shintaroName=new Label("Shintaro",imageView8);Main.ourSolider8.setLabel(shintaroName);
        Image image9=new Image(new FileInputStream("./src/main/java/9.PNG"));
        ImageView imageView9=new ImageView(image9);
        Label makotoName=new Label("Makoto",imageView9);Main.ourSolider9.setLabel(makotoName);
        Image image10=new Image(new FileInputStream("./src/main/java/10.PNG"));
        ImageView imageView10=new ImageView(image10);
        Label kaoruName=new Label("Kaoru",imageView10);Main.ourSolider10.setLabel(kaoruName);
        Image image11=new Image(new FileInputStream("./src/main/java/11.PNG"));
        ImageView imageView11=new ImageView(image11);
        Label futoshiName=new Label("Futoshi",imageView11);Main.ourSolider11.setLabel(futoshiName);
        Image image12=new Image(new FileInputStream("./src/main/java/12.PNG"));
        ImageView imageView12=new ImageView(image12);
        Label ryoName=new Label("Ryo",imageView12);Main.ourSolider12.setLabel(ryoName);
    }
    public static void setLabelToStudding() throws FileNotFoundException{
        Image image1=new Image(new FileInputStream("./src/main/java/container.png"));
        ImageView imageView1=new ImageView(image1);
        Label contLabel=new Label("Container",imageView1);Main.container.setLabel(contLabel);
        Image image2=new Image(new FileInputStream("./src/main/java/truck.png"));
        ImageView imageView2=new ImageView(image2);
        Label truckLabel=new Label("Truck",imageView2);Main.truck.setLabel(truckLabel);
        Image image3=new Image(new FileInputStream("./src/main/java/van.PNG"));
        ImageView imageView3=new ImageView(image3);
        Label vanLabel=new Label("Van",imageView3);Main.van.setLabel(vanLabel);
    }



}
