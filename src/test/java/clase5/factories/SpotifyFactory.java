package clase5.factories;

import org.testng.annotations.Factory;

public class SpotifyFactory {

    @Factory
    public Object[] spotyfyFactory() {

        return new Object[] {
                new SpotifyTest("test@test.com"),
                new SpotifyTest("prb@prb.com"),
                new SpotifyTest("fact@fact.com")
        };
    }
}
