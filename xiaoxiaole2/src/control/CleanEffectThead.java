package control;

import model.Rect;
import util.data;
import view.gamewindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CleanEffectThead extends Thread{
    private gamewindow win;

    public CleanEffectThead(gamewindow win) {
        this.win = win;
    }

    @Override
    public void run() {
        data.animate=1;
        List<Rect> list = win.getGamepanel().getCleanList();
        for(int a=0;a<10;a++) {
            for (int i = 0; i < list.size(); i++) {
                Rect r = list.get(i);
                r.setOldImage(r.getImage());
                r.setImage(null);
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < list.size(); i++) {
                Rect r = list.get(i);
                r.setImage(r.getOldImage());
            }
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
            for(int i=0;i<list.size();i++) {
                list.get(i).setImage(null);
                list.get(i).setValue(0);
            }
        list.clear();
        data.animate=0;


    }
}

