package ua.edu.ucu.tempseries;

final public class TempSummaryStatistics {

    double avgTemp;
    double devTemp;
    double minTemp;
    double maxTemp;

    public TempSummaryStatistics(double avgTemp, double devTemp,
                                 double minTemp, double maxTemp){
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.maxTemp = maxTemp;
        this.minTemp = minTemp;

    }

    public double getAvgTemp() {
        return avgTemp;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getDevTemp() {
        return devTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }
}

