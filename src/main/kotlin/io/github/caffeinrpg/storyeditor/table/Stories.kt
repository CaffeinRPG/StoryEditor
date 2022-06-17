package io.github.caffeinrpg.storyeditor.table

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object Stories : Table()
{
    val id: Column<Int> = integer("id").autoIncrement()
    override val primaryKey = PrimaryKey(id)

    val title: Column<String> = text("title")

    val content: Column<String> = text("content")

    val command: Column<String> = text("command")
}