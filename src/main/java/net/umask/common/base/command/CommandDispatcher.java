package net.umask.common.base.command;


public interface CommandDispatcher {
    public <R,T extends Command<R>> R dispatchCommand(T command);
}
