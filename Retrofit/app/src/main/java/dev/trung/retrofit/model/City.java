package dev.trung.retrofit.model;

/**
 * Created by trungnv on 8/3/2016.
 */

public class City {
    private int _id;
    private String name;
    private String country;
    private String coord;

    public City() {
    }

    public City(int _id, String name, String country, String coord) {
        this._id = _id;
        this.name = name;
        this.country = country;
        this.coord = coord;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCoord() {
        return coord;
    }

    public void setCoord(String coord) {
        this.coord = coord;
    }

    @Override
    public String toString() {
        StringBuilder append = new StringBuilder();
        return append.append("City{").append(
                "_id=" + _id).append(
                ", name='" + name + '\'').append(
                ", country='" + country + '\'').append(
                ", coord='" + coord + '\'').append(
                '}').toString();
    }
}
