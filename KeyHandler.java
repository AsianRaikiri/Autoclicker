import com.github.kwhat.jnativehook.NativeInputEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;


public class KeyHandler implements NativeKeyListener{
    @Override
    public void nativeKeyPressed(NativeKeyEvent e){
        NativeKeyListener.super.nativeKeyTyped(e);
        if(e.getKeyCode() == NativeKeyEvent.VC_SPACE){
            Execute.toggleClicker = !Execute.toggleClicker;
        }
        if(e.getKeyCode() == NativeKeyEvent.VC_PERIOD){
            Execute.endClicker = false;
        }
    }

}