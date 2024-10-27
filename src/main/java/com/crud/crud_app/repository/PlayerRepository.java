package com.crud.crud_app.repository;

import com.crud.crud_app.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, String> {
}
