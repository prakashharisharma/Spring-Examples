package com.td.sb.model;

import java.util.Date;

public class Order {

	private String content;
    private Date timestamp;
    private int priority;

    public Order() {
    }

    public Order(String content, Date timestamp) {
        this.content = content;
        this.timestamp = timestamp;
    }

    public Order(String content, Date timestamp, int priority) {
        this.content = content;
        this.timestamp = timestamp;
        this.priority = priority;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	@Override
    public String toString() {
        return "Order{" +
                "content='" + content + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
    
}
