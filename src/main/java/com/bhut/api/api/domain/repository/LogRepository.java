package com.bhut.api.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bhut.api.api.domain.model.Log;

@Repository
public interface LogRepository extends JpaRepository<Log, Long> {
}

