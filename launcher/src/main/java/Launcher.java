import org.emp.gl.gui.Board;
import org.emp.gl.gui.MainMenu;
import org.emp.gl.gui.Player;
import org.emp.gl.lookup.Lookup;
import org.emp.gl.time.service.impl.delegation.TimerServiceImplWithDelegation;
import org.emp.gl.timer.service.TimerService;

public class Launcher {
    static {
        // Lookup.getInstance().register(TimerService.class, new DummyTimeServiceImpl());
        Lookup.getInstance().register(TimerService.class, new TimerServiceImplWithDelegation());
        Lookup.getInstance().register(Board.class, new Board(10,10,10));
        Lookup.getInstance().register(Player.class, new Player(Lookup.getInstance().getService(Board.class)));
    }
        public static void main(String[] args){
            Board board=Lookup.getInstance().getService(Board.class);
            Player player=Lookup.getInstance().getService(Player.class);
            new MainMenu();
            TimerService ts=Lookup.getInstance().getService(TimerService.class);
            ts.addListener(player);

        }

}
