package app.test.com.fragements;

public class Profiler {
    private String text;
    private String photo;
    private String link;

    public Profiler() {
    }

    public Profiler(String text, String photo,String link) {
        this.text = text;
        this.photo = photo;
        this.link = link;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
