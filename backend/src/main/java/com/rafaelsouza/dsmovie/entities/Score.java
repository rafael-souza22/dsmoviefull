package com.rafaelsouza.dsmovie.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_score")

public class Score {

	@EmbeddedId
	private ScorePK id = new ScorePK();
	
	private Double scoreValue;

	public Score() {

	}

	public void SetMovie(Movie movie) {
		id.setMovie(movie);
	}

	public void setUser(User user) {
		id.setUser(user);
	}

	public ScorePK getId() {
		return id;
	}

	public void setId(ScorePK id) {
		this.id = id;
	}

	public Double getscoreValue() {
		return scoreValue;
	}

	public void setscoreValue(Double scoreValue) {
		this.scoreValue = scoreValue;
	}
	
}