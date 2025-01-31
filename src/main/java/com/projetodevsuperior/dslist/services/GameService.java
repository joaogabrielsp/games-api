package com.projetodevsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.projetodevsuperior.dslist.dto.GameDTO;
import com.projetodevsuperior.dslist.dto.GameMinDTO;
import com.projetodevsuperior.dslist.entities.Game;
import com.projetodevsuperior.dslist.projections.GameMinProjection;
import com.projetodevsuperior.dslist.repositories.GameRepository;


@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(@PathVariable Long id){
      Game result = gameRepository.findById(id).get();
      return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
      List<Game> result = gameRepository.findAll();
      return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
	public List<GameMinDTO> findByGameList(Long listId) {
		List<GameMinProjection> games = gameRepository.searchByList(listId);
		return games.stream().map(GameMinDTO::new).toList();
	}
}
