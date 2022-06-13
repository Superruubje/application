package Calculators;

public class EuroToCZ extends ValutaCalculator {

    @Override
    double valutaCalculator() {
        valuta = valuta * 24.67;
        return valuta;
    }
}
