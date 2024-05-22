package net.musecom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import net.musecom.dto.BoardDto;
import net.musecom.Entity.BoardEntity;
import net.musecom.repository.BoardRepository;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public void write(BoardDto bDto) {
        BoardEntity bEntity = BoardEntity.toBoardEntity(bDto);
        boardRepository.save(bEntity);
    }

    public List<BoardDto> findAll(){
       //column에 있는 모든 내용을 가져옴 
       List<BoardEntity> bEntities = boardRepository.findAll();
       
       //BoardDto 타입의 ArrayList를 만듬
       List<BoardDto> bDtos = new ArrayList<>();  
       
       //위에서 만든 ArrayList 박스에 column에서 가져온 내용을 하나하나 채움
       for(BoardEntity bEntity : bEntities) {
           bDtos.add(BoardDto.toBoardDto(bEntity));
       }    
       return bDtos;
    }
}
