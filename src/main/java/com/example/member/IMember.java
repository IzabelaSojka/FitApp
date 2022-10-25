package com.example.member;

public interface IMember {
    boolean createMember(Member member);
    boolean existMember(String login);
    boolean validationLogin(Member member);
    String findPassword(String login);
    String findEmail(String login);

}
