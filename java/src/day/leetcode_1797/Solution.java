package day.leetcode_1797;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//generate调用tokenID是唯一的
//方法一，时间表现不佳，空间表现良好
//方法二，LRS思想，建立链表记录时间
class Solution {
	public int timeToLive = 0;
    public HashMap<String,Integer> timeTable ;
    public Solution(int timeToLive) {
        this.timeToLive = timeToLive;
        this.timeTable = new HashMap<>();
    }
    public void generate(String tokenId, int currentTime) {
    	this.timeTable.put(tokenId, currentTime+this.timeToLive);
    }
    public void renew(String tokenId, int currentTime) {
    	if(this.timeTable.containsKey(tokenId))
    	{
    		if(this.timeTable.get(tokenId)>currentTime)
    			this.timeTable.put(tokenId, currentTime+this.timeToLive);
    		else 
    			this.timeTable.remove(tokenId);
    	}
    }
    public int countUnexpiredTokens(int currentTime) {
        List<String> temp = new ArrayList<String>();
    	for(String str: this.timeTable.keySet())
    	{
    		if(this.timeTable.get(str)<=currentTime)
    			temp.add(str);
    	}
        for(String str: temp)
            this.timeTable.remove(str);
    	return this.timeTable.size();
    }
}
class AuthenticationManager {
    int timeToLive;
    Node head;
    Node tail;
    Map<String, Node> map;

    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        this.head = new Node(-1);
        this.tail = new Node(-1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
        this.map = new HashMap<String, Node>();
    }

    public void generate(String tokenId, int currentTime) {
        Node node = new Node(currentTime + timeToLive, tokenId);
        map.put(tokenId, node);
        Node last = tail.prev;
        last.next = node;
        node.prev = last;
        tail.prev = node;
        node.next = tail;
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId).expire > currentTime) {
            Node node = map.get(tokenId);
            Node prev = node.prev;
            Node next = node.next;
            prev.next = next;
            next.prev = prev;
            node.expire = currentTime + timeToLive;
            Node last = tail.prev;
            last.next = node;
            node.prev = last;
            tail.prev = node;
            node.next = tail;
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (head.next.expire > 0 && head.next.expire <= currentTime) {
            Node node = head.next;
            map.remove(node.key);
            head.next = node.next;
            node.next.prev = head;
        }
        return map.size();
    }
}

class Node {
    int expire;
    String key;
    Node prev;
    Node next;

    public Node(int expire) {
        this(expire, null, null, null);
    }

    public Node(int expire, String key) {
        this(expire, key, null, null);
    }

    public Node(int expire, String key, Node prev, Node next) {
        this.expire = expire;
        this.key = key;
        this.prev = prev;
        this.next = next;
    }
}
/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */
