package dynamic_beat_9;

public class Track {
    private String titleImage; //제목 부분 이미지
    private String startImage; //게임 선택 창 표지 이미지
    private String gameImage; //해당 곡 실행시 표지 이미지

    private String startMusic;
    private String gameMusic; //게임 뮤직

    public String getStartMusic() {
        return startMusic;
    }

    public void setStartMusic(String startMusic) {
        this.startMusic = startMusic;
    }


    public String getTitleImage() {
        return titleImage;
    }
    
    public void setTitleImage(String titleImage) {
        this.titleImage = titleImage;
    }
    
    public String getStartImage() {
        return startImage;
    }
    
    public void setStartImage(String startImage) {
        this.startImage = startImage;
    }
    
    public String getGameImage() {
        return gameImage;
    }
    
    public void setGameImage(String gameImage) {
        this.gameImage = gameImage;
    }
    
    public String getGameMusic() {
        return gameMusic;
    }
    
    public void setGameMusic(String gameMusic) {
        this.gameMusic = gameMusic;
    }

    public Track(String titleImage, String startImage, String gameImage, String startMusic, String gameMusic) {
        this.titleImage = titleImage;
        this.startImage = startImage;
        this.gameImage = gameImage;
        this.startMusic = startMusic;
        this.gameMusic = gameMusic;
    }
}
