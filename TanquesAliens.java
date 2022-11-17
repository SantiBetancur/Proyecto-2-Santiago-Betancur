public class TanquesAliens extends Tanques {

    public TanquesAliens() {
        super(20);
    }

    public String getTank() {
        String tkShape = ("[TkA]:::");
        return getSalud() + tkShape;
    }

}
