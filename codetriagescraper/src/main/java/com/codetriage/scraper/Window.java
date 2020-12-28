package com.codetriage.scraper;

import javax.swing.*;
import java.awt.*;


public class Window {

    private String search;
    private JButton click;
    private JTextField t;
    private JButton b;


    public Window(int width, int height, String title) {
        search = null;

        JFrame frame = new JFrame(title);

        frame.setSize(width, height);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);


        t = new JTextField("Enter Search Query");
        b = new JButton("enter");

        t.setBounds(width/4, height/4, 150, 20);
        frame.add(t);
        t.setVisible(true);


        b.setBounds(width/4, height/4 + 20, 150, 20);
        frame.add(b);
        b.setVisible(true);

        frame.setVisible(true);



    }

    public void setSearch(String x)
    {
        search = x;
    }

    public String getSearch()
    {
        return search;
    }



}
