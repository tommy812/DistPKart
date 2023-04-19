import javax.swing.*;
///////////////////////////////////////////
//
//  Sid: 1955004
//
///////////////////////////////////////////
public class AnimationFrame extends JFrame {
    public AnimationFrame(){
        setTitle("Racing Karts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400,400);
        //pack();
        setLocationRelativeTo(null);
        AnimationPanel animation = new AnimationPanel();
        animation.startAnimation();
        add(animation);
    }
}
