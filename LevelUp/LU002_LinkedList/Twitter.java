import java.util.*;

public class Twitter {
    private class Node{
        int uId;
        int tId;
        Node next = null;
        
        Node(int uId , int tId){
            this.uId = uId;
            this.tId = tId;
        }
    }
    
    private HashMap<Integer, List<Integer>> map = new HashMap<>();
    private Node head = null;
    
    public Twitter() {
        
    }
    
    
    private void addFirst(Node node){
        if(this.head==null){
            this.head = node;
        }else{
            node.next = this.head;
            this.head = node;
        }
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Node node = new Node(userId,tweetId);
        addFirst(node);
    }
    
    
    
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> array = new ArrayList<>();
        List<Integer> newsFeed = new ArrayList<>();
        
        if(map.containsKey(userId)){
            array.addAll(map.get(userId));
        }
        
        array.add(userId);
        
        Node curr = head;
        
        while(curr!=null){
            if(array.contains(curr.uId)){
                newsFeed.add(curr.tId);
            }
            
            if(newsFeed.size()==10) break;
            
            curr = curr.next;
        }
        
        return newsFeed;
    }
    
    
    
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        
        if(map.containsKey(followerId)){
            List<Integer> following = map.get(followerId);
            
            following.add(followeeId);
            map.put(followerId,following); 
        }else{
            List<Integer> following = new ArrayList<Integer>();
            following.add(followeeId);
            map.put(followerId,following);
        }
        
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        
       if(map.containsKey(followerId)){
           List<Integer> following = map.get(followerId);
           following.remove(new Integer(followeeId));
           map.put(followerId,following);
       }
        
    } 
}
