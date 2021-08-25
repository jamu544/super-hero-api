package android.com.jumpco.io.superheroapi.pojo;

import com.google.gson.annotations.SerializedName;

public class SuperheroResponse {
    @SerializedName("powerstats")
    public Powerstats stats;
    @SerializedName("name")
    public String name;
    @SerializedName("id")
    public String id;
//
//    class Powerstats {
//
//        @SerializedName("name")
//        public String name;
//        @SerializedName("intelligence")
//        public String intelligence;
//        @SerializedName("strength")
//        public String strength;
//        @SerializedName("speed")
//        public String speed;
//        @SerializedName("durability")
//        public String durability;
//        @SerializedName("power")
//        public String power;
//        @SerializedName("combat")
//        public String combat;
//
//    }
//
//     public class Biography{
//        @SerializedName("full-name")
//        public String fullName;
//        @SerializedName("alter-egos")
//        public String alterEgos;
//        @SerializedName("aliases")
//        public String aliases;
//        @SerializedName("place-of-birth")
//        public String placeOfBirth;
//        @SerializedName("first-appearance")
//        public String firstAppearance;
//        @SerializedName("publisher")
//        public String publisher;
//        @SerializedName("alignment")
//        public String alignment;
//
//
//
//    }

//      class Appereance{
//        @SerializedName("gender")
//        public String gender;
//        @SerializedName("race")
//        public String race;
//        @SerializedName("height")
//        public String height;
//        @SerializedName("weight")
//        public String weight;
//        @SerializedName("eye-color")
//        public String eyeColor;
//        @SerializedName("hair-color")
//        public String hairColor;
//
//
//
//    }
//     class Work{
//        @SerializedName("occupation")
//        public String occupation;
//        @SerializedName("base")
//        public String base;
//
//    }
//    class Base{
//        @SerializedName("group-affiliation")
//        public String groupAffiliation;
//        @SerializedName("relatives")
//        public String relatives;
//
//    }
    class Image{
        @SerializedName("url")
        public String url;
        }

}