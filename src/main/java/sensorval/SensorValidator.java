package sensorval;

import java.util.List;

public class SensorValidator 
{
    public static boolean isJumpFine(double value, double nextValue, double maxDelta) {
        if(nextValue - value > maxDelta) {
            return false;
        }
        return true;
    }
    public static boolean validateSOCreadings(List<Double> values) {
        return validateValuesForDelta(values, 0.05);
    }

    public static boolean validateCurrentreadings(List<Double> values) {
        return validateValuesForDelta(values, 0.1);
    }

    private static boolean validateValuesForDelta(
        List<Double> values,
        double delta
    )
    {
        if( values != null) {
            int lastButOneIndex = values.size() - 1;
            for (int i = 0; i < lastButOneIndex; i++) {
                if (!isJumpFine(values.get(i), values.get(i + 1), delta)) {
                    return false;
                }
            }
        }
        return true;
    }
}
