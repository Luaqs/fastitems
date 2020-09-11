package dev.luaq.animations.command;

import dev.luaq.animations.LuaqAnimations;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

import java.util.ArrayList;
import java.util.List;

public class FastToggle implements ICommand {
    @Override
    public String getCommandName() {
        return "fastitems";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/fastitems";
    }

    @Override
    public List<String> getCommandAliases() {
        return new ArrayList<>();
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        LuaqAnimations fastItems = LuaqAnimations.instance;

        // toggle fast items
        boolean isEnabled = !fastItems.isEnabled();
        fastItems.setEnabled(isEnabled);

        // notify the user
        Minecraft minecraft = Minecraft.getMinecraft();
        minecraft.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§7You toggled fast items " + (isEnabled ? "§aon" : "§coff")));
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> addTabCompletionOptions(ICommandSender sender, String[] args, BlockPos pos) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
}
