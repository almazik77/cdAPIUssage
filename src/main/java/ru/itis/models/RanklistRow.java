package ru.itis.models;

import java.util.List;

public class RanklistRow {
    Party party;//	Объект Party. Участник, который занял соответствующее место в соревновании.
    Long rank;//	Целое число. Место участника в соревновании.
    Double points;//	Число с плавающей запятой. Суммарные баллы, набранные участником..
    Long penalty; //	Целое число. Суммарное пенальти (в ICPC понимании) участника.
    Long successfulHackCount;    //Целое число.
    Long unsuccessfulHackCount;//	Целое число.
    List<ProblemResult> problemResults; //	Список объектов ProblemResult. Результаты участника по каждой из задач соревнования. Порядок задач соответствует порядку задач в поле "problems" возвращаемого объекта.
    Long lastSubmissionTimeSeconds;    //Целое число. Только для соревновании IOI. Время в секундах от начала соревнования до последней попытки, которая увеличила суммарное количество баллов у участника.

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    public Long getRank() {
        return rank;
    }

    public void setRank(Long rank) {
        this.rank = rank;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Long getPenalty() {
        return penalty;
    }

    public void setPenalty(Long penalty) {
        this.penalty = penalty;
    }

    public Long getSuccessfulHackCount() {
        return successfulHackCount;
    }

    public void setSuccessfulHackCount(Long successfulHackCount) {
        this.successfulHackCount = successfulHackCount;
    }

    public Long getUnsuccessfulHackCount() {
        return unsuccessfulHackCount;
    }

    public void setUnsuccessfulHackCount(Long unsuccessfulHackCount) {
        this.unsuccessfulHackCount = unsuccessfulHackCount;
    }

    public List<ProblemResult> getProblemResults() {
        return problemResults;
    }

    public void setProblemResults(List<ProblemResult> problemResults) {
        this.problemResults = problemResults;
    }

    public Long getLastSubmissionTimeSeconds() {
        return lastSubmissionTimeSeconds;
    }

    public void setLastSubmissionTimeSeconds(Long lastSubmissionTimeSeconds) {
        this.lastSubmissionTimeSeconds = lastSubmissionTimeSeconds;
    }

    @Override
    public String toString() {
        return "RanklistRow{" +
                "party=" + party +
                ", rank=" + rank +
                ", points=" + points +
                ", penalty=" + penalty +
                ", successfulHackCount=" + successfulHackCount +
                ", unsuccessfulHackCount=" + unsuccessfulHackCount +
                ", problemResults=" + problemResults +
                ", lastSubmissionTimeSeconds=" + lastSubmissionTimeSeconds +
                '}';
    }
}
