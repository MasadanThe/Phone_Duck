package com.example.phone_duck.service;

import com.example.phone_duck.model.Channel;
import com.example.phone_duck.repository.JpaChannelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelService {
    @Autowired
    private JpaChannelRepository jpaChannelRepository;

    public List<Channel> getAllChannels()
    {
        return jpaChannelRepository.findAll();
    }

    public Channel save (Channel channel)
    {
        return jpaChannelRepository.save(channel);
    }

    public void delete(long id)
    {
        jpaChannelRepository.deleteById(id);
    }
}
