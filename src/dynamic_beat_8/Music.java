package dynamic_beat_8;

import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Music extends Thread {
    private Player player;
    private File file;
    private boolean isLoop;
    private FileInputStream fis;
    private BufferedInputStream bis;
    
    public Music(String name, boolean isLoop) {
        try {
            this.isLoop = isLoop;
            file = new File(Main.class.getResource("../music/" + name).toURI());
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            player = new Player(bis);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public int getTime() { //음악에 맞춰서 노트를 떨어뜨릴때 getTime으로 노트를 분석합니다.
        if (player == null) {
            return 0;
        }
        return player.getPosition();
    }
    
    public void close() { //음악이 언제 실행되고 있던간에 프로그램을 종료할 수 있도록 해주는 함수
        isLoop = false;
        player.close();
        this.interrupt();
    }
    
    @Override
    public void run() {
        try {
            do {
                player.play();
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                player = new Player(bis);
            } while (isLoop); //isLoop라는 값이 On이라면 곡을 실행합니다.
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
}

