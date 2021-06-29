package dynamic_beat_7;

import javax.swing.*;
import javax.swing.text.TabableView;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {
    private Image screenImage;
    private Graphics screenGraghic;

    private ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exit2.png")); //메뉴화면 종료버튼
    private ImageIcon exitButtonBasicImage      = new ImageIcon(Main.class.getResource("../image/exit.png"));
    private ImageIcon startButtonBasicImage        = new ImageIcon(Main.class.getResource("../image/start_button_resize.png")); //시작버튼(베이직)
    private ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/start_button_entered.png")); //시작버튼(호버)
    private ImageIcon quitButtonBasicImage      = new ImageIcon(Main.class.getResource("../image/quit_button_resize.png")); //종료버튼
    private ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/quit_button_entered.png")); //종료버튼(호버)
    private ImageIcon leftButtonImage               = new ImageIcon(Main.class.getResource("../image/left_button.png"));
    private ImageIcon rightButtonImage              = new ImageIcon(Main.class.getResource("../image/right_button.png"));


    private Image background = new ImageIcon(Main.class.getResource("../image/title_2.png")).getImage();
    private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/MenuBar.png")));


    private JButton exitButton = new JButton(exitButtonBasicImage); //기본 이미지입니다.
    private JButton startButton = new JButton(startButtonBasicImage);
    private JButton quitButtion = new JButton(quitButtonBasicImage);
    private JButton leftButton = new JButton(leftButtonImage);
    private JButton rightButton = new JButton(rightButtonImage);


    private int mouseX, mouseY;

    private boolean isMainScreen = false;


    ArrayList<Track> trackList = new ArrayList<Track>();


    private Image titleImage;
    private Image selectedImage;
    private Music selectedMusic; //코드의 함수화를 통해 간결화
    private int nowSelected = 0;


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

        Music music = new Music("데자뷰.mp3", true);
        music.start();

        trackList.add(new Track("심술.png", "game_image1_600.jpg", "game_image1_1280.jpg", "심술_selected.mp3", "심술.mp3"));
        trackList.add(new Track("Dejavue.png", "game_image2_600.jpg", "game_image2_1280.jpg", "데자뷰_selected.mp3", "데자뷰.mp3"));
        trackList.add(new Track("나의사춘기에게.png", "game_image3_600.jpg", "game_image3_1280.jpg", "나의사춘기에게_selected.mp3", "나의사춘기에게.mp3"));






        exitButton.setBounds(1220, 0, 50, 50);
        exitButton.setBorderPainted(false);
        exitButton.setContentAreaFilled(false);
        exitButton.setFocusPainted(false);
        exitButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                exitButton.setIcon(exitButtonEnteredImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                exitButton.setIcon(exitButtonBasicImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start();

                try {
                    Thread.sleep(200);
                } catch (InterruptedException exception) {
                    exception.printStackTrace();
                }
                System.exit(0); //클릭시에 게임이 종료됩니다.

            }

        });

        add(exitButton);

        startButton.setBounds(40, 200, 250, 200);
        startButton.setBorderPainted(false);
        startButton.setContentAreaFilled(false);
        startButton.setFocusPainted(false);
        startButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                startButton.setIcon(startButtonEnteredImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                startButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                startButton.setIcon(startButtonBasicImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start(); //시작버튼 클릭시
                music.close(); //음악이 꺼집니다.
                selectTrack(0); //첫번째 트랙 설정.

                startButton.setVisible(false); //시작 버튼이 안보이게됩니다.
                quitButtion.setVisible(false); //나가는 버튼도 안보이게 됩니다.
                leftButton.setVisible(true);
                rightButton.setVisible(true);

                background = new ImageIcon(Main.class.getResource("../image/background.jpg")).getImage();

                isMainScreen = true;
            }

        });

        add(startButton);

        quitButtion.setBounds(40, 330, 250, 200);
        quitButtion.setBorderPainted(false);
        quitButtion.setContentAreaFilled(false);
        quitButtion.setFocusPainted(false);
        quitButtion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                quitButtion.setIcon(quitButtonEnteredImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                quitButtion.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                quitButtion.setIcon(quitButtonBasicImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);

            }

        });

        add(quitButtion);

        leftButton.setVisible(false);
        leftButton.setBounds(140, 310, 60, 60);
        leftButton.setBorderPainted(false);
        leftButton.setContentAreaFilled(false);
        leftButton.setFocusPainted(false);
        leftButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                leftButton.setIcon(leftButtonImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                leftButton.setIcon(leftButtonImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start();
                selectLeft();
            }

        });

        add(leftButton);

        rightButton.setVisible(false);
        rightButton.setBounds(1080, 310, 60, 60);
        rightButton.setBorderPainted(false);
        rightButton.setContentAreaFilled(false);
        rightButton.setFocusPainted(false);
        rightButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                rightButton.setIcon(rightButtonImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                rightButton.setIcon(rightButtonImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start();
                selectRight();
            }

        });

        add(rightButton);

        menuBar.setBounds(0, 0, 1280, 30);
        menuBar.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
            }
        });
        menuBar.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { //마우스 위치를 반환하는 함수입니다.
                int x = e.getXOnScreen();
                int y = e.getYOnScreen();
                setLocation(x - mouseX, y - mouseY); //JFrame의 마우스 자체를 변경시켜줍니다.
            }
        });
        add(menuBar);


    }

    public void paint(Graphics g) {
        screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
        screenGraghic = screenImage.getGraphics(); //스크린 이미지로부터 그래픽스를 얻어옵니다.
        screenDraw(screenGraghic);
        g.drawImage(screenImage, 0, 0, null);
    }

    private void screenDraw(Graphics g) {
        g.drawImage(background, 0, 0, null);
        if (isMainScreen) {
            g.drawImage(selectedImage, 340, 100, null);
            g.drawImage(titleImage, 280, 25, null);
        }
        paintComponents(g); //paint Component는 추가된 부분을 보여주는 함수입니다. >> add 로 추가된 버튼..
        this.repaint();
    }

    public void selectTrack(int nowSelected) {
        if (selectedMusic != null) {
            selectedMusic.close();
        }
        titleImage = new ImageIcon(Main.class.getResource("../image/" + trackList.get(nowSelected).getTitleImage())).getImage();
        selectedImage = new ImageIcon(Main.class.getResource("../image/" + trackList.get(nowSelected).getStartImage())).getImage();
        selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
        selectedMusic.start();
    }

    public void selectLeft() {
        if (nowSelected == 0) {
            nowSelected = trackList.size() - 1;
        } else {
            nowSelected--;
        }
        selectTrack(nowSelected);
    }
    public void selectRight() {
        if (nowSelected == trackList.size() - 1) {
            nowSelected = 0;
        } else {
            nowSelected++;
        }
        selectTrack(nowSelected);
    }
}
