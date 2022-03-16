import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.InputEvent;

public class Execute {
    static public boolean toggleClicker;
    static public boolean endClicker = true;
    public static void main(String args[]){
        JFrame mainFrame = new JFrame("My Autoclicker");
        JPanel mainPanel = new JPanel(new FlowLayout());
        mainFrame.getContentPane().add(mainPanel);
        mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        mainFrame.setSize(300,200);
        mainFrame.setVisible(true);
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new KeyHandler());
        while (endClicker){
            try{
                Robot clicker = new Robot();
                int button = InputEvent.BUTTON1_DOWN_MASK;
                while(toggleClicker){
                    clicker.mousePress(button);
                    Thread.sleep(1);
                    clicker.mouseRelease(button);
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
