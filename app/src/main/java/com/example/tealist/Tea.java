package com.example.tealist;

public class Tea {

    private int id;
    private String name;
    private String description;
    private String imageURL;
    public Tea(int id, String name, String description, String imageURL) { // создаем объект чая
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Tea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    // прописываем геттеры и сеттеры
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}

