package app;

public class SecondTaskMetrics {

    private final int n;

    public SecondTaskMetrics(FirstTaskMetrics firstTaskMetrics) {
        this.n = firstTaskMetrics.operandsMinCount();
    }

    public void output() {
        System.out.println("Параметры надежности ПО");
        System.out.println("Число модулей: " + String.format("%.2f", modulesCount()));
        System.out.println("Длина программы: " + String.format("%.2f", programLength()));
        System.out.println("Объем ПО: " + String.format("%.2f", softwareSize()));
        System.out.println("Количество команд ассемблера: " + String.format("%.2f", asmCommandsCount()));
        System.out.println("Календарное время программирования: " + String.format("%.2f", programmingTime()));
        System.out.println("Потенциальное количество ошибок: " + String.format("%.2f", potentialErrorsCount()));
        System.out.println("Время наработки на отказ: " + String.format("%.2f", timeToFailure()) + "\n");
    }

    private double modulesCount() {
        return ((n / 8.0) + (n / 64.0));
    }

    private double programLength() {
        double K = modulesCount();
        return (220 * K) + K * (Math.log(K) / Math.log(2));
    }

    private double softwareSize() {
        double K = modulesCount();
        return (200 * K) + K * (Math.log(K) / Math.log(2));
    }

    private double asmCommandsCount() {
        double N = programLength();
        return (3 * N) / 8;
    }

    private double programmingTime() {
        double N = programLength();
        int m = 10;
        int v = 15;
        return (3 * N) / (8 * m * v);
    }

    private double potentialErrorsCount() {
        return softwareSize() / 3000;
    }

    private double timeToFailure() {
        double T = programmingTime();
        double B = potentialErrorsCount();
        return (T * 8) / (2 * Math.log(B));
    }
}
