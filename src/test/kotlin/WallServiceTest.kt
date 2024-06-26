package ru.netology

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class WallServiceTest {

    val post1 = Post(id = 1, text = "this is post #1")
    val post2 = Post(id = 2, text = "this is post #2")
    val post2New = Post(id = 1, text = "this is post #2NEW")
    val post3 = Post(id = 3, text = "this is post #3")

    @Before
    fun clearBeforeTest() {
        WallService.clear()
    }

    @Test
    fun add() {
        var tmpPost = WallService.add(post1)
        assertEquals(tmpPost.id, 0)
        assertEquals(tmpPost.text, "this is post #1")

        tmpPost = WallService.add(post2)
        assertEquals(tmpPost.id, 1)
        assertEquals(tmpPost.text, "this is post #2")

        tmpPost = WallService.add(post3)
        assertEquals(tmpPost.id, 2)
        assertEquals(tmpPost.text, "this is post #3")
    }

    @Test
    fun update() {
        WallService.add(post1)
        WallService.add(post2)
        assertEquals(WallService.update(post3), false)
        assertEquals(WallService.update(post2New), true)
    }
}