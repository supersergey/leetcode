package com.company.lru

class LRUCache(val capacity: Int) {
    private val map = linkedMapOf<Int, Int>()

    fun get(key: Int): Int {
        val v = map[key]
        if (v != null) {
            map.remove(key)
            map[key] = v
        }
        return map[key] ?: -1
    }

    fun put(key: Int, value: Int) {
        if (map.size == capacity && map[key] == null) {
            map.remove(map.entries.first().key)
        }
        map.remove(key)
        map[key] = value
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */

fun main() {
    var cache = LRUCache(2 /* capacity */)
    cache.put(2, 1)
    cache.put(1, 1)
    cache.put(2, 3)
    cache.put(4, 1)
    println(cache.get(1))
    println(cache.get(2))

//    cache = LRUCache(2 /* capacity */)
//    println(cache.get(2))
//    cache.put(2, 6)
//    println(cache.get(1))
//    cache.put(1, 5)
//    cache.put(1, 2)
//    println(cache.get(1))
//    println(cache.get(2))
    //-1
    //-1
    //2
    //6

}