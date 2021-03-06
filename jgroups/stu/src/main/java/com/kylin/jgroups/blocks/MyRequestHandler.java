package com.kylin.jgroups.blocks;

import org.apache.log4j.Logger;
import org.jgroups.Address;
import org.jgroups.Channel;
import org.jgroups.Message;
import org.jgroups.blocks.RequestHandler;

public class MyRequestHandler implements RequestHandler {
	
	private Channel channel;
	
	public MyRequestHandler(Channel channel) {
		super();
		this.channel = channel;
	}

	private static final Logger logger = Logger.getLogger(MyRequestHandler.class);

	public Object handle(Message msg) throws Exception {
		Address sender = msg.getSrc();
		logger.info(sender + ", " + msg.getObject());
		return channel.getName() + "-" + msg.getObject();
	}

}
