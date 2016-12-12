package sample;

/**
 * Created by y2793623b on 24/10/16.
 */
public class Card {

    String name;
    String type;
    String rarity;
    String set;
    String colors;
    String imageUrl;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSet() {
        return set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String text;

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Card{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", rarity='" + rarity + '\'' +
                ", set='" + set + '\'' +
                ", colors='" + colors + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
