package util;

import model.Rect;

import java.awt.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;


public class tool {

    public static void show(Rect[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                System.out.print(map[i][j].getValue()+"\t");
            }
            System.out.println();
        }
    }




    public static void ranMap(Rect[][] map){
        Image[]images={data.img1,data.img2,data.img3,data.img4};
        Random ran =new Random();
        for(int i = 0; i< map.length; i++){
            for(int j = 0; j< map[i].length; j++){
                map[i][j]=new Rect();
                int index=ran.nextInt(images.length);
                map[i][j].setImage(images[index]);
                map[i][j].setValue(index+1);

            }
        }
    }

    public static void updateMap(Rect[][] rects){
        for(int i=0;i<rects.length;i++){
            for(int j=0;j<rects[i].length;j++){
                rects[i][j].setX(data.START_X+data.s*j);
                rects[i][j].setY(data.START_Y+data.s*i);
            }
        }
    }

    public static void handMap(Rect[][] map){
            while(true){
                if(checkThree(map)){
                    resetRect(map);
                }else{
                    break;
                }
            }
    }

    public static boolean checkThree(Rect[][] map){
        for(int i=0;i<map.length;i++){
            int count=1;
            for(int j=1;j<map[i].length;j++){
                if(map[i][j].getValue()>0&&map[i][j].getValue()==map[i][j-1].getValue()){
                    count++;
                    if(count==3){
                        return true;
                    }
                }
            }
        }

        for(int j=0;j<map.length;j++){
            int count=1;
            for(int i=1;i<map.length;i++){
                if(map[i][j].getValue()>0&&map[i][j].getValue()==map[i-1][j].getValue()){
                    count++;
                    if(count==3){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void resetRect(Rect[][] map){
        Image[]images={data.img1,data.img2,data.img3,data.img4};
        Random ran =new Random();
        for(int i=0;i<map.length;i++){
            int count=1;
            for(int j=1;j<map[i].length;j++){
                if(map[i][j].getValue()>0&&map[i][j].getValue()==map[i][j-1].getValue()){
                    count++;
                    if(count==3){
                        int index=ran.nextInt(images.length);
                        map[i][j].setImage(images[index]);
                        map[i][j].setValue(index+1);
                        count=1;
                    }
                }
            }
        }

        for(int j=0;j<map.length;j++){
            int count=1;
            for(int i=1;i<map.length;i++){
                if(map[i][j].getValue()>0&&map[i][j].getValue()==map[i-1][j].getValue()){
                    count++;
                    if(count==3){
                        int index=ran.nextInt(images.length);
                        map[i][j].setImage(images[index]);
                        map[i][j].setValue(index+1);
                        count=1;
                    }
                }
            }
        }
    }



    public static Rect checkClick(int mx,int my,Rect[][] map){
        for(int i=0;i<map.length;i++){
            for(int j=0;j<map[i].length;j++){
                Rect r=map[i][j];
                if(r!=null&&r.getValue()>0&&mx>r.getX()&&my>r.getY()&&mx<r.getX()+data.s&&my<r.getY()+data.s){
                    return r;
                }
            }
        }

        return null;
    }

    public static int checkNear(Rect r1,Rect r2){
        if(r1.getY()==r2.getY()&&(r1.getX()==r2.getX()+data.s||r1.getX()==r2.getX()-data.s)){
            return 1;
        }

        if(r1.getX()==r2.getX()&&(r1.getY()==r2.getY()+data.s||r1.getY()==r2.getY()-data.s)){
            return 2;
        }
        return 0;
    }

    public static void findCleanRect(Rect[][]map,List<Rect>list){
        List<Rect> tempList=new ArrayList<>();
        for(int i=0;i<map.length;i++){
            tempList.clear();
            tempList.add(map[i][0]);
            for(int j=1;j<map[i].length;j++){
                if(map[i][j].getValue()>0&&map[i][j].getValue()==map[i][j-1].getValue()){
                    tempList.add(map[i][j]);
                    if(j==map[i].length-1){
                        if(tempList.size()>=3){
                            list.addAll(tempList);
                        }
                    }
                }else{
                    if(tempList.size()>=3){
                        list.addAll(tempList);
                    }
                        tempList.clear();
                        tempList.add(map[i][j]);
                    }
                }
            }

        for(int j = 0; j <map[0].length; j++){
            tempList.clear();
            tempList.add(map[0][j]);
            for(int i = 1; i <map.length; i++){
                if(map[i][j].getValue()>0&&map[i][j].getValue()==map[i-1][j].getValue()){
                    tempList.add(map[i][j]);
                    if(i==map[i].length-1){
                        if(tempList.size()>=3){
                            list.addAll(tempList);
                        }
                    }
                }else{
                    if(tempList.size()>=3){
                        list.addAll(tempList);
                    }
                    tempList.clear();
                    tempList.add(map[i][j]);
                }
            }
        }

        if(list.size()>0){
            HashSet<Rect> set = new HashSet<>(list);
            list.clear();
            list.addAll(set);
        }


    }




}
