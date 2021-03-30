package sensorval;

import java.util.List;
import java.util.Optional;

public class SensorValidator {

    public static boolean isJumpFine(
        double value,
        double nextValue,
        double maxDelta
    )
    {
        if (nextValue - value > maxDelta) {
            return false;
        }
        return true;
    }

    public static boolean validateSOCreadings(List<Double> values) {
        return validateValuesForDelta(
            Optional.of(values).orElseThrow(() -> new RuntimeException("Null list provided")),
            0.05
        );
    }

    public static boolean validateCurrentreadings(List<Double> values) {
        return validateValuesForDelta(
            Optional.of(values).orElseThrow(() -> new RuntimeException("Null list provided")),
            0.1
        );
    }

    private static boolean validateValuesForDelta(
        List<Double> values,
        double delta
    )
    {
        int lastButOneIndex = values.size() - 1;
        for (int i = 0; i < lastButOneIndex; i++) {
            if (!isJumpFine(values.get(i), values.get(i + 1), delta)) {
                return false;
            }
        }
        return true;
    }
}
