package com.revature.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table(name="CHANNEL")
@SequenceGenerator(name="channelSeq", sequenceName="CHANNEL_SEQ", allocationSize=1)
public class Channel {

	@Id
	@Column(name="CHANNEL_ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="channelSeq")
	private int channel_id;

	@Column(name="CHANNEL_CREATOR_ID")
	private int channel_creator_id;

	@Column(name="CHANNEL_NAME")
	private String channel_name;

	public Channel() {
		System.out.println("LOG: Channel has been instantiated");
	}
	
	public Channel(int channel_id, int channel_creator_id, String channel_name) {
		super();
		this.channel_id = channel_id;
		this.channel_creator_id = channel_creator_id;
		this.channel_name = channel_name;
	}

	@Override
	public String toString() {
		return "Channel [channel_id=" + channel_id + ", channel_creator_id=" + channel_creator_id + ", channel_name="
				+ channel_name + "]";
	}

	public int getChannel_id() {
		return channel_id;
	}

	public void setChannel_id(int channel_id) {
		this.channel_id = channel_id;
	}

	public int getChannel_creator_id() {
		return channel_creator_id;
	}

	public void setChannel_creator_id(int channel_creator_id) {
		this.channel_creator_id = channel_creator_id;
	}

	public String getChannel_name() {
		return channel_name;
	}

	public void setChannel_name(String channel_name) {
		this.channel_name = channel_name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + channel_creator_id;
		result = prime * result + channel_id;
		result = prime * result + ((channel_name == null) ? 0 : channel_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Channel other = (Channel) obj;
		if (channel_creator_id != other.channel_creator_id)
			return false;
		if (channel_id != other.channel_id)
			return false;
		if (channel_name == null) {
			if (other.channel_name != null)
				return false;
		} else if (!channel_name.equals(other.channel_name))
			return false;
		return true;
	}

}
