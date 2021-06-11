package org.emp.gl.gui;


import org.emp.gl.timer.service.TimerChangeListener;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import javax.swing.*;

public class Player extends JPanel implements TimerChangeListener {
    private int money=0;
    private int xPos=0;
    private int yPos=0;
    String direction="";
    private final Board board;
    public Player(Board board){
        this.board = board;
        xPos = 1;
        yPos = 1;
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {

            switch (direction){
                case "left":{
                    moveLeft(board); break;
                }
                case "right":{
                    moveRight(board);break;
                }
                case "up":{
                    moveUp(board);break;
                }
                case "down":{
                    moveDown(board);break;
                }
            }
    }

String prec = "";
    public class MyKeyListener extends KeyAdapter{
        public void keyPressed(KeyEvent e){

            if(e.getKeyChar() == 'a' && !prec.equals("right") ) {
                moveLeft(board);
                prec="left";
            }
            if(e.getKeyChar() == 'w'&& !prec.equals("down") ) {
                moveUp(board);
                prec="up";
            }
            if(e.getKeyChar() == 'd'&& !prec.equals("left") ){
                moveRight(board);
                prec="right";
            }
            if(e.getKeyChar() == 's'&& !prec.equals("up") )	{
                moveDown(board);
                prec="down";
            }

        }
    }
   public void moveLeft(Board board){
        if((board.get(xPos-1, yPos) != '#') && (board.get(xPos-1, yPos) != '=')){
            board.set(xPos, yPos, 'O');
            if(board.get(xPos-=1, yPos) == '8')	Win();
            else 	board.set(xPos, yPos, 'X');
        }
        repaint();
    }
    public void moveRight(Board board){
        if((board.get(xPos+1, yPos) != '#') && (board.get(xPos+1, yPos) != '=')){
            board.set(xPos, yPos, 'O');
            if(board.get(xPos+=1, yPos) == '8')	Win();
            else	board.set(xPos, yPos, 'X');
        }
    }
    public void moveUp(Board board){
        if((board.get(xPos, yPos-1) != '#') && (board.get(xPos, yPos-1) != '=')){
            board.set(xPos, yPos, 'O');
            if(board.get(xPos, yPos-=1) == '8')	Win();
            else	board.set(xPos, yPos, 'X');
        }
    }
    public void moveDown(Board board){
        if((board.get(xPos, yPos+1) != '#') && (board.get(xPos, yPos+1) != '=')){
            board.set(xPos, yPos, 'O');
            if(board.get(xPos, yPos+=1) == '8') Win();
            else	board.set(xPos, yPos, 'X');
        }
        repaint();
    }
    public void Win(){
        new MazeFrame(20, money);
    }

    public int getxPos(){
        return this.xPos;
    }
    public int getyPos(){
        return this.yPos;
    }
}	