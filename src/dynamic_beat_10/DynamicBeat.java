package dynamic_beat_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

public class DynamicBeat extends JFrame {

    ArrayList<Track> trackList = new ArrayList<Track>();

    private Image screenImage;
    private Graphics screenGraghic;


    private final ImageIcon exitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/exit2.png")); //메뉴화면 종료버튼
    private final ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/exit.png"));
    private final ImageIcon startButtonBasicImage = new ImageIcon(Main.class.getResource("../image/start_button_resize.png")); //시작버튼(베이직)
    private final ImageIcon startButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/start_button_entered.png")); //시작버튼(호버)
    private final ImageIcon quitButtonBasicImage = new ImageIcon(Main.class.getResource("../image/quit_button_resize.png")); //종료버튼
    private final ImageIcon quitButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/quit_button_entered.png")); //종료버튼(호버)
    private final ImageIcon leftButtonImage = new ImageIcon(Main.class.getResource("../image/left_button.png"));
    private final ImageIcon rightButtonImage = new ImageIcon(Main.class.getResource("../image/right_button.png"));
    private final ImageIcon easyButtonImage = new ImageIcon(Main.class.getResource("../image/easy.png"));
    private final ImageIcon normalButtonImage = new ImageIcon(Main.class.getResource("../image/normal.png"));
    private final ImageIcon hardButtonImage = new ImageIcon(Main.class.getResource("../image/hard.png"));
    private ImageIcon backButtonImage = new ImageIcon(Main.class.getResource("../image/back_button.png"));
    private ImageIcon backButtonEnteredImage = new ImageIcon(Main.class.getResource("../image/back_button_enter.png"));


    private Image background = new ImageIcon(Main.class.getResource("../image/title_2.png")).getImage();

    private final JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/MenuBar.png")));


    private final JButton exitButton = new JButton(exitButtonBasicImage); //기본 이미지입니다.
    private final JButton startButton = new JButton(startButtonBasicImage);
    private final JButton quitButtion = new JButton(quitButtonBasicImage);
    private final JButton leftButton = new JButton(leftButtonImage);
    private final JButton rightButton = new JButton(rightButtonImage);
    private final JButton easyButton = new JButton(easyButtonImage);
    private final JButton normalButton = new JButton(normalButtonImage);
    private final JButton hardButton = new JButton(hardButtonImage);
    private JButton backButton = new JButton(backButtonImage);


    private int mouseX, mouseY;
    private boolean isMainScreen = false;
    private boolean isGameScreen = false;

    private Image titleImage;
    private Image selectedImage;
    private Music selectedMusic; //코드의 함수화를 통해 간결화
    Music music = new Music("데자뷰.mp3", true);


    private int nowSelected = 0;


    public static Game game = new Game();//게임이 여러개 실행되지 못합니다.

    public DynamicBeat() {
        setTitle("Dynamic Beat");
        setUndecorated(true);
        setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEGHT);
        setResizable(false);//사용자가 마음대로 크기를 변경할 수 없습니다.
        setLocationRelativeTo(null); //게임 창이 정 중앙에 뜨게 됩니다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //게임 창을 종료시에 프로그램 전체가 종료됩니다.
        setVisible(true);
        setBackground(new Color(0, 0, 0, 0)); //배경 흰색으로 바뀝니다.
        setLayout(null);

        addKeyListener(new KeyListener());

        music.start();


        trackList.add(new Track("심술.png", "game_image1_600.jpg", "game_image1_1280.jpg", "심술_selected.mp3", "심술.mp3"));
        trackList.add(new Track("Dejavue.png", "game_image2_600.jpg", "game_image2_1280.jpg", "데자뷰_selected.mp3", "데자뷰.mp3"));
        trackList.add(new Track("나의사춘기에게.png", "game_image3_600.jpg", "game_image3_1280.jpg", "나의사춘기에게_selected.mp3", "나의사춘기에게.mp3"));

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

                enterMain();
            }

        });

        add(startButton);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //이지 버튼
        easyButton.setVisible(false);

        easyButton.setBounds(200, 580, 250, 67);
        easyButton.setBorderPainted(false);
        easyButton.setContentAreaFilled(false);
        easyButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                easyButton.setIcon(easyButtonImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                easyButton.setIcon(easyButtonImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start();
                gameStart(nowSelected, "easy");

                //난이도 쉬움 이벤트
            }

        });

        add(easyButton);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //노멀버튼
        normalButton.setVisible(false);

        normalButton.setBounds(480, 580, 250, 67);
        normalButton.setBorderPainted(false);
        normalButton.setContentAreaFilled(false);
        normalButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                normalButton.setIcon(normalButtonImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                normalButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                normalButton.setIcon(normalButtonImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start();
                gameStart(nowSelected, "normal");

                //난이도 노멀 이벤트
            }

        });

        add(normalButton);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//하드버튼
        hardButton.setVisible(false);

        hardButton.setBounds(760, 580, 250, 67);
        hardButton.setBorderPainted(false);
        hardButton.setContentAreaFilled(false);
        hardButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                hardButton.setIcon(hardButtonImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hardButton.setIcon(hardButtonImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start();
                gameStart(nowSelected, "hard");
            }

        });

        add(hardButton);

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//백버튼
        backButton.setVisible(false);

        backButton.setBounds(20, 50, 60, 60);
        backButton.setBorderPainted(false);
        backButton.setContentAreaFilled(false);
        backButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                backButton.setIcon(backButtonEnteredImage); //마우스가 올라가 있으면 엔터드 이미지로 변경됩니다.
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mouseExited(MouseEvent e) {
                backButton.setIcon(backButtonImage);//마우스 안올라 가 있을때 베이직 이미지로 변경됩니다.
                backButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); //손모양 커서를 가집니다. //종료 버튼 누를때..
            }

            @Override
            public void mousePressed(MouseEvent e) {
                Music buttonPressedMusic = new Music("Button_Click_sound.mp3", false);
                buttonPressedMusic.start();

                backMain();
            }

        });

        add(backButton);


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
        screenDraw((Graphics2D) screenGraghic);
        g.drawImage(screenImage, 0, 0, null);
    }

    private void screenDraw(Graphics2D g) {
        g.drawImage(background, 0, 0, null);
        if (isMainScreen) {
            g.drawImage(selectedImage, 340, 100, null);
            g.drawImage(titleImage, 280, 25, null);
        }
        if (isGameScreen) {
            game.screenDraw(g);
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

    public void gameStart(int nowSelected, String difficulty) {
        if (selectedMusic != null) {
            selectedMusic.close();
            isMainScreen = false;
            leftButton.setVisible(false);
            rightButton.setVisible(false);
            easyButton.setVisible(false);
            normalButton.setVisible(false);
            hardButton.setVisible(false);

            background = new ImageIcon(Main.class.getResource("../image/" + trackList.get(nowSelected).getGameImage())).getImage();
            backButton.setVisible(true);
            isGameScreen = true;
            setFocusable(true);
            requestFocus();
        }
    }

    public void backMain() {
        isMainScreen = true;
        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        normalButton.setVisible(true);
        hardButton.setVisible(true);

        background = new ImageIcon(Main.class.getResource("../image/background.jpg")).getImage();
        backButton.setVisible(false);
        selectTrack(nowSelected);
        isGameScreen = false;
    }

    public void enterMain() {
        selectTrack(0); //첫번째 트랙 설정.

        startButton.setVisible(false); //시작 버튼이 안보이게됩니다.
        quitButtion.setVisible(false); //나가는 버튼도 안보이게 됩니다.
        background = new ImageIcon(Main.class.getResource("../image/background.jpg")).getImage();

        leftButton.setVisible(true);
        rightButton.setVisible(true);
        easyButton.setVisible(true);
        normalButton.setVisible(true);
        hardButton.setVisible(true);


        isMainScreen = true;
    }
}
