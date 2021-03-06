package org.hexworks.zircon.examples.components

import org.hexworks.zircon.api.*
import org.hexworks.zircon.api.graphics.BoxType

object RadioButtonGroupsExample {

    private val theme = ColorThemes.ghostOfAChance()
    private val tileset = CP437TilesetResources.cheepicus16x16()

    @JvmStatic
    fun main(args: Array<String>) {

        val tileGrid = SwingApplications.startTileGrid(AppConfigs.newConfig()
                .withDefaultTileset(tileset)
                .withSize(Sizes.create(60, 30))
                .build())

        val screen = Screens.createScreenFor(tileGrid)

        val panel = Components.panel()
                .wrapWithBox(true)
                .withSize(Sizes.create(28, 28))
                .withPosition(Positions.create(31, 1))
                .build()
        screen.addComponent(panel)

        val simpleRadioButtonGroup0 = Components.radioButtonGroup()
                .withPosition(Positions.create(2, 2))
                .withSize(Sizes.create(14, 3))
                .build()
        val simpleRadioButtonGroup1 = Components.radioButtonGroup()
                .withPosition(Positions.create(0, 0))
                .withSize(Sizes.create(14, 3))
                .build()

        listOf(simpleRadioButtonGroup0, simpleRadioButtonGroup1).forEach {
            it.addOption("key0", "First")
            it.addOption("key1", "Second")
            it.addOption("key2", "Third")
        }

        screen.addComponent(simpleRadioButtonGroup0)
        panel.addComponent(simpleRadioButtonGroup1)

        val decoratedRadioButtonGroup0 = Components.radioButtonGroup()
                .withBoxType(BoxType.DOUBLE)
                .wrapWithShadow(true)
                .wrapWithBox(true)
                .withSize(Sizes.create(14, 3))
                .withPosition(Positions.create(2, 8))
                .build()
        val decoratedRadioButtonGroup1 = Components.radioButtonGroup()
                .withBoxType(BoxType.DOUBLE)
                .wrapWithShadow(true)
                .wrapWithBox(true)
                .withSize(Sizes.create(14, 3))
                .withPosition(Positions.create(0, 6))
                .build()

        screen.addComponent(decoratedRadioButtonGroup0)
        panel.addComponent(decoratedRadioButtonGroup1)

        listOf(decoratedRadioButtonGroup0, decoratedRadioButtonGroup1).forEach {
            it.addOption("key0", "First")
            it.addOption("key1", "Second")
            it.addOption("key2", "Third")
        }


        screen.display()
        screen.applyColorTheme(theme)
    }

}
