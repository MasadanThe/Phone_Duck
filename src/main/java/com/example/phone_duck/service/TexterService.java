package com.example.phone_duck.service;

import com.example.phone_duck.model.Texter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TexterService {

    public List<Texter> getAllByChannelId(List<Texter> texterList, String channelID)
    {
        List<Texter> foundTexterList = new ArrayList<>();
        for (Texter texter: texterList) {
            List<String> channelIdAsArray = Arrays.asList(texter.getChannelIds().split(","));
            if(channelIdAsArray.contains(channelID))
            {
                foundTexterList.add(texter);
            }


        }
        return foundTexterList;
    }

    public List<Texter> delete(WebSocketSession session, List<Texter> texterList)
    {
        for (Texter texter: texterList) {
            if (texter.getSession() == session)
            {
                texterList.remove(texter);
            }

        }
        return texterList;

    }
}
