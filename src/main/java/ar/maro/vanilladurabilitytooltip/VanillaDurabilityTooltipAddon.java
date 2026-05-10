package ar.maro.vanilladurabilitytooltip;

import api.AddonHandler;
import api.BTWAddon;

public class VanillaDurabilityTooltipAddon extends BTWAddon {
    private static VanillaDurabilityTooltipAddon instance;

    public VanillaDurabilityTooltipAddon() {
        super();
    }

    @Override
    public void initialize() {
        AddonHandler.logMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
    }
}