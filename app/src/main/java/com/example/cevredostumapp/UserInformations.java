package com.example.cevredostumapp;
//ademkalpakli
public class UserInformations {

    private String name,surname,birthday,age,education;


    public UserInformations() {
    }

    public UserInformations(String name, String surname, String birthday, String age, String education, String image) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.age = age;
        this.education = education;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }


    @Override
    public String toString() {
        return "UserInformations{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthday='" + birthday + '\'' +
                ", age='" + age + '\'' +
                ", education='" + education + '\'' +
                '}';
    }
}
