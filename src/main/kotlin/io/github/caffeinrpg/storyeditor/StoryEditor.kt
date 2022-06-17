package io.github.caffeinrpg.storyeditor

import hazae41.minecraft.kutils.bukkit.init
import io.github.caffeinrpg.storyeditor.config.MainConfig

class StoryEditor : AbstractStoryEditor()
{
    companion object
    {
        lateinit var plugin: StoryEditor
    }

    override fun onEnable()
    {
        plugin = this

        init(MainConfig)
        MainConfig.autoSave = true
    }
}