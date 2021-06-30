package dynamic_beat_10;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) { //키보드 누를때

        if (DynamicBeat.game == null) {
            return; //밑의 버튼 누르는 작업을 거치지 않도록 합니다.
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            DynamicBeat.game.pressS();

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            DynamicBeat.game.pressD();

        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            DynamicBeat.game.pressF();

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            DynamicBeat.game.pressSpace();

        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            DynamicBeat.game.pressJ();

        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            DynamicBeat.game.pressK();

        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            DynamicBeat.game.pressL();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) { //키보드 뗄때

        if (DynamicBeat.game == null) {
            return; //밑의 버튼 누르는 작업을 거치지 않도록 합니다.
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            DynamicBeat.game.releaseS();

        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            DynamicBeat.game.releaseD();

        } else if (e.getKeyCode() == KeyEvent.VK_F) {
            DynamicBeat.game.releaseF();

        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            DynamicBeat.game.releaseSpace();

        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            DynamicBeat.game.releaseJ();

        } else if (e.getKeyCode() == KeyEvent.VK_K) {
            DynamicBeat.game.releaseK();

        } else if (e.getKeyCode() == KeyEvent.VK_L) {
            DynamicBeat.game.releaseL();

        }

    }
}
