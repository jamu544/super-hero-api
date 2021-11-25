package android.com.jumpco.io.superheroapi.interfaces;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Api2 {
    @SerializedName("response")
    @Expose
    public String response;
    @Expose
    @SerializedName("id")
    public String id;
    @SerializedName("name")
    public String name;

    //powerstats
    @SerializedName("powerstats")
    @Expose
    public PowerStats powerStats;

    //biography
    @SerializedName("biography")
    @Expose
    public Biography biography;

    //appearance
    @SerializedName("appearance")
    @Expose
    public Appearance appearance;

    //work
    @SerializedName("work")
    @Expose
    public Work work;

    //connections
    @SerializedName("connections")
    @Expose
    public Connections connections;

    //connections
    @SerializedName("image")
    @Expose
    public Image image;


    public class PowerStats{
        @SerializedName("intelligence")
        public String intelligence;
        @SerializedName("strength")
        public String strength;
        @SerializedName("speed")
        public String speed;
        @SerializedName("durability")
        public String durability;
        @SerializedName("power")
        public String power;
        @SerializedName("combat")
        public String combat;
    }
    public class Biography{
        @SerializedName("full-name")
        public String fullName;
        @SerializedName("alter-egos")
        public String alterEgos;
        @SerializedName("aliases")
        public List<String> aliases;
        @SerializedName("place-of-birth")
        public String placeOfBirth;
        @SerializedName("first-appearance")
        public String firstAppearance;
        @SerializedName("publisher")
        public String publisher;
        @SerializedName("alignment")
        public String alignment;
    }

    public class Appearance{
        @SerializedName("gender")
        public String gender;
        @SerializedName("race")
        public String race;
        @SerializedName("height")
        public List<String> height;
        @SerializedName("weight")
        public List<String> weight;
        @SerializedName("eye-color")
        public String eyeColor;
        @SerializedName("hair-color")
        public String hairColor;
    }
    public class Work{
        @SerializedName("occupation")
        public String occupation;
        @SerializedName("base")
        public String base;
    }
    public class Connections{
        @SerializedName("group-affiliation")
        public String groupAffiliation;
        @SerializedName("relatives")
        public String relatives;
    }

    public class Image {
        @SerializedName("url")
        public String url;
    }




}
