package control;

import model.Rect;
import util.data;
import util.tool;

import java.awt.*;

public class RectMoveThread extends Thread {
    private Rect r1;
    private Rect r2;
    public int dire;

    public RectMoveThread(Rect r1, Rect r2, int dire) {
        this.r1 = r1;
        this.r2 = r2;
        this.dire = dire;
    }

    @Override
    public void run() {
        data.animate=1;
        if(dire == 1){
            int target1 = r2.getX();
            int target2 = r1.getX();
            while (true) {
                if(r1.getX()==target1) {
                    System.out.println("水平移动回去完毕") ;
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
                    data.animate=0;
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






        }else{
            int target1=r2.getY();
            int target2=r1.getY();
            while (true) {
                if(r1.getY()==target1) {
                    System.out.println("垂直移动回去完毕") ;
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

                    data.animate=0;
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
}


