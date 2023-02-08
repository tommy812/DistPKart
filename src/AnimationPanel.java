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
    protected ImageIcon imagesR[];// array containing the images
    protected ImageIcon imagesB[];// array containing the images
    private final int TOT_IMAGES = 16;
    private int currentImage = 0;//img index
    private final int ANIMATION_DELAY = 100; // ms delay
    private final int WIDTH = 50;
    private final int HEIGHT = 50;
    private Timer animationTimer;

    public AnimationPanel(){
        imagesR = new ImageIcon[TOT_IMAGES];
        //imagesB = new ImageIcon[TOT_IMAGES];

        //loading all 32 Images
        // In two different arrays, one for each Kart colour
        for(int i=0;i<imagesR.length;i++){
            imagesR[i] = new ImageIcon(getClass().getResource("Karts/KartRed/"+RED_KART+i+".png"));
            //imagesB[i] = new ImageIcon(getClass().getResource("Karts/"+BLUE_KART +i+".png"));
        }//For loop
    }//AnimationPanel

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        imagesR[currentImage].paintIcon(this,g,0,0);

        if(animationTimer.isRunning()){
            currentImage = (currentImage+1) % TOT_IMAGES;
        }//if statement
    }//PaintComponent()
    public void startAnimation(){
        if (animationTimer == null){
            currentImage =0;//display image0
            animationTimer = new Timer(ANIMATION_DELAY, new TimeHandler());//implementing ActionListener in the Animation class did nt work
            animationTimer.start();
        }else {
            if(! animationTimer.isRunning())
                animationTimer.restart();
        }
    }//startAnimation

    private class TimeHandler implements ActionListener {
        public void actionPerformed(ActionEvent actionEvent) {
            repaint();
        }//ActionPerformed()
    }



}//AnimationPanel
