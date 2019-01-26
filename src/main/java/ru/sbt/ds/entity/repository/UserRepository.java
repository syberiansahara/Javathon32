package ru.sbt.ds.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sbt.ds.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
