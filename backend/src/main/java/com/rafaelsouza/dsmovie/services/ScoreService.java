package com.rafaelsouza.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rafaelsouza.dsmovie.dto.MovieDTO;
import com.rafaelsouza.dsmovie.dto.ScoreDTO;
import com.rafaelsouza.dsmovie.entities.Movie;
import com.rafaelsouza.dsmovie.entities.Score;
import com.rafaelsouza.dsmovie.entities.User;
import com.rafaelsouza.dsmovie.repositories.MovieRepository;
import com.rafaelsouza.dsmovie.repositories.ScoreRepository;
import com.rafaelsouza.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {

	@Autowired
	private MovieRepository movieRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {

		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}

		Movie movie = movieRepository.findById(dto.getMovieId()).get();

		Score score = new Score();
		score.SetMovie(movie);
		score.setUser(user);
		score.setscoreValue(dto.getScore());

		score = scoreRepository.saveAndFlush(score);

		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getscoreValue();
		}

		double avg = sum / movie.getScores().size();

		movie.setScore(avg);
		movie.setCount(movie.getScores().size());

		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}