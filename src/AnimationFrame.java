import javax.swing.*;

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
