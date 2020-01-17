package com.example.fotomotionapp;


public class AnimationProject {

    // instance variables
    private String imageName;
    private String projectName;
    private String authorName;

    public AnimationProject() {
        imageName = "";
        projectName = "Project Name";
        authorName = "User Name";
    }

    public AnimationProject(String project, String author) {
        projectName = project;
        authorName = author;
    }

    public AnimationProject(String image, String project, String author) {
        imageName = image;
        projectName = project;
        authorName = author;
    }

    // getters and setters

    // getters
    public String getAuthorName() {
        return authorName;
    }

    public String getImageName() {
        return imageName;
    }

    public String getProjectName() {
        return projectName;
    }

    // setters
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
