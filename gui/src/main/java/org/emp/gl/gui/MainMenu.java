package org.emp.gl.gui;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MainMenu {

    JFrame frame = new JFrame("Maze");

    public MainMenu(){

        BoxLayout boxLayout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);

        Button play = new Button("Play");
        play.setFont(new Font("Verdana", Font.BOLD, 32));

        frame.add(play);


        frame.setLayout(boxLayout);
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        play.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                frame.dispose();
                new MazeFrame(10);
            }
        });


    }
}