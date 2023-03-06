package com.tibame.tga105.room.dao;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomLikeRepository {

private static final String KEY_PREFIX = "room_like:";
    
    private RedisTemplate<String, String> redisTemplate;
    private HashOperations<String, String, String> hashOps;
    
    public RoomLikeRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOps = redisTemplate.opsForHash();
    }
    
    // 獲取房型的按讚數
    public long getRoomLikeCount(String roomName) {
        String count = hashOps.get(KEY_PREFIX + roomName, "count");
        return count == null ? 0L : Long.parseLong(count);
    }
    
    // 按讚
    public boolean likeRoom(String memberId, String roomName) {
        String key = KEY_PREFIX + roomName;
        if (hashOps.hasKey(key, memberId)) {
            // 會員已經按讚
            return false;
        } else {
            // 更新按讚數和會員清單
            hashOps.increment(key, "count", 1L);
            hashOps.put(key, memberId, "");
            return true;
        }
    }
    
 // 取消按讚
    public boolean deleteLikedRoom(String memberId, String roomName) {
        String key = KEY_PREFIX + roomName;
        if (hashOps.hasKey(key, memberId)) {
            // 刪除會員按讚記錄
            hashOps.delete(key, memberId);
            // 更新按讚數
            hashOps.increment(key, "count", -1L);
            return true;
        } else {
            // 會員未按讚
            return false;
        }
    }



}
