package com.company.course_schedule

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        if (prerequisites.isEmpty())
            return true
        val courses = (0 until numCourses).map { Course(it) }
        for (p in prerequisites)
            courses[p[0]].addLink(courses[p[1]])
        for (course in courses) {
            val result = helper(courses.first(), emptySet())
            if (!result)
                return result
        }
        return true
    }

    private fun helper(course: Course, visited: Set<Course>): Boolean {
        if (course in visited)
            return false
        for (c in course.links) {
            val result = helper(c, visited + course)
            if (!result)
                return false
        }
        return true
    }

    class Course(val id: Int, val links: MutableSet<Course> = mutableSetOf()) {
        fun addLink(link: Course) {
            links.add(link)
        }
    }
}

fun main() {
    Solution().apply {
        println(canFinish(2, arrayOf(intArrayOf(1, 0))))
        println(canFinish(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))
        println(
            canFinish(4, arrayOf(
                    intArrayOf(2, 0),
                    intArrayOf(1, 0),
                    intArrayOf(3, 1),
                    intArrayOf(3, 2),
                    intArrayOf(1, 3)
                )
            )
        )
    }
}