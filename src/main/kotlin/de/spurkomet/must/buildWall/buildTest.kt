package de.spurkomet.must.buildWall

import net.axay.kspigot.commands.command
import net.axay.kspigot.commands.runs
import net.axay.kspigot.event.listen
import net.axay.kspigot.extensions.bukkit.getHandItem
import net.axay.kspigot.items.itemStack
import net.axay.kspigot.items.meta
import org.bukkit.Material
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.inventory.EquipmentSlot

class buildTestCommandClass{
    val buildTestCommand = command("build"){
        runs {
            this.player.inventory.setItem(1, itemStack(Material.CARROT_ON_A_STICK){
                durability = 19
                meta {
                    isUnbreakable = true

                }
            })
        }
    }
}

fun listener(){
    listen<PlayerInteractEvent> {
        val WorldSetType = it.player.world
        val playerLoc = it.player.location
        val player = it.player
        if (player.getHandItem(EquipmentSlot.HAND) == itemStack(Material.CARROT_ON_A_STICK){durability = 19; meta { isUnbreakable = true }}){
            if (playerLoc.yaw > -45 && playerLoc.yaw < 45){
                println(playerLoc.yaw)
                for (wall in playerLoc.blockZ+1 .. playerLoc.blockZ+10){
                    for (hight in playerLoc.blockY .. playerLoc.blockY+3){
                        WorldSetType.setType(playerLoc.blockX, hight, wall, Material.BEDROCK)
                    }
                }
            }else if (playerLoc.yaw > 45 && playerLoc.yaw < 135){
                println(playerLoc.yaw)
                for (wall in playerLoc.blockX-1 downTo playerLoc.blockX-10){
                    for (hight in playerLoc.blockY .. playerLoc.blockY+3){
                        WorldSetType.setType(wall, hight, playerLoc.blockZ, Material.BEDROCK)
                    }
                }
            }
            else if (playerLoc.yaw > -135 && playerLoc.yaw < -45){
                println("else")
                for (wall in playerLoc.blockX+1 .. playerLoc.blockX+10){
                    for (hight in playerLoc.blockY .. playerLoc.blockY+3){
                        WorldSetType.setType(wall, hight, playerLoc.blockZ, Material.BEDROCK)
                    }
                }
            }
            else{
                println(playerLoc.yaw)
                for (wall in playerLoc.blockZ-1 downTo playerLoc.blockZ-10){
                    for (hight in playerLoc.blockY .. playerLoc.blockY+3){
                        WorldSetType.setType(playerLoc.blockX, hight, wall, Material.BEDROCK)
                    }
                }
            }
        }
    }
}