package ru.team32.javathon.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.team32.javathon.entity.Theme;

public interface UserRepository extends JpaRepository<Theme, Long> {
}
