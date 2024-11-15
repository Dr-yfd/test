package control;

import model.Rect;
import util.data;
import util.tool;
import view.gamewindow;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class GameListener extends MouseAdapter {

    private gamewindow win;

    public GameListener(gamewindow win) {
        this.win = win;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(data.animate==1){

            return;

        }
        List<Rect> List=win.getGamepanel().getSelectedList();

        Rect rect=tool.checkClick(e.getX(),e.getY(),win.getGamepanel().getRectMap());
        if(rect!=null){
            rect.setSelected(1);
            List.add(rect);
            if(List.size()==2){
                if(List.get(0)!=List.get(1)){
                    int num=tool.checkNear(List.get(0),List.get(1));

                    if(num==1){
                        new HoriMoveThread(win).start();
                    }else if(num==2){
                        new VertiMoveThread(win).start();
                    }else{
                        System.out.println("不相邻");
                        Rect r=List.remove(0);
                        r.setSelected(0);

                    }
                }else{
                    rect.setSelected(0);
                    List.clear();
                }



            }
        }

    }
}
