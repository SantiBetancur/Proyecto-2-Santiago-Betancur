public class TanquesNormales extends Tanques {
    public TanquesNormales() {
        super(10);
    }

    public String getTank() {
        String tkShape = ("[TkN]:::");
        return getSalud() + tkShape;
    }
}
