package com.rafaelsouza.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelsouza.dsmovie.entities.Score;
import com.rafaelsouza.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {
	
	

}
