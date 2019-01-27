package ru.sbt.ds.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.ds.entity.Theme;

public interface ThemeRepository extends JpaRepository<Theme, Long> {
}
