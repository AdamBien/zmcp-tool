package airhacks.zmcpt.boundary;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RuntimeInfoToolTest {
    
    @Test
    void invokeTool() {
        var tool = new RuntimeInfoTool();
        var response = tool.apply(null);
        assertThat(response).isNotNull().as("response should not be null");
        assertThat(response.get("content")).isNotNull().as("content should not be null");
        assertThat(response.get("error")).isNotNull().as("error should not be null");
    }
}
