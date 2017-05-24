package yunxin;

import org.json.JSONObject;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GroupTest {
    @Test
    public void shouldReturn200WhenCreateGroup() throws Exception {
        Group group = new Group("boydfd");
        JSONObject newGroup = group.create("[\"boydfd\", \"boydfd1\"]");
        assertEquals(200, newGroup.get("code"));
    }
}
