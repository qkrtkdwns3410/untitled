package dynamic_beat_2;

import javax.swing.*;
import java.awt.*;

public class DynamicBeat extends JFrame {
    private Image screenImage;
    private Graphics screenGraghic;
    private Image introBackground;
    
    
    public DynamicBeat() {
        setTitle("Dynamic Beat");
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
        setResizable(false);//사용자가 마음대로 크기를 변경할 수 없습니다.
        setLocationRelativeTo(null); //게임 창이 정 중앙에 뜨게 됩니다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임 창을 종료시에 프로그램 전체가 종료됩니다.
        setVisible(true);
    
    
        introBackground = new ImageIcon(Main.class.getResource("../image/title_2.png")).getImage();
    }
    
    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
        screenGraghic = screenImage.getGraphics(); //스크린 이미지로부터 그래픽스를 얻어옵니다.
        screenDraw(screenGraghic);
        g.drawImage(screenImage, 0, 0, null);
    }
    
    private void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        this.repaint();
    }
    
}
