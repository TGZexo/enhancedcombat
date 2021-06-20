package net.mcreator.enhancedcombat.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;

import net.mcreator.enhancedcombat.EnhancedcombatModVariables;
import net.mcreator.enhancedcombat.EnhancedcombatModElements;
import net.mcreator.enhancedcombat.EnhancedcombatMod;

import java.util.Map;
import java.util.HashMap;

@EnhancedcombatModElements.ModElement.Tag
public class DashCooldownProcedureProcedure extends EnhancedcombatModElements.ModElement {
	public DashCooldownProcedureProcedure(EnhancedcombatModElements instance) {
		super(instance, 3);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EnhancedcombatMod.LOGGER.warn("Failed to load dependency entity for procedure DashCooldownProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((((entity.getCapability(EnhancedcombatModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EnhancedcombatModVariables.PlayerVariables())).DashCooldown) > 0)) {
			{
				double _setval = (double) (((entity.getCapability(EnhancedcombatModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new EnhancedcombatModVariables.PlayerVariables())).DashCooldown) - 0.05);
				entity.getCapability(EnhancedcombatModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DashCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if ((((entity.getCapability(EnhancedcombatModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new EnhancedcombatModVariables.PlayerVariables())).DashCooldown) < 0)) {
			{
				double _setval = (double) 0;
				entity.getCapability(EnhancedcombatModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.DashCooldown = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			Entity entity = event.player;
			World world = entity.world;
			double i = entity.getPosX();
			double j = entity.getPosY();
			double k = entity.getPosZ();
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", world);
			dependencies.put("entity", entity);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
