package ru.itis.models;

public class Contest {
    Long id;
    String name;

    String type;
    ; //{"CF", IOI, ICPC};

    String phase;
    ; // BEFORE, CODING, PENDING_SYSTEM_TEST, SYSTEM_TEST, FINISHED.
    Boolean frozen; // Если имеет значение true, то результаты соревнования заморожены и в них отображаются только попытки, сделанные до заморозки.
    Long durationSeconds; //	Целое число. Продолжительность соревнования в секундах.
    Long startTimeSeconds;//	Целое число. Может отсутствовать. Время начала соревнования в unix формате.
    Long relativeTimeSeconds;//	Целое число. Может отсутствовать. Количество секунд, прошедших с начала соревнования. Может быть отрицательно..
    String preparedBy;//	Строка. Может отсутствовать. Хэндл пользователя, создавшего соревнование.
    String websiteUrl;//	Строка. Может отсутствовать. URL сайта о соревновании.
    String description;//	Строка. Локализовано. Может отсутствовать.
    String difficulty;//	Целое число. Может отсутствовать. От 1 до 5. Чем больше число, тем сложнее задачи.
    String kind;//	Строка. Локализовано. Может отсутствовать. Одна из следующих категорий соревнования: Офиц. ICPC соревнование, Официальное школьное соревнование, Этап открытого кубка, Чемпионат школы/университета/города/области, Соревнование со сборов, Офиц. международное инд. соревнование, Тренировочное соревнование.
    String icpcRegion;//	Строка. Локализовано. Может отсутствовать. Название региона для официальных соревнований ICPC.
    String country;//	Строка. Локализовано. Может отсутствовать.
    String city; //	Строка. Локализовано. Может отсутствовать.
    String season;//	Строка. Может отсутствовать.

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFrozen() {
        return frozen;
    }

    public void setFrozen(Boolean frozen) {
        this.frozen = frozen;
    }

    public Long getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(Long durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Long getStartTimeSeconds() {
        return startTimeSeconds;
    }

    public void setStartTimeSeconds(Long startTimeSeconds) {
        this.startTimeSeconds = startTimeSeconds;
    }

    public Long getRelativeTimeSeconds() {
        return relativeTimeSeconds;
    }

    public void setRelativeTimeSeconds(Long relativeTimeSeconds) {
        this.relativeTimeSeconds = relativeTimeSeconds;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getIcpcRegion() {
        return icpcRegion;
    }

    public void setIcpcRegion(String icpcRegion) {
        this.icpcRegion = icpcRegion;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "Contest{" +
                "id=" + id +
                /*", name='" + name + '\'' +
                ", frozen=" + frozen +
                ", durationSeconds=" + durationSeconds +
                ", startTimeSeconds=" + startTimeSeconds +
                ", relativeTimeSeconds=" + relativeTimeSeconds +
                ", preparedBy='" + preparedBy + '\'' +
                ", websiteUrl='" + websiteUrl + '\'' +
                ", description='" + description + '\'' +
                ", difficulty='" + difficulty + '\'' +
                ", kind='" + kind + '\'' +
                ", icpcRegion='" + icpcRegion + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", season='" + season + '\'' + */
                '}';
    }
}
