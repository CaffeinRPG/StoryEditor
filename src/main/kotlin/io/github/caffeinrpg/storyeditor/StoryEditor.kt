package io.github.caffeinrpg.storyeditor

import dev.m1n1don.smartinvsr.inv.InventoryManager
import hazae41.minecraft.kutils.bukkit.init
import io.github.caffeinrpg.storyeditor.config.MainConfig
import io.github.caffeinrpg.storyeditor.table.Stories
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.io.File
import java.sql.Connection

class StoryEditor : AbstractStoryEditor()
{
    companion object
    {
        lateinit var plugin: StoryEditor
    }

    var invManager: InventoryManager? = null

    override fun onEnable()
    {
        plugin = this

        init(MainConfig)
        MainConfig.autoSave = true

        val dbFolder = File(dataFolder, "/database")
        if (!dbFolder.exists()) dbFolder.mkdirs()

        val dbFile = File(dataFolder, "/database/storyeditor.db")
        if (!dbFile.exists()) dbFile.createNewFile()

        Database.connect("jdbc:sqlite:${dbFile.path}", "org.sqlite.JDBC")
        TransactionManager.manager.defaultIsolationLevel = Connection.TRANSACTION_SERIALIZABLE

        transaction {
            addLogger(StdOutSqlLogger)

            SchemaUtils.create(
                Stories
            )
        }

        invManager = InventoryManager(this)
        invManager?.init()
    }
}