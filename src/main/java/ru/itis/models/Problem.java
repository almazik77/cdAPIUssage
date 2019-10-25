package ru.itis.models;

import java.util.List;

public class Problem {
    Long contestId; //Целое число. Может отсутствовать. Id соревнования, содержащего задачу.
    String problemsetName;//	Строка. Может отсутствовать. Короткое имя дополнительного архива, которому принадлежит задача.
    String index;//	Строка. Обычно буква или буква с цифрой, обозначающие индекс задачи в соревновании.
    String name;//	Строка. Локализовано.
    String type;//	Enum: PROGRAMMING, QUESTION.
    Double points;//	Число с плавающей запятой. Может отсутствовать. Максимальное количество баллов за задачу.
    Long rating;//	Целое число. Может отсутствовать. Рейтинг задачи (сложность).
    List<String> tags;//	Список строк. Теги задачи.

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public String getProblemsetName() {
        return problemsetName;
    }

    public void setProblemsetName(String problemsetName) {
        this.problemsetName = problemsetName;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Long getRating() {
        return rating;
    }

    public void setRating(Long rating) {
        this.rating = rating;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Problem{" +
                "contestId=" + contestId +
                ", problemsetName='" + problemsetName + '\'' +
                ", index='" + index + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", points=" + points +
                ", rating=" + rating +
                ", tags=" + tags +
                '}';
    }
}
