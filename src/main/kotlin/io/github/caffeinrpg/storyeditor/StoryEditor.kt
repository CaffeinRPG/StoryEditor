package io.github.caffeinrpg.storyeditor

class StoryEditor : AbstractStoryEditor()
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