package com.example.pycharmfilestructuregenerate.dirdoc

import com.intellij.ui.components.JBCheckBox
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBTextField
import com.intellij.util.ui.FormBuilder
import javax.swing.JComponent
import javax.swing.JPanel

/**
 * UI component for the plugin settings
 */
class SettingsComponent {
    private val panel: JPanel
    private val chkAutoUpdate = JBCheckBox("Automatically update when files change")
    private val txtOutputPath = JBTextField()
    private val txtOutputFileName = JBTextField()
    private val chkIncludeHidden = JBCheckBox("Include hidden files")
    private val chkPythonOnly = JBCheckBox("Show Python files only")
    private val chkIncludeTimestamp = JBCheckBox("Include timestamp")
    private val chkIncludeFileCount = JBCheckBox("Include file counts")
    private val txtExcludePatterns = JBTextField()
    private val txtMaxDepth = JBTextField()

    init {
        panel = FormBuilder.createFormBuilder()
            .addComponent(JBLabel("Auto-Update Settings"))
            .addComponent(chkAutoUpdate)
            .addSeparator()
            .addComponent(JBLabel("Output Settings"))
            .addLabeledComponent("Output Path:", txtOutputPath, 1, false)
            .addLabeledComponent("Output File Name:", txtOutputFileName, 1, false)
            .addSeparator()
            .addComponent(JBLabel("Content Settings"))
            .addComponent(chkIncludeHidden)
            .addComponent(chkPythonOnly)
            .addComponent(chkIncludeTimestamp)
            .addComponent(chkIncludeFileCount)
            .addLabeledComponent("Exclude Patterns (comma separated):", txtExcludePatterns, 1, false)
            .addLabeledComponent("Max Depth (-1 = unlimited):", txtMaxDepth, 1, false)
            .addComponentFillVertically(JPanel(), 0)
            .panel
    }

    fun getPanel(): JComponent = panel

    fun getPreferredFocusedComponent(): JComponent = txtOutputPath

    // Getters
    val isAutoUpdateEnabled: Boolean get() = chkAutoUpdate.isSelected
    val outputPath: String get() = txtOutputPath.text
    val outputFileName: String get() = txtOutputFileName.text
    val includeHidden: Boolean get() = chkIncludeHidden.isSelected
    val pythonFilesOnly: Boolean get() = chkPythonOnly.isSelected
    val includeTimestamp: Boolean get() = chkIncludeTimestamp.isSelected
    val includeFileCount: Boolean get() = chkIncludeFileCount.isSelected
    val excludePatterns: String get() = txtExcludePatterns.text
    val maxDepth: Int get() =
        try { txtMaxDepth.text.toInt() }
        catch (e: NumberFormatException) { -1 }

    // Setters
    fun setAutoUpdateEnabled(newStatus: Boolean) {
        chkAutoUpdate.isSelected = newStatus
    }

    fun setOutputPath(newPath: String) {
        txtOutputPath.text = newPath
    }

    fun setOutputFileName(newName: String) {
        txtOutputFileName.text = newName
    }

    fun setIncludeHidden(newValue: Boolean) {
        chkIncludeHidden.isSelected = newValue
    }

    fun setPythonFilesOnly(newValue: Boolean) {
        chkPythonOnly.isSelected = newValue
    }

    fun setIncludeTimestamp(newValue: Boolean) {
        chkIncludeTimestamp.isSelected = newValue
    }

    fun setIncludeFileCount(newValue: Boolean) {
        chkIncludeFileCount.isSelected = newValue
    }

    fun setExcludePatterns(newPatterns: String) {
        txtExcludePatterns.text = newPatterns
    }

    fun setMaxDepth(newDepth: Int) {
        txtMaxDepth.text = newDepth.toString()
    }
}
