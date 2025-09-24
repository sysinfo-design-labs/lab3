package app;

public class FirstTaskMetrics {
    private final int targetsCount;
    private final int measurementsCountPerTarget;
    private final int parametersCountPerTarget;
    private final int outputsCountPerTarget;
    private final double languageLevel;

    public FirstTaskMetrics(
            int targetsCount,
            int measurementsCountPerTarget,
            int parametersCountPerTarget,
            int outputsCountPerTarget,
            double languageLevel
    ) {
        this.targetsCount = targetsCount;
        this.measurementsCountPerTarget = measurementsCountPerTarget;
        this.parametersCountPerTarget = parametersCountPerTarget;
        this.outputsCountPerTarget = outputsCountPerTarget;
        this.languageLevel = languageLevel;
    }

    public void output() {
        System.out.println("Метрики Холстеда");
        System.out.println("Потенциальный объем программы: " + String.format("%.2f", programSizeCount()));
        System.out.println("Уровень языка программировния: " + languageLevel);
        System.out.println("Потенциальное количество ошибок: " + String.format("%.2f", potentialErrorsCount()) + "\n");
    }

    public int operandsMinCount() {
        return (targetsCount * measurementsCountPerTarget * parametersCountPerTarget) +
                (targetsCount * outputsCountPerTarget);
    }

    private double programSizeCount() {
        int n = operandsMinCount();
        return (n + 2) * (Math.log(n + 2) / Math.log(2));
    }

    private double potentialErrorsCount() {
        double V = programSizeCount();
        return (V * V) / (3000 * languageLevel);
    }
}
