package com.example.profile;


public interface IProfile {
    boolean createProfile(Profile profile);
    boolean updateProfile(Profile profile);
    Profile findProfile(String login);
    boolean existProfile(String Login);
    String findActivityLevel (String description);
    String findActivity (String level);
}
