package ru.otus.project.ucheba.Homework7;

public enum TerrainType {
    DENSEFORREST ("Густой лес"),
    PLAIN ("Равнина"),
    SWAMP ("Болото");

    private final String name;

    TerrainType(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
