//import java.util.*;
//
//public class Twitter {
//    Map<Integer, HashSet<Integer>> followerMap;
//    Map<Integer, HashSet<Integer>> tweetsMap;
//
//    public Twitter() {
//        followerMap = new HashMap<>();
//        tweetsMap = new HashMap<>();
//    }
//
//    public void postTweet(int userId, int tweetId) {
//        HashSet<Integer> ls;
//        if (tweetsMap.containsKey(userId)) {
//            ls = tweetsMap.get(userId);
//        } else {
//            ls = new HashSet<Integer>();
//        }
//        ls.add(tweetId);
//        tweetsMap.put(userId, ls);
//    }
//
//    public List<Integer> getNewsFeed(int userId) {
//        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
//        HashSet<Integer> tweets = new HashSet<Integer>();
//        tweets = tweetsMap.get(userId);
//        HashSet<Integer> followerList = followerMap.get(userId);
//        if(followerList!=null){
//            for (int followerId : followerList) {
//                tweets.addAll(tweetsMap.get(followerId));
//            }
//        }
//        if(followerList!=null){
//            pq.addAll(tweets);
//            tweets.clear();
//            int i = 10;
//            int size=pq.size();
//            while (i > 0 && size!=0) {
//                tweets.add(pq.poll());
//                i--;
//                size--;
//            }
//        }
//
//
//        return new ArrayList<>(tweets);
//    }
//
//    public void follow(int followerId, int followeeId) {
//        if (!followerMap.containsKey(followerId)) {
//            HashSet<Integer> ls = new HashSet<Integer>();
//            ls.add(followeeId);
//            followerMap.put(followerId, ls);
//        }
//
//
//    }
//
//    public void unfollow(int followerId, int followeeId) {
//        if (followerMap.containsKey(followerId)) {
//            HashSet<Integer> ls = followerMap.get(followerId);
//            ls.remove(followeeId);
//            followerMap.put(followerId, ls);
//
//        }
//
//    }
//}
//
//class MaxTime {
//    long tweetTime;
//    int tweetId;
//
//    public MaxTime(long tweetTime,int tweetId) {
//        this.tweetTime = tweetTime;
//        this.tweetId = tweetId;
//    }
//}
//
//class CompareMaxTime implements Comparator<MaxTime> {
//
//    @Override
//    public int compare(MaxTime o1, MaxTime o2) {
//        return   Long.compare(o1.tweetTime, o2.tweetTime);
//    }
//}
//
//
///**
// * Your Twitter object will be instantiated and called as such:
// * Twitter obj = new Twitter();
// * obj.postTweet(userId,tweetId);
// * List<Integer> param_2 = obj.getNewsFeed(userId);
// * obj.follow(followerId,followeeId);
// * obj.unfollow(followerId,followeeId);
// */