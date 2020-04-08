package model;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class Pet {
    private int id;
    private String name;
    private Status status;
    private Category category;
    private List<Tag> tags;
    private String[] photoUrls;

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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Pet generatePet(boolean valid) {
        Pet pet = new Pet();
        pet.setId(Integer.parseInt(RandomStringUtils.randomNumeric(8)));
        pet.setName(RandomStringUtils.randomAlphabetic(6));
        pet.setStatus(Status.getRandom());
        pet.setCategory(new Category().generateCategory());
        pet.setTags(new Tag().generateTags());
        return pet;
    }

}
