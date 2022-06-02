package Calculator;

public class CZToEuro extends ValutaCalculator {

    @Override
    double valutaCalculator() {
        valuta = valuta * 0.041;
        return valuta;
    }
}
