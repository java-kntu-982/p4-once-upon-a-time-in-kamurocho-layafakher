package model;

import javafx.scene.control.Label;

public class OurSolider extends Person{
    private int level=1;
    private boolean isEnabled;
    private Label label;

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }

    public Label getLabel() {
        return label;
    }

    public void setLabel(Label label) {
        this.label = label;
    }

    public OurSolider(String name, double health, double attack, Integer attackRange, Integer fieldOfView) {
        super(name, health, attack, attackRange);
        this.fieldOfView = fieldOfView;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Integer getFieldOfView() {
        return fieldOfView;
    }

    public void setFieldOfView(Integer fieldOfView) {
        this.fieldOfView = fieldOfView;
    }

    public OurSolider(String name) {
        super(name);
    }

    private Integer fieldOfView;

}