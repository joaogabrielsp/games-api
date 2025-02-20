package com.projetodevsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetodevsuperior.dslist.dto.GameListDTO;
import com.projetodevsuperior.dslist.entities.GameList;
import com.projetodevsuperior.dslist.projections.GameMinProjection;
import com.projetodevsuperior.dslist.repositories.GameListRepository;
import com.projetodevsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
      List<GameList> result = gameListRepository.findAll();
      return result.stream().map(GameListDTO::new).toList();
    }

    @Transactional
    public void move(long listId, int sourceIndex, int destinationIndex){

      List<GameMinProjection> list = gameRepository.searchByList(listId);

      GameMinProjection obj = list.remove(sourceIndex);
      list.add(destinationIndex, obj);

      int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
      int max = sourceIndex > destinationIndex ? sourceIndex : destinationIndex;

      for(int i = min; i <= max; i++){
        gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
      }
    }
}
