package airhacks.zmcpt.boundary;

import java.util.Map;

public interface ToolSpec {
    Map<String,String> SINGLE_REQUIRED_PARAMETER =              Map.of(
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
}
