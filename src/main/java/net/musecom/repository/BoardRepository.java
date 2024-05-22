package net.musecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.musecom.Entity.BoardEntity;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    
}
