package de.spurkomet.must

import de.spurkomet.must.buildWall.buildTestCommandClass
import de.spurkomet.must.buildWall.listener
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
    return "${col("dark_gray")}[${col("aqua")}must${col("dark_gray")}] ${col("white")}"
}