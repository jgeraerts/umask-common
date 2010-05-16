package net.umask.common.base.command;

import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class CommandHandlerTest {

    @Test
    public void testGetType(){
        assertEquals(Command1.class,new AbstractCommandHandler<Void,Command1>(){

            @Override
            public Void handleMessage(Command1 command) {
                return null;
            }
        }.getType());
    }

    private class Command1 implements Command<Void>{
    }
}
