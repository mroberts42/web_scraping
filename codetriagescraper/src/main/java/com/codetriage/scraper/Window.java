package com.codetriage.scraper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window {
    //elements needing to be returned
    private String search;
    private boolean toConsole;

    //Elements for window
    private int height, width;
    private JFrame frame;


    //Frame 1 elements
    private JTextField t;
    private JButton b;
    private JLabel l;

    //Frame 2 elements

    private JButton b1;
    private JButton b2;
    private JLabel la;



    public Window(int w, int h, String title) {

        height = h;
        width = w;
        search = null;

        frame = new JFrame(title);

        frame.setSize(width, height);
        frame.setLayout(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        l = new JLabel("Enter Search Query for Craigslist Albuquerque");
        t = new JTextField();
        b = new JButton("search");


        //Alignment for Label is good enough for now 12/29
        l.setBounds(0, height/4 - 60, width, 20);
        frame.add(l);
        l.setVisible(true);

        t.setBounds(width / 4, height / 4, 150, 20);
        frame.add(t);
        t.setVisible(true);


        b.setBounds(width / 4, height / 4 + 20, 150, 20);
        frame.add(b);
        b.addActionListener(new Action());
        b.setVisible(true);

        frame.setVisible(true);

    }
    //After inputting search query first method to update the JFrame with new options
    private void update1()
    {
        //frame.removeAll() does not work
        frame.remove(b);
        frame.remove(t);
/*
        la = new JLabel("How do you want your results?");
        b1 = new JButton("In a File");
        b2 = new JButton("Printed to the Console");

        la.setBounds(0, height/4 - 60, width, 20);
        frame.add(la);
        la.setVisible(true);

        b1.setBounds(width / 4, height / 4 + 20, 150, 20);
        frame.add(b1);
        b1.addActionListener(new Action());
        b1.setVisible(true);

        b2.setBounds(width / 4, height / 4, 150, 20);
        frame.add(b2);
        b2.addActionListener(new Action());
        b2.setVisible(true);
*/
        frame.repaint();


    }
    public void setSearch(String x) {
        search = x;
    }

    public synchronized String getSearch() {
        return search;
    }
    public void setToConsole(boolean x)
    {
        toConsole = x;
    }
    public boolean getToConsole()
    {
        return toConsole;
    }

    public class Action implements ActionListener
    {

        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == b)
            {
                try
                {
                    setSearch(t.getText());
                    l.setText("Thank You! Check Console for Results");
                    update1();
                    //System.out.println(getSearch());
                }
                catch(Exception ex)
                {
                   ex.printStackTrace();
                }
            }
            /*
            else if(e.getSource() == b1)
            {
                System.out.println("Print to File");
                setToConsole(false);}
            else if(e.getSource() == b2) {
                System.out.println("Print to Console");
                setToConsole(true);
            }
             */

        }
    }


}

