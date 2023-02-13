package com.example.phone_duck.controller;

import com.example.phone_duck.model.Channel;
import com.example.phone_duck.service.ChannelService;
import com.example.phone_duck.webSocket.SocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChannelController {
    @Autowired
    private ChannelService channelService;

    @Autowired
    private SocketHandler socketHandler;

    @GetMapping("channels")
    public ResponseEntity<List<Channel>> getChannels(){
        List<Channel> channels = channelService.getAllChannels();

        return ResponseEntity.ok(channels);
    }

    @PostMapping("channels")
    public ResponseEntity<List<Channel>> createChannel(@RequestBody Channel channel){
        channelService.save(channel);
        socketHandler.broadcastNewChannel(channel);

        List<Channel> channels = channelService.getAllChannels();

        return ResponseEntity.ok(channels);
    }

    @DeleteMapping("channels/{id}")
    public ResponseEntity<List<Channel>> deleteChannel(@PathVariable long id){
        channelService.delete(id);

        List<Channel> channels = channelService.getAllChannels();

        return ResponseEntity.ok(channels);
    }
}
