package com.zzti.market.serviceImpl;

import java.util.Date;
import java.util.UUID;

import javax.annotation.Resource;

import com.zzti.market.entity.Chatmessage;
import com.zzti.market.mapper.ChatmessageMapper;
import com.zzti.market.service.ChatService;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
	
	@Resource
	ChatmessageMapper chatmessageMapper;
	
	@Override
	public int saveMessage(String userid1, String userid2, String message) {
		Chatmessage chatmessage=new Chatmessage();
		String chatid = UUID.randomUUID().toString().replace("-", "");
		chatmessage.setChatid(chatid);
		chatmessage.setUserid1(userid1);
		chatmessage.setUserid2(userid2);
		chatmessage.setReplymessage(message);
		chatmessage.setSendtime(new Date());
		chatmessage.setWeathersee(0);
		return chatmessageMapper.insert(chatmessage);
		// TODO Auto-generated method stub
		
	}

	@Override
	public Chatmessage readMessage(String userid2) {
		Chatmessage chatmessage=new Chatmessage();
		chatmessage=chatmessageMapper.selectByUserId2(userid2);
		
		return chatmessage;
		// TODO Auto-generated method stub
		
	}

}
