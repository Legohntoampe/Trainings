package com.pluralstraining.conf_demo.repositories;

import com.pluralstraining.conf_demo.models.Session;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<Session, Long> {
}
