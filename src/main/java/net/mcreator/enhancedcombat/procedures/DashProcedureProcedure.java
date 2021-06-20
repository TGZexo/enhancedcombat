package net.mcreator.enhancedcombat.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.enhancedcombat.EnhancedcombatModElements;
import net.mcreator.enhancedcombat.EnhancedcombatMod;

import java.util.Map;

@EnhancedcombatModElements.ModElement.Tag
public class DashProcedureProcedure extends EnhancedcombatModElements.ModElement {
	public DashProcedureProcedure(EnhancedcombatModElements instance) {
		super(instance, 1);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				EnhancedcombatMod.LOGGER.warn("Failed to load dependency entity for procedure DashProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double XVel = 0;
		double ZVel = 0;
		if (((entity.getMotion().getX()) == 0)) {
			XVel = (double) 0;
		} else if (((entity.getMotion().getX()) > 0)) {
			XVel = (double) 1;
		} else {
			XVel = (double) (-1);
		}
		if (((entity.getMotion().getZ()) == 0)) {
			ZVel = (double) 0;
		} else if (((entity.getMotion().getZ()) > 0)) {
			ZVel = (double) 1;
		} else {
			ZVel = (double) (-1);
		}
		entity.setMotion(((entity.getMotion().getX()) + (XVel)), ((entity.getMotion().getY()) + 1), ((entity.getMotion().getZ()) + (ZVel)));
	}
}
