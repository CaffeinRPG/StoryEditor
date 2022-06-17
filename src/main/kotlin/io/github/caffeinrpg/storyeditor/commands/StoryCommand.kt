package io.github.caffeinrpg.storyeditor.commands

import hazae41.minecraft.kutils.bukkit.msg
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class StoryCommand : CommandExecutor
{
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean
    {
        if (args.isEmpty() || args[0] == "help")
        {
            sender.msg("Commands List")
            return true
        }

        when (args[0])
        {
            "create" -> {
            }

            "delete" -> {
            }

            "addword" -> {
            }

            "edit" -> {
            }

            "command", "cmd" -> {
            }

            "list" -> {
            }

            "play" -> {
            }

            "stop" -> {
            }
        }
        return true
    }
}