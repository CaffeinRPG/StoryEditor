package io.github.caffeinrpg.storyeditor.config

import hazae41.minecraft.kutils.bukkit.PluginConfigFile

object MainConfig : PluginConfigFile("config")
{
    var prefix by string("prefix")
}