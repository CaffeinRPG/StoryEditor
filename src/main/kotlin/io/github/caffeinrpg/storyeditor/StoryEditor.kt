package io.github.caffeinrpg.storyeditor

import org.bukkit.plugin.java.JavaPlugin

class StoryEditor : JavaPlugin()
{
    companion object
    {
        lateinit var plugin: StoryEditor
    }

    override fun onEnable()
    {
        plugin = this
    }
}