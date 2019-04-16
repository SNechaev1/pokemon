package men.snechaev.pokemon.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Pokemon {

    private String id;
    private String name;
    private String url;
    private String SpriteUrl;
    private String SpriteLocalPath;

    private ArrayList<String> abilities = new ArrayList<>();
    private Map<String, Integer> stats = new HashMap<>();


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSpriteUrl() {
        return SpriteUrl;
    }

    public void setSpriteUrl(String spriteUrl) {
        SpriteUrl = spriteUrl;
    }

    public String getSpriteLocalPath() {
        return SpriteLocalPath;
    }

    public void setSpriteLocalPath(String spriteLocalPath) {
        SpriteLocalPath = spriteLocalPath;
    }

    public ArrayList<String> getAbilities() {
        return abilities;
    }

    public void setAbilities(ArrayList<String> abilities) {
        this.abilities = abilities;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", SpriteUrl='" + SpriteUrl + '\'' +
                ", SpriteLocalPath='" + SpriteLocalPath + '\'' +
                ", abilities=" + abilities +
                ", stats=" + stats +
                '}';
    }
}
