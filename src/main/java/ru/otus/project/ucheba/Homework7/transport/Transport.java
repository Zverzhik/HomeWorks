package ru.otus.project.ucheba.Homework7.transport;

import ru.otus.project.ucheba.Homework7.TerrainType;

public interface Transport {
    boolean move(TerrainType area, int distance);
}
