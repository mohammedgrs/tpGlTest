package org.emp.gl.gui;
import org.emp.gl.lookup.Lookup;
import org.emp.gl.timer.service.TimerService;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class MazeFrame{

    static JFrame frame = new JFrame("Maze");
    JPanel p = new JPanel(new BorderLayout());
    JPanel p2 = new JPanel(new BorderLayout());
    String prec = "";
    public MazeFrame(int level){

        final Board test = Lookup.getInstance().getService(Board.class);
        final Player player = Lookup.getInstance().getService(Player.class);
        TimerService ts = Lookup.getInstance().getService(TimerService.class);

        p.add(test, BorderLayout.CENTER);
        p.setFocusable(true);
        frame.add(p, BorderLayout.CENTER);
        frame.add(p2, BorderLayout.SOUTH);
       p.addKeyListener(new KeyAdapter()
        {
            public void keyPressed(KeyEvent e){
                int keyCode = e.getKeyCode();
                if((e.getKeyChar() == 'a' || keyCode == KeyEvent.VK_LEFT)&& !player.direction.equals("right")) {
                    //player.moveLeft(test);
                    player.direction="left";
                }
                if((e.getKeyChar() == 'd' || keyCode == KeyEvent.VK_RIGHT)&& !player.direction.equals("left")){
                    //player.moveRight(test);
                    player.direction="right";
                }
                if((e.getKeyChar() == 'w' || keyCode == KeyEvent.VK_UP )&& !player.direction.equals("down")){
                    //player.moveUp(test);
                    player.direction="up";
                }
                if((e.getKeyChar() == 's' || keyCode == KeyEvent.VK_DOWN)&& !player.direction.equals("up")) {
                    //player.moveDown(test);
                    player.direction="down";
                }
            }
        });
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setBackground(Color.green);
        frame.setVisible(true);
    }
    public MazeFrame(int level, int money){
        frame.dispose();
        JFrame frame2 = new JFrame();
        frame2.setBackground(Color.green);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(500,500);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }

}