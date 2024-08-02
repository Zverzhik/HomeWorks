package ru.otus.project.ucheba.Homework11;


public enum Position {
    MANAGER ("MANAGERS"),
    DIRECTOR ("MANAGERS"),
    DRIVER ("EMPLOYEES"),
    ENGINEER ("EMPLOYEES"),
    SENIOR_MANAGER ("MANAGERS"),
    DEVELOPER ("EMPLOYEES"),
    QA ("EMPLOYEES"),
    JANITOR ("EMPLOYEES"),
    PLUMBER ("EMPLOYEES"),
    BRANCH_DIRECTOR ("MANAGERS"),
    JUNIOR_DEVELOPER ("EMPLOYEES");

    private final String type;

    Position(String type) {
        this.type = type;
    }

    public boolean isManager() {
        return this.type == "MANAGERS";
    }

    public boolean isEmployee() {
        return this.type == "EMPLOYEES";
    }
}
