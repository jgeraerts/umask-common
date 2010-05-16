package net.umask.common.base.command;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.unitils.easymock.annotation.Mock;
import org.unitils.easymock.EasyMockUnitils;
import org.unitils.UnitilsJUnit4TestClassRunner;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.isA;
import static com.google.common.collect.ImmutableList.of;
import com.google.common.collect.ImmutableList;


@RunWith(org.unitils.UnitilsJUnit4TestClassRunner.class)
public class CommandDispatcherTest {

    CommandDispatcher dispatcher;

    @Mock
    CommandHandler<Void,Command1> handler1;
    @Mock
    CommandHandler<Integer,Command2> handler2;



    @Before
    public void setUp(){

    }

    @Test
    public void testDispatchCommand() {
        expect(handler1.getType()).andReturn(Command1.class);
        expect(handler2.getType()).andReturn(Command2.class);
        expect(handler1.handleMessage(isA(Command1.class))).andReturn(null);
        EasyMockUnitils.replay();
        dispatcher=new CommandDispatcherImpl(ImmutableList.<CommandHandler>of(handler1,handler2));
        dispatcher.dispatchCommand(new Command1());
    }

    @Test(expected = IllegalStateException.class)
    public void testDispatchCommand_NoHandlerFound() {
        expect(handler1.getType()).andReturn(Command1.class);
        expect(handler2.getType()).andReturn(Command2.class);
        EasyMockUnitils.replay();
        dispatcher=new CommandDispatcherImpl(ImmutableList.<CommandHandler>of(handler1,handler2));
        dispatcher.dispatchCommand(new Command3());
    }

    private static class Command1 implements Command<Void>{}
    private static class Command2 implements Command<Integer>{}
    private static class Command3 implements Command<Integer>{}

}
