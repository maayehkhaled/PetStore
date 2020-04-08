package model;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.List;

public class Tag {
    private int id;
    private String name;

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

    public List<Tag> generateTags(){
        List<Tag> tagList= new ArrayList<>();
        for (int i = 0; i <Integer.parseInt(RandomStringUtils.randomNumeric(1)) ; i++) {
            Tag tag= new Tag();
            tag.setId(Integer.parseInt(RandomStringUtils.randomNumeric(1)));
            tag.setName(RandomStringUtils.randomAlphabetic(6));
            tagList.add(tag);
        }
        return tagList;
    }
}
