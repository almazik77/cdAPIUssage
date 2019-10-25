package ru.itis.models;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.List;

public class Party {
    Long contestId;//	Целое число. Может отсутствовать. Id соревнования, в котором участник принимает участие.
    List<Member> members;//	Список объектов Member. Члены группы участников.
    String participantType; //	Enum: CONTESTANT, PRACTICE, VIRTUAL, MANAGER, OUT_OF_COMPETITION.
    Long teamId; //	Целое число. Может отсутствовать. Если участник — это команда, то поле содержит уникальный id команды. Иначе, это поле отсутствует.
    String teamName;//	Строка. Локализовано. Может отсутствовать. Если участник — это команда или призрак, то это локализованное название команды. Иначе, это поле отсутствует.
    Boolean ghost; //	Boolean. Если имеет значение true, то участник является призраком. Он участвовал в этом соревновании, но не на Codeforces. Например, в контестах Андрея Станкевича в Тренировках есть призраки участников Петрозаводских Сборов.
    Long room; //	Целое число. Может отсутствовать. Комната, в которую этот участник был определен. Если отсутствует, то у участника нет комнаты.
    Long startTimeSeconds;//	Целое число. Может отсутствовать. Время, когда этот участник начал соревнование.

    public Long getContestId() {
        return contestId;
    }

    public void setContestId(Long contestId) {
        this.contestId = contestId;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }

    public String getParticipantType() {
        return participantType;
    }

    public void setParticipantType(String participantType) {
        this.participantType = participantType;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Boolean getGhost() {
        return ghost;
    }

    public void setGhost(Boolean ghost) {
        this.ghost = ghost;
    }

    public Long getRoom() {
        return room;
    }

    public void setRoom(Long room) {
        this.room = room;
    }

    public Long getStartTimeSeconds() {
        return startTimeSeconds;
    }

    public void setStartTimeSeconds(Long startTimeSeconds) {
        this.startTimeSeconds = startTimeSeconds;
    }

    @Override
    public String toString() {
        return "Party{" +
                "contestId=" + contestId +
                ", members=" + members +
                ", participantType=" + participantType +
                ", teamId=" + teamId +
                ", teamName='" + teamName + '\'' +
                ", ghost=" + ghost +
                ", room=" + room +
                ", startTimeSeconds=" + startTimeSeconds +
                '}';
    }
}
