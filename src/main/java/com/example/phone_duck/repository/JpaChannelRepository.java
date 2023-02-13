package com.example.phone_duck.repository;

import com.example.phone_duck.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaChannelRepository extends JpaRepository<Channel, Long> {
}
