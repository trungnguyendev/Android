package dev.trung.library.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * trung on 12/19/2016.
 */

public class Responsive {
    @SerializedName("cod")
    private String cod;
    @SerializedName("message")
    private String message;
    @SerializedName("list")
    private List<Weathers> list;

    public String getCod() {
        return cod;
    }

    public String getMessage() {
        return message;
    }

    public List<Weathers> getList() {
        return list;
    }
}
