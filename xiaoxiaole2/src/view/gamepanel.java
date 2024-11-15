package view;

import model.Rect;
import util.data;

import javax.swing.*;

import java.awt.*;
import java.util.ArrayList;

import java.util.List;

public class gamepanel extends JPanel {



    private  Rect[][] rectMap= new Rect[data.l][data.l];

    private List<Rect> selectedList= new ArrayList<>();

    private List<Rect> cleanList= new ArrayList<>();

    public gamepanel(){


    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);



        g.drawImage(data.imgbg,0,0,data.w,data.h,this);

        for(int i=0;i<rectMap.length;i++){
            for(int j=0;j<rectMap[i].length;j++){
                if(rectMap[i][j]!=null){
                    rectMap[i][j].draw(g);
                }
            }
        }




        g.setColor(Color.WHITE);
        for(int i=0;i<= data.l;i++){
            g.drawLine(data.START_X,data.START_Y+data.s*i,data.START_X+data.l*data.s,data.START_Y+data.s*i);
            g.drawLine(data.START_X+data.s*i,data.START_Y,data.START_X+data.s*i,data.START_Y+data.l*data.s);

        }


        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        repaint();
    }

    public Rect[][] getRectMap() {
        return rectMap;
    }

    public void setRectMap(Rect[][] rectMap) {
        this.rectMap = rectMap;
    }

    public List<Rect> getSelectedList() {
        return selectedList;
    }

    public void setSelectedList(List<Rect> selectedList) {
        this.selectedList = selectedList;
    }

    public List<Rect> getCleanList() {
        return cleanList;
    }

    public void setCleanList(List<Rect> cleanList) {
        this.cleanList = cleanList;
    }
}
