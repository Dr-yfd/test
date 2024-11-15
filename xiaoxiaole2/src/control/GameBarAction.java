package control;

import util.tool;
import view.gamewindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBarAction implements ActionListener {
    private gamewindow f;
   public GameBarAction(gamewindow f) {
       super();
       this.f = f;
   }
   @Override
    public void actionPerformed(ActionEvent e) {
       String action=e.getActionCommand();
       if(action.equals("start")) {

           tool.ranMap(f.getGamepanel().getRectMap());
           tool.updateMap(f.getGamepanel().getRectMap());

           tool.handMap(f.getGamepanel().getRectMap());

           tool.show(f.getGamepanel().getRectMap());

           f.getItemStart().setEnabled(false);
           f.getItemRe().setEnabled(true);
       }else if(action.equals("restart")) {
           tool.ranMap(f.getGamepanel().getRectMap());
           tool.updateMap(f.getGamepanel().getRectMap());
            tool.handMap(f.getGamepanel().getRectMap());

       }else if(action.equals("exit")) {
           int key= JOptionPane.showConfirmDialog(f,"真的要退出游戏吗","温馨提示",JOptionPane.OK_CANCEL_OPTION);
           if(key==0) {
               System.exit(0);
           }
       }else if(action.equals("about")) {
           JOptionPane.showConfirmDialog(f,"游戏名称：易方达的消消乐\n游戏版本：V0.1\n游戏作者：易方达\n公司：易方达的完美JAVA教室");
       }
   }



}
