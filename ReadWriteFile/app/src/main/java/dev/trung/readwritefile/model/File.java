package dev.trung.readwritefile.model;

/**
 * Created by trungnv on 7/29/2016.
 */
public class File {
    private String nameFile;
    private String uri;

    public File() {
    }

    public File(String nameFile, String uri) {
        this.nameFile = nameFile;
        this.uri = uri;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
