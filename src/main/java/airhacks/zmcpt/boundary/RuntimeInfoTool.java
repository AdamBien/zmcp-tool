package airhacks.zmcpt.boundary;

import java.util.Map;
import java.util.function.Function;

public class RuntimeInfoTool implements Function<String, Map<String, String>> {
    static Map<String, String> TOOL_SPEC = Map.of(
            "name", "RuntimeInfoTool",
            "description", "returns server's runtime metrics",
            "inputSchema", """
                    {
                        "type": "object",
                        "properties": {
                            "input": {
                                "type": "string"
                            }
                        },
                        "required": ["input"]
                    }
            """);

    @Override
    public Map<String, String> apply(String parameter) {
        return Map.of();
    }

}
