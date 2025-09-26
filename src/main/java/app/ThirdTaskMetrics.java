package app;

public class ThirdTaskMetrics {
    private final int startRating;
    private final double languageLevel;
    private final int programsCount;
    private final int[] programsSize;
    private final int[] errorsPerProgram;
    private final int nextProgramSize;

    public  ThirdTaskMetrics(
            int startRating,
            double languageLevel,
            int programsCount,
            int[] programsSize,
            int[] errorsPerProgram,
            int nextProgramSize
    ) {
        this.startRating = startRating;
        this.languageLevel = languageLevel;
        this.programsCount = programsCount;
        this.programsSize = programsSize;
        this.errorsPerProgram = errorsPerProgram;
        this.nextProgramSize = nextProgramSize;
    }

    public void output() {
        double R1 = calculateRating(1);
        double R2 = calculateRating(2);
        double R3 = calculateRating(3);
        System.out.println("Текущий рейтинг программиста и число ожидаемых ошибок");
        System.out.println("Коэффициент: 1 / (lam + R)");
        System.out.println("Рейтинг программиста: " + R1);
        System.out.println("Ожидаемое число ошибок: " + expectedErrorsCount(R1, 1) + "\n");
        System.out.println("Коэффициент: 1 / (lam * R)");
        System.out.println("Рейтинг программиста: " + R2);
        System.out.println("Ожидаемое число ошибок: " + expectedErrorsCount(R2, 2)  + "\n");
        System.out.println("Коэффициент: (1 / lam) + (1 / R)");
        System.out.println("Рейтинг программиста: " + String.format("%.2f", R3));
        System.out.println("Ожидаемое число ошибок: " + String.format("%.2f", expectedErrorsCount(R3, 3)));
    }

    private double calculateRating(int mode) {
        double R = startRating;
        int sumV = totalProgramsSize();
        for (int i = 0; i < programsCount; i++) {
            double sumB = 0.0;
            double coefficient = coefficientVariant(R, mode);

            for (int j = 0; j < errorsPerProgram.length; j++) {
                if (errorsPerProgram[j] != 0) {
                    sumB += errorsPerProgram[j] / coefficient;
                }
            }

            R = R * (1 + Math.pow(10, -3) * (sumV - sumB));
        }
        return R;
    }

    private double expectedErrorsCount(double R, int mode) {
        double coefficient = coefficientVariant(R, mode);
        return coefficient * nextProgramSize;
    }

    private int totalProgramsSize() {
        int result = 0;
        for (int i = 0; i < programsCount; i++) {
            result += programsSize[i];
        }
        return result;
    }

    private double coefficientVariant(double R, int mode) {
        return switch (mode) {
            case 1 -> 1.0 / (languageLevel + R);
            case 2 -> 1.0 / (languageLevel * R);
            case 3 -> (1.0 / languageLevel) + (1.0 / R);
            default -> throw new IllegalArgumentException("Unknown mode");
        };
    }
}
