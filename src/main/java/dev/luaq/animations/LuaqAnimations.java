package dev.luaq.animations;

import dev.luaq.animations.command.FastToggle;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = "animations", version = "1.1")
public class LuaqAnimations {
    @Mod.Instance
    public static LuaqAnimations instance;

    private boolean enabled = true;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new FastToggle());
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
