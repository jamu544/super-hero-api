package android.com.jumpco.io.superheroapi.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.sql.Array;
import java.util.ArrayList;

public class Results {

    //The SerializedName annotation should always display the exact name of an object in the JSON file.
    @SerializedName("name")
    public String superName;
    @SerializedName("response")
    public String response;
    @SerializedName("id")
    public int id;
    @SerializedName("powerstats")
    public Powerstats powerstats;
    @SerializedName("full-name")
    public Biography fullName;
    @SerializedName("race")
    public Appereance appereanceRace;
    @SerializedName("occupation")
    public Work work;
    @SerializedName("group-affiliation")
    public Connections connections;




    public class Powerstats {
        @SerializedName("id")
        public int id;
        @SerializedName("name")
        public String name;
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
        public String aliases;
        @SerializedName("place-of-birth")
        public String placeOfBirth;
        @SerializedName("first-appearance")
        public String firstAppearance;
        @SerializedName("publisher")
        public String publisher;
        @SerializedName("alignment")
        public String alignment;
    }
 public class Appereance{
        @SerializedName("gender")
        public String gender;
        @SerializedName("race")
        public String race;
        @SerializedName("height")
        public String height;
        @SerializedName("weight")
        public String weight;
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

}
