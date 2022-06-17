package io.github.caffeinrpg.storyeditor.story

import io.github.caffeinrpg.storyeditor.table.Stories
import org.bukkit.entity.Player

class StoryManager
{
    companion object
    {
        private var instance: StoryManager? = null

        fun getInstance(): StoryManager
        {
            if (instance == null)
                instance = StoryManager()

            return instance!!
        }
    }

    val stories: MutableMap<Int, Story> = mutableMapOf()
    val playing: MutableMap<Player, Stories> = mutableMapOf()

    fun createStory(title: String): Story?
    {
        TODO()
    }

    fun deleteStory(story: Story)
    {
        TODO()
    }

    fun addword(story: Story, line: Int, word: String): Story?
    {
        TODO()
    }

    fun addCommand(story: Story, command: String): Story?
    {
        TODO()
    }

    fun playStory(story: Story, target: Player)
    {
        TODO()
    }

    fun stopStory(target: Player)
    {
        TODO()
    }
}