package net.umask.common.base.command;


public interface CommandHandler<R,T extends Command<R>> {

    Class<T> getType();

    R handleMessage(T command);
}
