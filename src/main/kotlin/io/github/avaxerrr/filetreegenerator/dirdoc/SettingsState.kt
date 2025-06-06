// version 1.0.2

package io.github.avaxerrr.filetreegenerator.dirdoc

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

/**
 * Persistent settings state for the plugin
 */
@State(
    name = "com.filetreegenerator.dirdoc.SettingsState",
    storages = [Storage("FileTreeGeneratorSettings.xml")]
)
class SettingsState : PersistentStateComponent<SettingsState> {
    // Auto-update settings
    var autoUpdate: Boolean = false

    // Output settings
    var outputPath: String = ""
    var outputFileName: String = "directory-structure.md"

    // Content settings
    var includeHidden: Boolean = false
    var pythonFilesOnly: Boolean = true
    var includeTimestamp: Boolean = true
    var includeFileCount: Boolean = true
    var excludePatterns: String = "__pycache__, *.pyc, .git, .idea, venv"
    var maxDepth: Int = -1

    // Tree style setting
    var treeStyleOrdinal: Int = TreeStyle.SIMPLE.ordinal

    // Helper property to get/set the enum
    var treeStyle: TreeStyle
        get() = TreeStyle.values()[treeStyleOrdinal]
        set(value) { treeStyleOrdinal = value.ordinal }

    override fun getState(): SettingsState = this

    override fun loadState(state: SettingsState) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        fun getInstance(): SettingsState {
            return ApplicationManager.getApplication().getService(SettingsState::class.java)
        }
    }
}
