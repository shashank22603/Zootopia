package org.example;

public abstract class Animal {
    private String name ;
    private String sound ;
    private String type ;
    private String description ;
    public Animal (String name , String sound , String type , String description) {
        this.name = name ;
        this.sound = sound ;
        this.type = type ;
        this.description = description ;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSound() {
        return sound + "...." ;
    }
    public void setSound(String sound) {
        this.sound = sound;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


}
