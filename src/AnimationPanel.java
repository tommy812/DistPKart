///////////////////////////////////////////
//
//  Sid: 1955004
//
///////////////////////////////////////////

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.sql.Time;
import javax.swing.*;

//Class Reference from Deitel & Deitel ‘Java:How To Program’
public class AnimationPanel extends JPanel{
    private final static String RED_KART = "KartRed"; //standard name of the images Red kart
    private final static String BLUE_KART = "KartBlue"; //standard name of the images Blue kart
    protected ImageIcon images[];// array containing the images of Red Karts
    private final int TOT_IMAGES = 16;
    private int currentImg = 0;//img index
    private final int ANIMATION_DELAY = 100; // ms delay
    private Timer animationTimer;//Swing timer

    public AnimationPanel(){
        images = new ImageIcon[TOT_IMAGES];

        //loading all 16 Images in an array
        for(int i=0;i<images.length;i++){
            images[i] = new ImageIcon(getClass().getResource("Karts/KartRed/"+RED_KART+i+".png"));
        }//For loop
    }//AnimationPanel

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        images[currentImg].paintIcon(this,g,0,0);

        if(animationTimer.isRunning()){
            currentImg = (currentImg+1) % TOT_IMAGES;
        }//if statement
    }//PaintComponent()


    public void startAnimation(){
        if (animationTimer == null){
            currentImg =0;//display image0
            animationTimer = new Timer(ANIMATION_DELAY, new TimeHandler());//implementing ActionListener in the Animation class did nt work
            animationTimer.start();
        }else {
            if(! animationTimer.isRunning())
                animationTimer.restart();
        }//ifStatement
    }//startAnimation

    private class TimeHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            repaint();
        }//ActionPerformed()
    }
}//AnimationPanel
