package model;

import org.apache.commons.lang3.RandomStringUtils;

public class Category {
    private int id;
    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  Category generateCategory(){
        Category category= new Category();
        category.setId(Integer.parseInt(RandomStringUtils.randomNumeric(1)));
        category.setName(RandomStringUtils.randomAlphabetic(6));
        return category;
    }


}
