package model;
import javafx.scene.control.Label;


public class Person {
    private String name;
    private double Health;
    private double attack;
    private Integer attackRange;
    private double x;
    private double y;
    private double XSpeed;
    private double YSpeed;
    private boolean isAlive;


    public Person(String name) {
        this.name = name;
    }

    public Person(String name, double health, double attack, Integer attackRange) {
        this.name = name;
        Health = health;
        this.attack = attack;
        this.attackRange = attackRange;
    }

    public Person() {
    }

    public Person(double health, double attack, Integer attackRange) {
        Health = health;
        this.attack = attack;
        this.attackRange = attackRange;
    }


    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHealth() {
        return Health;
    }

    public void setHealth(double health) {
        Health = health;
    }

    public double getAttack() {
        return attack;
    }

    public void setAttack(double attack) {
        this.attack = attack;
    }

    public Integer getAttackRange() {
        return attackRange;
    }

    public void setAttackRange(Integer attackRange) {
        this.attackRange = attackRange;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getXSpeed() {
        return XSpeed;
    }

    public void setXSpeed(double XSpeed) {
        this.XSpeed = XSpeed;
    }

    public double getYSpeed() {
        return YSpeed;
    }

    public void setYSpeed(double YSpeed) {
        this.YSpeed = YSpeed;
    }
}
