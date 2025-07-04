package airhacks.zmcpt.boundary;

import java.util.Map;
import java.util.function.Function;

import airhacks.zmcpt.entity.ToolResponse;

public class RuntimeInfoTool implements Function<String, Map<String, String>> {

    /**
     * A TOOL_SPEC attribute has to exist in every tool implementation.
     * It is used to describe the tool's input parameters and its behavior and is fetched by zmcp via reflection.
     */
    static Map<String, String> TOOL_SPEC = ToolSpec.SINGLE_REQUIRED_PARAMETER;

    /**
     * The apply method is the entry point for the tool.
     * It is called by zmcp when the tool is invoked.
     * The parameter is the input parameter and is usually in JSON format.
     * The return value is a map of key-value pairs with predefined keys.
     */
    @Override
    public Map<String, String> apply(String parameter) {
        var memoryStatus = """
                Memory Status:
                Free Memory: %s
                Total Memory: %s
                Max Memory: %s
                """.formatted(freeMemory(), totalMemory(), maxMemory());
        return ToolResponse.success(memoryStatus).toMap();
    }

    /**
     * Returns the free memory available to the JVM in MB
     * @return
     */
    String freeMemory(){
        return toMB(Runtime.getRuntime().freeMemory());
    }

    /**
     * Returns the total memory available to the JVM in MB
     * @return
     */
    String totalMemory(){
        return toMB(Runtime.getRuntime().totalMemory());
    }

    /**
     * Returns the maximum memory available to the JVM in MB
     * @return
     */
    String maxMemory(){
        return toMB(Runtime.getRuntime().maxMemory());
    }

    String toMB(long bytes){
        return String.valueOf(bytes / 1024 / 1024 + " MB");
    }
}
