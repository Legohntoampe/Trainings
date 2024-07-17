package com.pluralstraining.conf_demo.repositories;

import com.pluralstraining.conf_demo.models.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
