public class Covid19Data {
    String region;
    String aldersgruppe;
    int bekræftedeIAlt;
    int døde;
    int indlagtPåIntensiv;
    int indlagte;

    public Covid19Data(String region, String aldersgruppe, int bekræftedeIAlt, int døde, int indlagtPåIntensiv, int indlagte) {
        this.region = region;
        this.aldersgruppe = aldersgruppe;
        this.bekræftedeIAlt = bekræftedeIAlt;
        this.døde = døde;
        this.indlagtPåIntensiv = indlagtPåIntensiv;
        this.indlagte = indlagte;
    }

    @Override
    public String toString() {
        return "Region: " + region + ", Aldersgruppe: " + aldersgruppe + ", Bekræftede i alt: " + bekræftedeIAlt +
                ", Døde: " + døde + ", Indlagt på intensiv: " + indlagtPåIntensiv + ", Indlagte: " + indlagte;
    }

}
