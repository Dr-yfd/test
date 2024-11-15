package view;

import model.Rect;
import util.data;

import javax.swing.*;

public class gamewindow extends JFrame {
    private JMenuBar bar = new JMenuBar();
    private JMenu menuGame= new JMenu("游戏");
    private JMenu menuHelp= new JMenu("帮助");
    private JMenuItem itemStart=new JMenuItem("开始游戏");
    private JMenuItem itemRe =new JMenuItem("重新开始");
    private JMenuItem itemExit=new JMenuItem("退出游戏");
    private JMenuItem itemAbout=new JMenuItem("关于");



    private gamepanel gamepanel=new gamepanel();

    public gamewindow(){
        setTitle("易方达的消消乐");
        setSize(data.w, data.h);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initBar();
        setContentPane(gamepanel);

    }

    public void initBar(){
        itemStart.setActionCommand("start");
        itemRe.setActionCommand("restart");
        itemExit.setActionCommand("exit");
        itemAbout.setActionCommand("about");

        itemStart.addActionListener(menuGame.getAction());
        itemRe.addActionListener(menuGame.getAction());
        itemExit.addActionListener(menuGame.getAction());
        itemAbout.addActionListener(menuGame.getAction());
        itemRe.setEnabled(false);

        menuGame.add(itemStart);
        menuGame.add(itemRe);
        menuGame.add(itemExit);
        menuGame.add(itemAbout);
        bar.add(menuGame);
        bar.add(menuHelp);

        this.setJMenuBar(bar);
    }

    public JMenuBar getBar() {
        return bar;
    }

    public void setBar(JMenuBar bar) {
        this.bar = bar;
    }

    public JMenu getMenuGame() {
        return menuGame;
    }

    public void setMenuGame(JMenu menuGame) {
        this.menuGame = menuGame;
    }

    public JMenu getMenuHelp() {
        return menuHelp;
    }

    public void setMenuHelp(JMenu menuHelp) {
        this.menuHelp = menuHelp;
    }

    public JMenuItem getItemStart() {
        return itemStart;
    }

    public void setItemStart(JMenuItem itemStart) {
        this.itemStart = itemStart;
    }

    public JMenuItem getItemRe() {
        return itemRe;
    }

    public void setItemRe(JMenuItem itemRe) {
        this.itemRe = itemRe;
    }

    public JMenuItem getItemExit() {
        return itemExit;
    }

    public void setItemExit(JMenuItem itemExit) {
        this.itemExit = itemExit;
    }

    public JMenuItem getItemAbout() {
        return itemAbout;
    }

    public void setItemAbout(JMenuItem itemAbout) {
        this.itemAbout = itemAbout;
    }

    public view.gamepanel getGamepanel() {
        return gamepanel;
    }

    public void setGamepanel(view.gamepanel gamepanel) {
        this.gamepanel = gamepanel;
    }

}
