package io.github.caffeinrpg.storyeditor.story

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
}