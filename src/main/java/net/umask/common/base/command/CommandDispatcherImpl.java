package net.umask.common.base.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CommandDispatcherImpl implements CommandDispatcher {

    private final Map<Class, CommandHandler> handlers = new HashMap<Class, CommandHandler>();

    @Autowired
    public CommandDispatcherImpl(List<CommandHandler> handlers) {

        for (CommandHandler handler : handlers) {
            this.handlers.put(handler.getType(), handler);
        }


    }

    public <R,T extends Command<R>> R dispatchCommand(T command) {
        CommandHandler handler = this.handlers.get(command.getClass());
        if (handler == null) {
            throw new IllegalStateException("No handler for command of class " + command.getClass().getName());
        }
        //noinspection unchecked
        return (R) handler.handleMessage(command);
    }
}