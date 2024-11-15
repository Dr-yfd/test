package control;

import model.Rect;
import util.data;
import util.tool;
import view.gamewindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoriMoveThread extends Thread {

    private gamewindow win;

    public HoriMoveThread(gamewindow win) {
        this.win = win;
    }

    public void run() {
        Rect[][]map=win.getGamepanel().getRectMap();
        List<Rect>list=new ArrayList<>();

        data.animate=1;

        Rect r1=win.getGamepanel().getSelectedList().get(0);
        Rect r2=win.getGamepanel().getSelectedList().get(1);

        int target1=r2.getX();
        int target2=r1.getX();

        System.out.println(r1.getX()+"------"+target1);

        while (true) {
            if(r1.getX()==target1) {
                System.out.println("水平移动完毕") ;
                r1.setSelected(0);
                r2.setSelected(0);

                r1.setX(target2);
                r2.setX(target1);
                int value1 =r1.getValue();
                Image img1=r1.getImage();
                r1.setValue(r2.getValue());
                r1.setImage(r2.getImage());
                r2.setValue(value1);
                r2.setImage(img1);
                win.getGamepanel().getSelectedList().clear();
                tool.show(win.getGamepanel().getRectMap());

                tool.findCleanRect(map,list);
                System.out.println("可消除元素的个数"+list.size());
                if(list.size()==0) {
                    System.out.println("没有能消除……移动回去");
                    new RectMoveThread(r1,r2,1).start();
                }else{
                    new CleanEffectThead(win).start();
                }

                break;
            }
            if(r1.getX() < target1) {
                r1.setX(r1.getX()+2);
                r2.setX(r2.getX()-2);
            }
                else if(r1.getX()>target1){
                r1.setX(r1.getX()-2);
                r2.setX(r2.getX()+2);
            }

            if(r1.getX()>r2.getX()){

            }
            if(r1.getX()<r2.getX()){

            }

            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }

}
