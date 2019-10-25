package ru.itis.models;

public class Member {
    String handle;//	Строка. Хэндл пользователя Codeforces.

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    @Override
    public String toString() {
        return "Member{" +
                "handle='" + handle + '\'' +
                '}';
    }
}
