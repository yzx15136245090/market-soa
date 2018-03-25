package com.zzti.market.service;


import com.zzti.market.entity.Chatmessage;

public interface ChatService {
int saveMessage ( String userid1, String userid2, String message );
Chatmessage readMessage ( String userid2 );
}
