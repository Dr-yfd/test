package model;

import util.data;

import java.awt.*;

public class Rect {
    private int x;
    private int y;
    private int value;
    private Image image;
    private int selected;
    private Image oldImage;
    public Rect(){

    }
    public void draw(Graphics g){

        g.drawImage(image,x,y, data.s,data.s,null);
        if(selected == 1){
            g.setColor(Color.yellow);
            g.drawRect(x,y,data.s,data.s);
            g.drawRect(x+1,y+1,data.s-2,data.s-2);
            g.drawRect(x+2,y+2,data.s-4,data.s-4);
        }
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public Image getOldImage() {
        return oldImage;
    }

    public void setOldImage(Image oldImage) {
        this.oldImage = oldImage;
    }
}
