package part1;


public class wineInstance {

    public double Alcohol;
    public double MalicAcid;
    public double Ash;
    public double AshAlcalinity;
    public double Magnesium;
    public double TotalPhenols;
    public double Flavanoids;
    public double NonFlavavnoidPhenols;
    public double Proanthocyanins;
    public double ColorIntensity;
    public double Hue;
    public double DilutedWinesOD;
    public double Proline;
    public double Class;


    public wineInstance () {

    }

    public double getAlcohol(){ return Alcohol; }

    public double getMalicAcid() {
        return MalicAcid;
    }

    public double getAsh(){
        return Ash;
    }

    public double getAshAlcalinity(){
        return AshAlcalinity;
    }

    public double getMagnesium(){
        return Magnesium;
    }

    public double getTotalPhenols(){
        return TotalPhenols;
    }

    public double getFlavanoids(){
        return Flavanoids;
    }

    public double getNonFlavavnoidPhenols() {
        return NonFlavavnoidPhenols;
    }

    public double getProanthocyanins() {
        return Proanthocyanins;
    }

    public double getColorIntensity() {
        return ColorIntensity;
    }

    public double getHue() {
        return Hue;
    }

    public double getDilutedWinesOD() {
        return DilutedWinesOD;
    }

    public double getProline() {
        return Proline;
    }

    public double classGet() {
        return Class;
    }

    @Override
    public String toString() {
        return  "wineInstance{" +
                "Alcohol=" + Alcohol +
                ", MalicAcid=" + MalicAcid +
                ", Ash=" + Ash +
                ", AshAlcalinity=" + AshAlcalinity +
                ", Magnesium=" + Magnesium +
                ", TotalPhenols=" + TotalPhenols +
                ", Flavanoids=" + Flavanoids +
                ", NonFlavavnoidPhenols=" + NonFlavavnoidPhenols +
                ", Proanthocyanins=" + Proanthocyanins +
                ", ColorIntensity=" + ColorIntensity +
                ", Hue=" + Hue +
                ", DilutedWinesOD=" + DilutedWinesOD +
                ", Proline=" + Proline +
                ", Class=" + Class +
                '}';
    }

}
