package dynamic_beat_4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class DynamicBeat extends JFrame {
    private Image screenImage;
    private Graphics screenGraghic;
    private Image introBackground = new ImageIcon(Main.class.getResource("../image/title_2.png")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/MenuBar.png")));
    
    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exit2.png"));
    
    private ImageIcon exitButtonBasicImage = new ImageIcon(new ImageIcon(Main.class.getResource("../image/exit1.png"));
    private JButton exitButton = new JButton(exitButtonBasicImage); //기본 이미지입니다.
    
    
    private int mouseX, mouseY;
    
    public DynamicBeat() {
        setTitle("Dynamic Beat");
        setUndecorated(true);
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
        setResizable(false);//사용자가 마음대로 크기를 변경할 수 없습니다.
        setLocationRelativeTo(null); //게임 창이 정 중앙에 뜨게 됩니다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임 창을 종료시에 프로그램 전체가 종료됩니다.
        setBackground(new Color(0, 0, 0, 0)); //배경 흰색으로 바뀝니다.
        setLayout(null);
        setVisible(true);
    
    
        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter(){
            @Override
            public void mouseDragged(MouseEvent e) { //마우스 위치를 반환하는 함수입니다.
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY); //JFrame의 마우스 자체를 변경시켜줍니다.
            }
        });
        add(menuBar);
    
        exitButton.setBounds(1234, 0, 30, 30);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                
            }
        });
        exitButton.setFocusPainted(false);
        add(exitButton);
        
        Music music = new Music("bol4.mp3", true);
        music.start();
    }
    
    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
        screenGraghic = screenImage.getGraphics(); //스크린 이미지로부터 그래픽스를 얻어옵니다.
        screenDraw(screenGraghic);
        g.drawImage(screenImage, 0, 0, null);
    }
    
    private void screenDraw(Graphics g) {
        g.drawImage(introBackground, 0, 0, null);
        paintComponents(g);
        this.repaint();
    }
    
}
