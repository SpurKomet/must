package de.spurkomet.gamemode

import de.spurkomet.gamemode.build.buildTestCommandClass
import de.spurkomet.gamemode.build.listener
import net.axay.kspigot.chat.col
import net.axay.kspigot.main.KSpigot


class InternalMainClass : KSpigot(){
    companion object {
        lateinit var INSTANCE: InternalMainClass; private set
    }
    override fun load() {
        INSTANCE = this
    }
    override fun startup() {
        listener()
        buildTestCommandClass()
    }
    override fun shutdown() {
    }
}
fun prefix(): String{
    return "${col("dark_gray")}[${col("aqua")}Gamemode${col("dark_gray")}] ${col("white")}"
}