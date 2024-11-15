package control;

import model.Rect;
import util.data;
import util.tool;
import view.gamewindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class VertiMoveThread extends Thread {
    public gamewindow win;
    public VertiMoveThread(gamewindow win) {
        this.win = win;
    }
    @Override
    public void run() {
        Rect[][]map=win.getGamepanel().getRectMap();
        List<Rect> list=new ArrayList<>();
        data.animate=1;
        Rect r1=win.getGamepanel().getSelectedList().get(0);
        Rect r2=win.getGamepanel().getSelectedList().get(1);
        int target1=r2.getY();
        int target2=r1.getY();

        while (true) {
            if(r1.getY()==target1) {
                System.out.println("垂直移动完毕") ;
                r1.setSelected(0);
                r2.setSelected(0);

                r1.setY(target2);
                r2.setY(target1);
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
                    new RectMoveThread(r1,r2,2).start();
                }else{
                    new CleanEffectThead(win).start();
                }
                break;
            }
            if(r1.getY() < target1) {
                r1.setY(r1.getY()+2);
                r2.setY(r2.getY()-2);
            }
            else if(r1.getY()>target1){
                r1.setY(r1.getY()-2);
                r2.setY(r2.getY()+2);
            }

            if(r1.getY()>r2.getY()){

            }
            if(r1.getY()<r2.getY()){

            }

            try{
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}

