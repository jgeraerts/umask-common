package net.umask.common.base.command;

import net.umask.common.base.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;

public abstract class AbstractCommandHandler<R,T extends Command<R>> implements CommandHandler<R,T> {
    private Class<T> commandType;

    @Autowired
    private Repository repository;

    @SuppressWarnings({"unchecked"})
    public AbstractCommandHandler() {
        this.commandType = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public Class<T> getType() {
        return commandType;
    }

    protected Repository getRepository() {
        return repository;
    }
}
